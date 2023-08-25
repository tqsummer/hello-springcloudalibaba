package com.study.hello.springcloud.stock.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stock")
public class StockController {
    @Value("${server.port}")
    private Integer port;

    @RequestMapping("/deduct")
    public String deduct() {
        System.out.println("扣减1个库存");
        return "扣减1个库存,server.port:" + port;
    }
}
