package com.study.hello.springcloud.order.ribbon;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;

public class RibbonConfiguration {
    @Bean
    public IRule iRule() {
        return new CustomRibbonRule();
    }
}
