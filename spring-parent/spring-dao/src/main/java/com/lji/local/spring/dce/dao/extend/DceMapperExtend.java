package com.lji.local.spring.dce.dao.extend;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import com.lji.local.spring.dce.model.DceAchievements;
import com.lji.local.spring.dce.model.DceFund;
import com.lji.local.spring.dce.model.DceFundNet;
import com.lji.local.spring.dce.model.DceFundWeekRor;
import com.lji.local.spring.dce.model.DceQuotation;

/**
 * dce相关,为了方便所有的sql直接写一个类里面
 * @author lji
 * @date 2016年3月17日下午2:34:10
 */
public interface DceMapperExtend {
	
	/**
	 * 因为fund_temp_id不是主键
	 * @auther lji
	 * @date 2016年3月17日下午2:35:43
	 * @param id
	 * @return
	 */
	@Select("SELECT * FROM ism_fund_temp WHERE fund_source_id = #{id} LIMIT 1")
	@ResultMap("com.lji.local.spring.dce.dao.DceFundMapper.BaseResultMap")
	public DceFund getFundBySourceId(@Param("id") String id);
	
	/**
	 * 获取第一个沪深300值
	 * @auther lji
	 * @date 2016年3月17日下午3:22:46
	 * @return
	 */
	@Select("SELECT * FROM ism_quotation WHERE quotation_type = 1 ORDER BY creat_date ASC LIMIT 1")
	@ResultMap("com.lji.local.spring.dce.dao.DceQuotationMapper.BaseResultMap")
	public DceQuotation getFirstQuotation();
	
	/**
	 * 获取最后一个沪深300值
	 * @auther lji
	 * @date 2016年3月17日下午3:22:46
	 * @return
	 */
	@Select("SELECT * FROM ism_quotation WHERE quotation_type = 1 ORDER BY creat_date DESC LIMIT 1")
	@ResultMap("com.lji.local.spring.dce.dao.DceQuotationMapper.BaseResultMap")
	public DceQuotation getLastQuotation();
	
	/**
	 * 获取基金的第一个净值
	 * @auther lji
	 * @date 2016年3月17日下午3:30:13
	 * @param id
	 * @return
	 */
	@Select("SELECT * FROM ism_fundnet_temp_log WHERE fund_temp_id = #{id} ORDER BY create_time ASC LIMIT 1")
	@ResultMap("com.lji.local.spring.dce.dao.DceFundNetMapper.BaseResultMap")
	public DceFundNet getFirstFundNet(@Param("id") String id);
	
	/**
	 * 获取基金的最后一个净值
	 * @auther lji
	 * @date 2016年3月17日下午3:30:13
	 * @param id
	 * @return
	 */
	@Select("SELECT * FROM ism_fundnet_temp_log WHERE fund_temp_id = #{id} ORDER BY create_time DESC LIMIT 1")
	@ResultMap("com.lji.local.spring.dce.dao.DceFundNetMapper.BaseResultMap")
	public DceFundNet getLastFundNet(@Param("id") String id);
	
	/**
	 * 根据id和section获取唯一的绩效
	 * @auther lji
	 * @date 2016年3月17日下午4:13:43
	 * @param id
	 * @param section
	 * @return
	 */
	@Select("SELECT * FROM ism_achievements_temp WHERE fund_temp_id = #{id} AND section_type = #{section} LIMIT 1")
	@ResultMap("com.lji.local.spring.dce.dao.DceAchievementsMapper.BaseResultMap")
	public DceAchievements getAchiByIdAndSection(@Param("id") String id,@Param("section") int section);
	
	/**
	 * 获取所有的基金source_id
	 * @auther lji
	 * @date 2016年3月17日下午4:57:00
	 * @return
	 */
	@Select("SELECT fund_source_id FROM ism_fund_temp WHERE verify_type = 3 GROUP BY fund_source_id")
	@ResultType(List.class)
	public List<String> getAllSourceId();
	
	/**
	 * 获取基金某时间区间段的收益率
	 * @auther lji
	 * @date 2016年3月18日上午5:23:23
	 * @param sql
	 * @param id
	 * @param stime
	 * @param etime
	 * @return
	 */
	@Select("${sql}")
	@ResultType(List.class)
	public List<BigDecimal> getRors(@Param("sql") String sql,
			@Param("id") String id,
			@Param("stime") Date stime,
			@Param("etime") Date etime);
	
	/**
	 * 获取最近一期的无风险收益率
	 * @auther lji
	 * @date 2016年3月18日上午5:24:23
	 * @return
	 */
	@Select("SELECT deposit_rate FROM benchmark_rate WHERE update_date < #{time} ORDER BY update_date DESC LIMIT 1")
	@ResultType(BigDecimal.class)
	public BigDecimal getLatestDepositRate(@Param("time") Date time);
	
	/**
	 * 获取基金时间段内的净值最大值
	 * @auther lji
	 * @date 2016年3月18日上午5:26:56
	 * @param id
	 * @param stime
	 * @param etime
	 * @return
	 */
	@Select("SELECT * FROM ism_fundnet_temp_log WHERE fund_temp_id = #{id} AND create_time >= #{stime} AND create_time < #{etime} ORDER BY fund_net DESC LIMIT 1")
	@ResultMap("com.lji.local.spring.dce.dao.DceFundNetMapper.BaseResultMap")
	public DceFundNet getMaxFundNet(@Param("id") String id,
			@Param("stime") Date stime,
			@Param("etime") Date etime);
	
	/**
	 * 
	 * @auther lji
	 * @date 2016年3月18日上午5:31:07
	 * @param id
	 * @param time
	 * @return
	 */
	@Select("SELECT * FROM ism_fund_week_ror WHERE fund_id = #{id} AND date_ror >= #{time} ORDER BY date_ror ASC LIMIT 1")
	@ResultMap("com.lji.local.spring.dce.dao.DceFundWeekRorMapper.BaseResultMap")
	public DceFundWeekRor getLatelyIndexRor(@Param("id") String id,
			@Param("time") Date time);
}
