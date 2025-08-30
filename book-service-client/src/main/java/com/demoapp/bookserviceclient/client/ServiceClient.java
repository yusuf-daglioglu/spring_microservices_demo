package com.demoapp.bookserviceclient.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("book-service")
public interface ServiceClient {

    @RequestMapping("/mybooks")
    String mybooks();
}