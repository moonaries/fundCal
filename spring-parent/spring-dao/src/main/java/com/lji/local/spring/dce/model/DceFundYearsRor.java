package com.lji.local.spring.dce.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class DceFundYearsRor extends DceFundYearsRorKey implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ism_fund_years_ror.ror
     *
     * @mbggenerated
     */
    private BigDecimal ror;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ism_fund_years_ror
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ism_fund_years_ror.ror
     *
     * @return the value of ism_fund_years_ror.ror
     *
     * @mbggenerated
     */
    public BigDecimal getRor() {
        return ror;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ism_fund_years_ror.ror
     *
     * @param ror the value for ism_fund_years_ror.ror
     *
     * @mbggenerated
     */
    public void setRor(BigDecimal ror) {
        this.ror = ror;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ism_fund_years_ror
     *
     * @mbggenerated
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        DceFundYearsRor other = (DceFundYearsRor) that;
        return (this.getYearRor() == null ? other.getYearRor() == null : this.getYearRor().equals(other.getYearRor()))
            && (this.getFundId() == null ? other.getFundId() == null : this.getFundId().equals(other.getFundId()))
            && (this.getIntervalType() == null ? other.getIntervalType() == null : this.getIntervalType().equals(other.getIntervalType()))
            && (this.getRor() == null ? other.getRor() == null : this.getRor().equals(other.getRor()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ism_fund_years_ror
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getYearRor() == null) ? 0 : getYearRor().hashCode());
        result = prime * result + ((getFundId() == null) ? 0 : getFundId().hashCode());
        result = prime * result + ((getIntervalType() == null) ? 0 : getIntervalType().hashCode());
        result = prime * result + ((getRor() == null) ? 0 : getRor().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ism_fund_years_ror
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", ror=").append(ror);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}