package ResilienceExample.reading.src.main.java.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
@RestController
@SpringBootApplication
public class Resilience4jReadingApplication {


    @Autowired
    private Resilience4jShoppingService service;

  @Bean
  public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
    return restTemplateBuilder.build();
  }


    @GetMapping("/api/{api}")
    public String toRead(@PathVariable String api) {
        return service.callApi(api);
    }

    @RequestMapping("/api/{api}")
    public String toRead(@PathVariable String api) {
        return service.readingList(api);
    }


    public static void main(String[] args) {
        SpringApplication.run(Resilience4jReadingApplication.class, args);
    }
}