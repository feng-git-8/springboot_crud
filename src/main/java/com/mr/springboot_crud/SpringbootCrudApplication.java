package com.mr.springboot_crud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.mr.springboot_crud.mapper")
public class SpringbootCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootCrudApplication.class, args);
    }

}
