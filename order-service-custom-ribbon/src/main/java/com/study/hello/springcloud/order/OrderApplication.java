package com.study.hello.springcloud.order;

import com.study.hello.springcloud.order.ribbon.RibbonConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RibbonClients(value = {
        @RibbonClient(name = "stock-service", configuration = RibbonConfiguration.class)
})
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

    @Bean
    @LoadBalanced
    RestTemplate getRestTemplate(RestTemplateBuilder restTemplateBuilder){
       return restTemplateBuilder.build();
    }
}
