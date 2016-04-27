package com.lji.local.spring.common;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * AOP方法,拦截方法，判断是否有DataSource的注解，如果有切换数据源
 * 
 * @author lji
 *
 */
@Aspect
@Component 
public class DataSourceExchange {

	/**
	 * 声明暴露给dubbo扫描的位置，因为aop代理的部分不能被扫描到
	 * @auther lji
	 * @date 2016年3月16日上午12:23:22
	 */
	@Pointcut("execution(* com.lji.local.spring.service..*.*(..))")
	public void pointCut() {
	}

	@Around("pointCut()")
	public Object invoke(ProceedingJoinPoint pjp) throws Throwable {
		Object returnObject;
		MethodSignature signature = (MethodSignature) pjp.getSignature();
		Method method = signature.getMethod();
		String yuanDataSource = DataSourceHolder.getDataSource();
		DataSource dataSource = method.getAnnotation(DataSource.class);

		if (dataSource != null) {
			DataSourceHolder.setDataSource(dataSource.value());
		}

		try {
			returnObject = pjp.proceed();
		} catch (Exception ex) {
			throw ex;
		} finally {
			DataSourceHolder.setDataSource(yuanDataSource);
		}
		
		return returnObject;
	}
}
