package com.aaa.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloRibbon {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/helloRibbo")
    @HystrixCommand(fallbackMethod = "error")
    public String helloRibbo(String name){

        return restTemplate.getForObject("http://eureka-client/hellWorld?name="+name,String.class);
    }


    public String error(String name){

        return "hystrix-"+name;
    }

}
