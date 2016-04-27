package com.lji.local.spring.strategy.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import lji.com.local.spring.utils.CalendarUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lji.local.spring.common.Constant;
import com.lji.local.spring.dce.dao.DceFundDailyRorMapper;
import com.lji.local.spring.dce.dao.DceFundWeekRorMapper;
import com.lji.local.spring.dce.dao.DceQuotationMapper;
import com.lji.local.spring.dce.dao.extend.DceMapperExtend;
import com.lji.local.spring.dce.model.DceFundDailyRor;
import com.lji.local.spring.dce.model.DceFundDailyRorCriteria;
import com.lji.local.spring.dce.model.DceFundNet;
import com.lji.local.spring.dce.model.DceFundWeekRor;
import com.lji.local.spring.dce.model.DceFundWeekRorCriteria;
import com.lji.local.spring.dce.model.DceQuotation;
import com.lji.local.spring.dce.model.DceQuotationCriteria;
import com.lji.local.spring.strategy.IStrategy;
import com.lji.local.spring.strategy.bean.TimeSection;

/**
 * 计算每周收益
 * @author lji
 * @date 2016年3月16日下午3:19:09
 */
@Service(value="weekStrategy")
public class WeekStrategy implements IStrategy<String,String>{
	
	@Autowired
	private DceQuotationMapper hsDao;
	
	@Autowired
	private DceFundWeekRorMapper weekDao;
	
	@Autowired
	private DceMapperExtend dceDaoEx;
	
	@Autowired
	private DceFundDailyRorMapper dailyDao;

	@Override
	public String operate(String in) {
		TimeSection ts = new TimeSection();
		switch(in) {
		case Constant.HS300_ID:
			DceQuotation first = dceDaoEx.getFirstQuotation();
			DceQuotation last = dceDaoEx.getLastQuotation();
			if(first!=null && last != null) {
				// 循环开始时间
				Date stime = CalendarUtil.getWeekStart(first.getCreatDate());
				// 截至时间
				Date ltime = last.getCreatDate();
				// 如果截至日期不是当周，需要截至日期加上7天，以把最后一个日期包含进去
				if(!CalendarUtil.isSameWeek(new Date(), ltime)) {
					ltime = CalendarUtil.nextWeekDay(ltime);
				}
				Date etime = CalendarUtil.nextWeekDay(stime);
				ts.setStart(stime);
				ts.setEnd(etime);
				// 循环开始
				while (ts.getEnd().before(ltime)) {
					DceQuotationCriteria example = new DceQuotationCriteria();
					example.createCriteria().andCreatDateGreaterThanOrEqualTo(ts.getStart())
						.andCreatDateLessThan(ts.getEnd()).andQuotationTypeEqualTo(Constant.QUOTATION_TYPE_HS300);
					example.setOrderByClause(" creat_date ASC");
					List<DceQuotation> qs = hsDao.selectByExample(example);
					BigDecimal weekRor = new BigDecimal(1);
					for(DceQuotation item : qs) {
						weekRor = weekRor.multiply(item.getRor().add(new BigDecimal(1)));
					}
					DceFundWeekRor week = new DceFundWeekRor();
					week.setFundId("HSZS");
					week.setDateRor(ts.getEnd());
					week.setRor(weekRor.subtract(new BigDecimal(1)));
					
					DceFundWeekRorCriteria weekExample = new DceFundWeekRorCriteria();
					weekExample.createCriteria().andDateRorEqualTo(ts.getEnd()).andFundIdEqualTo("HSZS");
					int count = weekDao.countByExample(weekExample);
					if(count > 0) {
						weekDao.updateByExample(week, weekExample);
					} else {
						weekDao.insert(week);
					}
					ts.moveNextWeek();
				}
			}
			break;
		default:
			DceFundNet _first = dceDaoEx.getFirstFundNet(in);
			DceFundNet _last = dceDaoEx.getLastFundNet(in);
			if(_first!=null && _last!=null) {
				// 循环开始时间
				Date stime = CalendarUtil.getWeekStart(_first.getCreateTime());
				// 截至时间
				Date ltime = _last.getCreateTime();
				// 如果截至日期不是当周，需要截至日期加上7天，以把最后一个日期包含进去
				if(!CalendarUtil.isSameWeek(new Date(), ltime)) {
					ltime = CalendarUtil.nextWeekDay(ltime);
				}
				Date etime = CalendarUtil.nextWeekDay(stime);
				ts.setStart(stime);
				ts.setEnd(etime);
				// 循环开始
				while(ts.getEnd().before(ltime)) {
					DceFundDailyRorCriteria example = new DceFundDailyRorCriteria();
					example.createCriteria().andDateRorGreaterThanOrEqualTo(ts.getStart())
						.andDateRorLessThan(ts.getEnd()).andFundIdEqualTo(in);
					example.setOrderByClause(" date_ror ASC");
					List<DceFundDailyRor> qs = dailyDao.selectByExample(example);
					BigDecimal weekRor = new BigDecimal(1);
					for(DceFundDailyRor item : qs) {
						weekRor = weekRor.multiply(item.getValueRor().add(new BigDecimal(1)));
					}
					DceFundWeekRor week = new DceFundWeekRor();
					week.setFundId(in);
					week.setDateRor(ts.getEnd());
					week.setRor(weekRor.subtract(new BigDecimal(1)));
					
					DceFundWeekRorCriteria weekExample = new DceFundWeekRorCriteria();
					weekExample.createCriteria().andDateRorEqualTo(ts.getEnd()).andFundIdEqualTo(in);
					int count = weekDao.countByExample(weekExample);
					if(count > 0) {
						weekDao.updateByExample(week, weekExample);
					} else {
						weekDao.insert(week);
					}
					ts.moveNextWeek();
				}
				
			}
			break;
		}
		return null;
	}

}
