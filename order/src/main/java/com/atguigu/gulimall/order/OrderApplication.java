package com.atguigu.gulimall.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.atguigu.gulimall.order.dao")
public class orderApplication {
    public static void main(String[] args) {
        SpringApplication.run(orderApplication.class,args);
    }
}
