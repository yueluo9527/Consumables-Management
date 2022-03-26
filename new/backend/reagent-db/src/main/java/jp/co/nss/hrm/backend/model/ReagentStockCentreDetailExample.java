package jp.co.nss.hrm.backend.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReagentStockCentreDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReagentStockCentreDetailExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andStockNoIsNull() {
            addCriterion("stock_no is null");
            return (Criteria) this;
        }

        public Criteria andStockNoIsNotNull() {
            addCriterion("stock_no is not null");
            return (Criteria) this;
        }

        public Criteria andStockNoEqualTo(String value) {
            addCriterion("stock_no =", value, "stockNo");
            return (Criteria) this;
        }

        public Criteria andStockNoNotEqualTo(String value) {
            addCriterion("stock_no <>", value, "stockNo");
            return (Criteria) this;
        }

        public Criteria andStockNoGreaterThan(String value) {
            addCriterion("stock_no >", value, "stockNo");
            return (Criteria) this;
        }

        public Criteria andStockNoGreaterThanOrEqualTo(String value) {
            addCriterion("stock_no >=", value, "stockNo");
            return (Criteria) this;
        }

        public Criteria andStockNoLessThan(String value) {
            addCriterion("stock_no <", value, "stockNo");
            return (Criteria) this;
        }

        public Criteria andStockNoLessThanOrEqualTo(String value) {
            addCriterion("stock_no <=", value, "stockNo");
            return (Criteria) this;
        }

        public Criteria andStockNoLike(String value) {
            addCriterion("stock_no like", value, "stockNo");
            return (Criteria) this;
        }

        public Criteria andStockNoNotLike(String value) {
            addCriterion("stock_no not like", value, "stockNo");
            return (Criteria) this;
        }

        public Criteria andStockNoIn(List<String> values) {
            addCriterion("stock_no in", values, "stockNo");
            return (Criteria) this;
        }

        public Criteria andStockNoNotIn(List<String> values) {
            addCriterion("stock_no not in", values, "stockNo");
            return (Criteria) this;
        }

        public Criteria andStockNoBetween(String value1, String value2) {
            addCriterion("stock_no between", value1, value2, "stockNo");
            return (Criteria) this;
        }

        public Criteria andStockNoNotBetween(String value1, String value2) {
            addCriterion("stock_no not between", value1, value2, "stockNo");
            return (Criteria) this;
        }

        public Criteria andReagentNameIsNull() {
            addCriterion("reagent_name is null");
            return (Criteria) this;
        }

        public Criteria andReagentNameIsNotNull() {
            addCriterion("reagent_name is not null");
            return (Criteria) this;
        }

        public Criteria andReagentNameEqualTo(String value) {
            addCriterion("reagent_name =", value, "reagentName");
            return (Criteria) this;
        }

        public Criteria andReagentNameNotEqualTo(String value) {
            addCriterion("reagent_name <>", value, "reagentName");
            return (Criteria) this;
        }

        public Criteria andReagentNameGreaterThan(String value) {
            addCriterion("reagent_name >", value, "reagentName");
            return (Criteria) this;
        }

        public Criteria andReagentNameGreaterThanOrEqualTo(String value) {
            addCriterion("reagent_name >=", value, "reagentName");
            return (Criteria) this;
        }

        public Criteria andReagentNameLessThan(String value) {
            addCriterion("reagent_name <", value, "reagentName");
            return (Criteria) this;
        }

        public Criteria andReagentNameLessThanOrEqualTo(String value) {
            addCriterion("reagent_name <=", value, "reagentName");
            return (Criteria) this;
        }

        public Criteria andReagentNameLike(String value) {
            addCriterion("reagent_name like", value, "reagentName");
            return (Criteria) this;
        }

        public Criteria andReagentNameNotLike(String value) {
            addCriterion("reagent_name not like", value, "reagentName");
            return (Criteria) this;
        }

        public Criteria andReagentNameIn(List<String> values) {
            addCriterion("reagent_name in", values, "reagentName");
            return (Criteria) this;
        }

        public Criteria andReagentNameNotIn(List<String> values) {
            addCriterion("reagent_name not in", values, "reagentName");
            return (Criteria) this;
        }

        public Criteria andReagentNameBetween(String value1, String value2) {
            addCriterion("reagent_name between", value1, value2, "reagentName");
            return (Criteria) this;
        }

        public Criteria andReagentNameNotBetween(String value1, String value2) {
            addCriterion("reagent_name not between", value1, value2, "reagentName");
            return (Criteria) this;
        }

        public Criteria andReagentIdIsNull() {
            addCriterion("reagent_id is null");
            return (Criteria) this;
        }

        public Criteria andReagentIdIsNotNull() {
            addCriterion("reagent_id is not null");
            return (Criteria) this;
        }

        public Criteria andReagentIdEqualTo(Long value) {
            addCriterion("reagent_id =", value, "reagentId");
            return (Criteria) this;
        }

        public Criteria andReagentIdNotEqualTo(Long value) {
            addCriterion("reagent_id <>", value, "reagentId");
            return (Criteria) this;
        }

        public Criteria andReagentIdGreaterThan(Long value) {
            addCriterion("reagent_id >", value, "reagentId");
            return (Criteria) this;
        }

        public Criteria andReagentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("reagent_id >=", value, "reagentId");
            return (Criteria) this;
        }

        public Criteria andReagentIdLessThan(Long value) {
            addCriterion("reagent_id <", value, "reagentId");
            return (Criteria) this;
        }

        public Criteria andReagentIdLessThanOrEqualTo(Long value) {
            addCriterion("reagent_id <=", value, "reagentId");
            return (Criteria) this;
        }

        public Criteria andReagentIdIn(List<Long> values) {
            addCriterion("reagent_id in", values, "reagentId");
            return (Criteria) this;
        }

        public Criteria andReagentIdNotIn(List<Long> values) {
            addCriterion("reagent_id not in", values, "reagentId");
            return (Criteria) this;
        }

        public Criteria andReagentIdBetween(Long value1, Long value2) {
            addCriterion("reagent_id between", value1, value2, "reagentId");
            return (Criteria) this;
        }

        public Criteria andReagentIdNotBetween(Long value1, Long value2) {
            addCriterion("reagent_id not between", value1, value2, "reagentId");
            return (Criteria) this;
        }

        public Criteria andReagentNoIsNull() {
            addCriterion("reagent_no is null");
            return (Criteria) this;
        }

        public Criteria andReagentNoIsNotNull() {
            addCriterion("reagent_no is not null");
            return (Criteria) this;
        }

        public Criteria andReagentNoEqualTo(String value) {
            addCriterion("reagent_no =", value, "reagentNo");
            return (Criteria) this;
        }

        public Criteria andReagentNoNotEqualTo(String value) {
            addCriterion("reagent_no <>", value, "reagentNo");
            return (Criteria) this;
        }

        public Criteria andReagentNoGreaterThan(String value) {
            addCriterion("reagent_no >", value, "reagentNo");
            return (Criteria) this;
        }

        public Criteria andReagentNoGreaterThanOrEqualTo(String value) {
            addCriterion("reagent_no >=", value, "reagentNo");
            return (Criteria) this;
        }

        public Criteria andReagentNoLessThan(String value) {
            addCriterion("reagent_no <", value, "reagentNo");
            return (Criteria) this;
        }

        public Criteria andReagentNoLessThanOrEqualTo(String value) {
            addCriterion("reagent_no <=", value, "reagentNo");
            return (Criteria) this;
        }

        public Criteria andReagentNoLike(String value) {
            addCriterion("reagent_no like", value, "reagentNo");
            return (Criteria) this;
        }

        public Criteria andReagentNoNotLike(String value) {
            addCriterion("reagent_no not like", value, "reagentNo");
            return (Criteria) this;
        }

        public Criteria andReagentNoIn(List<String> values) {
            addCriterion("reagent_no in", values, "reagentNo");
            return (Criteria) this;
        }

        public Criteria andReagentNoNotIn(List<String> values) {
            addCriterion("reagent_no not in", values, "reagentNo");
            return (Criteria) this;
        }

        public Criteria andReagentNoBetween(String value1, String value2) {
            addCriterion("reagent_no between", value1, value2, "reagentNo");
            return (Criteria) this;
        }

        public Criteria andReagentNoNotBetween(String value1, String value2) {
            addCriterion("reagent_no not between", value1, value2, "reagentNo");
            return (Criteria) this;
        }

        public Criteria andExpireDateIsNull() {
            addCriterion("expire_date is null");
            return (Criteria) this;
        }

        public Criteria andExpireDateIsNotNull() {
            addCriterion("expire_date is not null");
            return (Criteria) this;
        }

        public Criteria andExpireDateEqualTo(String value) {
            addCriterion("expire_date =", value, "expireDate");
            return (Criteria) this;
        }

        public Criteria andExpireDateNotEqualTo(String value) {
            addCriterion("expire_date <>", value, "expireDate");
            return (Criteria) this;
        }

        public Criteria andExpireDateGreaterThan(String value) {
            addCriterion("expire_date >", value, "expireDate");
            return (Criteria) this;
        }

        public Criteria andExpireDateGreaterThanOrEqualTo(String value) {
            addCriterion("expire_date >=", value, "expireDate");
            return (Criteria) this;
        }

        public Criteria andExpireDateLessThan(String value) {
            addCriterion("expire_date <", value, "expireDate");
            return (Criteria) this;
        }

        public Criteria andExpireDateLessThanOrEqualTo(String value) {
            addCriterion("expire_date <=", value, "expireDate");
            return (Criteria) this;
        }

        public Criteria andExpireDateLike(String value) {
            addCriterion("expire_date like", value, "expireDate");
            return (Criteria) this;
        }

        public Criteria andExpireDateNotLike(String value) {
            addCriterion("expire_date not like", value, "expireDate");
            return (Criteria) this;
        }

        public Criteria andExpireDateIn(List<String> values) {
            addCriterion("expire_date in", values, "expireDate");
            return (Criteria) this;
        }

        public Criteria andExpireDateNotIn(List<String> values) {
            addCriterion("expire_date not in", values, "expireDate");
            return (Criteria) this;
        }

        public Criteria andExpireDateBetween(String value1, String value2) {
            addCriterion("expire_date between", value1, value2, "expireDate");
            return (Criteria) this;
        }

        public Criteria andExpireDateNotBetween(String value1, String value2) {
            addCriterion("expire_date not between", value1, value2, "expireDate");
            return (Criteria) this;
        }

        public Criteria andQuantityIsNull() {
            addCriterion("quantity is null");
            return (Criteria) this;
        }

        public Criteria andQuantityIsNotNull() {
            addCriterion("quantity is not null");
            return (Criteria) this;
        }

        public Criteria andQuantityEqualTo(Long value) {
            addCriterion("quantity =", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotEqualTo(Long value) {
            addCriterion("quantity <>", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityGreaterThan(Long value) {
            addCriterion("quantity >", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityGreaterThanOrEqualTo(Long value) {
            addCriterion("quantity >=", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityLessThan(Long value) {
            addCriterion("quantity <", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityLessThanOrEqualTo(Long value) {
            addCriterion("quantity <=", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityIn(List<Long> values) {
            addCriterion("quantity in", values, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotIn(List<Long> values) {
            addCriterion("quantity not in", values, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityBetween(Long value1, Long value2) {
            addCriterion("quantity between", value1, value2, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotBetween(Long value1, Long value2) {
            addCriterion("quantity not between", value1, value2, "quantity");
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

        public Criteria andCreateByIsNull() {
            addCriterion("create_by is null");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNotNull() {
            addCriterion("create_by is not null");
            return (Criteria) this;
        }

        public Criteria andCreateByEqualTo(String value) {
            addCriterion("create_by =", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotEqualTo(String value) {
            addCriterion("create_by <>", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThan(String value) {
            addCriterion("create_by >", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThanOrEqualTo(String value) {
            addCriterion("create_by >=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThan(String value) {
            addCriterion("create_by <", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThanOrEqualTo(String value) {
            addCriterion("create_by <=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLike(String value) {
            addCriterion("create_by like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotLike(String value) {
            addCriterion("create_by not like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByIn(List<String> values) {
            addCriterion("create_by in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotIn(List<String> values) {
            addCriterion("create_by not in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByBetween(String value1, String value2) {
            addCriterion("create_by between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotBetween(String value1, String value2) {
            addCriterion("create_by not between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNull() {
            addCriterion("update_by is null");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNotNull() {
            addCriterion("update_by is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateByEqualTo(String value) {
            addCriterion("update_by =", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotEqualTo(String value) {
            addCriterion("update_by <>", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThan(String value) {
            addCriterion("update_by >", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThanOrEqualTo(String value) {
            addCriterion("update_by >=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThan(String value) {
            addCriterion("update_by <", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThanOrEqualTo(String value) {
            addCriterion("update_by <=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLike(String value) {
            addCriterion("update_by like", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotLike(String value) {
            addCriterion("update_by not like", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByIn(List<String> values) {
            addCriterion("update_by in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotIn(List<String> values) {
            addCriterion("update_by not in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByBetween(String value1, String value2) {
            addCriterion("update_by between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotBetween(String value1, String value2) {
            addCriterion("update_by not between", value1, value2, "updateBy");
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

        public Criteria andOverdueIsNull() {
            addCriterion("overdue is null");
            return (Criteria) this;
        }

        public Criteria andOverdueIsNotNull() {
            addCriterion("overdue is not null");
            return (Criteria) this;
        }

        public Criteria andOverdueEqualTo(Long value) {
            addCriterion("overdue =", value, "overdue");
            return (Criteria) this;
        }

        public Criteria andOverdueNotEqualTo(Long value) {
            addCriterion("overdue <>", value, "overdue");
            return (Criteria) this;
        }

        public Criteria andOverdueGreaterThan(Long value) {
            addCriterion("overdue >", value, "overdue");
            return (Criteria) this;
        }

        public Criteria andOverdueGreaterThanOrEqualTo(Long value) {
            addCriterion("overdue >=", value, "overdue");
            return (Criteria) this;
        }

        public Criteria andOverdueLessThan(Long value) {
            addCriterion("overdue <", value, "overdue");
            return (Criteria) this;
        }

        public Criteria andOverdueLessThanOrEqualTo(Long value) {
            addCriterion("overdue <=", value, "overdue");
            return (Criteria) this;
        }

        public Criteria andOverdueIn(List<Long> values) {
            addCriterion("overdue in", values, "overdue");
            return (Criteria) this;
        }

        public Criteria andOverdueNotIn(List<Long> values) {
            addCriterion("overdue not in", values, "overdue");
            return (Criteria) this;
        }

        public Criteria andOverdueBetween(Long value1, Long value2) {
            addCriterion("overdue between", value1, value2, "overdue");
            return (Criteria) this;
        }

        public Criteria andOverdueNotBetween(Long value1, Long value2) {
            addCriterion("overdue not between", value1, value2, "overdue");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIsNull() {
            addCriterion("delete_flag is null");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIsNotNull() {
            addCriterion("delete_flag is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagEqualTo(Byte value) {
            addCriterion("delete_flag =", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotEqualTo(Byte value) {
            addCriterion("delete_flag <>", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagGreaterThan(Byte value) {
            addCriterion("delete_flag >", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagGreaterThanOrEqualTo(Byte value) {
            addCriterion("delete_flag >=", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagLessThan(Byte value) {
            addCriterion("delete_flag <", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagLessThanOrEqualTo(Byte value) {
            addCriterion("delete_flag <=", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIn(List<Byte> values) {
            addCriterion("delete_flag in", values, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotIn(List<Byte> values) {
            addCriterion("delete_flag not in", values, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagBetween(Byte value1, Byte value2) {
            addCriterion("delete_flag between", value1, value2, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotBetween(Byte value1, Byte value2) {
            addCriterion("delete_flag not between", value1, value2, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andEnterTimeIsNull() {
            addCriterion("enter_time is null");
            return (Criteria) this;
        }

        public Criteria andEnterTimeIsNotNull() {
            addCriterion("enter_time is not null");
            return (Criteria) this;
        }

        public Criteria andEnterTimeEqualTo(Date value) {
            addCriterion("enter_time =", value, "enterTime");
            return (Criteria) this;
        }

        public Criteria andEnterTimeNotEqualTo(Date value) {
            addCriterion("enter_time <>", value, "enterTime");
            return (Criteria) this;
        }

        public Criteria andEnterTimeGreaterThan(Date value) {
            addCriterion("enter_time >", value, "enterTime");
            return (Criteria) this;
        }

        public Criteria andEnterTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("enter_time >=", value, "enterTime");
            return (Criteria) this;
        }

        public Criteria andEnterTimeLessThan(Date value) {
            addCriterion("enter_time <", value, "enterTime");
            return (Criteria) this;
        }

        public Criteria andEnterTimeLessThanOrEqualTo(Date value) {
            addCriterion("enter_time <=", value, "enterTime");
            return (Criteria) this;
        }

        public Criteria andEnterTimeIn(List<Date> values) {
            addCriterion("enter_time in", values, "enterTime");
            return (Criteria) this;
        }

        public Criteria andEnterTimeNotIn(List<Date> values) {
            addCriterion("enter_time not in", values, "enterTime");
            return (Criteria) this;
        }

        public Criteria andEnterTimeBetween(Date value1, Date value2) {
            addCriterion("enter_time between", value1, value2, "enterTime");
            return (Criteria) this;
        }

        public Criteria andEnterTimeNotBetween(Date value1, Date value2) {
            addCriterion("enter_time not between", value1, value2, "enterTime");
            return (Criteria) this;
        }

        public Criteria andEnterNoIsNull() {
            addCriterion("enter_no is null");
            return (Criteria) this;
        }

        public Criteria andEnterNoIsNotNull() {
            addCriterion("enter_no is not null");
            return (Criteria) this;
        }

        public Criteria andEnterNoEqualTo(Long value) {
            addCriterion("enter_no =", value, "enterNo");
            return (Criteria) this;
        }

        public Criteria andEnterNoNotEqualTo(Long value) {
            addCriterion("enter_no <>", value, "enterNo");
            return (Criteria) this;
        }

        public Criteria andEnterNoGreaterThan(Long value) {
            addCriterion("enter_no >", value, "enterNo");
            return (Criteria) this;
        }

        public Criteria andEnterNoGreaterThanOrEqualTo(Long value) {
            addCriterion("enter_no >=", value, "enterNo");
            return (Criteria) this;
        }

        public Criteria andEnterNoLessThan(Long value) {
            addCriterion("enter_no <", value, "enterNo");
            return (Criteria) this;
        }

        public Criteria andEnterNoLessThanOrEqualTo(Long value) {
            addCriterion("enter_no <=", value, "enterNo");
            return (Criteria) this;
        }

        public Criteria andEnterNoIn(List<Long> values) {
            addCriterion("enter_no in", values, "enterNo");
            return (Criteria) this;
        }

        public Criteria andEnterNoNotIn(List<Long> values) {
            addCriterion("enter_no not in", values, "enterNo");
            return (Criteria) this;
        }

        public Criteria andEnterNoBetween(Long value1, Long value2) {
            addCriterion("enter_no between", value1, value2, "enterNo");
            return (Criteria) this;
        }

        public Criteria andEnterNoNotBetween(Long value1, Long value2) {
            addCriterion("enter_no not between", value1, value2, "enterNo");
            return (Criteria) this;
        }

        public Criteria andEnterManIsNull() {
            addCriterion("enter_man is null");
            return (Criteria) this;
        }

        public Criteria andEnterManIsNotNull() {
            addCriterion("enter_man is not null");
            return (Criteria) this;
        }

        public Criteria andEnterManEqualTo(String value) {
            addCriterion("enter_man =", value, "enterMan");
            return (Criteria) this;
        }

        public Criteria andEnterManNotEqualTo(String value) {
            addCriterion("enter_man <>", value, "enterMan");
            return (Criteria) this;
        }

        public Criteria andEnterManGreaterThan(String value) {
            addCriterion("enter_man >", value, "enterMan");
            return (Criteria) this;
        }

        public Criteria andEnterManGreaterThanOrEqualTo(String value) {
            addCriterion("enter_man >=", value, "enterMan");
            return (Criteria) this;
        }

        public Criteria andEnterManLessThan(String value) {
            addCriterion("enter_man <", value, "enterMan");
            return (Criteria) this;
        }

        public Criteria andEnterManLessThanOrEqualTo(String value) {
            addCriterion("enter_man <=", value, "enterMan");
            return (Criteria) this;
        }

        public Criteria andEnterManLike(String value) {
            addCriterion("enter_man like", value, "enterMan");
            return (Criteria) this;
        }

        public Criteria andEnterManNotLike(String value) {
            addCriterion("enter_man not like", value, "enterMan");
            return (Criteria) this;
        }

        public Criteria andEnterManIn(List<String> values) {
            addCriterion("enter_man in", values, "enterMan");
            return (Criteria) this;
        }

        public Criteria andEnterManNotIn(List<String> values) {
            addCriterion("enter_man not in", values, "enterMan");
            return (Criteria) this;
        }

        public Criteria andEnterManBetween(String value1, String value2) {
            addCriterion("enter_man between", value1, value2, "enterMan");
            return (Criteria) this;
        }

        public Criteria andEnterManNotBetween(String value1, String value2) {
            addCriterion("enter_man not between", value1, value2, "enterMan");
            return (Criteria) this;
        }

        public Criteria andOutTimeIsNull() {
            addCriterion("out_time is null");
            return (Criteria) this;
        }

        public Criteria andOutTimeIsNotNull() {
            addCriterion("out_time is not null");
            return (Criteria) this;
        }

        public Criteria andOutTimeEqualTo(Date value) {
            addCriterion("out_time =", value, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeNotEqualTo(Date value) {
            addCriterion("out_time <>", value, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeGreaterThan(Date value) {
            addCriterion("out_time >", value, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("out_time >=", value, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeLessThan(Date value) {
            addCriterion("out_time <", value, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeLessThanOrEqualTo(Date value) {
            addCriterion("out_time <=", value, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeIn(List<Date> values) {
            addCriterion("out_time in", values, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeNotIn(List<Date> values) {
            addCriterion("out_time not in", values, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeBetween(Date value1, Date value2) {
            addCriterion("out_time between", value1, value2, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeNotBetween(Date value1, Date value2) {
            addCriterion("out_time not between", value1, value2, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutNoIsNull() {
            addCriterion("out_no is null");
            return (Criteria) this;
        }

        public Criteria andOutNoIsNotNull() {
            addCriterion("out_no is not null");
            return (Criteria) this;
        }

        public Criteria andOutNoEqualTo(Long value) {
            addCriterion("out_no =", value, "outNo");
            return (Criteria) this;
        }

        public Criteria andOutNoNotEqualTo(Long value) {
            addCriterion("out_no <>", value, "outNo");
            return (Criteria) this;
        }

        public Criteria andOutNoGreaterThan(Long value) {
            addCriterion("out_no >", value, "outNo");
            return (Criteria) this;
        }

        public Criteria andOutNoGreaterThanOrEqualTo(Long value) {
            addCriterion("out_no >=", value, "outNo");
            return (Criteria) this;
        }

        public Criteria andOutNoLessThan(Long value) {
            addCriterion("out_no <", value, "outNo");
            return (Criteria) this;
        }

        public Criteria andOutNoLessThanOrEqualTo(Long value) {
            addCriterion("out_no <=", value, "outNo");
            return (Criteria) this;
        }

        public Criteria andOutNoIn(List<Long> values) {
            addCriterion("out_no in", values, "outNo");
            return (Criteria) this;
        }

        public Criteria andOutNoNotIn(List<Long> values) {
            addCriterion("out_no not in", values, "outNo");
            return (Criteria) this;
        }

        public Criteria andOutNoBetween(Long value1, Long value2) {
            addCriterion("out_no between", value1, value2, "outNo");
            return (Criteria) this;
        }

        public Criteria andOutNoNotBetween(Long value1, Long value2) {
            addCriterion("out_no not between", value1, value2, "outNo");
            return (Criteria) this;
        }

        public Criteria andOutManIsNull() {
            addCriterion("out_man is null");
            return (Criteria) this;
        }

        public Criteria andOutManIsNotNull() {
            addCriterion("out_man is not null");
            return (Criteria) this;
        }

        public Criteria andOutManEqualTo(String value) {
            addCriterion("out_man =", value, "outMan");
            return (Criteria) this;
        }

        public Criteria andOutManNotEqualTo(String value) {
            addCriterion("out_man <>", value, "outMan");
            return (Criteria) this;
        }

        public Criteria andOutManGreaterThan(String value) {
            addCriterion("out_man >", value, "outMan");
            return (Criteria) this;
        }

        public Criteria andOutManGreaterThanOrEqualTo(String value) {
            addCriterion("out_man >=", value, "outMan");
            return (Criteria) this;
        }

        public Criteria andOutManLessThan(String value) {
            addCriterion("out_man <", value, "outMan");
            return (Criteria) this;
        }

        public Criteria andOutManLessThanOrEqualTo(String value) {
            addCriterion("out_man <=", value, "outMan");
            return (Criteria) this;
        }

        public Criteria andOutManLike(String value) {
            addCriterion("out_man like", value, "outMan");
            return (Criteria) this;
        }

        public Criteria andOutManNotLike(String value) {
            addCriterion("out_man not like", value, "outMan");
            return (Criteria) this;
        }

        public Criteria andOutManIn(List<String> values) {
            addCriterion("out_man in", values, "outMan");
            return (Criteria) this;
        }

        public Criteria andOutManNotIn(List<String> values) {
            addCriterion("out_man not in", values, "outMan");
            return (Criteria) this;
        }

        public Criteria andOutManBetween(String value1, String value2) {
            addCriterion("out_man between", value1, value2, "outMan");
            return (Criteria) this;
        }

        public Criteria andOutManNotBetween(String value1, String value2) {
            addCriterion("out_man not between", value1, value2, "outMan");
            return (Criteria) this;
        }

        public Criteria andApplyManIsNull() {
            addCriterion("apply_man is null");
            return (Criteria) this;
        }

        public Criteria andApplyManIsNotNull() {
            addCriterion("apply_man is not null");
            return (Criteria) this;
        }

        public Criteria andApplyManEqualTo(String value) {
            addCriterion("apply_man =", value, "applyMan");
            return (Criteria) this;
        }

        public Criteria andApplyManNotEqualTo(String value) {
            addCriterion("apply_man <>", value, "applyMan");
            return (Criteria) this;
        }

        public Criteria andApplyManGreaterThan(String value) {
            addCriterion("apply_man >", value, "applyMan");
            return (Criteria) this;
        }

        public Criteria andApplyManGreaterThanOrEqualTo(String value) {
            addCriterion("apply_man >=", value, "applyMan");
            return (Criteria) this;
        }

        public Criteria andApplyManLessThan(String value) {
            addCriterion("apply_man <", value, "applyMan");
            return (Criteria) this;
        }

        public Criteria andApplyManLessThanOrEqualTo(String value) {
            addCriterion("apply_man <=", value, "applyMan");
            return (Criteria) this;
        }

        public Criteria andApplyManLike(String value) {
            addCriterion("apply_man like", value, "applyMan");
            return (Criteria) this;
        }

        public Criteria andApplyManNotLike(String value) {
            addCriterion("apply_man not like", value, "applyMan");
            return (Criteria) this;
        }

        public Criteria andApplyManIn(List<String> values) {
            addCriterion("apply_man in", values, "applyMan");
            return (Criteria) this;
        }

        public Criteria andApplyManNotIn(List<String> values) {
            addCriterion("apply_man not in", values, "applyMan");
            return (Criteria) this;
        }

        public Criteria andApplyManBetween(String value1, String value2) {
            addCriterion("apply_man between", value1, value2, "applyMan");
            return (Criteria) this;
        }

        public Criteria andApplyManNotBetween(String value1, String value2) {
            addCriterion("apply_man not between", value1, value2, "applyMan");
            return (Criteria) this;
        }

        public Criteria andOpenPeriodIsNull() {
            addCriterion("open_period is null");
            return (Criteria) this;
        }

        public Criteria andOpenPeriodIsNotNull() {
            addCriterion("open_period is not null");
            return (Criteria) this;
        }

        public Criteria andOpenPeriodEqualTo(String value) {
            addCriterion("open_period =", value, "openPeriod");
            return (Criteria) this;
        }

        public Criteria andOpenPeriodNotEqualTo(String value) {
            addCriterion("open_period <>", value, "openPeriod");
            return (Criteria) this;
        }

        public Criteria andOpenPeriodGreaterThan(String value) {
            addCriterion("open_period >", value, "openPeriod");
            return (Criteria) this;
        }

        public Criteria andOpenPeriodGreaterThanOrEqualTo(String value) {
            addCriterion("open_period >=", value, "openPeriod");
            return (Criteria) this;
        }

        public Criteria andOpenPeriodLessThan(String value) {
            addCriterion("open_period <", value, "openPeriod");
            return (Criteria) this;
        }

        public Criteria andOpenPeriodLessThanOrEqualTo(String value) {
            addCriterion("open_period <=", value, "openPeriod");
            return (Criteria) this;
        }

        public Criteria andOpenPeriodLike(String value) {
            addCriterion("open_period like", value, "openPeriod");
            return (Criteria) this;
        }

        public Criteria andOpenPeriodNotLike(String value) {
            addCriterion("open_period not like", value, "openPeriod");
            return (Criteria) this;
        }

        public Criteria andOpenPeriodIn(List<String> values) {
            addCriterion("open_period in", values, "openPeriod");
            return (Criteria) this;
        }

        public Criteria andOpenPeriodNotIn(List<String> values) {
            addCriterion("open_period not in", values, "openPeriod");
            return (Criteria) this;
        }

        public Criteria andOpenPeriodBetween(String value1, String value2) {
            addCriterion("open_period between", value1, value2, "openPeriod");
            return (Criteria) this;
        }

        public Criteria andOpenPeriodNotBetween(String value1, String value2) {
            addCriterion("open_period not between", value1, value2, "openPeriod");
            return (Criteria) this;
        }

        public Criteria andReagentPriceIsNull() {
            addCriterion("reagent_price is null");
            return (Criteria) this;
        }

        public Criteria andReagentPriceIsNotNull() {
            addCriterion("reagent_price is not null");
            return (Criteria) this;
        }

        public Criteria andReagentPriceEqualTo(BigDecimal value) {
            addCriterion("reagent_price =", value, "reagentPrice");
            return (Criteria) this;
        }

        public Criteria andReagentPriceNotEqualTo(BigDecimal value) {
            addCriterion("reagent_price <>", value, "reagentPrice");
            return (Criteria) this;
        }

        public Criteria andReagentPriceGreaterThan(BigDecimal value) {
            addCriterion("reagent_price >", value, "reagentPrice");
            return (Criteria) this;
        }

        public Criteria andReagentPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("reagent_price >=", value, "reagentPrice");
            return (Criteria) this;
        }

        public Criteria andReagentPriceLessThan(BigDecimal value) {
            addCriterion("reagent_price <", value, "reagentPrice");
            return (Criteria) this;
        }

        public Criteria andReagentPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("reagent_price <=", value, "reagentPrice");
            return (Criteria) this;
        }

        public Criteria andReagentPriceIn(List<BigDecimal> values) {
            addCriterion("reagent_price in", values, "reagentPrice");
            return (Criteria) this;
        }

        public Criteria andReagentPriceNotIn(List<BigDecimal> values) {
            addCriterion("reagent_price not in", values, "reagentPrice");
            return (Criteria) this;
        }

        public Criteria andReagentPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("reagent_price between", value1, value2, "reagentPrice");
            return (Criteria) this;
        }

        public Criteria andReagentPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("reagent_price not between", value1, value2, "reagentPrice");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeIsNull() {
            addCriterion("delete_time is null");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeIsNotNull() {
            addCriterion("delete_time is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeEqualTo(Date value) {
            addCriterion("delete_time =", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeNotEqualTo(Date value) {
            addCriterion("delete_time <>", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeGreaterThan(Date value) {
            addCriterion("delete_time >", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("delete_time >=", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeLessThan(Date value) {
            addCriterion("delete_time <", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeLessThanOrEqualTo(Date value) {
            addCriterion("delete_time <=", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeIn(List<Date> values) {
            addCriterion("delete_time in", values, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeNotIn(List<Date> values) {
            addCriterion("delete_time not in", values, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeBetween(Date value1, Date value2) {
            addCriterion("delete_time between", value1, value2, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeNotBetween(Date value1, Date value2) {
            addCriterion("delete_time not between", value1, value2, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteByIsNull() {
            addCriterion("delete_by is null");
            return (Criteria) this;
        }

        public Criteria andDeleteByIsNotNull() {
            addCriterion("delete_by is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteByEqualTo(String value) {
            addCriterion("delete_by =", value, "deleteBy");
            return (Criteria) this;
        }

        public Criteria andDeleteByNotEqualTo(String value) {
            addCriterion("delete_by <>", value, "deleteBy");
            return (Criteria) this;
        }

        public Criteria andDeleteByGreaterThan(String value) {
            addCriterion("delete_by >", value, "deleteBy");
            return (Criteria) this;
        }

        public Criteria andDeleteByGreaterThanOrEqualTo(String value) {
            addCriterion("delete_by >=", value, "deleteBy");
            return (Criteria) this;
        }

        public Criteria andDeleteByLessThan(String value) {
            addCriterion("delete_by <", value, "deleteBy");
            return (Criteria) this;
        }

        public Criteria andDeleteByLessThanOrEqualTo(String value) {
            addCriterion("delete_by <=", value, "deleteBy");
            return (Criteria) this;
        }

        public Criteria andDeleteByLike(String value) {
            addCriterion("delete_by like", value, "deleteBy");
            return (Criteria) this;
        }

        public Criteria andDeleteByNotLike(String value) {
            addCriterion("delete_by not like", value, "deleteBy");
            return (Criteria) this;
        }

        public Criteria andDeleteByIn(List<String> values) {
            addCriterion("delete_by in", values, "deleteBy");
            return (Criteria) this;
        }

        public Criteria andDeleteByNotIn(List<String> values) {
            addCriterion("delete_by not in", values, "deleteBy");
            return (Criteria) this;
        }

        public Criteria andDeleteByBetween(String value1, String value2) {
            addCriterion("delete_by between", value1, value2, "deleteBy");
            return (Criteria) this;
        }

        public Criteria andDeleteByNotBetween(String value1, String value2) {
            addCriterion("delete_by not between", value1, value2, "deleteBy");
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