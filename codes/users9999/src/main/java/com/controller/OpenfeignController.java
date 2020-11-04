package com.controller;

import com.feignclients.ProductsClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
