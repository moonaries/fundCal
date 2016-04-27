package com.lji.local.spring.dce.dao;

import com.lji.local.spring.dce.model.DceFundNet;
import com.lji.local.spring.dce.model.DceFundNetCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface DceFundNetMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ism_fundnet_temp_log
     *
     * @mbggenerated
     */
    int countByExample(DceFundNetCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ism_fundnet_temp_log
     *
     * @mbggenerated
     */
    int deleteByExample(DceFundNetCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ism_fundnet_temp_log
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String fundnetId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ism_fundnet_temp_log
     *
     * @mbggenerated
     */
    int insert(DceFundNet record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ism_fundnet_temp_log
     *
     * @mbggenerated
     */
    int insertSelective(DceFundNet record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ism_fundnet_temp_log
     *
     * @mbggenerated
     */
    List<DceFundNet> selectByExampleWithRowbounds(DceFundNetCriteria example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ism_fundnet_temp_log
     *
     * @mbggenerated
     */
    List<DceFundNet> selectByExample(DceFundNetCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ism_fundnet_temp_log
     *
     * @mbggenerated
     */
    DceFundNet selectByPrimaryKey(String fundnetId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ism_fundnet_temp_log
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") DceFundNet record, @Param("example") DceFundNetCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ism_fundnet_temp_log
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") DceFundNet record, @Param("example") DceFundNetCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ism_fundnet_temp_log
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(DceFundNet record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ism_fundnet_temp_log
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(DceFundNet record);
}