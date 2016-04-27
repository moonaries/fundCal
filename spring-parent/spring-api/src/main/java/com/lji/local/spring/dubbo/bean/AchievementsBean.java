package com.lji.local.spring.dubbo.bean;

import java.io.Serializable;

public class AchievementsBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -970415526545363L;

	/**
	 * 绩效ID
	 */
	private String achievementsId;
	
	/**
	 * 基金ID
	 */
	private String fundTempId;
	
	/**
	 * 收益率
	 */
	private String profit; 
	
	/**
	 * 年化收益
	 */
	private String yearsProfit;
	
	/**
	 * 最大回撤率
	 */
	private String maxBackVal;
	
	/**
	 * 月胜率
	 */
	private String everyYearsWinrate;
	
	/**
	 * 夏普比率
	 */
	private String sharpRatio;
	
	/**
	 * 索提诺比率
	 */
	private String atinuoRatio;
	
	/**
	 * 特雷诺比率
	 */
	private String treynorRatio;
	
	/**
	 * 时间区间类型
	 */
	private String sectionType;
	
	/**
	 * 上一次更新时间
	 */
	private String lastUpdateTime;
	
	/**
	 * 上一次更新操作人
	 */
	private String lastor;
	
	/**
	 * 创建时间
	 */
	private String createDate;

	/**
	 * 创建人
	 */
	private String creator;

	public String getAchievementsId() {
		return achievementsId;
	}

	public void setAchievementsId(String achievementsId) {
		this.achievementsId = achievementsId;
	}

	public String getFundTempId() {
		return fundTempId;
	}

	public void setFundTempId(String fundTempId) {
		this.fundTempId = fundTempId;
	}

	public String getProfit() {
		return profit;
	}

	public void setProfit(String profit) {
		this.profit = profit;
	}

	public String getYearsProfit() {
		return yearsProfit;
	}

	public void setYearsProfit(String yearsProfit) {
		this.yearsProfit = yearsProfit;
	}

	public String getMaxBackVal() {
		return maxBackVal;
	}

	public void setMaxBackVal(String maxBackVal) {
		this.maxBackVal = maxBackVal;
	}

	public String getEveryYearsWinrate() {
		return everyYearsWinrate;
	}

	public void setEveryYearsWinrate(String everyYearsWinrate) {
		this.everyYearsWinrate = everyYearsWinrate;
	}

	public String getSharpRatio() {
		return sharpRatio;
	}

	public void setSharpRatio(String sharpRatio) {
		this.sharpRatio = sharpRatio;
	}

	public String getAtinuoRatio() {
		return atinuoRatio;
	}

	public void setAtinuoRatio(String atinuoRatio) {
		this.atinuoRatio = atinuoRatio;
	}

	public String getTreynorRatio() {
		return treynorRatio;
	}

	public void setTreynorRatio(String treynorRatio) {
		this.treynorRatio = treynorRatio;
	}

	public String getSectionType() {
		return sectionType;
	}

	public void setSectionType(String sectionType) {
		this.sectionType = sectionType;
	}

	public String getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(String lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public String getLastor() {
		return lastor;
	}

	public void setLastor(String lastor) {
		this.lastor = lastor;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}
}
