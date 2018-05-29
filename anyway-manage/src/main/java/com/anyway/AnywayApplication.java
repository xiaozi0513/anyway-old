package com.anyway;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 *
 * @author wang_hui
 * @date 2018/5/29 22:35
 * @since 1.0.0
 **/
@SpringBootApplication
@MapperScan(basePackages = {"com.anyway.modules.*.dao"})
public class AnywayApplication {
    public static void main(String[] args) {
        SpringApplication.run(AnywayApplication.class, args);
    }
}
