package com.controller;

import com.entity.Product;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

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
    public Map<String,Object> findOne(@RequestParam("id") String id2){
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
    /*模拟业务提供方的业务逻辑响应时间*/
    @PostMapping("/product/saveProduct2")
    public Map<String,Object> saveProduct2(@RequestParam("productName") String  productName){
        try{
            //模拟响应时间为'2s+',即超过了‘1s’的响应时间
            Thread.sleep(2000);}
        catch (Exception e) {
            e.printStackTrace();
        }
        log.info("商品服务保存商品信息调用成功，当前服务的端口号:[{}]", port);
        log.info("当前接受商品名称:[{}]",productName);
        HashMap<String, Object> map = new HashMap<>();
        map.put("msg","商品服务查询商品信息调用成功,当前服务端口: "+port);
        map.put("当前商品的名称:", productName);
        map.put("status", true);
        return map;
    }
    @GetMapping("/product/break")
//    @HystrixCommand(fallbackMethod = "testBreakFall")
   @HystrixCommand(defaultFallback = "testBreakFall2")
    public Map<String,Object> testBreak(@RequestParam("id")int id){
        log.info("接受到的商品的id为:"+id);
        if (id<0){
            throw  new RuntimeException("数据不合法!!!");
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("msg","商品服务查询商品信息调用成功,当前服务端口: "+port);
        map.put("当前商品的名称:", id);
        map.put("status", true);
        return map;
    }
    public String testBreakFall(int id){
        return "当前数据"+id+"不合法>>>熔断器已经打开！";
    }
    //默认的fallback不能有参数，否则500异常-》FallbackDefinitionException: fallback method wasn't found:
    public Map<String,Object> testBreakFall2(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("ERROR","当前服务已经被降级,无法使用");
        return map;
    }
}
