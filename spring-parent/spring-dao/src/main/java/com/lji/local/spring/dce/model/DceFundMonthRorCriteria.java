package com.lji.local.spring.dce.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DceFundMonthRorCriteria {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ism_fund_monthly_ror
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ism_fund_monthly_ror
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ism_fund_monthly_ror
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ism_fund_monthly_ror
     *
     * @mbggenerated
     */
    public DceFundMonthRorCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ism_fund_monthly_ror
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ism_fund_monthly_ror
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ism_fund_monthly_ror
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ism_fund_monthly_ror
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ism_fund_monthly_ror
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ism_fund_monthly_ror
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ism_fund_monthly_ror
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
     * This method corresponds to the database table ism_fund_monthly_ror
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
     * This method corresponds to the database table ism_fund_monthly_ror
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ism_fund_monthly_ror
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
     * This class corresponds to the database table ism_fund_monthly_ror
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

        public Criteria andYearRorIsNull() {
            addCriterion("year_ror is null");
            return (Criteria) this;
        }

        public Criteria andYearRorIsNotNull() {
            addCriterion("year_ror is not null");
            return (Criteria) this;
        }

        public Criteria andYearRorEqualTo(Integer value) {
            addCriterion("year_ror =", value, "yearRor");
            return (Criteria) this;
        }

        public Criteria andYearRorNotEqualTo(Integer value) {
            addCriterion("year_ror <>", value, "yearRor");
            return (Criteria) this;
        }

        public Criteria andYearRorGreaterThan(Integer value) {
            addCriterion("year_ror >", value, "yearRor");
            return (Criteria) this;
        }

        public Criteria andYearRorGreaterThanOrEqualTo(Integer value) {
            addCriterion("year_ror >=", value, "yearRor");
            return (Criteria) this;
        }

        public Criteria andYearRorLessThan(Integer value) {
            addCriterion("year_ror <", value, "yearRor");
            return (Criteria) this;
        }

        public Criteria andYearRorLessThanOrEqualTo(Integer value) {
            addCriterion("year_ror <=", value, "yearRor");
            return (Criteria) this;
        }

        public Criteria andYearRorIn(List<Integer> values) {
            addCriterion("year_ror in", values, "yearRor");
            return (Criteria) this;
        }

        public Criteria andYearRorNotIn(List<Integer> values) {
            addCriterion("year_ror not in", values, "yearRor");
            return (Criteria) this;
        }

        public Criteria andYearRorBetween(Integer value1, Integer value2) {
            addCriterion("year_ror between", value1, value2, "yearRor");
            return (Criteria) this;
        }

        public Criteria andYearRorNotBetween(Integer value1, Integer value2) {
            addCriterion("year_ror not between", value1, value2, "yearRor");
            return (Criteria) this;
        }

        public Criteria andMonthRorIsNull() {
            addCriterion("month_ror is null");
            return (Criteria) this;
        }

        public Criteria andMonthRorIsNotNull() {
            addCriterion("month_ror is not null");
            return (Criteria) this;
        }

        public Criteria andMonthRorEqualTo(Integer value) {
            addCriterion("month_ror =", value, "monthRor");
            return (Criteria) this;
        }

        public Criteria andMonthRorNotEqualTo(Integer value) {
            addCriterion("month_ror <>", value, "monthRor");
            return (Criteria) this;
        }

        public Criteria andMonthRorGreaterThan(Integer value) {
            addCriterion("month_ror >", value, "monthRor");
            return (Criteria) this;
        }

        public Criteria andMonthRorGreaterThanOrEqualTo(Integer value) {
            addCriterion("month_ror >=", value, "monthRor");
            return (Criteria) this;
        }

        public Criteria andMonthRorLessThan(Integer value) {
            addCriterion("month_ror <", value, "monthRor");
            return (Criteria) this;
        }

        public Criteria andMonthRorLessThanOrEqualTo(Integer value) {
            addCriterion("month_ror <=", value, "monthRor");
            return (Criteria) this;
        }

        public Criteria andMonthRorIn(List<Integer> values) {
            addCriterion("month_ror in", values, "monthRor");
            return (Criteria) this;
        }

        public Criteria andMonthRorNotIn(List<Integer> values) {
            addCriterion("month_ror not in", values, "monthRor");
            return (Criteria) this;
        }

        public Criteria andMonthRorBetween(Integer value1, Integer value2) {
            addCriterion("month_ror between", value1, value2, "monthRor");
            return (Criteria) this;
        }

        public Criteria andMonthRorNotBetween(Integer value1, Integer value2) {
            addCriterion("month_ror not between", value1, value2, "monthRor");
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

        public Criteria andRorIsNull() {
            addCriterion("ror is null");
            return (Criteria) this;
        }

        public Criteria andRorIsNotNull() {
            addCriterion("ror is not null");
            return (Criteria) this;
        }

        public Criteria andRorEqualTo(BigDecimal value) {
            addCriterion("ror =", value, "ror");
            return (Criteria) this;
        }

        public Criteria andRorNotEqualTo(BigDecimal value) {
            addCriterion("ror <>", value, "ror");
            return (Criteria) this;
        }

        public Criteria andRorGreaterThan(BigDecimal value) {
            addCriterion("ror >", value, "ror");
            return (Criteria) this;
        }

        public Criteria andRorGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ror >=", value, "ror");
            return (Criteria) this;
        }

        public Criteria andRorLessThan(BigDecimal value) {
            addCriterion("ror <", value, "ror");
            return (Criteria) this;
        }

        public Criteria andRorLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ror <=", value, "ror");
            return (Criteria) this;
        }

        public Criteria andRorIn(List<BigDecimal> values) {
            addCriterion("ror in", values, "ror");
            return (Criteria) this;
        }

        public Criteria andRorNotIn(List<BigDecimal> values) {
            addCriterion("ror not in", values, "ror");
            return (Criteria) this;
        }

        public Criteria andRorBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ror between", value1, value2, "ror");
            return (Criteria) this;
        }

        public Criteria andRorNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ror not between", value1, value2, "ror");
            return (Criteria) this;
        }

        public Criteria andFundIdLikeInsensitive(String value) {
            addCriterion("upper(fund_id) like", value.toUpperCase(), "fundId");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table ism_fund_monthly_ror
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
     * This class corresponds to the database table ism_fund_monthly_ror
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