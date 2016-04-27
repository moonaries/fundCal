package lji.com.local.spring.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import lji.com.local.spring.common.Commons;

public class MathUtil {
	
	/**
	 * 求和
	 * @auther lji
	 * @date 2016年3月17日下午11:06:44
	 * @param list
	 * @return
	 */
	public static BigDecimal sum(List<BigDecimal> list) {
		if(list!=null && list.size() > 0) {
			BigDecimal result = new BigDecimal(0);
			for(BigDecimal b : list) {
				result = result.add(b);
			}
			return result;
		} else {
			return null;
		}
	}
	
	/**
	 * 求平均值
	 * @auther lji
	 * @date 2016年3月17日下午11:05:02
	 * @param list
	 * @return
	 */
	public static BigDecimal avg(List<BigDecimal> list) {
		if(list!=null && list.size() > 0) {
			return sum(list).divide(new BigDecimal(list.size()), Commons.ACCURACY, RoundingMode.HALF_UP);
		} else {
			return null;
		}
	}
	
	/**
	 * 求标准差
	 * @auther lji
	 * @date 2016年3月17日下午11:12:30
	 * @param list
	 * @return
	 */
	public static BigDecimal std(List<BigDecimal> list) {
		if(list!=null && list.size() > 0) {
			return new BigDecimal(Math.sqrt(var(list).doubleValue()));
		} else {
			return null;
		}
	}
	
	/**
	 * 求方差
	 * @auther lji
	 * @date 2016年3月17日下午11:14:33
	 * @param list
	 * @return
	 */
	public static BigDecimal var(List<BigDecimal> list) {
		if(list!=null && list.size() > 0) {
			BigDecimal avg = avg(list);
			BigDecimal temp = new BigDecimal(0);
			for(BigDecimal b : list) {
				temp = temp.add((b.subtract(avg)).pow(2));
			}
			return temp.divide(new BigDecimal(list.size()), Commons.ACCURACY, RoundingMode.HALF_UP);
		} else {
			return null;
		}
	}
	
	/**
	 * 计算两个变量样本的协方差
	 * 这里要求变量样本数目一致，逻辑顺序一致(程序中体现在时间顺序上)
	 * @auther lji
	 * @date 2016年3月18日上午12:31:39
	 * @param sampleOne
	 * @param sampleTwo
	 * @return
	 */
	public static BigDecimal cov(List<BigDecimal> sampleOne,List<BigDecimal> sampleTwo) {
		if(sampleOne!=null && sampleTwo!=null && sampleOne.size() == sampleTwo.size()) {
			BigDecimal avgOne = avg(sampleOne);
			BigDecimal avgTwo = avg(sampleTwo);
			BigDecimal temp = new BigDecimal(0);
			for(int i =0;i<sampleOne.size();i++) {
				temp = temp.add((sampleOne.get(i).subtract(avgOne)).multiply(sampleTwo.get(i).subtract(avgTwo)));
			}
			return temp.divide(new BigDecimal(sampleOne.size()), Commons.ACCURACY, RoundingMode.HALF_UP);
		} else {
			return null;
		}
	}
}
