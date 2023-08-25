# 启用Spring Cloud LoadBalancer
## 1. 引入依赖
```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-loadbalancer</artifactId>
</dependency>
```
## 2. 配置
```yaml
spring:
  cloud:
    loadbalancer:
      #关闭netflix的ribbon负载均衡(这里关闭后，就会使用spring cloud loadbalancer的负载均衡，maven依赖中可以不用排除netflix的ribbon包)
      ribbon:
        enabled: false
```