package app;

import io.micrometer.core.instrument.binder.hystrix.HystrixMetricsBinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.web.client.RestTemplate;


@Configuration
@RestController
@SpringBootApplication
public class HystrixReadingApplication {

  @Autowired
  private HystrixShoppingService service;

  @Bean
  public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
    return restTemplateBuilder.build();
  }

  @Bean
  public HystrixMetricsBinder hystrixMetrics() {
    return new HystrixMetricsBinder();
  }

  @RequestMapping("/api/{api}")
  public String toRead(@PathVariable String api) {
    return service.callApi(api);
  }


 /** @RequestMapping("/api/{api}")
  public String toRead(@PathVariable String api) {
    return service.readingList(api);
  }**/

  public static void main(String[] args) {
    SpringApplication.run(HystrixReadingApplication.class, args);
  }
}