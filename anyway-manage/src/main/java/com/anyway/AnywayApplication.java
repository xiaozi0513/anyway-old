package com.anyway;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动类
 * @author wang_hui
 * @date 2018/5/29 22:35
 * @since 1.0.0
 **/
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@MapperScan(basePackages = {"com.anyway.modules.*.dao"})
public class AnywayApplication {
    public static void main(String[] args) {
//        SpringApplication bootstrap = new SpringApplication(AnywayApplication.class);
//        bootstrap.setBanner(new ResourceBanner(new ClassPathResource("banner.txt")));
//        bootstrap.run(args);
        SpringApplication.run(AnywayApplication.class, args);
    }
}
