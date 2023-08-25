# 1.添加FeignService接口
```java
@FeignClient(value = "stock-service",path="/stock")
public interface StockFeignService {
    @RequestMapping("/deduct")
    String deduct();
}
```
# 2.OrderApplication添加@EnableFeignClients注解
```java
@SpringBootApplication
@EnableFeignClients
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class,args);
    }
}
```
# 3.删除OrderController中的RestTemplate
```java
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
```
# 4.删除OrderApplication中的RestTemplate
```java
@SpringBootApplication
@EnableFeignClients
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class,args);
    }
//    @Bean
//    @LoadBalanced
//    RestTemplate getRestTemplate(RestTemplateBuilder restTemplateBuilder){
//        return restTemplateBuilder.build();
//    }
}
```
# 5.启动项目
    访问http://localhost:8084/order/add