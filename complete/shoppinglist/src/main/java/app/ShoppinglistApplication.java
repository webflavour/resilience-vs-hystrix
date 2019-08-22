package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@SpringBootApplication
public class ShoppinglistApplication {

  @RequestMapping(value = "/recommended")
  public String readingList(){
    return "Apfel, Birne, Salat";
  }

  public static void main(String[] args) {
    SpringApplication.run(ShoppinglistApplication.class, args);
  }
}
