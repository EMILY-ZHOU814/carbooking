package com.zuche;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
})
@ComponentScan(basePackages = {"com.zuche.controller", "com.zuche.service"})
@MapperScan(basePackages = {"com.zuche.dao"})
public class ZucheApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZucheApplication.class, args);
    }

}
