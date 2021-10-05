package com.yuanfang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yuanfang.dao")
public class SpringbootJasyptApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootJasyptApplication.class, args);
    }

}
