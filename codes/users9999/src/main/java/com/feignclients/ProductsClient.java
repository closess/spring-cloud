package com.feignclients;

import com.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

//value属性用来指定:调用服务名称
@FeignClient("PRODUCTS")
public interface ProductsClient {
    @GetMapping("/product/findAll") //书写服务调用路径
     Map<String, Object> showMsg();

    @GetMapping("/product/findOne")
     Map<String,Object> findOne(@RequestParam("id2") String productId);

    @PostMapping("/product/save")
     Map<String,Object> save(@RequestParam("name") String name);

    @PostMapping("/product/saveProduct")
    Map<String,Object> saveProduct(@RequestBody Product product);
}
