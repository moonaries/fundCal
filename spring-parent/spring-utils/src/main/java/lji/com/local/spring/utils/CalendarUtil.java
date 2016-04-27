package lji.com.local.spring.utils;

import java.util.Calendar;
import java.util.Date;

public class CalendarUtil {
		
	/**
	 * 获取本周第一天(以周末作为第一天)
	 * @auther lji
	 * @date 2016年3月16日下午3:50:16
	 * @return
	 */
	public static Date getWeekStart(Date date) {
		if(date == null) {
			return null;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		cal.add(Calendar.DATE, 1 - dayOfWeek);
		return cal.getTime();
	}
	
	/**
	 * 获取本月的第一天
	 * @auther lji
	 * @date 2016年3月17日下午3:52:53
	 * @param date
	 * @return
	 */
	public static Date getMonthStart(Date date) {
		if(date == null) {
			return null;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		cal.clear();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month);
		return cal.getTime();
	}
		
	/**
	 * 获取year年的第一天
	 * @auther lji
	 * @date 2016年3月16日上午11:04:29
	 * @param year
	 * @return
	 */
	public static Date getYearStart(int year) {
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(Calendar.YEAR, year);
		return cal.getTime();
	}
	
	/**
	 * 获取data的下一周
	 * @auther lji
	 * @date 2016年3月16日下午3:59:53
	 * @return
	 */
	public static Date nextWeekDay(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, 7);
		return cal.getTime();
	}
	
	/**
	 * 获取data的下一月
	 * @auther lji
	 * @date 2016年3月16日下午3:59:53
	 * @return
	 */
	public static Date nextMonthDay(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, 1);
		return cal.getTime();
	}
	
	/**
	 * 判断两个日期是否是同一周
	 * @auther lji
	 * @date 2016年3月16日下午4:12:05
	 * @param date_one
	 * @param date_two
	 * @return
	 */
	public static boolean isSameWeek(Date date_one,Date date_two) {
		Calendar cal_one = Calendar.getInstance();
		Calendar cal_two = Calendar.getInstance();
		cal_one.setTime(date_one);
		cal_two.setTime(date_two);
		if((cal_one.get(Calendar.YEAR) != cal_two.get(Calendar.YEAR)) 
				|| cal_one.get(Calendar.WEEK_OF_YEAR) != cal_two.get(Calendar.WEEK_OF_YEAR)) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * 获取date所在的年份
	 * @auther lji
	 * @date 2016年3月16日下午5:20:50
	 * @param date
	 * @return
	 */
	public static int getYear(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.YEAR);
	}
	
	/**
	 * 获取date所在的月份
	 * @auther lji
	 * @date 2016年3月16日下午5:20:50
	 * @param date
	 * @return
	 */
	public static int getMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.MONTH);
	}

}
