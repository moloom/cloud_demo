package com.mo.moloom;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

//basePackages指定扫描Feign所在的包，防止Feign通过jar包引入时报错找不到；
// 此class在com.mo.moloom下，而Feign在com.mo.moloom.clients下，则可以不加
@EnableFeignClients(basePackages = "com.mo.moloom.clients")
@MapperScan("com.mo.moloom.mapper")
@SpringBootApplication
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

}