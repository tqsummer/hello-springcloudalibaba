# 自定义负载均衡策略配置
建议使用第一种方式，第二种方式会导致所有的服务都使用这个负载均衡策略。
## 1.yaml配置自定义负载均衡策略
```yaml
#stock-service配置负载均衡策略
stock-service:
  ribbon:
    NFLoadBalancerRuleClassName: com.alibaba.cloud.nacos.ribbon.NacosRule
```
## 2.Configuration类配置自定义负载均衡策略
a.有个踩坑的问题，能被ComponentScan扫描到的Configuration类中，如果使用@Bean注解定义IRule，那么就会导致所有的服务都使用这个负载均衡策略。<br/>
b.所以不能配置全局的负载均衡策略，否则会导致所有的服务都使用这个负载均衡策略。<br/>
c.因些RibbonConfiguration需要定义在不能被ComponentScan扫描到的包中，否则会导致所有的服务都使用这个负载均衡策略。<br/>
d.由于OrderApplication是在com.study.hello.springcloud.order包下。<br/>
e.所以RibbonConfiguration不能定义在com.study.hello.springcloud.order包下。<br/>
<br/><strong>解决不被扫描，可以在RibbonConfiguration上不加Configuration注解或不放在ComponentScan扫描包内，建议使用不加Configuration注解</strong><br/>


### 2.1.添加配置类
```java
@Configuration
public class RibbonConfiguration {
    @Bean
    public IRule ribbonRule() {
        return new CustomRibbonRule();
    }
}
```
### 2.2.添加自定义负载均衡策略
```java
public class CustomRibbonRule extends AbstractLoadBalancerRule {
    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose(Object o) {
        ILoadBalancer loadBalancer = getLoadBalancer();
        List<Server> allServers = loadBalancer.getAllServers();
        for (Server server : allServers) {
            System.out.println(server.getHostPort());
        }
        return allServers.get(0);
    }
}
```
### 2.3.添加注解
使用@RibbonClients注解，指定具体的服务使用哪个负载均衡策略。
```java
@SpringBootApplication
@RibbonClients(value = {
        @RibbonClient(name = "stock-service", configuration = RibbonConfiguration.class)
})
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class,args);
    }
}
```
### 2.4.启动项目
    访问http://localhost:8084/order/add

# 3.配置饥饿加载
```yaml
#stock-service配置饥饿加载
stock-service:
  ribbon:
    eager-load:
      enabled: true
```
