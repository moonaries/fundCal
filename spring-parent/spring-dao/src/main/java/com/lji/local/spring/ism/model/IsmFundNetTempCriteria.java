package com.lji.local.spring.ism.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IsmFundNetTempCriteria {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ism_fundnet_temp_log
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ism_fundnet_temp_log
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ism_fundnet_temp_log
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ism_fundnet_temp_log
     *
     * @mbggenerated
     */
    public IsmFundNetTempCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ism_fundnet_temp_log
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ism_fundnet_temp_log
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ism_fundnet_temp_log
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ism_fundnet_temp_log
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ism_fundnet_temp_log
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ism_fundnet_temp_log
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ism_fundnet_temp_log
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
     * This method corresponds to the database table ism_fundnet_temp_log
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
     * This method corresponds to the database table ism_fundnet_temp_log
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ism_fundnet_temp_log
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
     * This class corresponds to the database table ism_fundnet_temp_log
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

        public Criteria andFundnetIdIsNull() {
            addCriterion("fundnet_id is null");
            return (Criteria) this;
        }

        public Criteria andFundnetIdIsNotNull() {
            addCriterion("fundnet_id is not null");
            return (Criteria) this;
        }

        public Criteria andFundnetIdEqualTo(String value) {
            addCriterion("fundnet_id =", value, "fundnetId");
            return (Criteria) this;
        }

        public Criteria andFundnetIdNotEqualTo(String value) {
            addCriterion("fundnet_id <>", value, "fundnetId");
            return (Criteria) this;
        }

        public Criteria andFundnetIdGreaterThan(String value) {
            addCriterion("fundnet_id >", value, "fundnetId");
            return (Criteria) this;
        }

        public Criteria andFundnetIdGreaterThanOrEqualTo(String value) {
            addCriterion("fundnet_id >=", value, "fundnetId");
            return (Criteria) this;
        }

        public Criteria andFundnetIdLessThan(String value) {
            addCriterion("fundnet_id <", value, "fundnetId");
            return (Criteria) this;
        }

        public Criteria andFundnetIdLessThanOrEqualTo(String value) {
            addCriterion("fundnet_id <=", value, "fundnetId");
            return (Criteria) this;
        }

        public Criteria andFundnetIdLike(String value) {
            addCriterion("fundnet_id like", value, "fundnetId");
            return (Criteria) this;
        }

        public Criteria andFundnetIdNotLike(String value) {
            addCriterion("fundnet_id not like", value, "fundnetId");
            return (Criteria) this;
        }

        public Criteria andFundnetIdIn(List<String> values) {
            addCriterion("fundnet_id in", values, "fundnetId");
            return (Criteria) this;
        }

        public Criteria andFundnetIdNotIn(List<String> values) {
            addCriterion("fundnet_id not in", values, "fundnetId");
            return (Criteria) this;
        }

        public Criteria andFundnetIdBetween(String value1, String value2) {
            addCriterion("fundnet_id between", value1, value2, "fundnetId");
            return (Criteria) this;
        }

        public Criteria andFundnetIdNotBetween(String value1, String value2) {
            addCriterion("fundnet_id not between", value1, value2, "fundnetId");
            return (Criteria) this;
        }

        public Criteria andFundTempIdIsNull() {
            addCriterion("fund_temp_id is null");
            return (Criteria) this;
        }

        public Criteria andFundTempIdIsNotNull() {
            addCriterion("fund_temp_id is not null");
            return (Criteria) this;
        }

        public Criteria andFundTempIdEqualTo(String value) {
            addCriterion("fund_temp_id =", value, "fundTempId");
            return (Criteria) this;
        }

        public Criteria andFundTempIdNotEqualTo(String value) {
            addCriterion("fund_temp_id <>", value, "fundTempId");
            return (Criteria) this;
        }

        public Criteria andFundTempIdGreaterThan(String value) {
            addCriterion("fund_temp_id >", value, "fundTempId");
            return (Criteria) this;
        }

        public Criteria andFundTempIdGreaterThanOrEqualTo(String value) {
            addCriterion("fund_temp_id >=", value, "fundTempId");
            return (Criteria) this;
        }

        public Criteria andFundTempIdLessThan(String value) {
            addCriterion("fund_temp_id <", value, "fundTempId");
            return (Criteria) this;
        }

        public Criteria andFundTempIdLessThanOrEqualTo(String value) {
            addCriterion("fund_temp_id <=", value, "fundTempId");
            return (Criteria) this;
        }

        public Criteria andFundTempIdLike(String value) {
            addCriterion("fund_temp_id like", value, "fundTempId");
            return (Criteria) this;
        }

        public Criteria andFundTempIdNotLike(String value) {
            addCriterion("fund_temp_id not like", value, "fundTempId");
            return (Criteria) this;
        }

        public Criteria andFundTempIdIn(List<String> values) {
            addCriterion("fund_temp_id in", values, "fundTempId");
            return (Criteria) this;
        }

        public Criteria andFundTempIdNotIn(List<String> values) {
            addCriterion("fund_temp_id not in", values, "fundTempId");
            return (Criteria) this;
        }

        public Criteria andFundTempIdBetween(String value1, String value2) {
            addCriterion("fund_temp_id between", value1, value2, "fundTempId");
            return (Criteria) this;
        }

        public Criteria andFundTempIdNotBetween(String value1, String value2) {
            addCriterion("fund_temp_id not between", value1, value2, "fundTempId");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andFundNetIsNull() {
            addCriterion("fund_net is null");
            return (Criteria) this;
        }

        public Criteria andFundNetIsNotNull() {
            addCriterion("fund_net is not null");
            return (Criteria) this;
        }

        public Criteria andFundNetEqualTo(BigDecimal value) {
            addCriterion("fund_net =", value, "fundNet");
            return (Criteria) this;
        }

        public Criteria andFundNetNotEqualTo(BigDecimal value) {
            addCriterion("fund_net <>", value, "fundNet");
            return (Criteria) this;
        }

        public Criteria andFundNetGreaterThan(BigDecimal value) {
            addCriterion("fund_net >", value, "fundNet");
            return (Criteria) this;
        }

        public Criteria andFundNetGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fund_net >=", value, "fundNet");
            return (Criteria) this;
        }

        public Criteria andFundNetLessThan(BigDecimal value) {
            addCriterion("fund_net <", value, "fundNet");
            return (Criteria) this;
        }

        public Criteria andFundNetLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fund_net <=", value, "fundNet");
            return (Criteria) this;
        }

        public Criteria andFundNetIn(List<BigDecimal> values) {
            addCriterion("fund_net in", values, "fundNet");
            return (Criteria) this;
        }

        public Criteria andFundNetNotIn(List<BigDecimal> values) {
            addCriterion("fund_net not in", values, "fundNet");
            return (Criteria) this;
        }

        public Criteria andFundNetBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fund_net between", value1, value2, "fundNet");
            return (Criteria) this;
        }

        public Criteria andFundNetNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fund_net not between", value1, value2, "fundNet");
            return (Criteria) this;
        }

        public Criteria andFundUpnetIsNull() {
            addCriterion("fund_upnet is null");
            return (Criteria) this;
        }

        public Criteria andFundUpnetIsNotNull() {
            addCriterion("fund_upnet is not null");
            return (Criteria) this;
        }

        public Criteria andFundUpnetEqualTo(BigDecimal value) {
            addCriterion("fund_upnet =", value, "fundUpnet");
            return (Criteria) this;
        }

        public Criteria andFundUpnetNotEqualTo(BigDecimal value) {
            addCriterion("fund_upnet <>", value, "fundUpnet");
            return (Criteria) this;
        }

        public Criteria andFundUpnetGreaterThan(BigDecimal value) {
            addCriterion("fund_upnet >", value, "fundUpnet");
            return (Criteria) this;
        }

        public Criteria andFundUpnetGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fund_upnet >=", value, "fundUpnet");
            return (Criteria) this;
        }

        public Criteria andFundUpnetLessThan(BigDecimal value) {
            addCriterion("fund_upnet <", value, "fundUpnet");
            return (Criteria) this;
        }

        public Criteria andFundUpnetLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fund_upnet <=", value, "fundUpnet");
            return (Criteria) this;
        }

        public Criteria andFundUpnetIn(List<BigDecimal> values) {
            addCriterion("fund_upnet in", values, "fundUpnet");
            return (Criteria) this;
        }

        public Criteria andFundUpnetNotIn(List<BigDecimal> values) {
            addCriterion("fund_upnet not in", values, "fundUpnet");
            return (Criteria) this;
        }

        public Criteria andFundUpnetBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fund_upnet between", value1, value2, "fundUpnet");
            return (Criteria) this;
        }

        public Criteria andFundUpnetNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fund_upnet not between", value1, value2, "fundUpnet");
            return (Criteria) this;
        }

        public Criteria andFundSourceIsNull() {
            addCriterion("fund_source is null");
            return (Criteria) this;
        }

        public Criteria andFundSourceIsNotNull() {
            addCriterion("fund_source is not null");
            return (Criteria) this;
        }

        public Criteria andFundSourceEqualTo(Integer value) {
            addCriterion("fund_source =", value, "fundSource");
            return (Criteria) this;
        }

        public Criteria andFundSourceNotEqualTo(Integer value) {
            addCriterion("fund_source <>", value, "fundSource");
            return (Criteria) this;
        }

        public Criteria andFundSourceGreaterThan(Integer value) {
            addCriterion("fund_source >", value, "fundSource");
            return (Criteria) this;
        }

        public Criteria andFundSourceGreaterThanOrEqualTo(Integer value) {
            addCriterion("fund_source >=", value, "fundSource");
            return (Criteria) this;
        }

        public Criteria andFundSourceLessThan(Integer value) {
            addCriterion("fund_source <", value, "fundSource");
            return (Criteria) this;
        }

        public Criteria andFundSourceLessThanOrEqualTo(Integer value) {
            addCriterion("fund_source <=", value, "fundSource");
            return (Criteria) this;
        }

        public Criteria andFundSourceIn(List<Integer> values) {
            addCriterion("fund_source in", values, "fundSource");
            return (Criteria) this;
        }

        public Criteria andFundSourceNotIn(List<Integer> values) {
            addCriterion("fund_source not in", values, "fundSource");
            return (Criteria) this;
        }

        public Criteria andFundSourceBetween(Integer value1, Integer value2) {
            addCriterion("fund_source between", value1, value2, "fundSource");
            return (Criteria) this;
        }

        public Criteria andFundSourceNotBetween(Integer value1, Integer value2) {
            addCriterion("fund_source not between", value1, value2, "fundSource");
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

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andFundnetIdLikeInsensitive(String value) {
            addCriterion("upper(fundnet_id) like", value.toUpperCase(), "fundnetId");
            return (Criteria) this;
        }

        public Criteria andFundTempIdLikeInsensitive(String value) {
            addCriterion("upper(fund_temp_id) like", value.toUpperCase(), "fundTempId");
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
     * This class corresponds to the database table ism_fundnet_temp_log
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
     * This class corresponds to the database table ism_fundnet_temp_log
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