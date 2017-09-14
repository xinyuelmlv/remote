package com.maple.earnings.pojo;

import java.util.ArrayList;
import java.util.List;

public class EProductExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EProductExample() {
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

        public Criteria andNumIidIsNull() {
            addCriterion("num_iid is null");
            return (Criteria) this;
        }

        public Criteria andNumIidIsNotNull() {
            addCriterion("num_iid is not null");
            return (Criteria) this;
        }

        public Criteria andNumIidEqualTo(Long value) {
            addCriterion("num_iid =", value, "numIid");
            return (Criteria) this;
        }

        public Criteria andNumIidNotEqualTo(Long value) {
            addCriterion("num_iid <>", value, "numIid");
            return (Criteria) this;
        }

        public Criteria andNumIidGreaterThan(Long value) {
            addCriterion("num_iid >", value, "numIid");
            return (Criteria) this;
        }

        public Criteria andNumIidGreaterThanOrEqualTo(Long value) {
            addCriterion("num_iid >=", value, "numIid");
            return (Criteria) this;
        }

        public Criteria andNumIidLessThan(Long value) {
            addCriterion("num_iid <", value, "numIid");
            return (Criteria) this;
        }

        public Criteria andNumIidLessThanOrEqualTo(Long value) {
            addCriterion("num_iid <=", value, "numIid");
            return (Criteria) this;
        }

        public Criteria andNumIidIn(List<Long> values) {
            addCriterion("num_iid in", values, "numIid");
            return (Criteria) this;
        }

        public Criteria andNumIidNotIn(List<Long> values) {
            addCriterion("num_iid not in", values, "numIid");
            return (Criteria) this;
        }

        public Criteria andNumIidBetween(Long value1, Long value2) {
            addCriterion("num_iid between", value1, value2, "numIid");
            return (Criteria) this;
        }

        public Criteria andNumIidNotBetween(Long value1, Long value2) {
            addCriterion("num_iid not between", value1, value2, "numIid");
            return (Criteria) this;
        }

        public Criteria andApprroveStatusIsNull() {
            addCriterion("apprrove_status is null");
            return (Criteria) this;
        }

        public Criteria andApprroveStatusIsNotNull() {
            addCriterion("apprrove_status is not null");
            return (Criteria) this;
        }

        public Criteria andApprroveStatusEqualTo(String value) {
            addCriterion("apprrove_status =", value, "apprroveStatus");
            return (Criteria) this;
        }

        public Criteria andApprroveStatusNotEqualTo(String value) {
            addCriterion("apprrove_status <>", value, "apprroveStatus");
            return (Criteria) this;
        }

        public Criteria andApprroveStatusGreaterThan(String value) {
            addCriterion("apprrove_status >", value, "apprroveStatus");
            return (Criteria) this;
        }

        public Criteria andApprroveStatusGreaterThanOrEqualTo(String value) {
            addCriterion("apprrove_status >=", value, "apprroveStatus");
            return (Criteria) this;
        }

        public Criteria andApprroveStatusLessThan(String value) {
            addCriterion("apprrove_status <", value, "apprroveStatus");
            return (Criteria) this;
        }

        public Criteria andApprroveStatusLessThanOrEqualTo(String value) {
            addCriterion("apprrove_status <=", value, "apprroveStatus");
            return (Criteria) this;
        }

        public Criteria andApprroveStatusLike(String value) {
            addCriterion("apprrove_status like", value, "apprroveStatus");
            return (Criteria) this;
        }

        public Criteria andApprroveStatusNotLike(String value) {
            addCriterion("apprrove_status not like", value, "apprroveStatus");
            return (Criteria) this;
        }

        public Criteria andApprroveStatusIn(List<String> values) {
            addCriterion("apprrove_status in", values, "apprroveStatus");
            return (Criteria) this;
        }

        public Criteria andApprroveStatusNotIn(List<String> values) {
            addCriterion("apprrove_status not in", values, "apprroveStatus");
            return (Criteria) this;
        }

        public Criteria andApprroveStatusBetween(String value1, String value2) {
            addCriterion("apprrove_status between", value1, value2, "apprroveStatus");
            return (Criteria) this;
        }

        public Criteria andApprroveStatusNotBetween(String value1, String value2) {
            addCriterion("apprrove_status not between", value1, value2, "apprroveStatus");
            return (Criteria) this;
        }

        public Criteria andModifiedIsNull() {
            addCriterion("modified is null");
            return (Criteria) this;
        }

        public Criteria andModifiedIsNotNull() {
            addCriterion("modified is not null");
            return (Criteria) this;
        }

        public Criteria andModifiedEqualTo(String value) {
            addCriterion("modified =", value, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedNotEqualTo(String value) {
            addCriterion("modified <>", value, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedGreaterThan(String value) {
            addCriterion("modified >", value, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedGreaterThanOrEqualTo(String value) {
            addCriterion("modified >=", value, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedLessThan(String value) {
            addCriterion("modified <", value, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedLessThanOrEqualTo(String value) {
            addCriterion("modified <=", value, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedLike(String value) {
            addCriterion("modified like", value, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedNotLike(String value) {
            addCriterion("modified not like", value, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedIn(List<String> values) {
            addCriterion("modified in", values, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedNotIn(List<String> values) {
            addCriterion("modified not in", values, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedBetween(String value1, String value2) {
            addCriterion("modified between", value1, value2, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedNotBetween(String value1, String value2) {
            addCriterion("modified not between", value1, value2, "modified");
            return (Criteria) this;
        }

        public Criteria andNumIsNull() {
            addCriterion("num is null");
            return (Criteria) this;
        }

        public Criteria andNumIsNotNull() {
            addCriterion("num is not null");
            return (Criteria) this;
        }

        public Criteria andNumEqualTo(int value) {
            addCriterion("num =", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotEqualTo(int value) {
            addCriterion("num <>", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThan(int value) {
            addCriterion("num >", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThanOrEqualTo(int value) {
            addCriterion("num >=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThan(int value) {
            addCriterion("num <", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThanOrEqualTo(int value) {
            addCriterion("num <=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumIn(List<Integer> values) {
            addCriterion("num in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotIn(List<Integer> values) {
            addCriterion("num not in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumBetween(int value1,int value2) {
            addCriterion("num between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotBetween(int value1, int value2) {
            addCriterion("num not between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Double value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Double value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Double value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Double value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Double value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Double> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Double> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Double value1, Double value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Double value1, Double value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andUIdIsNull() {
            addCriterion("taobao_user_id is null");
            return (Criteria) this;
        }

        public Criteria andUIdIsNotNull() {
            addCriterion("taobao_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUIdEqualTo(String value) {
            addCriterion("taobao_user_id =", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdNotEqualTo(String value) {
            addCriterion("taobao_user_id <>", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdGreaterThan(String value) {
            addCriterion("taobao_user_id >", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdGreaterThanOrEqualTo(Long value) {
            addCriterion("taobao_user_id >=", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdLessThan(String value) {
            addCriterion("taobao_user_id <", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdLessThanOrEqualTo(String value) {
            addCriterion("taobao_user_id <=", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdIn(List<String> values) {
            addCriterion("taobao_user_id in", values, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdNotIn(List<String> values) {
            addCriterion("taobao_user_id not in", values, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdBetween(String value1, String value2) {
            addCriterion("taobao_user_id between", value1, value2, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdNotBetween(String value1, String value2) {
            addCriterion("taobao_user_id not between", value1, value2, "uId");
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