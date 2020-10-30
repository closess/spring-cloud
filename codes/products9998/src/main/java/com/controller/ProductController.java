package com.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
@Slf4j
public class ProductController {
    @Value("${server.port}")
    private int port;

    @GetMapping("/product/findAll")
    public Map<String, Object> showMsg(){
        log.info("商品服务查询所有调用成功,当前服务端口:[{}]",port);
        HashMap<String, Object> map = new HashMap<>();
        map.put("msg", "服务调用成功，服务提供的端口号："+port);
        map.put("status", true);
        return map;
    }
}
