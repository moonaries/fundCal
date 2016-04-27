package com.lji.local.spring.strategy.bean;

import java.io.Serializable;
import java.util.Date;

import lji.com.local.spring.utils.CalendarUtil;

/**
 * 时间计算区间段
 * @author lji
 * @date 2016年3月16日下午2:27:44
 */
public class TimeSection implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1837209649253422579L;

	// 开始时间
	private Date start;
	
	// 结束时间
	private Date end;

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}
	
	/**
	 * 时间框向后移动一周
	 * @auther lji
	 * @date 2016年3月17日下午3:19:46
	 */
	public void moveNextWeek() {
		this.start = this.end;
		this.end = CalendarUtil.nextWeekDay(this.end);
	}
	
	/**
	 * 时间框向后移动一月
	 * @auther lji
	 * @date 2016年3月17日下午3:57:59
	 */
	public void moveNextMonth() {
		this.start = this.end;
		this.end = CalendarUtil.nextMonthDay(this.end);
	}
	
	/**
	 * 清空内部信息
	 * @auther lji
	 * @date 2016年3月17日下午3:28:05
	 */
	public void clear() {
		this.start = null;
		this.end = null;
	}
}
