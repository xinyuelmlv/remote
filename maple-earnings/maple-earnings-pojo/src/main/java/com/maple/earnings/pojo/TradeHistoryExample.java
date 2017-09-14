package com.maple.earnings.pojo;

import java.util.ArrayList;
import java.util.List;

public class TradeHistoryExample {
    protected String orderByClause;
    protected String userId;
    
    public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TradeHistoryExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
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

        public Criteria andChangetimeIsNull() {
            addCriterion("changeTime is null");
            return (Criteria) this;
        }

        public Criteria andChangetimeIsNotNull() {
            addCriterion("changeTime is not null");
            return (Criteria) this;
        }

        public Criteria andChangetimeEqualTo(String value) {
            addCriterion("changeTime =", value, "changetime");
            return (Criteria) this;
        }

        public Criteria andChangetimeNotEqualTo(String value) {
            addCriterion("changeTime <>", value, "changetime");
            return (Criteria) this;
        }

        public Criteria andChangetimeGreaterThan(String value) {
            addCriterion("changeTime >", value, "changetime");
            return (Criteria) this;
        }

        public Criteria andChangetimeGreaterThanOrEqualTo(String value) {
            addCriterion("changeTime >=", value, "changetime");
            return (Criteria) this;
        }

        public Criteria andChangetimeLessThan(String value) {
            addCriterion("changeTime <", value, "changetime");
            return (Criteria) this;
        }

        public Criteria andChangetimeLessThanOrEqualTo(String value) {
            addCriterion("changeTime <=", value, "changetime");
            return (Criteria) this;
        }

        public Criteria andChangetimeLike(String value) {
            addCriterion("changeTime like", value, "changetime");
            return (Criteria) this;
        }

        public Criteria andChangetimeNotLike(String value) {
            addCriterion("changeTime not like", value, "changetime");
            return (Criteria) this;
        }

        public Criteria andChangetimeIn(List<String> values) {
            addCriterion("changeTime in", values, "changetime");
            return (Criteria) this;
        }

        public Criteria andChangetimeNotIn(List<String> values) {
            addCriterion("changeTime not in", values, "changetime");
            return (Criteria) this;
        }

        public Criteria andChangetimeBetween(String value1, String value2) {
            addCriterion("changeTime between", value1, value2, "changetime");
            return (Criteria) this;
        }

        public Criteria andChangetimeNotBetween(String value1, String value2) {
            addCriterion("changeTime not between", value1, value2, "changetime");
            return (Criteria) this;
        }

        public Criteria andRealpaymentIsNull() {
            addCriterion("realPayment is null");
            return (Criteria) this;
        }

        public Criteria andRealpaymentIsNotNull() {
            addCriterion("realPayment is not null");
            return (Criteria) this;
        }

        public Criteria andRealpaymentEqualTo(Double value) {
            addCriterion("realPayment =", value, "realpayment");
            return (Criteria) this;
        }

        public Criteria andRealpaymentNotEqualTo(Double value) {
            addCriterion("realPayment <>", value, "realpayment");
            return (Criteria) this;
        }

        public Criteria andRealpaymentGreaterThan(Double value) {
            addCriterion("realPayment >", value, "realpayment");
            return (Criteria) this;
        }

        public Criteria andRealpaymentGreaterThanOrEqualTo(Double value) {
            addCriterion("realPayment >=", value, "realpayment");
            return (Criteria) this;
        }

        public Criteria andRealpaymentLessThan(Double value) {
            addCriterion("realPayment <", value, "realpayment");
            return (Criteria) this;
        }

        public Criteria andRealpaymentLessThanOrEqualTo(Double value) {
            addCriterion("realPayment <=", value, "realpayment");
            return (Criteria) this;
        }

        public Criteria andRealpaymentIn(List<Double> values) {
            addCriterion("realPayment in", values, "realpayment");
            return (Criteria) this;
        }

        public Criteria andRealpaymentNotIn(List<Double> values) {
            addCriterion("realPayment not in", values, "realpayment");
            return (Criteria) this;
        }

        public Criteria andRealpaymentBetween(Double value1, Double value2) {
            addCriterion("realPayment between", value1, value2, "realpayment");
            return (Criteria) this;
        }

