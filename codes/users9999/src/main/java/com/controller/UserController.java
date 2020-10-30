package com.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class UserController {
    @GetMapping("/user/findAll")
    public String findAll(){
        log.info("调用用户服务...");
        //使用restTemplate 调用商品服务
        RestTemplate restTemplate = new RestTemplate();
        String forObject = restTemplate.getForObject("http://localhost:9998/product/findAll", String.class);
        return forObject;

    }
}
