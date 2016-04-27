package com.lji.local.spring.call;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.transaction.annotation.Transactional;

import com.lji.local.spring.common.Constant;
import com.lji.local.spring.dce.dao.DceAchievementsMapper;
import com.lji.local.spring.dce.dao.DceFundMapper;
import com.lji.local.spring.dce.dao.extend.DceMapperExtend;
import com.lji.local.spring.dce.model.DceAchievements;
import com.lji.local.spring.dce.model.DceAchievementsCriteria;
import com.lji.local.spring.dce.model.DceFund;
import com.lji.local.spring.strategy.impl.AchiStrategy;
import com.lji.local.spring.strategy.impl.AtinuoStrategy;
import com.lji.local.spring.strategy.impl.DailyStrategy;
import com.lji.local.spring.strategy.impl.DiffStrategy;
import com.lji.local.spring.strategy.impl.MaxBackStrategy;
import com.lji.local.spring.strategy.impl.MonthStrategy;
import com.lji.local.spring.strategy.impl.RateStrategy;
import com.lji.local.spring.strategy.impl.SharpStrategy;
import com.lji.local.spring.strategy.impl.TimeStrategy;
import com.lji.local.spring.strategy.impl.TreynorStrategy;
import com.lji.local.spring.strategy.impl.WeekStrategy;
import com.lji.local.spring.strategy.impl.WinRateStrategy;

public class MainExecutor {
	
	private static Logger logger = Logger.getLogger(MainExecutor.class);
	
	@Resource(name="achiStrategy")
	private AchiStrategy achiStrategy;
	
	@Autowired
	private DceFundMapper fundDao;
	
	@Autowired
	private DceAchievementsMapper achiDao;	
	
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
		
	private ThreadPoolTaskExecutor threadPool;  
	    
    public ThreadPoolTaskExecutor getThreadPool() {
		return threadPool;
	}

	public void setThreadPool(ThreadPoolTaskExecutor threadPool) {
		this.threadPool = threadPool;
	}

	/**
	 * 计算所有基金绩效并且直接入库
	 * @auther lji
	 * @date 2016年3月24日下午12:41:39
	 */
	public void calAll() {
		// 先计算沪深300的数值
		this.calQuotation(true);
		List<String> ids = dceDaoEx.getAllSourceId();
		this.doCal(ids,true);
    }  
	
	/**
	 * 计算所有基金绩效，不入库，返回计算结果
	 * @auther lji
	 * @date 2016年3月24日下午12:41:51
	 * @param ids
	 * @return
	 */
	public List<List<DceAchievements>> calAll(List<String> ids) {
		return this.doCal(ids,false);
	}
	
