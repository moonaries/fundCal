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
import com.lji.local.spring.dce.dao.DceFundWeekRorMapper;
import com.lji.local.spring.dce.dao.extend.DceMapperExtend;
import com.lji.local.spring.dce.model.DceFundWeekRor;
import com.lji.local.spring.dce.model.DceFundWeekRorCriteria;
import com.lji.local.spring.strategy.IStrategy;
import com.lji.local.spring.strategy.bean.TimeSection;

@Service(value="treynorStrategy")
public class TreynorStrategy implements IStrategy<Map<String,Object>,BigDecimal> {
	
	@Autowired
	private TimeStrategy timeStrategy;
	
	@Autowired
	private DceMapperExtend dceDaoEx;
	
	@Autowired
	private DceFundWeekRorMapper weekDao;

	@Override
	public BigDecimal operate(Map<String, Object> map) {
		String id = map.get("id").toString();
		SectionType s = (SectionType)map.get("section");
		TimeSection ts = timeStrategy.getTimeSection(s, id);
		if(StringUtils.isNotEmpty(id)) {
			DceFundWeekRorCriteria example = new DceFundWeekRorCriteria();
			example.createCriteria().andFundIdEqualTo(id).andDateRorGreaterThanOrEqualTo(ts.getStart())
				.andDateRorLessThan(ts.getEnd());
			example.setOrderByClause(" date_ror ASC");
			List<DceFundWeekRor> weeks = weekDao.selectByExample(example);
			
			if(weeks!=null && weeks.size() > 9) {
				List<BigDecimal> rors = new ArrayList<BigDecimal>();
				List<BigDecimal> hsRors = new ArrayList<BigDecimal>();
				for(DceFundWeekRor week : weeks) {
					rors.add(week.getRor());
					DceFundWeekRor hs300 = dceDaoEx.getLatelyIndexRor("HSZS", week.getDateRor());
					hsRors.add(hs300.getRor());
				}
				
				BigDecimal cov = MathUtil.cov(rors, hsRors);
				// cov可能很小，在很小的时候不参与计算
				if(cov != null && (cov.abs().compareTo(new BigDecimal(0)) > 0E-8)) {
					BigDecimal beta = cov.divide(MathUtil.std(hsRors).pow(2), Commons.ACCURACY, RoundingMode.HALF_UP);
					BigDecimal rfProfit = dceDaoEx.getLatestDepositRate(ts.getEnd());
					return (MathUtil.avg(rors).subtract(rfProfit.divide(new BigDecimal(52), Commons.ACCURACY, RoundingMode.HALF_UP)))
							.divide(beta, Commons.ACCURACY, RoundingMode.HALF_UP);
				}
			}
		}
		return null;
	}

}
