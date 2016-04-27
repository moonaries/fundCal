package lji.com.local.spring.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class PropertiesUtil {
	
	private static Properties prop;
	
	private static Logger logger = Logger.getLogger(PropertiesUtil.class);
	
	public static String getValue(String key) {
		String retValue = "";

		try {
		if(prop == null) {
				InputStream in = ClassLoader.getSystemClassLoader().getResourceAsStream("dubbo.properties");
				prop = new Properties();
				prop.load(in);
			}
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
		retValue = prop.getProperty(key, "").trim();
        return retValue;
		
	}

}
