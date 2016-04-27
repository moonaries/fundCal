package com.lji.local.spring.dubbo.service.impl;

import java.util.ArrayList;
import java.util.List;

import lji.com.local.spring.utils.BeanUtilsEx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lji.local.spring.call.MainExecutor;
import com.lji.local.spring.common.Constant;
import com.lji.local.spring.dce.dao.DceFundMapper;
import com.lji.local.spring.dce.model.DceAchievements;
import com.lji.local.spring.dce.model.DceFund;
import com.lji.local.spring.dubbo.bean.AchievementsBean;
import com.lji.local.spring.dubbo.service.DceService;

@Service
@com.alibaba.dubbo.config.annotation.Service(group = Constant.DUBBO_GROUP_NAME, version = Constant.DUBBO_VERSION)
public class DceServiceImpl implements DceService {
		
	@Autowired
	private MainExecutor executor;
	
	@Autowired
	private DceFundMapper fundDao;

	@Override
	public List<AchievementsBean> calSingleFund(String id) {
		return dce2Bean(executor.calSingle(id));
	}

	@Override
	public List<AchievementsBean> calQuotation() {
		return dce2Bean(executor.calQuotation());
	}
	
	@Override
	public void calAllFund() {
		executor.calAll();
	}
	
	@Override
	public List<List<AchievementsBean>> calFunds(List<String> ids) {
		List<List<AchievementsBean>> result = new ArrayList<List<AchievementsBean>>();
		List<String> sourceIds = new ArrayList<String>();
		for(String id : ids) {
			DceFund fund = fundDao.selectByPrimaryKey(id);
			if(fund != null) {
				sourceIds.add(fund.getFundSourceId());
			}
		}
		List<List<DceAchievements>> list = executor.calAll(sourceIds);
		if(list != null) {
			for(List<DceAchievements> temp : list) {
				result.add(dce2Bean(temp));
			}
		}
		return result;
	}
	
	private List<AchievementsBean> dce2Bean(List<DceAchievements> source) {
		List<AchievementsBean> list = new ArrayList<AchievementsBean>();
		for(DceAchievements dce : source) {
			AchievementsBean bean = new AchievementsBean();
			BeanUtilsEx.copyProperties(bean, dce);
			list.add(bean);
		}
		return list;
	}
}

