package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class MainApplicationCenter3344 {
    public static void main(String[] args) {
        SpringApplication.run(MainApplicationCenter3344.class, args);
    }
}