	/**
	 * 计算方法，采用多线程
	 * @auther lji
	 * @date 2016年3月24日下午12:42:11
	 * @param ids 基金的fund_temp_id，ism库中的id
	 * @param inSql 是否入库
	 * @return
	 */
	private List<List<DceAchievements>> doCal(List<String> ids,boolean inSql) {
		List<List<DceAchievements>> result = new ArrayList<List<DceAchievements>>();
		List<Future<List<DceAchievements>>> calList = new ArrayList<Future<List<DceAchievements>>>();
		List<Future<Integer>> sqlList = new ArrayList<Future<Integer>>();
		for(String id : ids) {
			FutureTask<List<DceAchievements>> future = new FutureTask<List<DceAchievements>>(new CalCall(id));
			threadPool.execute(future);
			calList.add(future);
		}
		
		// 等待计算
		for(Future<List<DceAchievements>> future : calList) {
			while(!future.isDone()) ;
			try {
				List<DceAchievements> data = future.get();
				// 如果需要入库,数据集直接入库不返回，因为可能会有很多数据
				if(inSql && data != null) {
					for(DceAchievements dce : data) {
						FutureTask<Integer> _future = new FutureTask<Integer>(new SqlCall(dce));
						threadPool.execute(_future);
						sqlList.add(_future);
					}
				} else {
					// 不需要入库就把数据集放到result中
					result.add(data);
				}
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
		}
		threadPool.setWaitForTasksToCompleteOnShutdown(true);
		threadPool.shutdown();
		while(true) {
			if(threadPool.getActiveCount() == 0) {
				// 根据是否入库标志返回相应的结果
				if(inSql) {
					return null;
				} else {
					return result;
				}
			}
		}
	}
	
	/**
	 * 计算沪深300的绩效
	 * @auther lji
	 * @date 2016年3月24日下午12:44:11
	 * @return
	 */
	public List<DceAchievements> calQuotation() {
		return this.calSingle(Constant.HS300_ID);
	}
	
	/**
	 * 计算沪深300的绩效，不返回结果，入库
	 * @auther lji
	 * @date 2016年3月24日下午1:23:28
	 * @param inSql
	 */
	public void calQuotation(boolean inSql) {
		List<DceAchievements> result  = this.calSingle(Constant.HS300_ID);
		List<Future<Integer>> sqlList = new ArrayList<Future<Integer>>();
		if(result != null) {
			for(DceAchievements dce : result) {
				FutureTask<Integer> future = new FutureTask<Integer>(new SqlCall(dce));
				sqlList.add(future);
				threadPool.submit(future);
			}
		}
		
		// 用以等待结果执行完成
		for(Future<Integer> future : sqlList) {
			while(!future.isDone());
		}
	}

	/**
	 * 计算单一的基金绩效,这个永远不入库,直接返回结果
	 * @auther lji
	 * @date 2016年3月24日下午12:43:50
	 * @param id
	 * @return
	 */
	@Transactional
	public List<DceAchievements> calSingle(String id) {
		try {
			String calID = "";
			if(!id.equals(Constant.HS300_ID)) {
				DceFund fund = fundDao.selectByPrimaryKey(id);
				if(fund == null) {
					logger.error(new Date() + "id为	" + "======"+ id + "	的基金找不到对应的dce基金");
					return null;
				}
				calID = fund.getFundSourceId();
			} else {
				calID = Constant.HS300_ID;
			}
			CalCall call = new CalCall(calID);
			FutureTask<List<DceAchievements>> future = new FutureTask<List<DceAchievements>>(call);
			threadPool.submit(future);
			
			while(!future.isDone());
			return future.get();
		} catch (InterruptedException | ExecutionException e) {
			logger.error(e.getMessage());
			return null;
		}
	}
		
	private class CalCall implements Callable<List<DceAchievements>> {
		
    	private String id;
    	
    	public CalCall(String id) {
    		this.id = id;
    	}

    	@Override
    	public List<DceAchievements> call() {
    		try {
    			logger.info(new Date() + "======"+ id + "	开始计算");
    			System.out.println(new Date() + "======"+ id + "	开始计算");
    			List<DceAchievements> result = achiStrategy.operate(id);
    			logger.info(new Date() + "======"+ id + "	计算结束");
    			System.out.println(new Date() + "======"+ id + "	计算结束");
    			return result;
    		} catch (Exception e) {
    			logger.error(new Date() + "id为	" + "======"+ id + "	的基金计算出错");
    			return null;
    		}
    	}

    }
    
    private class SqlCall implements Callable<Integer> {
    	
    	private DceAchievements achi;
    	    	
    	public SqlCall(DceAchievements achi) {
    		this.achi = achi;
    	}

    	@Override
    	public Integer call() throws Exception {
    		DceAchievementsCriteria example = new DceAchievementsCriteria();
    		example.createCriteria().andFundTempIdEqualTo(achi.getFundTempId()).andSectionTypeEqualTo(achi.getSectionType());
    		int count = achiDao.countByExample(example);
//    		logger.info(new Date() + "========" + achi.getFundTempId() + "	的" + achi.getSectionType() + "时间段绩效准备入库");
//			System.out.println(new Date() + "========" + achi.getFundTempId() + "	的" + achi.getSectionType() + "时间段绩效准备入库");
    		if(count > 0) {
    			logger.info(new Date() + "========" + achi.getFundTempId() + "	的" + achi.getSectionType() + "时间段绩效成功入库");
    			System.out.println(new Date() + "========" + achi.getFundTempId() + "	的" + achi.getSectionType() + "时间段绩效成功入库");
    			return achiDao.updateByExample(achi, example);
    		} else {
    			logger.info(new Date() + "========" + achi.getFundTempId() + "	的" + achi.getSectionType() + "时间段绩效成功入库");
    			System.out.println(new Date() + "========" + achi.getFundTempId() + "	的" + achi.getSectionType() + "时间段绩效成功入库");
    			return achiDao.insert(achi);
    		}
    	}

    }
}
