package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Configuration
@RestController
@SpringBootApplication
public class ResilienceReadingApplication {


    @Autowired
    private ResilienceShoppingService service;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder.build();
    }


    @GetMapping("/api/{api}")
    public String toRead(@PathVariable String api) {
        return service.callApi(api);
    }

   /** @RequestMapping("/api/{api}")
    public String toReadThis(@PathVariable String api) {
        return service.readingList(api);
    }**/


    public static void main(String[] args) {
        SpringApplication.run(ResilienceReadingApplication.class, args);
    }
}