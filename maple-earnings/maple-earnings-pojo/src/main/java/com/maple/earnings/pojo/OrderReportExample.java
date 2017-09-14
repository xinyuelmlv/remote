package com.maple.earnings.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OrderReportExample {
	protected String userId;
	
    public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	protected String orderByClause;
 
    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderReportExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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

        public Criteria andTidIsNull() {
            addCriterion("tid is null");
            return (Criteria) this;
        }

        public Criteria andTidIsNotNull() {
            addCriterion("tid is not null");
            return (Criteria) this;
        }

        public Criteria andTidEqualTo(Long value) {
            addCriterion("tid =", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotEqualTo(Long value) {
            addCriterion("tid <>", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidGreaterThan(Long value) {
            addCriterion("tid >", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidGreaterThanOrEqualTo(Long value) {
            addCriterion("tid >=", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLessThan(Long value) {
            addCriterion("tid <", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLessThanOrEqualTo(Long value) {
            addCriterion("tid <=", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidIn(List<Long> values) {
            addCriterion("tid in", values, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotIn(List<Long> values) {
            addCriterion("tid not in", values, "tid");
            return (Criteria) this;
        }

        public Criteria andTidBetween(Long value1, Long value2) {
            addCriterion("tid between", value1, value2, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotBetween(Long value1, Long value2) {
            addCriterion("tid not between", value1, value2, "tid");
            return (Criteria) this;
        }

        public Criteria andProductCostIsNull() {
            addCriterion("product_cost is null");
            return (Criteria) this;
        }

        public Criteria andProductCostIsNotNull() {
            addCriterion("product_cost is not null");
            return (Criteria) this;
        }

        public Criteria andProductCostEqualTo(BigDecimal value) {
            addCriterion("product_cost =", value, "productCost");
            return (Criteria) this;
        }

        public Criteria andProductCostNotEqualTo(BigDecimal value) {
            addCriterion("product_cost <>", value, "productCost");
            return (Criteria) this;
        }

        public Criteria andProductCostGreaterThan(BigDecimal value) {
            addCriterion("product_cost >", value, "productCost");
            return (Criteria) this;
        }

        public Criteria andProductCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("product_cost >=", value, "productCost");
            return (Criteria) this;
        }

        public Criteria andProductCostLessThan(BigDecimal value) {
            addCriterion("product_cost <", value, "productCost");
            return (Criteria) this;
        }

        public Criteria andProductCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("product_cost <=", value, "productCost");
            return (Criteria) this;
        }

        public Criteria andProductCostIn(List<BigDecimal> values) {
            addCriterion("product_cost in", values, "productCost");
            return (Criteria) this;
        }

        public Criteria andProductCostNotIn(List<BigDecimal> values) {
            addCriterion("product_cost not in", values, "productCost");
            return (Criteria) this;
        }

        public Criteria andProductCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("product_cost between", value1, value2, "productCost");
            return (Criteria) this;
        }

        public Criteria andProductCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("product_cost not between", value1, value2, "productCost");
            return (Criteria) this;
        }

        public Criteria andExtraCostIsNull() {
            addCriterion("extra_cost is null");
            return (Criteria) this;
        }

        public Criteria andExtraCostIsNotNull() {
            addCriterion("extra_cost is not null");
            return (Criteria) this;
        }

        public Criteria andExtraCostEqualTo(BigDecimal value) {
            addCriterion("extra_cost =", value, "extraCost");
            return (Criteria) this;
        }

        public Criteria andExtraCostNotEqualTo(BigDecimal value) {
            addCriterion("extra_cost <>", value, "extraCost");
            return (Criteria) this;
        }

        public Criteria andExtraCostGreaterThan(BigDecimal value) {
            addCriterion("extra_cost >", value, "extraCost");
            return (Criteria) this;
        }

        public Criteria andExtraCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("extra_cost >=", value, "extraCost");
            return (Criteria) this;
        }

        public Criteria andExtraCostLessThan(BigDecimal value) {
            addCriterion("extra_cost <", value, "extraCost");
            return (Criteria) this;
        }

        public Criteria andExtraCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("extra_cost <=", value, "extraCost");
            return (Criteria) this;
        }

        public Criteria andExtraCostIn(List<BigDecimal> values) {
            addCriterion("extra_cost in", values, "extraCost");
            return (Criteria) this;
        }

        public Criteria andExtraCostNotIn(List<BigDecimal> values) {
            addCriterion("extra_cost not in", values, "extraCost");
            return (Criteria) this;
        }

        public Criteria andExtraCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("extra_cost between", value1, value2, "extraCost");
            return (Criteria) this;
        }

        public Criteria andExtraCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("extra_cost not between", value1, value2, "extraCost");
            return (Criteria) this;
        }

        public Criteria andTotalFeeIsNull() {
            addCriterion("total_fee is null");
            return (Criteria) this;
        }

        public Criteria andTotalFeeIsNotNull() {
            addCriterion("total_fee is not null");
            return (Criteria) this;
        }

        public Criteria andTotalFeeEqualTo(BigDecimal value) {
            addCriterion("total_fee =", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeNotEqualTo(BigDecimal value) {
            addCriterion("total_fee <>", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeGreaterThan(BigDecimal value) {
            addCriterion("total_fee >", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_fee >=", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeLessThan(BigDecimal value) {
            addCriterion("total_fee <", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_fee <=", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeIn(List<BigDecimal> values) {
            addCriterion("total_fee in", values, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeNotIn(List<BigDecimal> values) {
            addCriterion("total_fee not in", values, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_fee between", value1, value2, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_fee not between", value1, value2, "totalFee");
            return (Criteria) this;
        }

        public Criteria andRefundFeeIsNull() {
            addCriterion("refund_fee is null");
            return (Criteria) this;
        }

        public Criteria andRefundFeeIsNotNull() {
            addCriterion("refund_fee is not null");
            return (Criteria) this;
        }

        public Criteria andRefundFeeEqualTo(BigDecimal value) {
            addCriterion("refund_fee =", value, "refundFee");
            return (Criteria) this;
        }

        public Criteria andRefundFeeNotEqualTo(BigDecimal value) {
            addCriterion("refund_fee <>", value, "refundFee");
            return (Criteria) this;
        }

        public Criteria andRefundFeeGreaterThan(BigDecimal value) {
            addCriterion("refund_fee >", value, "refundFee");
            return (Criteria) this;
        }

        public Criteria andRefundFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("refund_fee >=", value, "refundFee");
            return (Criteria) this;
        }

        public Criteria andRefundFeeLessThan(BigDecimal value) {
            addCriterion("refund_fee <", value, "refundFee");
            return (Criteria) this;
        }

        public Criteria andRefundFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("refund_fee <=", value, "refundFee");
            return (Criteria) this;
        }

        public Criteria andRefundFeeIn(List<BigDecimal> values) {
            addCriterion("refund_fee in", values, "refundFee");
            return (Criteria) this;
        }

        public Criteria andRefundFeeNotIn(List<BigDecimal> values) {
            addCriterion("refund_fee not in", values, "refundFee");
            return (Criteria) this;
        }

        public Criteria andRefundFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("refund_fee between", value1, value2, "refundFee");
            return (Criteria) this;
        }

        public Criteria andRefundFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("refund_fee not between", value1, value2, "refundFee");
            return (Criteria) this;
        }

        public Criteria andGainIsNull() {
            addCriterion("gain is null");
            return (Criteria) this;
        }

        public Criteria andGainIsNotNull() {
            addCriterion("gain is not null");
            return (Criteria) this;
        }

        public Criteria andGainEqualTo(BigDecimal value) {
            addCriterion("gain =", value, "gain");
            return (Criteria) this;
        }

        public Criteria andGainNotEqualTo(BigDecimal value) {
            addCriterion("gain <>", value, "gain");
            return (Criteria) this;
        }

        public Criteria andGainGreaterThan(BigDecimal value) {
            addCriterion("gain >", value, "gain");
            return (Criteria) this;
        }

        public Criteria andGainGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("gain >=", value, "gain");
            return (Criteria) this;
        }

        public Criteria andGainLessThan(BigDecimal value) {
            addCriterion("gain <", value, "gain");
            return (Criteria) this;
        }

        public Criteria andGainLessThanOrEqualTo(BigDecimal value) {
            addCriterion("gain <=", value, "gain");
            return (Criteria) this;
        }

        public Criteria andGainIn(List<BigDecimal> values) {
            addCriterion("gain in", values, "gain");
            return (Criteria) this;
        }

        public Criteria andGainNotIn(List<BigDecimal> values) {
            addCriterion("gain not in", values, "gain");
            return (Criteria) this;
        }

        public Criteria andGainBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("gain between", value1, value2, "gain");
            return (Criteria) this;
        }

        public Criteria andGainNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("gain not between", value1, value2, "gain");
            return (Criteria) this;
        }

        public Criteria andCommissionIsNull() {
            addCriterion("commission is null");
            return (Criteria) this;
        }

        public Criteria andCommissionIsNotNull() {
            addCriterion("commission is not null");
            return (Criteria) this;
        }

        public Criteria andCommissionEqualTo(BigDecimal value) {
            addCriterion("commission =", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionNotEqualTo(BigDecimal value) {
            addCriterion("commission <>", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionGreaterThan(BigDecimal value) {
            addCriterion("commission >", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("commission >=", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionLessThan(BigDecimal value) {
            addCriterion("commission <", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionLessThanOrEqualTo(BigDecimal value) {
            addCriterion("commission <=", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionIn(List<BigDecimal> values) {
            addCriterion("commission in", values, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionNotIn(List<BigDecimal> values) {
            addCriterion("commission not in", values, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("commission between", value1, value2, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("commission not between", value1, value2, "commission");
            return (Criteria) this;
        }

        public Criteria andRealReceiveIsNull() {
            addCriterion("real_receive is null");
            return (Criteria) this;
        }

        public Criteria andRealReceiveIsNotNull() {
            addCriterion("real_receive is not null");
            return (Criteria) this;
        }

        public Criteria andRealReceiveEqualTo(BigDecimal value) {
            addCriterion("real_receive =", value, "realReceive");
            return (Criteria) this;
        }

        public Criteria andRealReceiveNotEqualTo(BigDecimal value) {
            addCriterion("real_receive <>", value, "realReceive");
            return (Criteria) this;
        }

        public Criteria andRealReceiveGreaterThan(BigDecimal value) {
            addCriterion("real_receive >", value, "realReceive");
            return (Criteria) this;
        }

        public Criteria andRealReceiveGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("real_receive >=", value, "realReceive");
            return (Criteria) this;
        }

        public Criteria andRealReceiveLessThan(BigDecimal value) {
            addCriterion("real_receive <", value, "realReceive");
            return (Criteria) this;
        }

        public Criteria andRealReceiveLessThanOrEqualTo(BigDecimal value) {
            addCriterion("real_receive <=", value, "realReceive");
            return (Criteria) this;
        }

        public Criteria andRealReceiveIn(List<BigDecimal> values) {
            addCriterion("real_receive in", values, "realReceive");
            return (Criteria) this;
        }

        public Criteria andRealReceiveNotIn(List<BigDecimal> values) {
            addCriterion("real_receive not in", values, "realReceive");
            return (Criteria) this;
        }

        public Criteria andRealReceiveBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("real_receive between", value1, value2, "realReceive");
            return (Criteria) this;
        }

        public Criteria andRealReceiveNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("real_receive not between", value1, value2, "realReceive");
            return (Criteria) this;
        }

        public Criteria andReportDateIsNull() {
            addCriterion("report_date is null");
            return (Criteria) this;
        }

        public Criteria andReportDateIsNotNull() {
            addCriterion("report_date is not null");
            return (Criteria) this;
        }

        public Criteria andReportDateEqualTo(String value) {
            addCriterion("report_date =", value, "reportDate");
            return (Criteria) this;
        }

        public Criteria andReportDateNotEqualTo(String value) {
            addCriterion("report_date <>", value, "reportDate");
            return (Criteria) this;
        }

        public Criteria andReportDateGreaterThan(String value) {
            addCriterion("report_date >", value, "reportDate");
            return (Criteria) this;
        }

        public Criteria andReportDateGreaterThanOrEqualTo(String value) {
            addCriterion("report_date >=", value, "reportDate");
            return (Criteria) this;
        }

        public Criteria andReportDateLessThan(String value) {
            addCriterion("report_date <", value, "reportDate");
            return (Criteria) this;
        }

        public Criteria andReportDateLessThanOrEqualTo(String value) {
            addCriterion("report_date <=", value, "reportDate");
            return (Criteria) this;
        }

        public Criteria andReportDateLike(String value) {
            addCriterion("report_date like", value, "reportDate");
            return (Criteria) this;
        }

        public Criteria andReportDateNotLike(String value) {
            addCriterion("report_date not like", value, "reportDate");
            return (Criteria) this;
        }

        public Criteria andReportDateIn(List<String> values) {
            addCriterion("report_date in", values, "reportDate");
            return (Criteria) this;
        }

        public Criteria andReportDateNotIn(List<String> values) {
            addCriterion("report_date not in", values, "reportDate");
            return (Criteria) this;
        }

        public Criteria andReportDateBetween(String value1, String value2) {
            addCriterion("report_date between", value1, value2, "reportDate");
            return (Criteria) this;
        }

        public Criteria andReportDateNotBetween(String value1, String value2) {
            addCriterion("report_date not between", value1, value2, "reportDate");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("taobao_user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("taobao_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("taobao_user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("taobao_user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("taobao_user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("taobao_user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("taobao_user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("taobao_user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("taobao_user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("taobao_user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("taobao_user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("taobao_user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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