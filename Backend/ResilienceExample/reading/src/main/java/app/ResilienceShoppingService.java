package app;

import io.github.resilience4j.bulkhead.Bulkhead;
import io.github.resilience4j.bulkhead.BulkheadRegistry;
import io.github.resilience4j.bulkhead.BulkheadConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.ratelimiter.RateLimiterConfig;
import io.github.resilience4j.timelimiter.TimeLimiter;

import java.time.Duration;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;
import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.*;


@Service
public class ResilienceShoppingService {

    private final CircuitBreaker circuitBreaker;
    private final Bulkhead bulkhead;
    private final RateLimiter rateLimiter;

    private TimeLimiter timeLimiter;
    private ExecutorService executorService = Executors.newFixedThreadPool(10);
    private final Function<String, String> chainedCallable;

    @Autowired
    private RestTemplate restTemplate;

    public ResilienceShoppingService() {

        BulkheadConfig config = BulkheadConfig.custom()
                .maxConcurrentCalls(150)
                .maxWaitDuration(Duration.ofMillis(500))
                .build();
        BulkheadRegistry registry = BulkheadRegistry.of(config);
        bulkhead = Bulkhead.of("apiCall", BulkheadConfig.ofDefaults());
       /** chainedCallable = Bulkhead.decorateFunction(bulkhead, this::restrictedCall);**/


        circuitBreaker = CircuitBreaker.of("apiCall", CircuitBreakerConfig.custom()
                .failureRateThreshold(50)
                .waitDurationInOpenState(Duration.ofMillis(1000))
                .ringBufferSizeInHalfOpenState(2)
                .ringBufferSizeInClosedState(2)
                .build());
        chainedCallable = CircuitBreaker.decorateFunction(circuitBreaker, this::restrictedCall);

        rateLimiter = RateLimiter.of("apiCall", RateLimiterConfig.custom()
                .limitRefreshPeriod(Duration.ofSeconds(1))
                .limitForPeriod(10)
                .timeoutDuration(Duration.ofSeconds(2))
                .build());
        /**chainedCallable = RateLimiter.decorateFunction(rateLimiter, this::restrictedCall);**/
    }

    public String callApi(String api) {
        return chainedCallable.apply(api);
    }

    private String restrictedCall(String api) {
        return restTemplate.getForObject("http://localhost:8080/" + api, String.class);
    }
}