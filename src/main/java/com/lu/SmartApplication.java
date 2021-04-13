package com.lu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lu.mapper")
public class SmartApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartApplication.class, args);
    }

}
