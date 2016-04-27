package com.lji.local.spring.strategy.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.lji.local.spring.dce.dao.DceFundMapper;
import com.lji.local.spring.dce.dao.DceFundNetMapper;
import com.lji.local.spring.dce.model.DceFund;
import com.lji.local.spring.dce.model.DceFundCriteria;
import com.lji.local.spring.dce.model.DceFundNet;
import com.lji.local.spring.dce.model.DceFundNetCriteria;
import com.lji.local.spring.strategy.IStrategy;

/**
 * 计算diff,diff指的是当期基金累计净值与单位净值的差值a与上一期基金累计净值与单位净值的差值b的差值，即a-b
 * @author lji
 * @date 2016年3月16日下午1:53:09
 */
@Service(value="diffStrategy")
public class DiffStrategy implements IStrategy<String,String> {
	
	@Autowired
	private DceFundNetMapper netDao;
	
	@Autowired
	private DceFundMapper fundDao;

	@Override
	public String operate(String in) {
		if(StringUtils.isEmpty(in)) {
			return "基金ID不得为空";
		}
		// 上期累净与单位净值差
		BigDecimal preDiff = new BigDecimal(0);
		
		DceFundNetCriteria example = new DceFundNetCriteria();
		example.createCriteria().andFundTempIdEqualTo(in);
		example.setOrderByClause(" create_time ASC");
		List<DceFundNet> list = netDao.selectByExample(example);
		// 基金是否是按照复利计算,如果连续两次出现ABS(dDiff) > 0.0001，那么则认为该基金是复利计算的基金，这样的基金收益率计算与一般基金不同
		int isComplexflag = 0;
		for(DceFundNet net : list) {
			BigDecimal curNet = net.getFundNet();
			BigDecimal curUpnet = net.getFundUpnet();
			BigDecimal curDiff = curUpnet.subtract(curNet);
			
			BigDecimal dDiff = curDiff.subtract(preDiff);
			if(dDiff.abs().compareTo(new BigDecimal(0.0001)) < 0) {
				dDiff = new BigDecimal(0);
				isComplexflag = 0;
			} else {
				isComplexflag ++;
				if(isComplexflag > 2) {
					DceFund fund = new DceFund();
					fund.setIsComplex(1);
					DceFundCriteria _example = new DceFundCriteria();
					_example.createCriteria().andFundTempIdEqualTo(in);
					fundDao.updateByExampleSelective(fund, _example);
				}
			}
			net.setNvDiff(dDiff);
			netDao.updateByPrimaryKey(net);
			preDiff = curDiff;
		}
		return null;
	}

}
