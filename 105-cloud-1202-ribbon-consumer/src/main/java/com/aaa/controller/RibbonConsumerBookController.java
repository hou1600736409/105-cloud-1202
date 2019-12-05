package com.aaa.controller;

import com.aaa.model.BookInfo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedList;
import java.util.List;

@RestController
public class RibbonConsumerBookController {
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "error")
    @GetMapping("getAllBookFromRibbon")
    public List<BookInfo> getAllBook(){
        LinkedList<BookInfo> forObject = restTemplate.getForObject("http://provider-server/getAllBook", LinkedList.class);
        System.out.println(forObject);
        return forObject;

    }

    public List<BookInfo> error() {
        System.out.println("服务熔断");
        return null;
    }


}
