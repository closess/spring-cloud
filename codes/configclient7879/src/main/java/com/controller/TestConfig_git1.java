package com.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope//配置手动刷新的注解
@Slf4j
public class TestConfig_git1 {
    //测试是否拉去了远端的配置
    @Value("${server.port}")
    private String port;
    @Value("${username}")
    private String username;
    @GetMapping("/client/test1")
    public String test1(){
        log.info("当前客户端的环境是[{}]",port);
        return port;
    }
    //配置手动刷新
    //@RefreshScope 也可以放在方法上面
    @GetMapping("/client/test2")
    public String test2(){
        log.info("当前加载的配置文件的信息为[{}]", username);
        return username;
    }

}
