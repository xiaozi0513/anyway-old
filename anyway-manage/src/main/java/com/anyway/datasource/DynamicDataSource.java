package com.anyway.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.lang.Nullable;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 动态数据源
 *
 * @author wang_hui
 * @date 2018/5/29 23:13
 * @since 1.0.0
 **/
public class DynamicDataSource extends AbstractRoutingDataSource {

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();
    public static List<Object> dataSourceKeys = new ArrayList<>();

    /**
     * 设置默认数据源和所有数据源集
     *
     * @param defaultTargetDataSource
     * @param targetDataSource
     */
    public DynamicDataSource(DataSource defaultTargetDataSource, Map<Object, Object> targetDataSource) {
        DynamicDataSource.dataSourceKeys.addAll(targetDataSource.keySet());
        super.setDefaultTargetDataSource(defaultTargetDataSource);
        super.setTargetDataSources(targetDataSource);
        super.afterPropertiesSet();
    }

    @Nullable
    @Override
    protected Object determineCurrentLookupKey() {
        return getDataSourceKey();
    }

    /**
     * 设置当前数据源
     *
     * @param dataSourceKey
     */
    public static void setDataSourceKey(String dataSourceKey) {
        contextHolder.set(dataSourceKey);
    }

    /**
     * 获取当前数据源
     *
     * @return
     */
    public static String getDataSourceKey() {
        return contextHolder.get();
    }

    /**
     * 清除当前数据源
     */
    public static void clearDataSourceKey() {
        contextHolder.remove();
    }

    /**
     * 判断数据源是否存在
     *
     * @param dataSourceKey
     * @return
     */
    public static boolean containsDataSource(String dataSourceKey) {
        return dataSourceKeys.contains(dataSourceKey);
    }

}
