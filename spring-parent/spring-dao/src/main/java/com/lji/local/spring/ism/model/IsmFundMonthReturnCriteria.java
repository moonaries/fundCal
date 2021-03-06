package com.lji.local.spring.ism.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IsmFundMonthReturnCriteria {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ism_fundmonthreturn
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ism_fundmonthreturn
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ism_fundmonthreturn
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ism_fundmonthreturn
     *
     * @mbggenerated
     */
    public IsmFundMonthReturnCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ism_fundmonthreturn
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ism_fundmonthreturn
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ism_fundmonthreturn
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ism_fundmonthreturn
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ism_fundmonthreturn
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ism_fundmonthreturn
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ism_fundmonthreturn
     *
     * @mbggenerated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ism_fundmonthreturn
     *
     * @mbggenerated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ism_fundmonthreturn
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ism_fundmonthreturn
     *
     * @mbggenerated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table ism_fundmonthreturn
     *
     * @mbggenerated
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andFundReturnIdIsNull() {
            addCriterion("fund_return_id is null");
            return (Criteria) this;
        }

        public Criteria andFundReturnIdIsNotNull() {
            addCriterion("fund_return_id is not null");
            return (Criteria) this;
        }

        public Criteria andFundReturnIdEqualTo(String value) {
            addCriterion("fund_return_id =", value, "fundReturnId");
            return (Criteria) this;
        }

        public Criteria andFundReturnIdNotEqualTo(String value) {
            addCriterion("fund_return_id <>", value, "fundReturnId");
            return (Criteria) this;
        }

        public Criteria andFundReturnIdGreaterThan(String value) {
            addCriterion("fund_return_id >", value, "fundReturnId");
            return (Criteria) this;
        }

        public Criteria andFundReturnIdGreaterThanOrEqualTo(String value) {
            addCriterion("fund_return_id >=", value, "fundReturnId");
            return (Criteria) this;
        }

        public Criteria andFundReturnIdLessThan(String value) {
            addCriterion("fund_return_id <", value, "fundReturnId");
            return (Criteria) this;
        }

        public Criteria andFundReturnIdLessThanOrEqualTo(String value) {
            addCriterion("fund_return_id <=", value, "fundReturnId");
            return (Criteria) this;
        }

        public Criteria andFundReturnIdLike(String value) {
            addCriterion("fund_return_id like", value, "fundReturnId");
            return (Criteria) this;
        }

        public Criteria andFundReturnIdNotLike(String value) {
            addCriterion("fund_return_id not like", value, "fundReturnId");
            return (Criteria) this;
        }

        public Criteria andFundReturnIdIn(List<String> values) {
            addCriterion("fund_return_id in", values, "fundReturnId");
            return (Criteria) this;
        }

        public Criteria andFundReturnIdNotIn(List<String> values) {
            addCriterion("fund_return_id not in", values, "fundReturnId");
            return (Criteria) this;
        }

        public Criteria andFundReturnIdBetween(String value1, String value2) {
            addCriterion("fund_return_id between", value1, value2, "fundReturnId");
            return (Criteria) this;
        }

        public Criteria andFundReturnIdNotBetween(String value1, String value2) {
            addCriterion("fund_return_id not between", value1, value2, "fundReturnId");
            return (Criteria) this;
        }

        public Criteria andFundIdIsNull() {
            addCriterion("fund_id is null");
            return (Criteria) this;
        }

        public Criteria andFundIdIsNotNull() {
            addCriterion("fund_id is not null");
            return (Criteria) this;
        }

        public Criteria andFundIdEqualTo(String value) {
            addCriterion("fund_id =", value, "fundId");
            return (Criteria) this;
        }

        public Criteria andFundIdNotEqualTo(String value) {
            addCriterion("fund_id <>", value, "fundId");
            return (Criteria) this;
        }

        public Criteria andFundIdGreaterThan(String value) {
            addCriterion("fund_id >", value, "fundId");
            return (Criteria) this;
        }

        public Criteria andFundIdGreaterThanOrEqualTo(String value) {
            addCriterion("fund_id >=", value, "fundId");
            return (Criteria) this;
        }

        public Criteria andFundIdLessThan(String value) {
            addCriterion("fund_id <", value, "fundId");
            return (Criteria) this;
        }

        public Criteria andFundIdLessThanOrEqualTo(String value) {
            addCriterion("fund_id <=", value, "fundId");
            return (Criteria) this;
        }

        public Criteria andFundIdLike(String value) {
            addCriterion("fund_id like", value, "fundId");
            return (Criteria) this;
        }

        public Criteria andFundIdNotLike(String value) {
            addCriterion("fund_id not like", value, "fundId");
            return (Criteria) this;
        }

        public Criteria andFundIdIn(List<String> values) {
            addCriterion("fund_id in", values, "fundId");
            return (Criteria) this;
        }

        public Criteria andFundIdNotIn(List<String> values) {
            addCriterion("fund_id not in", values, "fundId");
            return (Criteria) this;
        }

        public Criteria andFundIdBetween(String value1, String value2) {
            addCriterion("fund_id between", value1, value2, "fundId");
            return (Criteria) this;
        }

        public Criteria andFundIdNotBetween(String value1, String value2) {
            addCriterion("fund_id not between", value1, value2, "fundId");
            return (Criteria) this;
        }

        public Criteria andMonthReturnNumIsNull() {
            addCriterion("month_return_num is null");
            return (Criteria) this;
        }

        public Criteria andMonthReturnNumIsNotNull() {
            addCriterion("month_return_num is not null");
            return (Criteria) this;
        }

        public Criteria andMonthReturnNumEqualTo(BigDecimal value) {
            addCriterion("month_return_num =", value, "monthReturnNum");
            return (Criteria) this;
        }

        public Criteria andMonthReturnNumNotEqualTo(BigDecimal value) {
            addCriterion("month_return_num <>", value, "monthReturnNum");
            return (Criteria) this;
        }

        public Criteria andMonthReturnNumGreaterThan(BigDecimal value) {
            addCriterion("month_return_num >", value, "monthReturnNum");
            return (Criteria) this;
        }

        public Criteria andMonthReturnNumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("month_return_num >=", value, "monthReturnNum");
            return (Criteria) this;
        }

        public Criteria andMonthReturnNumLessThan(BigDecimal value) {
            addCriterion("month_return_num <", value, "monthReturnNum");
            return (Criteria) this;
        }

        public Criteria andMonthReturnNumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("month_return_num <=", value, "monthReturnNum");
            return (Criteria) this;
        }

        public Criteria andMonthReturnNumIn(List<BigDecimal> values) {
            addCriterion("month_return_num in", values, "monthReturnNum");
            return (Criteria) this;
        }

        public Criteria andMonthReturnNumNotIn(List<BigDecimal> values) {
            addCriterion("month_return_num not in", values, "monthReturnNum");
            return (Criteria) this;
        }

        public Criteria andMonthReturnNumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("month_return_num between", value1, value2, "monthReturnNum");
            return (Criteria) this;
        }

        public Criteria andMonthReturnNumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("month_return_num not between", value1, value2, "monthReturnNum");
            return (Criteria) this;
        }

        public Criteria andMonthsIsNull() {
            addCriterion("months is null");
            return (Criteria) this;
        }

        public Criteria andMonthsIsNotNull() {
            addCriterion("months is not null");
            return (Criteria) this;
        }

        public Criteria andMonthsEqualTo(Date value) {
            addCriterion("months =", value, "months");
            return (Criteria) this;
        }

        public Criteria andMonthsNotEqualTo(Date value) {
            addCriterion("months <>", value, "months");
            return (Criteria) this;
        }

        public Criteria andMonthsGreaterThan(Date value) {
            addCriterion("months >", value, "months");
            return (Criteria) this;
        }

        public Criteria andMonthsGreaterThanOrEqualTo(Date value) {
            addCriterion("months >=", value, "months");
            return (Criteria) this;
        }

        public Criteria andMonthsLessThan(Date value) {
            addCriterion("months <", value, "months");
            return (Criteria) this;
        }

        public Criteria andMonthsLessThanOrEqualTo(Date value) {
            addCriterion("months <=", value, "months");
            return (Criteria) this;
        }

        public Criteria andMonthsIn(List<Date> values) {
            addCriterion("months in", values, "months");
            return (Criteria) this;
        }

        public Criteria andMonthsNotIn(List<Date> values) {
            addCriterion("months not in", values, "months");
            return (Criteria) this;
        }

        public Criteria andMonthsBetween(Date value1, Date value2) {
            addCriterion("months between", value1, value2, "months");
            return (Criteria) this;
        }

        public Criteria andMonthsNotBetween(Date value1, Date value2) {
            addCriterion("months not between", value1, value2, "months");
            return (Criteria) this;
        }

        public Criteria andCreatDateIsNull() {
            addCriterion("creat_date is null");
            return (Criteria) this;
        }

        public Criteria andCreatDateIsNotNull() {
            addCriterion("creat_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreatDateEqualTo(Date value) {
            addCriterion("creat_date =", value, "creatDate");
            return (Criteria) this;
        }

        public Criteria andCreatDateNotEqualTo(Date value) {
            addCriterion("creat_date <>", value, "creatDate");
            return (Criteria) this;
        }

        public Criteria andCreatDateGreaterThan(Date value) {
            addCriterion("creat_date >", value, "creatDate");
            return (Criteria) this;
        }

        public Criteria andCreatDateGreaterThanOrEqualTo(Date value) {
            addCriterion("creat_date >=", value, "creatDate");
            return (Criteria) this;
        }

        public Criteria andCreatDateLessThan(Date value) {
            addCriterion("creat_date <", value, "creatDate");
            return (Criteria) this;
        }

        public Criteria andCreatDateLessThanOrEqualTo(Date value) {
            addCriterion("creat_date <=", value, "creatDate");
            return (Criteria) this;
        }

        public Criteria andCreatDateIn(List<Date> values) {
            addCriterion("creat_date in", values, "creatDate");
            return (Criteria) this;
        }

        public Criteria andCreatDateNotIn(List<Date> values) {
            addCriterion("creat_date not in", values, "creatDate");
            return (Criteria) this;
        }

        public Criteria andCreatDateBetween(Date value1, Date value2) {
            addCriterion("creat_date between", value1, value2, "creatDate");
            return (Criteria) this;
        }

        public Criteria andCreatDateNotBetween(Date value1, Date value2) {
            addCriterion("creat_date not between", value1, value2, "creatDate");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNull() {
            addCriterion("creator is null");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNotNull() {
            addCriterion("creator is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorEqualTo(String value) {
            addCriterion("creator =", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotEqualTo(String value) {
            addCriterion("creator <>", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThan(String value) {
            addCriterion("creator >", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThanOrEqualTo(String value) {
            addCriterion("creator >=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThan(String value) {
            addCriterion("creator <", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThanOrEqualTo(String value) {
            addCriterion("creator <=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLike(String value) {
            addCriterion("creator like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotLike(String value) {
            addCriterion("creator not like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorIn(List<String> values) {
            addCriterion("creator in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotIn(List<String> values) {
            addCriterion("creator not in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorBetween(String value1, String value2) {
            addCriterion("creator between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotBetween(String value1, String value2) {
            addCriterion("creator not between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andModifyDateIsNull() {
            addCriterion("modify_date is null");
            return (Criteria) this;
        }

        public Criteria andModifyDateIsNotNull() {
            addCriterion("modify_date is not null");
            return (Criteria) this;
        }

        public Criteria andModifyDateEqualTo(Date value) {
            addCriterion("modify_date =", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateNotEqualTo(Date value) {
            addCriterion("modify_date <>", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateGreaterThan(Date value) {
            addCriterion("modify_date >", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateGreaterThanOrEqualTo(Date value) {
            addCriterion("modify_date >=", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateLessThan(Date value) {
            addCriterion("modify_date <", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateLessThanOrEqualTo(Date value) {
            addCriterion("modify_date <=", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateIn(List<Date> values) {
            addCriterion("modify_date in", values, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateNotIn(List<Date> values) {
            addCriterion("modify_date not in", values, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateBetween(Date value1, Date value2) {
            addCriterion("modify_date between", value1, value2, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateNotBetween(Date value1, Date value2) {
            addCriterion("modify_date not between", value1, value2, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifierIsNull() {
            addCriterion("MODIFIER is null");
            return (Criteria) this;
        }

        public Criteria andModifierIsNotNull() {
            addCriterion("MODIFIER is not null");
            return (Criteria) this;
        }

        public Criteria andModifierEqualTo(String value) {
            addCriterion("MODIFIER =", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierNotEqualTo(String value) {
            addCriterion("MODIFIER <>", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierGreaterThan(String value) {
            addCriterion("MODIFIER >", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierGreaterThanOrEqualTo(String value) {
            addCriterion("MODIFIER >=", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierLessThan(String value) {
            addCriterion("MODIFIER <", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierLessThanOrEqualTo(String value) {
            addCriterion("MODIFIER <=", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierLike(String value) {
            addCriterion("MODIFIER like", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierNotLike(String value) {
            addCriterion("MODIFIER not like", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierIn(List<String> values) {
            addCriterion("MODIFIER in", values, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierNotIn(List<String> values) {
            addCriterion("MODIFIER not in", values, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierBetween(String value1, String value2) {
            addCriterion("MODIFIER between", value1, value2, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierNotBetween(String value1, String value2) {
            addCriterion("MODIFIER not between", value1, value2, "modifier");
            return (Criteria) this;
        }

        public Criteria andFundReturnIdLikeInsensitive(String value) {
            addCriterion("upper(fund_return_id) like", value.toUpperCase(), "fundReturnId");
            return (Criteria) this;
        }

        public Criteria andFundIdLikeInsensitive(String value) {
            addCriterion("upper(fund_id) like", value.toUpperCase(), "fundId");
            return (Criteria) this;
        }

        public Criteria andCreatorLikeInsensitive(String value) {
            addCriterion("upper(creator) like", value.toUpperCase(), "creator");
            return (Criteria) this;
        }

        public Criteria andModifierLikeInsensitive(String value) {
            addCriterion("upper(MODIFIER) like", value.toUpperCase(), "modifier");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table ism_fundmonthreturn
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table ism_fundmonthreturn
     *
     * @mbggenerated
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}