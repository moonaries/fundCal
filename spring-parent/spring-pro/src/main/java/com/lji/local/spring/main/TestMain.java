package com.lji.local.spring.main;

import java.io.FileNotFoundException;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.util.Log4jConfigurer;

import com.lji.local.spring.call.MainExecutor;
import com.lji.local.spring.container.SpringContainer;

public class TestMain {
	
	private static Logger logger = Logger.getLogger(TestMain.class);
	
	public static void main(String[] args) {
		
		
		try {
			Log4jConfigurer.initLogging("classpath:log4j.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		logger.info(new Date() + "	计算开始");
		SpringContainer container = new SpringContainer();
		container.start();
		
		MainExecutor mainExecutor = SpringContainer.getContext().getBean(MainExecutor.class);
		mainExecutor.calAll();
		
		logger.info(new Date() + "	计算结束");
//		DceService dceService = SpringContainer.getContext().getBean(DceService.class);
//		dceService.calAllFund();
//		dceService.calSingleFund("276e92e5-820b-11e5-93a9-02004c4f4f50");
	}

}

