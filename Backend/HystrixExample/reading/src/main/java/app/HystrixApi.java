package app;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixThreadPoolKey;
import org.springframework.web.client.RestTemplate;

public class HystrixApi extends HystrixCommand<String> {

    private static final String COMMAND_GROUP_KEY = "HystrixApiCalls";
    private final RestTemplate restTemplate;
    private final String api;

    public HystrixApi(RestTemplate restTemplate, String api) {

        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey(COMMAND_GROUP_KEY))
                .andCommandKey(HystrixCommandKey.Factory.asKey("apiCall"))
                .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("apiThreadPool")));

        this.restTemplate = restTemplate;
        this.api = api;
    }

    @Override
    protected String run() {
        return restTemplate.getForObject("http://localhost:8080/" + api, String.class);
    }
}