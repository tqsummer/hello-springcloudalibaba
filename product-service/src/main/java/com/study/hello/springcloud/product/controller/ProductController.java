package com.study.hello.springcloud.product.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Value("${server.port}")
    private Integer port;

    @RequestMapping("/{id}")
    public String get(@PathVariable Integer id) {
        System.out.println("查询商品" + id + "信息");
        return "商品" + id + "信息,server.port:" + port;
    }
}
