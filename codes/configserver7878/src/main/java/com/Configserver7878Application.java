package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer//开启统一配置中心服务
public class Configserver7878Application {

	public static void main(String[] args) {
		SpringApplication.run(Configserver7878Application.class, args);
	}

}
