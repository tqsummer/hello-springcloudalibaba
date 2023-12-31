package com.study.hello.springcloud.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "stock-service", path = "/stock")
public interface StockFeignService {
    @RequestMapping("/deduct")
    String deduct();
}
