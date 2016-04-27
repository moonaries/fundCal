package com.lji.local.spring.strategy.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import lji.com.local.spring.utils.CalendarUtil;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lji.local.spring.common.SectionType;
import com.lji.local.spring.ism.dao.IsmFundNetTempMapper;
import com.lji.local.spring.ism.model.IsmFundNetTemp;
import com.lji.local.spring.ism.model.IsmFundNetTempCriteria;
import com.lji.local.spring.strategy.bean.TimeSection;

/**
 * 计算时间区间
 * @author lji
 * @date 2016年3月16日上午10:45:12
 */
@Service
public class TimeStrategy {	
	
	@Autowired
	private IsmFundNetTempMapper netDao;
	
	/**
	 * 返回日期结果集
	 * @auther lji
	 * @date 2016年3月16日上午11:05:05
	 * @param s
	 * @param id
	 * @return
	 */
	public TimeSection getTimeSection(SectionType s,String id) {
		Calendar cal = Calendar.getInstance();
		TimeSection result = new TimeSection();
		IsmFundNetTemp net = new IsmFundNetTemp();
		if(StringUtils.isNotEmpty(id) && !id.toUpperCase().equals("HSZS")) {
			IsmFundNetTempCriteria example = new IsmFundNetTempCriteria();
			example.createCriteria().andFundTempIdEqualTo(id);
			example.setOrderByClause(" create_time asc");
			RowBounds row = new RowBounds(0,1);
			List<IsmFundNetTemp> list = netDao.selectByExampleWithRowbounds(example, row);
			if(list!= null && list.size() > 0) {
				net = list.get(0);
			}
		}
		
		switch(s.getIndex()) {
		// 今年以来
		case 1:
			result.setStart(CalendarUtil.getYearStart(cal.get(Calendar.YEAR)));
			result.setEnd(new Date());
			break;
		// 成立以来
		case 2:
			result.setStart(net.getCreateTime());
			result.setEnd(new Date());
			break;
		// 近一月
		case 3:
			cal.add(Calendar.MONTH, -1);
			result.setStart(cal.getTime());
			result.setEnd(new Date());
			break;
		// 近三月
		case 4:
			cal.add(Calendar.MONTH, -3);
			result.setStart(cal.getTime());
			result.setEnd(new Date());
			break;
		// 近六月
		case 5:
			cal.add(Calendar.MONTH, -6);
			result.setStart(cal.getTime());
			result.setEnd(new Date());
			break;
		// 近一年
		case 6:
			cal.add(Calendar.YEAR, -1);
			result.setStart(cal.getTime());
			result.setEnd(new Date());
			break;
		// 近两年
		case 7:
			cal.add(Calendar.YEAR, -2);
			result.setStart(cal.getTime());
			result.setEnd(new Date());
			break;
		// 近三年
		case 8:
			cal.add(Calendar.YEAR, -3);
			result.setStart(cal.getTime());
			result.setEnd(new Date());
			break;
		// curYear - 1
		case 9:
			result.setStart(CalendarUtil.getYearStart(cal.get(Calendar.YEAR) - 1));
			result.setEnd(CalendarUtil.getYearStart(cal.get(Calendar.YEAR)));
			break;
		// curYear - 2
		case 10:
			result.setStart(CalendarUtil.getYearStart(cal.get(Calendar.YEAR) - 2));
			result.setEnd(CalendarUtil.getYearStart(cal.get(Calendar.YEAR) - 1));
			break;
		// curYear - 3
		case 11:
			result.setStart(CalendarUtil.getYearStart(cal.get(Calendar.YEAR) - 3));
			result.setEnd(CalendarUtil.getYearStart(cal.get(Calendar.YEAR) - 2));
			break;
		// curYear - 4
		case 12:
			result.setStart(CalendarUtil.getYearStart(cal.get(Calendar.YEAR) - 4));
			result.setEnd(CalendarUtil.getYearStart(cal.get(Calendar.YEAR) - 3));
			break;
		}
		return result;
	}
}
