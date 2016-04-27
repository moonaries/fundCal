package com.lji.local.spring.common;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface DataSource {
    String value() default DataSource.dceDB;
 
    public static String ismDB = "ismDataSource";
 
    public static String cebDB = "cebDataSource";
    
    public static String dceDB = "dceDataSource";
    
    public static String jydbDB = "jydbDataSource";
 
}
