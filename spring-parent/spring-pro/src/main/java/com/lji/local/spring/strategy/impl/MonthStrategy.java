package com.lji.local.spring.strategy.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import lji.com.local.spring.utils.CalendarUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lji.local.spring.common.Constant;
import com.lji.local.spring.dce.dao.DceFundDailyRorMapper;
import com.lji.local.spring.dce.dao.DceFundMonthRorMapper;
import com.lji.local.spring.dce.dao.DceFundNetMapper;
import com.lji.local.spring.dce.dao.DceQuotationMapper;
import com.lji.local.spring.dce.dao.extend.DceMapperExtend;
import com.lji.local.spring.dce.model.DceFundDailyRor;
import com.lji.local.spring.dce.model.DceFundDailyRorCriteria;
import com.lji.local.spring.dce.model.DceFundMonthRor;
import com.lji.local.spring.dce.model.DceFundMonthRorCriteria;
import com.lji.local.spring.dce.model.DceFundNet;
import com.lji.local.spring.dce.model.DceQuotation;
import com.lji.local.spring.dce.model.DceQuotationCriteria;
import com.lji.local.spring.strategy.IStrategy;
import com.lji.local.spring.strategy.bean.TimeSection;

/**
 * 计算月收益
 * @author lji
 * @date 2016年3月16日下午4:49:09
 */
@Service(value="monthStrategy")
public class MonthStrategy implements IStrategy<String,String> {
	
	@Autowired
	private DceFundMonthRorMapper monthDao;
	
	@Autowired
	private DceQuotationMapper hsDao;
	
	@Autowired
	private DceMapperExtend dceDaoEx;
	
	@Autowired
	private DceFundNetMapper netDao;
	
	@Autowired
	private DceFundDailyRorMapper dailyDao;

	@Override
	public String operate(String in) {
		TimeSection ts = new TimeSection();
		switch(in) {
		case Constant.HS300_ID:
			DceQuotation first = dceDaoEx.getFirstQuotation();
			if(first!=null) {
				// 第一个日期所在的年份、月度
				Date stime = CalendarUtil.getMonthStart(first.getCreatDate());
				Date etime = CalendarUtil.nextMonthDay(stime);
				ts.setStart(stime);
				ts.setEnd(etime);
				while(ts.getStart().before(new Date())) {					
					DceQuotationCriteria example = new DceQuotationCriteria();
					example.createCriteria().andQuotationTypeEqualTo(Constant.QUOTATION_TYPE_HS300)
						.andCreatDateGreaterThanOrEqualTo(ts.getStart()).andCreatDateLessThan(ts.getEnd());
					example.setOrderByClause(" creat_date ASC");
					List<DceQuotation> _list = hsDao.selectByExample(example);
					BigDecimal monthRor = new BigDecimal(1);
					for(DceQuotation _q : _list) {
						monthRor = monthRor.multiply(_q.getRor().add(new BigDecimal(1)));
					}
					
					DceFundMonthRor month = new DceFundMonthRor();
					month.setFundId("HSZS");
					month.setMonthRor(CalendarUtil.getMonth(ts.getStart()) + 1);
					month.setYearRor(CalendarUtil.getYear(ts.getStart()));
					month.setRor(monthRor.subtract(new BigDecimal(1)));
					
					DceFundMonthRorCriteria _example = new DceFundMonthRorCriteria();
					_example.createCriteria().andFundIdEqualTo("HSZS")
						.andYearRorEqualTo(CalendarUtil.getYear(ts.getStart()))
						.andMonthRorEqualTo(CalendarUtil.getMonth(ts.getStart()) + 1);
					int count = monthDao.countByExample(_example);
					if(count > 0) {
						monthDao.updateByExample(month, _example);
					} else {
						monthDao.insert(month);
					}
					ts.moveNextMonth();
				}
			}
			break;
		default:
			DceFundNet _first = dceDaoEx.getFirstFundNet(in);
			if(_first!=null) {
				// 第一个日期所在的年份、月度
				Date stime = CalendarUtil.getMonthStart(_first.getCreateTime());
				Date etime = CalendarUtil.nextMonthDay(stime);
				ts.setStart(stime);
				ts.setEnd(etime);
				while(ts.getStart().before(new Date())) {					
					DceFundDailyRorCriteria example = new DceFundDailyRorCriteria();
					example.createCriteria().andFundIdEqualTo(in)
						.andDateRorGreaterThanOrEqualTo(ts.getStart()).andDateRorLessThan(ts.getEnd());
					example.setOrderByClause(" date_ror ASC");
					List<DceFundDailyRor> list = dailyDao.selectByExample(example);
					BigDecimal monthRor = new BigDecimal(1);
					for(DceFundDailyRor q : list) {
						monthRor = monthRor.multiply(q.getValueRor().add(new BigDecimal(1)));
					}
					
					DceFundMonthRor month = new DceFundMonthRor();
					month.setFundId(in);
					month.setMonthRor(CalendarUtil.getMonth(ts.getStart()) + 1);
					month.setYearRor(CalendarUtil.getYear(ts.getStart()));
					month.setRor(monthRor.subtract(new BigDecimal(1)));
					
					DceFundMonthRorCriteria _example = new DceFundMonthRorCriteria();
					_example.createCriteria().andFundIdEqualTo(in)
						.andYearRorEqualTo(CalendarUtil.getYear(ts.getStart()))
						.andMonthRorEqualTo(CalendarUtil.getMonth(ts.getStart()) + 1);
					int count = monthDao.countByExample(_example);
					if(count > 0) {
						monthDao.updateByExample(month, _example);
					} else {
						monthDao.insert(month);
					}
					ts.moveNextMonth();
				}
			}
			break;
		}
		return null;
	}

}
