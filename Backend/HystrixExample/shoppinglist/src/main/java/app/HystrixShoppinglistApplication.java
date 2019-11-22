package app;

import app.model.Order;
import app.model.OrderRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
@SpringBootApplication

public class HystrixShoppinglistApplication {

 @Autowired
  private  OrderRepository orderRepository;


 @RequestMapping(value = "/api/read")

  public String readingList(){
    return "Apfel, Birne, Salat";
  }



  public static void main(String[] args) {
    SpringApplication.run(HystrixShoppinglistApplication.class, args);
  }
}
