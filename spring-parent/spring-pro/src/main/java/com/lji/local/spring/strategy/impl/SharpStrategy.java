package com.lji.local.spring.strategy.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lji.com.local.spring.common.Commons;
import lji.com.local.spring.utils.MathUtil;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lji.local.spring.common.SectionType;
import com.lji.local.spring.dce.dao.extend.DceMapperExtend;
import com.lji.local.spring.strategy.IStrategy;
import com.lji.local.spring.strategy.bean.TimeSection;

@Service(value="sharpStrategy")
public class SharpStrategy implements IStrategy<Map<String,Object>,BigDecimal> {
	
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
			String sql = "SELECT ror FROM ism_fund_week_ror WHERE fund_id = #{id} "
					+ "AND date_ror >= #{stime} AND date_ror < #{etime}";
			List<BigDecimal> rors = dceDaoEx.getRors(sql, id, ts.getStart(), ts.getEnd());
			if(rors!=null && rors.size() > 9) {
				// 无风险收益率
				BigDecimal rfProfit = dceDaoEx.getLatestDepositRate(ts.getEnd());
				// 收益率平均值
				BigDecimal avgProfit = MathUtil.avg(rors);
				List<BigDecimal> list = new ArrayList<BigDecimal>();
				for(BigDecimal ror : rors) {
					BigDecimal temp = ror.subtract(rfProfit);
					list.add(temp);
				}
				BigDecimal stdF = MathUtil.std(list);
				// 保护分母
				if(stdF.abs().compareTo(new BigDecimal(0)) < 1E-10) {
					return null;
				}
				return (avgProfit.subtract(rfProfit.divide(new BigDecimal(52), Commons.ACCURACY, RoundingMode.HALF_UP)))
						.divide(MathUtil.std(list), Commons.ACCURACY, RoundingMode.HALF_UP).multiply(new BigDecimal(Math.pow(52, 0.5)));
			}
		}
		return null;
	}

}
