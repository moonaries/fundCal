package com.lji.local.spring.dce.dao;

import com.lji.local.spring.dce.model.DceFundYearsRor;
import com.lji.local.spring.dce.model.DceFundYearsRorCriteria;
import com.lji.local.spring.dce.model.DceFundYearsRorKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface DceFundYearsRorMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ism_fund_years_ror
     *
     * @mbggenerated
     */
    int countByExample(DceFundYearsRorCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ism_fund_years_ror
     *
     * @mbggenerated
     */
    int deleteByExample(DceFundYearsRorCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ism_fund_years_ror
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(DceFundYearsRorKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ism_fund_years_ror
     *
     * @mbggenerated
     */
    int insert(DceFundYearsRor record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ism_fund_years_ror
     *
     * @mbggenerated
     */
    int insertSelective(DceFundYearsRor record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ism_fund_years_ror
     *
     * @mbggenerated
     */
    List<DceFundYearsRor> selectByExampleWithRowbounds(DceFundYearsRorCriteria example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ism_fund_years_ror
     *
     * @mbggenerated
     */
    List<DceFundYearsRor> selectByExample(DceFundYearsRorCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ism_fund_years_ror
     *
     * @mbggenerated
     */
    DceFundYearsRor selectByPrimaryKey(DceFundYearsRorKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ism_fund_years_ror
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") DceFundYearsRor record, @Param("example") DceFundYearsRorCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ism_fund_years_ror
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") DceFundYearsRor record, @Param("example") DceFundYearsRorCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ism_fund_years_ror
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(DceFundYearsRor record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ism_fund_years_ror
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(DceFundYearsRor record);
}