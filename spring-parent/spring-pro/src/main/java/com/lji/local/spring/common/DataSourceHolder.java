package com.lji.local.spring.common;

/**
 * 数据源操作
 * @author shangke
 */
public class DataSourceHolder {
	
    //线程本地环境
    private static final ThreadLocal<String> dataSources = new ThreadLocal<String>();
    //设置数据源
    public static void setDataSource(String customerType) {
        dataSources.set(customerType);
    }
    //获取数据源
    public static String getDataSource() {
    	String ret = dataSources.get();
    	if (ret == null){
    		return DataSource.dceDB;
    	} else {
    		return ret;
    	}
    }
    //清除数据源
    public static void clearDataSource() {
        dataSources.remove();
    }
 
}
