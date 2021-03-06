package com.lji.local.spring.dce.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class DceQuotation extends DceQuotationKey implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ism_quotation.quotation_value
     *
     * @mbggenerated
     */
    private String quotationValue;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ism_quotation.creator
     *
     * @mbggenerated
     */
    private String creator;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ism_quotation.modify_date
     *
     * @mbggenerated
     */
    private Date modifyDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ism_quotation.modifier
     *
     * @mbggenerated
     */
    private String modifier;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ism_quotation.ror
     *
     * @mbggenerated
     */
    private BigDecimal ror;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ism_quotation
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ism_quotation.quotation_value
     *
     * @return the value of ism_quotation.quotation_value
     *
     * @mbggenerated
     */
    public String getQuotationValue() {
        return quotationValue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ism_quotation.quotation_value
     *
     * @param quotationValue the value for ism_quotation.quotation_value
     *
     * @mbggenerated
     */
    public void setQuotationValue(String quotationValue) {
        this.quotationValue = quotationValue == null ? null : quotationValue.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ism_quotation.creator
     *
     * @return the value of ism_quotation.creator
     *
     * @mbggenerated
     */
    public String getCreator() {
        return creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ism_quotation.creator
     *
     * @param creator the value for ism_quotation.creator
     *
     * @mbggenerated
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ism_quotation.modify_date
     *
     * @return the value of ism_quotation.modify_date
     *
     * @mbggenerated
     */
    public Date getModifyDate() {
        return modifyDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ism_quotation.modify_date
     *
     * @param modifyDate the value for ism_quotation.modify_date
     *
     * @mbggenerated
     */
    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ism_quotation.modifier
     *
     * @return the value of ism_quotation.modifier
     *
     * @mbggenerated
     */
    public String getModifier() {
        return modifier;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ism_quotation.modifier
     *
     * @param modifier the value for ism_quotation.modifier
     *
     * @mbggenerated
     */
    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ism_quotation.ror
     *
     * @return the value of ism_quotation.ror
     *
     * @mbggenerated
     */
    public BigDecimal getRor() {
        return ror;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ism_quotation.ror
     *
     * @param ror the value for ism_quotation.ror
     *
     * @mbggenerated
     */
    public void setRor(BigDecimal ror) {
        this.ror = ror;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ism_quotation
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
        DceQuotation other = (DceQuotation) that;
        return (this.getQuotationId() == null ? other.getQuotationId() == null : this.getQuotationId().equals(other.getQuotationId()))
            && (this.getQuotationType() == null ? other.getQuotationType() == null : this.getQuotationType().equals(other.getQuotationType()))
            && (this.getCreatDate() == null ? other.getCreatDate() == null : this.getCreatDate().equals(other.getCreatDate()))
            && (this.getQuotationValue() == null ? other.getQuotationValue() == null : this.getQuotationValue().equals(other.getQuotationValue()))
            && (this.getCreator() == null ? other.getCreator() == null : this.getCreator().equals(other.getCreator()))
            && (this.getModifyDate() == null ? other.getModifyDate() == null : this.getModifyDate().equals(other.getModifyDate()))
            && (this.getModifier() == null ? other.getModifier() == null : this.getModifier().equals(other.getModifier()))
            && (this.getRor() == null ? other.getRor() == null : this.getRor().equals(other.getRor()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ism_quotation
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getQuotationId() == null) ? 0 : getQuotationId().hashCode());
        result = prime * result + ((getQuotationType() == null) ? 0 : getQuotationType().hashCode());
        result = prime * result + ((getCreatDate() == null) ? 0 : getCreatDate().hashCode());
        result = prime * result + ((getQuotationValue() == null) ? 0 : getQuotationValue().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        result = prime * result + ((getModifyDate() == null) ? 0 : getModifyDate().hashCode());
        result = prime * result + ((getModifier() == null) ? 0 : getModifier().hashCode());
        result = prime * result + ((getRor() == null) ? 0 : getRor().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ism_quotation
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", quotationValue=").append(quotationValue);
        sb.append(", creator=").append(creator);
        sb.append(", modifyDate=").append(modifyDate);
        sb.append(", modifier=").append(modifier);
        sb.append(", ror=").append(ror);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}