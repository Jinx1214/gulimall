package com.atguigu.gulimall.coupon;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.atguigu.gulimall.coupon.dao")
public class couponApplication {
    public static void main(String[] args) {
        SpringApplication.run(couponApplication.class,args);
    }
}
