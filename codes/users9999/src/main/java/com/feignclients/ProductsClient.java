package com.feignclients;

import com.entity.Product;
import com.fallback.ProductClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Component
//value属性用来指定:调用服务名称
@FeignClient(value = "PRODUCTS",fallback = ProductClientFallback.class)
public interface ProductsClient {
    @GetMapping("/product/findAll") //书写服务调用路径
     Map<String, Object> showMsg();

    @GetMapping("/product/findOne")
     Map<String,Object> findOne(@RequestParam("id") String id2);

    @PostMapping("/product/save")//伪HTTP客户端请求方式和服务端一样，可以和 OpenFeign的controller的请求方式不一样
     Map<String,Object> save(@RequestParam("name") String name);

    @PostMapping("/product/saveProduct")
    Map<String,Object> saveProduct( Product product);

    @PostMapping("/product/saveProduct2")
    Map<String,Object> saveProduct2(@RequestParam("productName") String  productName);

    @GetMapping("/product/break")
    public Map<String,Object> testBreak(@RequestParam("id") int id);
}
