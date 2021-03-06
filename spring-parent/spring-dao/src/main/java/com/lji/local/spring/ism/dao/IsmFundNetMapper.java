package com.lji.local.spring.ism.dao;

import com.lji.local.spring.ism.model.IsmFundNet;
import com.lji.local.spring.ism.model.IsmFundNetCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface IsmFundNetMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ism_fund_net_log
     *
     * @mbggenerated
     */
    int countByExample(IsmFundNetCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ism_fund_net_log
     *
     * @mbggenerated
     */
    int deleteByExample(IsmFundNetCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ism_fund_net_log
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String fundFlowId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ism_fund_net_log
     *
     * @mbggenerated
     */
    int insert(IsmFundNet record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ism_fund_net_log
     *
     * @mbggenerated
     */
    int insertSelective(IsmFundNet record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ism_fund_net_log
     *
     * @mbggenerated
     */
    List<IsmFundNet> selectByExampleWithRowbounds(IsmFundNetCriteria example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ism_fund_net_log
     *
     * @mbggenerated
     */
    List<IsmFundNet> selectByExample(IsmFundNetCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ism_fund_net_log
     *
     * @mbggenerated
     */
    IsmFundNet selectByPrimaryKey(String fundFlowId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ism_fund_net_log
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") IsmFundNet record, @Param("example") IsmFundNetCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ism_fund_net_log
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") IsmFundNet record, @Param("example") IsmFundNetCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ism_fund_net_log
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(IsmFundNet record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ism_fund_net_log
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(IsmFundNet record);
}