package com.lji.local.spring.container;

import lji.com.local.spring.utils.PropertiesUtil;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * spring加载类
 * @author lji
 * @date 2016年3月15日下午3:21:01
 */
public class SpringContainer {
	
	private static final Logger logger = Logger.getLogger(SpringContainer.class);
	
	static ClassPathXmlApplicationContext context;
	
	private String contextPath;
	
	public static ClassPathXmlApplicationContext getContext() {
		return context;
	}
	
	/**
	 * 构造函数，获取spring配置文件路径
	 * @param contextPath
	 */
	public SpringContainer(String contextPath) {
		this.contextPath = contextPath;
	}
	
	/**
	 * 无参构造函数，从配置文件获取spring配置文集
	 */
	public SpringContainer() {
		this.contextPath = PropertiesUtil.getValue("dubbo.spring.config");
	}

	/**
	 * 容器启动
	 * @auther lji
	 * @date 2016年3月15日下午3:24:50
	 */
	public void start() {
        context = new ClassPathXmlApplicationContext(contextPath.split("[,\\s]+"));
        context.start();
    }
	
	/**
	 * 容器关闭
	 * @auther lji
	 * @date 2016年3月15日下午3:24:55
	 */
	public void stop() {
        try {
            if (context != null) {
                context.stop();
                context.close();
                context = null;
            }
        } catch (Throwable e) {
            logger.error(e.getMessage(), e);
        }
    }
}
