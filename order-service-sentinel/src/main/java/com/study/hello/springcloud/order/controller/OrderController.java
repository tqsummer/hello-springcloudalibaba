package com.study.hello.springcloud.order.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @RequestMapping("/add")
    public String add() {
        return "add order success";
    }
}
