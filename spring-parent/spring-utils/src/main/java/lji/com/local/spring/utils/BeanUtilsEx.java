package lji.com.local.spring.utils;

import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.converters.SqlDateConverter;
import org.springframework.util.StringUtils;


/**
 * 相同字段名的对象复制
 * @author lji
 * @date 2016年3月21日上午10:40:03
 */
public class BeanUtilsEx {
	   static {
	        // 注册sql.date的转换器，即允许BeanUtils.copyProperties时的源目标的sql类型的值允许为空
	        ConvertUtils.register(new SqlDateConverter(), java.util.Date.class);
	        // 注册util.date的转换器，转化到date的时候将调用这个转化器
	        ConvertUtils.register(new UtilDateConverter(), java.util.Date.class);
	    }

	    public static void copyProperties(Object target, Object source) {
	        try {
				BeanUtils.copyProperties(target, source);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
	    }
	}

	@SuppressWarnings("rawtypes")
	class UtilDateConverter implements Converter {
		@Override
		public Object convert(Class type, Object value) {
	        if (value instanceof Date) {
	            return value;
	        }
	        String p = (String) value;
	        if (StringUtils.isEmpty(p)) {
	            return null;
	        }
	        try {
	            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	            return  df.parse(p.trim());
	        } catch (Exception e) {
	            try {
	                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	                return  df.parse(p.trim());
	            } catch (Exception ex) {
	                return null;
	            }
	        }
	    }
}
