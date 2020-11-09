package com.controller;

import com.entity.Product;
import com.feignclients.ProductsClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@Slf4j
public class OpenfeignController {

    @Autowired
    private ProductsClient productsClient;

    @GetMapping("/user/findAllFeignClient")
    public Map<String, Object> findAllFeignClient(){
        log.info("通过使用OpenFeign组件调用商品服务...");
        Map<String, Object> msg = productsClient.showMsg();
        return msg;
    }
    @GetMapping("/user/findOne")
    public Map<String,Object> findOne(String productId){
        log.info("用来这是GET方式的参数传递");
        Map<String,Object> msg= productsClient.findOne(productId);
        log.info("调用返回的信息是：[{}]",msg);
        return msg;
    }

    @GetMapping("/user/save")
    public Map<String,Object> save(String productName){
        log.info("接收到的商品信息的名称[{}]", productName);
        Map<String, Object> msg = productsClient.save(productName);
        return msg;
    }
    @GetMapping("/user/saveProduct")
    public Map<String, Object> saveProduct(Product product){
        log.info("接收到的商品信息:[{}]",product);
        Map<String, Object> map = productsClient.saveProduct(product);
        log.info("调用成功返回结果: "+map);
        return map;
    }
    @GetMapping("/user/saveProduct2")
    public Map<String,Object>saveProduct2(String productName){
        log.info("接收到商品的名称为：[{}]", productName);
        Map<String, Object> map = productsClient.saveProduct2(productName);
        log.info("调用成功后的响应结果：[{}]", map);
        return map;
    }
    @GetMapping("/user/break")
    public Map<String, Object> testBreak(@RequestParam("id") int id){
        log.info("接收到的前端传过来的参数：[{}]", id);
        Map<String,Object>  map= productsClient.testBreak(id);
        log.info("响应结果:[{}]", map);
        return map;
    }

}
