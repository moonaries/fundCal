package com.lji.local.spring.strategy.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.lji.local.spring.common.Constant;
import com.lji.local.spring.common.SectionType;
import com.lji.local.spring.dce.dao.DceFundDailyRorMapper;
import com.lji.local.spring.dce.dao.DceQuotationMapper;
import com.lji.local.spring.dce.model.DceFundDailyRor;
import com.lji.local.spring.dce.model.DceFundDailyRorCriteria;
import com.lji.local.spring.dce.model.DceQuotation;
import com.lji.local.spring.dce.model.DceQuotationCriteria;
import com.lji.local.spring.strategy.IStrategy;
import com.lji.local.spring.strategy.bean.TimeSection;

/**
 * 收益计算类
 * @author lji
 * @date 2016年3月16日下午12:20:50
 */
@Service(value="rateStrategy")
public class RateStrategy implements IStrategy<Map<String,Object>,BigDecimal> {
	
	@Autowired
	private TimeStrategy timeStrategy;
	
	@Autowired
	private DceQuotationMapper hsDao;
	
	@Autowired
	private DceFundDailyRorMapper fundDailyDao;
	
	@Override
	public BigDecimal operate(Map<String,Object> map) {
		String id = map.get("id").toString();
		SectionType s = (SectionType)map.get("section");
		TimeSection ts = timeStrategy.getTimeSection(s, id);
		BigDecimal result = new BigDecimal(1);
		if(StringUtils.isNotEmpty(id)) {
			switch(id) {
			// 沪深300不计算成立以来收益
			case Constant.HS300_ID:
				if(s.getIndex() == 2) {
					return null;
				}
				DceQuotationCriteria example = new DceQuotationCriteria();
				example.createCriteria().andQuotationTypeEqualTo(Constant.QUOTATION_TYPE_HS300)
					.andCreatDateGreaterThanOrEqualTo(ts.getStart()).andCreatDateLessThan(ts.getEnd());
				example.setOrderByClause(" creat_date ASC");
				List<DceQuotation> list = hsDao.selectByExample(example);
				for(DceQuotation q : list) {
					result = result.multiply(q.getRor().add(new BigDecimal(1)));
				}
				result = result.subtract(new BigDecimal(1));
				break;
			// 计算基金的绩效
			default:
				DceFundDailyRorCriteria _example = new DceFundDailyRorCriteria();
				_example.createCriteria().andFundIdEqualTo(id).andDateRorGreaterThanOrEqualTo(ts.getStart())
					.andDateRorLessThan(ts.getEnd());
				_example.setOrderByClause(" date_ror ASC");
				List<DceFundDailyRor> _list = fundDailyDao.selectByExample(_example);
				for(DceFundDailyRor q : _list) {
					result = result.multiply(q.getValueRor().add(new BigDecimal(1)));
				}
				result = result.subtract(new BigDecimal(1));
				break;
			}
			result = result.divide(new BigDecimal(1), Constant.ACCURACY, RoundingMode.HALF_UP);
			return result;
		} else {
			return null;
		}
	}
 
}
