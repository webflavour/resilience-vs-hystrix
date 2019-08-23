package app;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class HystrixShoppingService {

  private final RestTemplate restTemplate;

  public ShoppingService(RestTemplate rest) {
    this.restTemplate = rest;
  }

  @HystrixCommand(fallbackMethod = "reliable")
  public String readingList() {
    URI uri = URI.create("http://localhost:8090/recommended");

    return this.restTemplate.getForObject(uri, String.class);
  }


  public String callApi(String api) {
    return new ApiHystrixCommand(restTemplate, api).execute();
  }

  public String reliable() {
    return "Birne";
  }

}
