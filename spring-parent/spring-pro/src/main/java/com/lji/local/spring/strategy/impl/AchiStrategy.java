package com.lji.local.spring.strategy.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.lji.local.spring.common.Constant;
import com.lji.local.spring.common.SectionType;
import com.lji.local.spring.dce.dao.DceAchievementsMapper;
import com.lji.local.spring.dce.dao.extend.DceMapperExtend;
import com.lji.local.spring.dce.model.DceAchievements;
import com.lji.local.spring.dce.model.DceFundNet;
import com.lji.local.spring.strategy.IStrategy;

/**
 * 计算绩效数据
 * @author lji
 * @date 2016年3月16日上午10:42:51
 */
@Service(value="achiStrategy")
public class AchiStrategy implements IStrategy<String,List<DceAchievements>> {
	
	@Autowired
	private TimeStrategy timeStrategy;
		
	@Autowired
	private DceAchievementsMapper achievementsDao;
	
	@Resource(name="rateStrategy")
	private RateStrategy rateStrategy;
	
	@Resource(name="sharpStrategy")
	private SharpStrategy sharpStrategy;

	@Resource(name="atinuoStrategy")
	private AtinuoStrategy atinuoStrategy;

	@Resource(name="treynorStrategy")
	private TreynorStrategy treynorStrategy;

	@Resource(name="winRateStrategy")
	private WinRateStrategy winRateStrategy;

	@Resource(name="maxBackStrategy")
	private MaxBackStrategy maxBackStrategy;
	
	@Autowired
	private DceMapperExtend dceDaoEx;

	@Resource(name="diffStrategy")
	private DiffStrategy diffStrategy;

	@Resource(name="dailyStrategy")
	private DailyStrategy dailyStrategy;

	@Resource(name="weekStrategy")
	private WeekStrategy weekStrategy;

	@Resource(name="monthStrategy")
	private MonthStrategy monthStrategy;

	@Override
	public List<DceAchievements> operate(String in) {
		List<DceAchievements> result = new ArrayList<DceAchievements>();
		// 沪深300不需要计算diff
		if(StringUtils.isNotEmpty(in) && !in.equals(Constant.HS300_ID)) {
			// 如果基金没有净值，则返回空集合
			DceFundNet net = dceDaoEx.getFirstFundNet(in);
			if(net == null) {
				return result;
			}
			diffStrategy.operate(in);
		}
		dailyStrategy.operate(in);
		weekStrategy.operate(in);
		monthStrategy.operate(in);
		
		for(SectionType s : SectionType.values()) {
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("id", in);
			map.put("section", s);
			// 沪深300不计算成立以来收益率
			if(s.getIndex() == 2 && in.equals(Constant.HS300_ID)) {
				continue;
			} else {
				DceAchievements achi = dceDaoEx.getAchiByIdAndSection(in, s.getValue());
				// 如果没有这一条记录
				if(achi == null) {
					achi = new DceAchievements();
					achi.setAchievementsId(UUID.randomUUID().toString());
					achi.setCreateDate(new Date());
					achi.setCreator("JUYUAN");
					achi.setFundTempId(in);
					achi.setLastor("JUYUAN");
					achi.setLastUpdateTime(new Date());
					achi.setSectionType(s.getValue());
				}
				
				BigDecimal rate = rateStrategy.operate(map);
				achi.setProfit(rate);
				BigDecimal sharp,atinuo,treynor,winnerRate,maxBack;
				// 一般基金需要计算这些,沪深300只需要计算收益率
				if(!in.equals(Constant.HS300_ID)) {
					sharp = sharpStrategy.operate(map);
					atinuo = atinuoStrategy.operate(map);
					treynor = treynorStrategy.operate(map);
					winnerRate = winRateStrategy.operate(map);
					maxBack = maxBackStrategy.operate(map);
					
					achi.setSharpRatio(sharp);
					achi.setAtinuoRatio(atinuo);
					achi.setTreynorRatio(treynor);
					achi.setEveryYearsWinrate(winnerRate);
					achi.setMaxBackVal(maxBack);
				}
				result.add(achi);
			}
		}
		return result;
	}
}
