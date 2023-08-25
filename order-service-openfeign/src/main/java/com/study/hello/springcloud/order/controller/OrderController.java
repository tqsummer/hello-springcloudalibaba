package com.study.hello.springcloud.order.controller;

import com.study.hello.springcloud.order.feign.StockFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private StockFeignService stockFeignService;

    @RequestMapping("/add")
    public String add() {
        String response = stockFeignService.deduct();
        return response;
    }
}
