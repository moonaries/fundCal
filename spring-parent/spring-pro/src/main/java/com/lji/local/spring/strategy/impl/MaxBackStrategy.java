package com.lji.local.spring.strategy.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;

import lji.com.local.spring.common.Commons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.lji.local.spring.common.SectionType;
import com.lji.local.spring.dce.dao.DceFundNetMapper;
import com.lji.local.spring.dce.dao.extend.DceMapperExtend;
import com.lji.local.spring.dce.model.DceFundNet;
import com.lji.local.spring.dce.model.DceFundNetCriteria;
import com.lji.local.spring.strategy.IStrategy;
import com.lji.local.spring.strategy.bean.TimeSection;

@Service(value="maxBackStrategy")
public class MaxBackStrategy implements IStrategy<Map<String,Object>,BigDecimal> {


	@Autowired
	private TimeStrategy timeStrategy;
	
	@Autowired
	private DceMapperExtend dceDaoEx;
	
	@Autowired
	private DceFundNetMapper netDao;

	@Override
	public BigDecimal operate(Map<String, Object> map) {
		String id = map.get("id").toString();
		SectionType s = (SectionType)map.get("section");
		TimeSection ts = timeStrategy.getTimeSection(s, id);
		if(StringUtils.isNotEmpty(id)) {
			BigDecimal maxBack = new BigDecimal(0);
			DceFundNet maxNet = dceDaoEx.getMaxFundNet(id, ts.getStart(), ts.getEnd());
			
			DceFundNetCriteria example = new DceFundNetCriteria();
			example.createCriteria().andFundTempIdEqualTo(id).andCreateTimeGreaterThanOrEqualTo(ts.getStart())
				.andCreateTimeLessThan(ts.getEnd());
			example.setOrderByClause(" create_time DESC");
			List<DceFundNet> nets = netDao.selectByExample(example);
			if(nets!=null && nets.size() > 0 && maxNet != null) {
				for(DceFundNet net : nets) {
					if(net.getCreateTime().after(maxNet.getCreateTime())) {
						BigDecimal temp = net.getFundNet().subtract(maxNet.getFundNet())
								.divide(maxNet.getFundNet(), Commons.ACCURACY, RoundingMode.HALF_UP);
						if(temp.compareTo(maxBack) < 0) {
							maxBack = temp;
						}
					} else if(net.getCreateTime().before(maxNet.getCreateTime())) {
						maxNet = dceDaoEx.getMaxFundNet(id, ts.getStart(), net.getCreateTime());
						if(maxNet != null) {
							BigDecimal temp = net.getFundNet().subtract(maxNet.getFundNet())
									.divide(maxNet.getFundNet(), Commons.ACCURACY, RoundingMode.HALF_UP);
							if(temp.compareTo(maxBack) < 0) {
								maxBack = temp;
							}
						} else {
							// 这里是做的保护，因为有日期重复的
							return maxBack.equals(new BigDecimal(0))?null:maxBack;
						}
					}
				}
				return maxBack.equals(new BigDecimal(0))?null:maxBack;
			}
		}
		return null;
	}

}
