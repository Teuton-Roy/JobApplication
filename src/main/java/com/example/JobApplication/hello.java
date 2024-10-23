package com.example.JobApplication;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

@RestController
public class hello {
    
    @GetExchange("/hello")
    public String hello(){
        return "Hey Hello!";
    }
    
}
