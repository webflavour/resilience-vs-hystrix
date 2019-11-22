package app;

import io.micrometer.core.instrument.binder.hystrix.HystrixMetricsBinder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class SpringConfiguration {

    @Bean
    private RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder.build();
    }

    @Bean
    private HystrixMetricsBinder hystrixMetrics() {
        return new HystrixMetricsBinder();
    }
}