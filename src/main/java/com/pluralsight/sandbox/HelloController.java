package com.pluralsight.sandbox;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String index() {
        System.out.println("NARF NARF NARF NARF");
        return "Greetings from Spring Boot!";
    }
    
    @GetMapping("/test")
    public String test() {
    	System.out.printf("test api call", "test");
    	return "test successful";
    	
    }

}
