package com.lji.local.spring.strategy.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;

import lji.com.local.spring.common.Commons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.lji.local.spring.common.SectionType;
import com.lji.local.spring.dce.dao.extend.DceMapperExtend;
import com.lji.local.spring.strategy.IStrategy;
import com.lji.local.spring.strategy.bean.TimeSection;

@Service(value="winRateStrategy")
public class WinRateStrategy implements IStrategy<Map<String,Object>,BigDecimal> {
	
	@Autowired
	private TimeStrategy timeStrategy;
	
	@Autowired
	private DceMapperExtend dceDaoEx;

	@Override
	public BigDecimal operate(Map<String, Object> map) {
		String id = map.get("id").toString();
		SectionType s = (SectionType)map.get("section");
		TimeSection ts = timeStrategy.getTimeSection(s, id);
		if(StringUtils.isNotEmpty(id)) {
			String sql = "SELECT ror FROM ism_fund_monthly_ror WHERE fund_id = #{id} " + 
			"AND (year_ror > YEAR(#{stime}) OR (year_ror = YEAR(#{stime}) AND month_ror >= MONTH(#{stime}))) " +
			"AND (year_ror < YEAR(#{etime}) OR (year_ror = YEAR(#{etime}) AND month_ror < MONTH(#{etime})))";
			
			List<BigDecimal> rors = dceDaoEx.getRors(sql, id, ts.getStart(), ts.getEnd());
			int winNum = 0,allNum = 0;
			for(BigDecimal ror : rors) {
				allNum ++;
				if(ror.compareTo(new BigDecimal(0)) > 0) {
					winNum ++;
				}
			}
			if(allNum > 0) {
				return new BigDecimal(winNum).divide(new BigDecimal(allNum), Commons.ACCURACY, RoundingMode.HALF_UP);
			}
		}
		return null;
	}

}