        public Criteria andRealpaymentNotBetween(Double value1, Double value2) {
            addCriterion("realPayment not between", value1, value2, "realpayment");
            return (Criteria) this;
        }

        public Criteria andPostfeeIsNull() {
            addCriterion("postFee is null");
            return (Criteria) this;
        }

        public Criteria andPostfeeIsNotNull() {
            addCriterion("postFee is not null");
            return (Criteria) this;
        }

        public Criteria andPostfeeEqualTo(Double value) {
            addCriterion("postFee =", value, "postfee");
            return (Criteria) this;
        }

        public Criteria andPostfeeNotEqualTo(Double value) {
            addCriterion("postFee <>", value, "postfee");
            return (Criteria) this;
        }

        public Criteria andPostfeeGreaterThan(Double value) {
            addCriterion("postFee >", value, "postfee");
            return (Criteria) this;
        }

        public Criteria andPostfeeGreaterThanOrEqualTo(Double value) {
            addCriterion("postFee >=", value, "postfee");
            return (Criteria) this;
        }

        public Criteria andPostfeeLessThan(Double value) {
            addCriterion("postFee <", value, "postfee");
            return (Criteria) this;
        }

        public Criteria andPostfeeLessThanOrEqualTo(Double value) {
            addCriterion("postFee <=", value, "postfee");
            return (Criteria) this;
        }

        public Criteria andPostfeeIn(List<Double> values) {
            addCriterion("postFee in", values, "postfee");
            return (Criteria) this;
        }

        public Criteria andPostfeeNotIn(List<Double> values) {
            addCriterion("postFee not in", values, "postfee");
            return (Criteria) this;
        }

        public Criteria andPostfeeBetween(Double value1, Double value2) {
            addCriterion("postFee between", value1, value2, "postfee");
            return (Criteria) this;
        }

        public Criteria andPostfeeNotBetween(Double value1, Double value2) {
            addCriterion("postFee not between", value1, value2, "postfee");
            return (Criteria) this;
        }

        public Criteria andShuoldpaymentIsNull() {
            addCriterion("shuoldPayment is null");
            return (Criteria) this;
        }

        public Criteria andShuoldpaymentIsNotNull() {
            addCriterion("shuoldPayment is not null");
            return (Criteria) this;
        }

        public Criteria andShuoldpaymentEqualTo(Double value) {
            addCriterion("shuoldPayment =", value, "shuoldpayment");
            return (Criteria) this;
        }

        public Criteria andShuoldpaymentNotEqualTo(Double value) {
            addCriterion("shuoldPayment <>", value, "shuoldpayment");
            return (Criteria) this;
        }

        public Criteria andShuoldpaymentGreaterThan(Double value) {
            addCriterion("shuoldPayment >", value, "shuoldpayment");
            return (Criteria) this;
        }

        public Criteria andShuoldpaymentGreaterThanOrEqualTo(Double value) {
            addCriterion("shuoldPayment >=", value, "shuoldpayment");
            return (Criteria) this;
        }

        public Criteria andShuoldpaymentLessThan(Double value) {
            addCriterion("shuoldPayment <", value, "shuoldpayment");
            return (Criteria) this;
        }

        public Criteria andShuoldpaymentLessThanOrEqualTo(Double value) {
            addCriterion("shuoldPayment <=", value, "shuoldpayment");
            return (Criteria) this;
        }

        public Criteria andShuoldpaymentIn(List<Double> values) {
            addCriterion("shuoldPayment in", values, "shuoldpayment");
            return (Criteria) this;
        }

        public Criteria andShuoldpaymentNotIn(List<Double> values) {
            addCriterion("shuoldPayment not in", values, "shuoldpayment");
            return (Criteria) this;
        }

        public Criteria andShuoldpaymentBetween(Double value1, Double value2) {
            addCriterion("shuoldPayment between", value1, value2, "shuoldpayment");
            return (Criteria) this;
        }

        public Criteria andShuoldpaymentNotBetween(Double value1, Double value2) {
            addCriterion("shuoldPayment not between", value1, value2, "shuoldpayment");
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