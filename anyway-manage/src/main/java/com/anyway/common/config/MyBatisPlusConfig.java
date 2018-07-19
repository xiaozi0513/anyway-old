package com.anyway.common.config;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: wang_hui
 * @date: 2018/7/19 下午4:37
 * @since:
 */
@Configuration
@MapperScan("com.anyway.modules.*.dao")
public class MyBatisPlusConfig {

    /**
     * Mybatis Plus性能优化，
     * @return
     */
    @Bean
    public PerformanceInterceptor performanceInterceptor() {
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        //SQL执行性能分析，开发环境使用，线上不推荐。maxTime指的是sql最大执行时长
        performanceInterceptor.setMaxTime(1000);
        //SQL是否格式化。默认false
        performanceInterceptor.setFormat(true);
        return performanceInterceptor;
    }

    /**
     * mybatis-plus分页插件
     * <p/>
     * 文档：http://mp.baomidou.com
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        return paginationInterceptor;
    }

}
