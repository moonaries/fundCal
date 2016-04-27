package com.lji.local.spring.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lji.local.spring.ism.dao.IsmFundMapper;
import com.lji.local.spring.ism.model.IsmFund;
import com.lji.local.spring.ism.model.IsmFundCriteria;
import com.lji.local.spring.service.IsmFundService;

@Service(value="ismService")
public class IsmFundServiceImpl implements IsmFundService {
	
	@Autowired
	private IsmFundMapper ismFundDao;

	@Override
	public List<IsmFund> getFundList() {
		IsmFundCriteria example = new IsmFundCriteria();
		RowBounds row = new RowBounds(0, 20);
		return ismFundDao.selectByExampleWithRowbounds(example, row);
	}

}
