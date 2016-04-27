package com.lji.local.spring.strategy;

import org.springframework.transaction.annotation.Transactional;

import com.lji.local.spring.common.DataSource;

/**
 * 策略类接口
 * @author lji
 * @date 2016年3月16日上午10:33:46
 */
public interface IStrategy<INPUT,OUTPUT> {
	
	/**
	 * 策略执行,并返回执行结果集
	 * @auther lji
	 * @date 2016年3月16日上午10:34:12
	 * @param strategy
	 * @return
	 */
	@DataSource(DataSource.dceDB)
	@Transactional
	public OUTPUT operate(INPUT in);
}
