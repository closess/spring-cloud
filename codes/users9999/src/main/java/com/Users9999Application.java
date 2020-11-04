package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//@EnableDiscoveryClient//加不加都行
@EnableFeignClients//开启openfeign的支持
public class Users9999Application {

    public static void main(String[] args) {
        SpringApplication.run(Users9999Application.class, args);
    }

}
