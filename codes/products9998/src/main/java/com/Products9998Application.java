package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
@EnableCircuitBreaker  //用来开启断路器
public class Products9998Application {

    public static void main(String[] args) {
        SpringApplication.run(Products9998Application.class, args);
    }

}
