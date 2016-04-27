package com.lji.local.spring.strategy.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lji.local.spring.common.Constant;
import com.lji.local.spring.dce.dao.DceFundDailyRorMapper;
import com.lji.local.spring.dce.dao.DceFundMapper;
import com.lji.local.spring.dce.dao.DceFundNetMapper;
import com.lji.local.spring.dce.dao.DceQuotationMapper;
import com.lji.local.spring.dce.dao.extend.DceMapperExtend;
import com.lji.local.spring.dce.model.DceFund;
import com.lji.local.spring.dce.model.DceFundDailyRor;
import com.lji.local.spring.dce.model.DceFundDailyRorCriteria;
import com.lji.local.spring.dce.model.DceFundNet;
import com.lji.local.spring.dce.model.DceFundNetCriteria;
import com.lji.local.spring.dce.model.DceQuotation;
import com.lji.local.spring.dce.model.DceQuotationCriteria;
import com.lji.local.spring.strategy.IStrategy;

/**
 * 沪深300每日收益计算
 * @author lji
 * @date 2016年3月16日下午3:27:02
 */
@Service(value="dailyStrategy")
public class DailyStrategy implements IStrategy<String,String> {

	@Autowired
	private DceQuotationMapper hsDao;
	
	@Autowired
	private DceFundNetMapper netDao;
	
	@Autowired
	private DceFundMapper fundDao;
	
	@Autowired
	private DceMapperExtend dceDaoEx;
	
	@Autowired
	private DceFundDailyRorMapper dailyDao;
	
	@Override
	public String operate(String in) {
		switch(in) {
		// 计算沪深300
		case Constant.HS300_ID:
			DceQuotationCriteria example = new DceQuotationCriteria();
			example.createCriteria().andQuotationTypeEqualTo(Constant.QUOTATION_TYPE_HS300);
			example.setOrderByClause(" creat_date ASC");
			List<DceQuotation> list = hsDao.selectByExample(example);
			boolean isFirstRow = true;
			BigDecimal preValue = new BigDecimal(1);
			for(DceQuotation q : list) {
				if(isFirstRow) {
					q.setRor(new BigDecimal(0));
					preValue = new BigDecimal(q.getQuotationValue());
					hsDao.updateByPrimaryKey(q);
					isFirstRow = false;
				} else {
					q.setRor((new BigDecimal(q.getQuotationValue()).divide(preValue, Constant.ACCURACY, RoundingMode.HALF_UP)).subtract(new BigDecimal(1)));
					preValue = new BigDecimal(q.getQuotationValue());
					hsDao.updateByPrimaryKey(q);
				}
			}
			break;
		// 如果不是沪深300，那么入参in则是基金的id
		default:
			// 查询基金信息
			DceFund fund = dceDaoEx.getFundBySourceId(in);
							
			DceFundNetCriteria _example = new DceFundNetCriteria();
			_example.createCriteria().andFundTempIdEqualTo(in);
			_example.setOrderByClause(" create_time ASC");
			List<DceFundNet> _list = netDao.selectByExample(_example);
			boolean _isFirstRow = true;
			BigDecimal preNet = new BigDecimal(0);
			BigDecimal preUpnet = new BigDecimal(0);
			
			for(DceFundNet net : _list) {
				DceFundDailyRorCriteria dailyExample = new DceFundDailyRorCriteria();
				dailyExample.createCriteria().andFundIdEqualTo(in).andDateRorEqualTo(net.getCreateTime());
				int count = dailyDao.countByExample(dailyExample);
				DceFundDailyRor daily = new DceFundDailyRor();
				daily.setDateRor(net.getCreateTime());
				daily.setFundId(in);
				if(_isFirstRow) {
					daily.setDividend(new BigDecimal(0));
					daily.setIssuspicious(0);
					daily.setSplitRatio(new BigDecimal(1));
					daily.setValueRor(new BigDecimal(0));
					
					_isFirstRow = false;				
					preNet = net.getFundNet();
					preUpnet = net.getFundUpnet();
				} else {
					BigDecimal ror = new BigDecimal(0);
					switch(fund.getIsComplex()) {
					// 单利模式
					case 0:
						ror = (net.getFundNet().add(net.getNvDiff())).divide(preNet, Constant.ACCURACY, RoundingMode.HALF_UP)
							.subtract(new BigDecimal(1));
						break;
					// 复利模式
					case 1:
						ror = (net.getFundUpnet().divide(preUpnet, Constant.ACCURACY, RoundingMode.HALF_UP)).subtract(new BigDecimal(1));
						break;
					}
					// 净值是否可疑 1、可疑 0 不可疑
					int isSuspicious = 0;
					if(ror.abs().compareTo(new BigDecimal(0.5)) > 0) {
						isSuspicious = 1;
					}
					daily.setDividend(net.getNvDiff());
					daily.setIssuspicious(isSuspicious);
					daily.setSplitRatio(new BigDecimal(1));
					daily.setValueRor(ror);
					
					preNet = net.getFundNet();
					preUpnet = net.getFundUpnet();
				}
				if(count > 0) {
					dailyDao.updateByExample(daily, dailyExample);
				} else {
					dailyDao.insert(daily);
				}
			}
		}
		return null;
	}

}
