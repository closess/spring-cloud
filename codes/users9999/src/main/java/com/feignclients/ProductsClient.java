package com.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

//value属性用来指定:调用服务名称
@FeignClient("PRODUCTS")
public interface ProductsClient {
    @GetMapping("/product/findAll") //书写服务调用路径
     Map<String, Object> showMsg();
}
