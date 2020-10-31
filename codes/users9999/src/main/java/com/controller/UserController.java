package com.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@Slf4j
public class UserController {
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private  RestTemplate restTemplate;

    @GetMapping("/user/findAll")
    public String findAll(){

        log.info("调用用户服务...");
        //1、使用restTemplate 调用商品服务
 /*       RestTemplate restTemplate = new RestTemplate();
        String forObject = restTemplate.getForObject("http://localhost:9998/product/findAll", String.class);
*/
        //2、使用discovery Client形式调用
//        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("products");
//        for (ServiceInstance serviceInstance:serviceInstances) {
//            System.out.println(serviceInstance.getHost());
//            System.out.println(serviceInstance.getPort());
//        }
        //3、使用loadBalance Client形式调用
//        ServiceInstance product = loadBalancerClient.choose("products");
//        System.out.println(product.getPort());
//        System.out.println(product.getHost());
//        RestTemplate restTemplate = new RestTemplate();
//        String url="http://"+product.getHost()+":"+product.getPort()+"/product/findAll";
//        String forObject = restTemplate.getForObject(url, String.class);
        //4、使用@loadBalanced
        String forObject = restTemplate.getForObject("http://products/product/findAll", String.class);
        return forObject;
    }
}
