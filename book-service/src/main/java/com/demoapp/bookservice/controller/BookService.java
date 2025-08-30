package com.demoapp.bookservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class BookService {

    private Logger logger = LoggerFactory.getLogger(BookService.class);

    @HystrixCommand
    @RequestMapping("/mybooks")
    public String ping() {
        logger.info("mybooks service called");
        return "your books: dan brawn - davinci";
    }
}