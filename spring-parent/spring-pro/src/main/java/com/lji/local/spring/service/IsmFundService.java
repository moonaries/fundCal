package com.lji.local.spring.service;

import java.util.List;

import com.lji.local.spring.common.DataSource;
import com.lji.local.spring.ism.model.IsmFund;

public interface IsmFundService {
	
	@DataSource(DataSource.ismDB)
	public List<IsmFund> getFundList();
	
}
