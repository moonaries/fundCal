package com.lji.local.spring.dubbo.service;

import java.util.List;

import com.lji.local.spring.dubbo.bean.AchievementsBean;

public interface DceService {

	/**
	 * 计算单个基金的绩效
	 * @auther lji
	 * @date 2016年3月17日下午4:46:47
	 * @param id 这里传递过来的id是ism_fund_temp中的fund_temp_id，即ism表中的基金id，后续的计算中需要转换成fund_source_id
	 * @return
	 */
	public List<AchievementsBean> calSingleFund(String id);
	
	/**
	 * 根据id列表计算基金绩效，不入库，返回计算结果列表
	 * @auther lji
	 * @date 2016年3月23日上午4:57:00
	 * @param ids
	 * @return
	 */
	public List<List<AchievementsBean>> calFunds(List<String> ids);
	
	/**
	 * 计算所有基金的绩效,过程中的信息会打印在log中
	 * @auther lji
	 * @date 2016年3月17日下午4:47:56
	 * @return
	 */
	public void calAllFund();
	
	/**
	 * 计算沪深300的绩效
	 * @auther lji
	 * @date 2016年3月18日上午3:09:02
	 * @return
	 */
	public List<AchievementsBean> calQuotation();
}
