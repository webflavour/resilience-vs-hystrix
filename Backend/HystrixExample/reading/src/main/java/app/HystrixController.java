package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HystrixController {


    @Autowired
    private HystrixService service;

    /** @RequestMapping("/api/{api}") **/
    @GetMapping("/api/{api}")
    public String toRead(@PathVariable String api) {
        return service.callApi(api);
    }


}