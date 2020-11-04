package com.controller;

import com.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
@Slf4j
public class ProductController {
    @Value("${server.port}")
    private int port;

    @GetMapping("/product/findAll")
    public Map<String, Object> showMsg() {
        log.info("商品服务查询所有调用成功,当前服务端口:[{}]", port);
        HashMap<String, Object> map = new HashMap<>();
        map.put("msg", "服务调用成功，服务提供的端口号：" + port);
        map.put("status", true);
        return map;
    }

    @GetMapping("/product/findOne")
    public Map<String,Object> findOne(String id2){
        log.info("商品服务查询商品信息调用成功,当前服务端口:[{}]", port);
        log.info("当前接收商品信息的id:[{}]", id2);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("msg", "商品服务查询商品信息调用成功,当前服务端口: " + port);
        map.put("status", true);
        map.put("productId", id2);
        return map;
    }
    //1.商品服务加入post方式请求并接受name
    @PostMapping("/product/save")
    public Map<String,Object> save(String name){
        log.info("商品服务保存商品调用成功,当前服务端口:[{}]",port);
        log.info("当前接收商品名称:[{}]",name);
        Map<String, Object> map = new HashMap<String,Object>();
        map.put("msg","商品服务查询商品信息调用成功,当前服务端口: "+port);
        map.put("status",true);
        map.put("name",name);
        return map;
    }
    //2.商品服务定义接收对象的方法
    @PostMapping("/product/saveProduct")
    public Map<String,Object> saveProduct(@RequestBody Product product){
        log.info("商品服务保存商品信息调用成功，当前服务的端口号:[{}]", port);
        log.info("当前接受商品名称:[{}]",product);
        HashMap<String, Object> map = new HashMap<>();
        map.put("msg","商品服务查询商品信息调用成功,当前服务端口: "+port);
        map.put("status", true);
        map.put("product",product);
        return map;

    }
}
