package com.anyway.datasource.aspect;

import com.anyway.datasource.DataSourceNames;
import com.anyway.datasource.DynamicDataSource;
import com.anyway.datasource.annotation.TargetDataSource;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author: wang_hui
 * @date: 2018/5/30 下午5:57
 * @since:
 */
@Slf4j
@Aspect
@Component
public class TargetDataSourceAspect implements Ordered {

    @Pointcut("@annotation(com.anyway.datasource.annotation.TargetDataSource)")
    public void dataSourcePointcut() {

    }

    @Around("dataSourcePointcut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        TargetDataSource targetDataSource = method.getAnnotation(TargetDataSource.class);
        if (!DynamicDataSource.dataSourceKeys.contains(targetDataSource.name())) {
            log.warn("datasource [{}] doesn't exist, use default datasource [{}].", targetDataSource.name(), DataSourceNames.MASTER);
            DynamicDataSource.setDataSourceKey(DataSourceNames.MASTER);
        } else {
            DynamicDataSource.setDataSourceKey(targetDataSource.name());
            log.debug("set datasource is [{}].", targetDataSource.name());
        }

        try {
            return point.proceed();
        } finally {
            DynamicDataSource.clearDataSourceKey();
            log.debug("delete datasource.");
        }
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
