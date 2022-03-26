package jp.co.nss.hrm.backend.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReagentCollectDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReagentCollectDetailExample() {
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

        public Criteria andCollectNoIsNull() {
            addCriterion("collect_no is null");
            return (Criteria) this;
        }

        public Criteria andCollectNoIsNotNull() {
            addCriterion("collect_no is not null");
            return (Criteria) this;
        }

        public Criteria andCollectNoEqualTo(String value) {
            addCriterion("collect_no =", value, "collectNo");
            return (Criteria) this;
        }

        public Criteria andCollectNoNotEqualTo(String value) {
            addCriterion("collect_no <>", value, "collectNo");
            return (Criteria) this;
        }

        public Criteria andCollectNoGreaterThan(String value) {
            addCriterion("collect_no >", value, "collectNo");
            return (Criteria) this;
        }

        public Criteria andCollectNoGreaterThanOrEqualTo(String value) {
            addCriterion("collect_no >=", value, "collectNo");
            return (Criteria) this;
        }

        public Criteria andCollectNoLessThan(String value) {
            addCriterion("collect_no <", value, "collectNo");
            return (Criteria) this;
        }

        public Criteria andCollectNoLessThanOrEqualTo(String value) {
            addCriterion("collect_no <=", value, "collectNo");
            return (Criteria) this;
        }

        public Criteria andCollectNoLike(String value) {
            addCriterion("collect_no like", value, "collectNo");
            return (Criteria) this;
        }

        public Criteria andCollectNoNotLike(String value) {
            addCriterion("collect_no not like", value, "collectNo");
            return (Criteria) this;
        }

        public Criteria andCollectNoIn(List<String> values) {
            addCriterion("collect_no in", values, "collectNo");
            return (Criteria) this;
        }

        public Criteria andCollectNoNotIn(List<String> values) {
            addCriterion("collect_no not in", values, "collectNo");
            return (Criteria) this;
        }

        public Criteria andCollectNoBetween(String value1, String value2) {
            addCriterion("collect_no between", value1, value2, "collectNo");
            return (Criteria) this;
        }

        public Criteria andCollectNoNotBetween(String value1, String value2) {
            addCriterion("collect_no not between", value1, value2, "collectNo");
            return (Criteria) this;
        }

        public Criteria andReagentCodeIsNull() {
            addCriterion("reagent_code is null");
            return (Criteria) this;
        }

        public Criteria andReagentCodeIsNotNull() {
            addCriterion("reagent_code is not null");
            return (Criteria) this;
        }

        public Criteria andReagentCodeEqualTo(String value) {
            addCriterion("reagent_code =", value, "reagentCode");
            return (Criteria) this;
        }

        public Criteria andReagentCodeNotEqualTo(String value) {
            addCriterion("reagent_code <>", value, "reagentCode");
            return (Criteria) this;
        }

        public Criteria andReagentCodeGreaterThan(String value) {
            addCriterion("reagent_code >", value, "reagentCode");
            return (Criteria) this;
        }

        public Criteria andReagentCodeGreaterThanOrEqualTo(String value) {
            addCriterion("reagent_code >=", value, "reagentCode");
            return (Criteria) this;
        }

        public Criteria andReagentCodeLessThan(String value) {
            addCriterion("reagent_code <", value, "reagentCode");
            return (Criteria) this;
        }

        public Criteria andReagentCodeLessThanOrEqualTo(String value) {
            addCriterion("reagent_code <=", value, "reagentCode");
            return (Criteria) this;
        }

        public Criteria andReagentCodeLike(String value) {
            addCriterion("reagent_code like", value, "reagentCode");
            return (Criteria) this;
        }

        public Criteria andReagentCodeNotLike(String value) {
            addCriterion("reagent_code not like", value, "reagentCode");
            return (Criteria) this;
        }

        public Criteria andReagentCodeIn(List<String> values) {
            addCriterion("reagent_code in", values, "reagentCode");
            return (Criteria) this;
        }

        public Criteria andReagentCodeNotIn(List<String> values) {
            addCriterion("reagent_code not in", values, "reagentCode");
            return (Criteria) this;
        }

        public Criteria andReagentCodeBetween(String value1, String value2) {
            addCriterion("reagent_code between", value1, value2, "reagentCode");
            return (Criteria) this;
        }

        public Criteria andReagentCodeNotBetween(String value1, String value2) {
            addCriterion("reagent_code not between", value1, value2, "reagentCode");
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

        public Criteria andSupplierShortNameIsNull() {
            addCriterion("supplier_short_name is null");
            return (Criteria) this;
        }

        public Criteria andSupplierShortNameIsNotNull() {
            addCriterion("supplier_short_name is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierShortNameEqualTo(String value) {
            addCriterion("supplier_short_name =", value, "supplierShortName");
            return (Criteria) this;
        }

        public Criteria andSupplierShortNameNotEqualTo(String value) {
            addCriterion("supplier_short_name <>", value, "supplierShortName");
            return (Criteria) this;
        }

        public Criteria andSupplierShortNameGreaterThan(String value) {
            addCriterion("supplier_short_name >", value, "supplierShortName");
            return (Criteria) this;
        }

        public Criteria andSupplierShortNameGreaterThanOrEqualTo(String value) {
            addCriterion("supplier_short_name >=", value, "supplierShortName");
            return (Criteria) this;
        }

        public Criteria andSupplierShortNameLessThan(String value) {
            addCriterion("supplier_short_name <", value, "supplierShortName");
            return (Criteria) this;
        }

        public Criteria andSupplierShortNameLessThanOrEqualTo(String value) {
            addCriterion("supplier_short_name <=", value, "supplierShortName");
            return (Criteria) this;
        }

        public Criteria andSupplierShortNameLike(String value) {
            addCriterion("supplier_short_name like", value, "supplierShortName");
            return (Criteria) this;
        }

        public Criteria andSupplierShortNameNotLike(String value) {
            addCriterion("supplier_short_name not like", value, "supplierShortName");
            return (Criteria) this;
        }

        public Criteria andSupplierShortNameIn(List<String> values) {
            addCriterion("supplier_short_name in", values, "supplierShortName");
            return (Criteria) this;
        }

        public Criteria andSupplierShortNameNotIn(List<String> values) {
            addCriterion("supplier_short_name not in", values, "supplierShortName");
            return (Criteria) this;
        }

        public Criteria andSupplierShortNameBetween(String value1, String value2) {
            addCriterion("supplier_short_name between", value1, value2, "supplierShortName");
            return (Criteria) this;
        }

        public Criteria andSupplierShortNameNotBetween(String value1, String value2) {
            addCriterion("supplier_short_name not between", value1, value2, "supplierShortName");
            return (Criteria) this;
        }

        public Criteria andFactoryIsNull() {
            addCriterion("factory is null");
            return (Criteria) this;
        }

        public Criteria andFactoryIsNotNull() {
            addCriterion("factory is not null");
            return (Criteria) this;
        }

        public Criteria andFactoryEqualTo(String value) {
            addCriterion("factory =", value, "factory");
            return (Criteria) this;
        }

        public Criteria andFactoryNotEqualTo(String value) {
            addCriterion("factory <>", value, "factory");
            return (Criteria) this;
        }

        public Criteria andFactoryGreaterThan(String value) {
            addCriterion("factory >", value, "factory");
            return (Criteria) this;
        }

        public Criteria andFactoryGreaterThanOrEqualTo(String value) {
            addCriterion("factory >=", value, "factory");
            return (Criteria) this;
        }

        public Criteria andFactoryLessThan(String value) {
            addCriterion("factory <", value, "factory");
            return (Criteria) this;
        }

        public Criteria andFactoryLessThanOrEqualTo(String value) {
            addCriterion("factory <=", value, "factory");
            return (Criteria) this;
        }

        public Criteria andFactoryLike(String value) {
            addCriterion("factory like", value, "factory");
            return (Criteria) this;
        }

        public Criteria andFactoryNotLike(String value) {
            addCriterion("factory not like", value, "factory");
            return (Criteria) this;
        }

        public Criteria andFactoryIn(List<String> values) {
            addCriterion("factory in", values, "factory");
            return (Criteria) this;
        }

        public Criteria andFactoryNotIn(List<String> values) {
            addCriterion("factory not in", values, "factory");
            return (Criteria) this;
        }

        public Criteria andFactoryBetween(String value1, String value2) {
            addCriterion("factory between", value1, value2, "factory");
            return (Criteria) this;
        }

        public Criteria andFactoryNotBetween(String value1, String value2) {
            addCriterion("factory not between", value1, value2, "factory");
            return (Criteria) this;
        }

        public Criteria andUnitIsNull() {
            addCriterion("unit is null");
            return (Criteria) this;
        }

        public Criteria andUnitIsNotNull() {
            addCriterion("unit is not null");
            return (Criteria) this;
        }

        public Criteria andUnitEqualTo(String value) {
            addCriterion("unit =", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotEqualTo(String value) {
            addCriterion("unit <>", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThan(String value) {
            addCriterion("unit >", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThanOrEqualTo(String value) {
            addCriterion("unit >=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThan(String value) {
            addCriterion("unit <", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThanOrEqualTo(String value) {
            addCriterion("unit <=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLike(String value) {
            addCriterion("unit like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotLike(String value) {
            addCriterion("unit not like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitIn(List<String> values) {
            addCriterion("unit in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotIn(List<String> values) {
            addCriterion("unit not in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitBetween(String value1, String value2) {
            addCriterion("unit between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotBetween(String value1, String value2) {
            addCriterion("unit not between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andReagentTypeIsNull() {
            addCriterion("reagent_type is null");
            return (Criteria) this;
        }

        public Criteria andReagentTypeIsNotNull() {
            addCriterion("reagent_type is not null");
            return (Criteria) this;
        }

        public Criteria andReagentTypeEqualTo(String value) {
            addCriterion("reagent_type =", value, "reagentType");
            return (Criteria) this;
        }

        public Criteria andReagentTypeNotEqualTo(String value) {
            addCriterion("reagent_type <>", value, "reagentType");
            return (Criteria) this;
        }

        public Criteria andReagentTypeGreaterThan(String value) {
            addCriterion("reagent_type >", value, "reagentType");
            return (Criteria) this;
        }

        public Criteria andReagentTypeGreaterThanOrEqualTo(String value) {
            addCriterion("reagent_type >=", value, "reagentType");
            return (Criteria) this;
        }

        public Criteria andReagentTypeLessThan(String value) {
            addCriterion("reagent_type <", value, "reagentType");
            return (Criteria) this;
        }

        public Criteria andReagentTypeLessThanOrEqualTo(String value) {
            addCriterion("reagent_type <=", value, "reagentType");
            return (Criteria) this;
        }

        public Criteria andReagentTypeLike(String value) {
            addCriterion("reagent_type like", value, "reagentType");
            return (Criteria) this;
        }

        public Criteria andReagentTypeNotLike(String value) {
            addCriterion("reagent_type not like", value, "reagentType");
            return (Criteria) this;
        }

        public Criteria andReagentTypeIn(List<String> values) {
            addCriterion("reagent_type in", values, "reagentType");
            return (Criteria) this;
        }

        public Criteria andReagentTypeNotIn(List<String> values) {
            addCriterion("reagent_type not in", values, "reagentType");
            return (Criteria) this;
        }

        public Criteria andReagentTypeBetween(String value1, String value2) {
            addCriterion("reagent_type between", value1, value2, "reagentType");
            return (Criteria) this;
        }

        public Criteria andReagentTypeNotBetween(String value1, String value2) {
            addCriterion("reagent_type not between", value1, value2, "reagentType");
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

        public Criteria andReagentNumberIsNull() {
            addCriterion("reagent_number is null");
            return (Criteria) this;
        }

        public Criteria andReagentNumberIsNotNull() {
            addCriterion("reagent_number is not null");
            return (Criteria) this;
        }

        public Criteria andReagentNumberEqualTo(Long value) {
            addCriterion("reagent_number =", value, "reagentNumber");
            return (Criteria) this;
        }

        public Criteria andReagentNumberNotEqualTo(Long value) {
            addCriterion("reagent_number <>", value, "reagentNumber");
            return (Criteria) this;
        }

        public Criteria andReagentNumberGreaterThan(Long value) {
            addCriterion("reagent_number >", value, "reagentNumber");
            return (Criteria) this;
        }

        public Criteria andReagentNumberGreaterThanOrEqualTo(Long value) {
            addCriterion("reagent_number >=", value, "reagentNumber");
            return (Criteria) this;
        }

        public Criteria andReagentNumberLessThan(Long value) {
            addCriterion("reagent_number <", value, "reagentNumber");
            return (Criteria) this;
        }

        public Criteria andReagentNumberLessThanOrEqualTo(Long value) {
            addCriterion("reagent_number <=", value, "reagentNumber");
            return (Criteria) this;
        }

        public Criteria andReagentNumberIn(List<Long> values) {
            addCriterion("reagent_number in", values, "reagentNumber");
            return (Criteria) this;
        }

        public Criteria andReagentNumberNotIn(List<Long> values) {
            addCriterion("reagent_number not in", values, "reagentNumber");
            return (Criteria) this;
        }

        public Criteria andReagentNumberBetween(Long value1, Long value2) {
            addCriterion("reagent_number between", value1, value2, "reagentNumber");
            return (Criteria) this;
        }

        public Criteria andReagentNumberNotBetween(Long value1, Long value2) {
            addCriterion("reagent_number not between", value1, value2, "reagentNumber");
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