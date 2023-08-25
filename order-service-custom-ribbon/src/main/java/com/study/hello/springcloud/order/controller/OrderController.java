package com.study.hello.springcloud.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/add")
    public String add() {
        String response = restTemplate.getForObject("http://stock-service/stock/deduct", String.class);
        String productResponse = restTemplate.getForObject("http://product-service/product/1", String.class);
        return response + productResponse;
    }
}
