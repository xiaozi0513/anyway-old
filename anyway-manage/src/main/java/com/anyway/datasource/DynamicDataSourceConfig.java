package com.anyway.datasource;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 动态多数据源配置
 * @author wang_hui
 * @date 2018/5/29 23:08
 * @since 1.0.0
 **/
@Configuration
public class DynamicDataSourceConfig {

    @Bean(name = "masterDataSource", initMethod = "init", destroyMethod = "close")
    @ConfigurationProperties("spring.datasource.druid.master")
    public DataSource masterDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "slaveDataSource", initMethod = "init", destroyMethod = "close")
    @ConfigurationProperties("spring.datasource.druid.slave")
    public DataSource slaveDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean("dynamicDataSource")
    @Primary
    public DynamicDataSource dataSource(DataSource masterDataSource, DataSource slaveDataSource) {
        Map<Object, Object> targetDataSource = new HashMap<>();
        targetDataSource.put(DataSourceNames.MASTER, masterDataSource);
        targetDataSource.put(DataSourceNames.SLAVE, slaveDataSource);
        return new DynamicDataSource(masterDataSource, targetDataSource);
    }

}
