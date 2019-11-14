package com.studienprojekt.app;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@SpringBootApplication
@CrossOrigin
public class App {



    @RequestMapping(value = "/api/read")
    @ResponseBody
    public String readingList() {
        return "Apfel, Birne, Salat";
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
