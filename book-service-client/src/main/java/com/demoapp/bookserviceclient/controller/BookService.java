package com.demoapp.bookserviceclient.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demoapp.bookserviceclient.client.ServiceClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class BookService {

    private Logger logger = LoggerFactory.getLogger(BookService.class);

    @Autowired
    private ServiceClient serviceClient;

    @HystrixCommand(fallbackMethod = "mybooksFallback")
    @RequestMapping("/mybooks-public")
    public String mybooks() {
        logger.info("mybooks-public service called");
        String response = serviceClient.mybooks();
        logger.info("response: " + response);
        return response;
    }

    public String mybooksFallback() {
        return "mybooksFallback method called";
    }

    @HystrixCommand
    @RequestMapping("/test")
    public String test() {
        logger.info("test service called");
        return "book-service-client service is up";
    }
}