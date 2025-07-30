package com.hf.aicodebackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.hf.aicodebackend.mapper")
@SpringBootApplication
public class AiCodeBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(AiCodeBackendApplication.class, args);
    }

}
