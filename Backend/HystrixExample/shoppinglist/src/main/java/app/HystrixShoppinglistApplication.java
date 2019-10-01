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
@CrossOrigin

public class HystrixShoppinglistApplication {

 @Autowired
    OrderRepository orderRepository;

 @CrossOrigin
  @RequestMapping(value = "/api/read")
  public String readingList(){
    return "Apfel, Birne, Salat";
  }

 @CrossOrigin
 @RequestMapping(value = "/api/order/add", method = RequestMethod.POST)
    public ResponseEntity<Void> addOrder(@RequestBody String order) {
        try {
            if (order != null && order != "") {
                orderRepository.save(new Order(order));
                System.out.println("The order: '" + order + "' was added.");
                return new ResponseEntity<>(HttpStatus.CREATED);
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

         @CrossOrigin
       @RequestMapping(value = "/api/order/delete/{id}", method = RequestMethod.DELETE)
       public ResponseEntity<Void> removeOrder(@PathVariable("id") int id) {
           try {
                   if (orderRepository.existsById(id)) {
                       orderRepository.deleteById(id);
                       System.out.println("The order: " + id + " was deleted." );
                       return new ResponseEntity<>(HttpStatus.OK);
                   }
                   return new ResponseEntity<>(HttpStatus.NOT_FOUND);
               }
           catch(Exception e) {
               System.out.println(e);
               return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
           }
       }

  public static void main(String[] args) {
    SpringApplication.run(HystrixShoppinglistApplication.class, args);
  }
}
