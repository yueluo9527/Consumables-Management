package jp.co.nss.hrm.backend.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ReagentStockDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReagentStockDetailExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andStockTypeIsNull() {
            addCriterion("stock_type is null");
            return (Criteria) this;
        }

        public Criteria andStockTypeIsNotNull() {
            addCriterion("stock_type is not null");
            return (Criteria) this;
        }

        public Criteria andStockTypeEqualTo(String value) {
            addCriterion("stock_type =", value, "stockType");
            return (Criteria) this;
        }

        public Criteria andStockTypeNotEqualTo(String value) {
            addCriterion("stock_type <>", value, "stockType");
            return (Criteria) this;
        }

        public Criteria andStockTypeGreaterThan(String value) {
            addCriterion("stock_type >", value, "stockType");
            return (Criteria) this;
        }

        public Criteria andStockTypeGreaterThanOrEqualTo(String value) {
            addCriterion("stock_type >=", value, "stockType");
            return (Criteria) this;
        }

        public Criteria andStockTypeLessThan(String value) {
            addCriterion("stock_type <", value, "stockType");
            return (Criteria) this;
        }

        public Criteria andStockTypeLessThanOrEqualTo(String value) {
            addCriterion("stock_type <=", value, "stockType");
            return (Criteria) this;
        }

        public Criteria andStockTypeLike(String value) {
            addCriterion("stock_type like", value, "stockType");
            return (Criteria) this;
        }

        public Criteria andStockTypeNotLike(String value) {
            addCriterion("stock_type not like", value, "stockType");
            return (Criteria) this;
        }

        public Criteria andStockTypeIn(List<String> values) {
            addCriterion("stock_type in", values, "stockType");
            return (Criteria) this;
        }

        public Criteria andStockTypeNotIn(List<String> values) {
            addCriterion("stock_type not in", values, "stockType");
            return (Criteria) this;
        }

        public Criteria andStockTypeBetween(String value1, String value2) {
            addCriterion("stock_type between", value1, value2, "stockType");
            return (Criteria) this;
        }

        public Criteria andStockTypeNotBetween(String value1, String value2) {
            addCriterion("stock_type not between", value1, value2, "stockType");
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

        public Criteria andReagentIdEqualTo(String value) {
            addCriterion("reagent_id =", value, "reagentId");
            return (Criteria) this;
        }

        public Criteria andReagentIdNotEqualTo(String value) {
            addCriterion("reagent_id <>", value, "reagentId");
            return (Criteria) this;
        }

        public Criteria andReagentIdGreaterThan(String value) {
            addCriterion("reagent_id >", value, "reagentId");
            return (Criteria) this;
        }

        public Criteria andReagentIdGreaterThanOrEqualTo(String value) {
            addCriterion("reagent_id >=", value, "reagentId");
            return (Criteria) this;
        }

        public Criteria andReagentIdLessThan(String value) {
            addCriterion("reagent_id <", value, "reagentId");
            return (Criteria) this;
        }

        public Criteria andReagentIdLessThanOrEqualTo(String value) {
            addCriterion("reagent_id <=", value, "reagentId");
            return (Criteria) this;
        }

        public Criteria andReagentIdLike(String value) {
            addCriterion("reagent_id like", value, "reagentId");
            return (Criteria) this;
        }

        public Criteria andReagentIdNotLike(String value) {
            addCriterion("reagent_id not like", value, "reagentId");
            return (Criteria) this;
        }

        public Criteria andReagentIdIn(List<String> values) {
            addCriterion("reagent_id in", values, "reagentId");
            return (Criteria) this;
        }

        public Criteria andReagentIdNotIn(List<String> values) {
            addCriterion("reagent_id not in", values, "reagentId");
            return (Criteria) this;
        }

        public Criteria andReagentIdBetween(String value1, String value2) {
            addCriterion("reagent_id between", value1, value2, "reagentId");
            return (Criteria) this;
        }

        public Criteria andReagentIdNotBetween(String value1, String value2) {
            addCriterion("reagent_id not between", value1, value2, "reagentId");
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

        public Criteria andSpecificationIsNull() {
            addCriterion("specification is null");
            return (Criteria) this;
        }

        public Criteria andSpecificationIsNotNull() {
            addCriterion("specification is not null");
            return (Criteria) this;
        }

        public Criteria andSpecificationEqualTo(String value) {
            addCriterion("specification =", value, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationNotEqualTo(String value) {
            addCriterion("specification <>", value, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationGreaterThan(String value) {
            addCriterion("specification >", value, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationGreaterThanOrEqualTo(String value) {
            addCriterion("specification >=", value, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationLessThan(String value) {
            addCriterion("specification <", value, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationLessThanOrEqualTo(String value) {
            addCriterion("specification <=", value, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationLike(String value) {
            addCriterion("specification like", value, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationNotLike(String value) {
            addCriterion("specification not like", value, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationIn(List<String> values) {
            addCriterion("specification in", values, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationNotIn(List<String> values) {
            addCriterion("specification not in", values, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationBetween(String value1, String value2) {
            addCriterion("specification between", value1, value2, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationNotBetween(String value1, String value2) {
            addCriterion("specification not between", value1, value2, "specification");
            return (Criteria) this;
        }

        public Criteria andManufacturerNameIsNull() {
            addCriterion("manufacturer_name is null");
            return (Criteria) this;
        }

        public Criteria andManufacturerNameIsNotNull() {
            addCriterion("manufacturer_name is not null");
            return (Criteria) this;
        }

        public Criteria andManufacturerNameEqualTo(String value) {
            addCriterion("manufacturer_name =", value, "manufacturerName");
            return (Criteria) this;
        }

        public Criteria andManufacturerNameNotEqualTo(String value) {
            addCriterion("manufacturer_name <>", value, "manufacturerName");
            return (Criteria) this;
        }

        public Criteria andManufacturerNameGreaterThan(String value) {
            addCriterion("manufacturer_name >", value, "manufacturerName");
            return (Criteria) this;
        }

        public Criteria andManufacturerNameGreaterThanOrEqualTo(String value) {
            addCriterion("manufacturer_name >=", value, "manufacturerName");
            return (Criteria) this;
        }

        public Criteria andManufacturerNameLessThan(String value) {
            addCriterion("manufacturer_name <", value, "manufacturerName");
            return (Criteria) this;
        }

        public Criteria andManufacturerNameLessThanOrEqualTo(String value) {
            addCriterion("manufacturer_name <=", value, "manufacturerName");
            return (Criteria) this;
        }

        public Criteria andManufacturerNameLike(String value) {
            addCriterion("manufacturer_name like", value, "manufacturerName");
            return (Criteria) this;
        }

        public Criteria andManufacturerNameNotLike(String value) {
            addCriterion("manufacturer_name not like", value, "manufacturerName");
            return (Criteria) this;
        }

        public Criteria andManufacturerNameIn(List<String> values) {
            addCriterion("manufacturer_name in", values, "manufacturerName");
            return (Criteria) this;
        }

        public Criteria andManufacturerNameNotIn(List<String> values) {
            addCriterion("manufacturer_name not in", values, "manufacturerName");
            return (Criteria) this;
        }

        public Criteria andManufacturerNameBetween(String value1, String value2) {
            addCriterion("manufacturer_name between", value1, value2, "manufacturerName");
            return (Criteria) this;
        }

        public Criteria andManufacturerNameNotBetween(String value1, String value2) {
            addCriterion("manufacturer_name not between", value1, value2, "manufacturerName");
            return (Criteria) this;
        }

        public Criteria andRegistrationNoIsNull() {
            addCriterion("registration_no is null");
            return (Criteria) this;
        }

        public Criteria andRegistrationNoIsNotNull() {
            addCriterion("registration_no is not null");
            return (Criteria) this;
        }

        public Criteria andRegistrationNoEqualTo(String value) {
            addCriterion("registration_no =", value, "registrationNo");
            return (Criteria) this;
        }

        public Criteria andRegistrationNoNotEqualTo(String value) {
            addCriterion("registration_no <>", value, "registrationNo");
            return (Criteria) this;
        }

        public Criteria andRegistrationNoGreaterThan(String value) {
            addCriterion("registration_no >", value, "registrationNo");
            return (Criteria) this;
        }

        public Criteria andRegistrationNoGreaterThanOrEqualTo(String value) {
            addCriterion("registration_no >=", value, "registrationNo");
            return (Criteria) this;
        }

        public Criteria andRegistrationNoLessThan(String value) {
            addCriterion("registration_no <", value, "registrationNo");
            return (Criteria) this;
        }

        public Criteria andRegistrationNoLessThanOrEqualTo(String value) {
            addCriterion("registration_no <=", value, "registrationNo");
            return (Criteria) this;
        }

        public Criteria andRegistrationNoLike(String value) {
            addCriterion("registration_no like", value, "registrationNo");
            return (Criteria) this;
        }

        public Criteria andRegistrationNoNotLike(String value) {
            addCriterion("registration_no not like", value, "registrationNo");
            return (Criteria) this;
        }

        public Criteria andRegistrationNoIn(List<String> values) {
            addCriterion("registration_no in", values, "registrationNo");
            return (Criteria) this;
        }

        public Criteria andRegistrationNoNotIn(List<String> values) {
            addCriterion("registration_no not in", values, "registrationNo");
            return (Criteria) this;
        }

        public Criteria andRegistrationNoBetween(String value1, String value2) {
            addCriterion("registration_no between", value1, value2, "registrationNo");
            return (Criteria) this;
        }

        public Criteria andRegistrationNoNotBetween(String value1, String value2) {
            addCriterion("registration_no not between", value1, value2, "registrationNo");
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

        public Criteria andBranchIsNull() {
            addCriterion("branch is null");
            return (Criteria) this;
        }

        public Criteria andBranchIsNotNull() {
            addCriterion("branch is not null");
            return (Criteria) this;
        }

        public Criteria andBranchEqualTo(String value) {
            addCriterion("branch =", value, "branch");
            return (Criteria) this;
        }

        public Criteria andBranchNotEqualTo(String value) {
            addCriterion("branch <>", value, "branch");
            return (Criteria) this;
        }

        public Criteria andBranchGreaterThan(String value) {
            addCriterion("branch >", value, "branch");
            return (Criteria) this;
        }

        public Criteria andBranchGreaterThanOrEqualTo(String value) {
            addCriterion("branch >=", value, "branch");
            return (Criteria) this;
        }

        public Criteria andBranchLessThan(String value) {
            addCriterion("branch <", value, "branch");
            return (Criteria) this;
        }

        public Criteria andBranchLessThanOrEqualTo(String value) {
            addCriterion("branch <=", value, "branch");
            return (Criteria) this;
        }

        public Criteria andBranchLike(String value) {
            addCriterion("branch like", value, "branch");
            return (Criteria) this;
        }

        public Criteria andBranchNotLike(String value) {
            addCriterion("branch not like", value, "branch");
            return (Criteria) this;
        }

        public Criteria andBranchIn(List<String> values) {
            addCriterion("branch in", values, "branch");
            return (Criteria) this;
        }

        public Criteria andBranchNotIn(List<String> values) {
            addCriterion("branch not in", values, "branch");
            return (Criteria) this;
        }

        public Criteria andBranchBetween(String value1, String value2) {
            addCriterion("branch between", value1, value2, "branch");
            return (Criteria) this;
        }

        public Criteria andBranchNotBetween(String value1, String value2) {
            addCriterion("branch not between", value1, value2, "branch");
            return (Criteria) this;
        }

        public Criteria andReagentUnitIsNull() {
            addCriterion("reagent_unit is null");
            return (Criteria) this;
        }

        public Criteria andReagentUnitIsNotNull() {
            addCriterion("reagent_unit is not null");
            return (Criteria) this;
        }

        public Criteria andReagentUnitEqualTo(String value) {
            addCriterion("reagent_unit =", value, "reagentUnit");
            return (Criteria) this;
        }

        public Criteria andReagentUnitNotEqualTo(String value) {
            addCriterion("reagent_unit <>", value, "reagentUnit");
            return (Criteria) this;
        }

        public Criteria andReagentUnitGreaterThan(String value) {
            addCriterion("reagent_unit >", value, "reagentUnit");
            return (Criteria) this;
        }

        public Criteria andReagentUnitGreaterThanOrEqualTo(String value) {
            addCriterion("reagent_unit >=", value, "reagentUnit");
            return (Criteria) this;
        }

        public Criteria andReagentUnitLessThan(String value) {
            addCriterion("reagent_unit <", value, "reagentUnit");
            return (Criteria) this;
        }

        public Criteria andReagentUnitLessThanOrEqualTo(String value) {
            addCriterion("reagent_unit <=", value, "reagentUnit");
            return (Criteria) this;
        }

        public Criteria andReagentUnitLike(String value) {
            addCriterion("reagent_unit like", value, "reagentUnit");
            return (Criteria) this;
        }

        public Criteria andReagentUnitNotLike(String value) {
            addCriterion("reagent_unit not like", value, "reagentUnit");
            return (Criteria) this;
        }

        public Criteria andReagentUnitIn(List<String> values) {
            addCriterion("reagent_unit in", values, "reagentUnit");
            return (Criteria) this;
        }

        public Criteria andReagentUnitNotIn(List<String> values) {
            addCriterion("reagent_unit not in", values, "reagentUnit");
            return (Criteria) this;
        }

        public Criteria andReagentUnitBetween(String value1, String value2) {
            addCriterion("reagent_unit between", value1, value2, "reagentUnit");
            return (Criteria) this;
        }

        public Criteria andReagentUnitNotBetween(String value1, String value2) {
            addCriterion("reagent_unit not between", value1, value2, "reagentUnit");
            return (Criteria) this;
        }

        public Criteria andReagentStatusIsNull() {
            addCriterion("reagent_status is null");
            return (Criteria) this;
        }

        public Criteria andReagentStatusIsNotNull() {
            addCriterion("reagent_status is not null");
            return (Criteria) this;
        }

        public Criteria andReagentStatusEqualTo(String value) {
            addCriterion("reagent_status =", value, "reagentStatus");
            return (Criteria) this;
        }

        public Criteria andReagentStatusNotEqualTo(String value) {
            addCriterion("reagent_status <>", value, "reagentStatus");
            return (Criteria) this;
        }

        public Criteria andReagentStatusGreaterThan(String value) {
            addCriterion("reagent_status >", value, "reagentStatus");
            return (Criteria) this;
        }

        public Criteria andReagentStatusGreaterThanOrEqualTo(String value) {
            addCriterion("reagent_status >=", value, "reagentStatus");
            return (Criteria) this;
        }

        public Criteria andReagentStatusLessThan(String value) {
            addCriterion("reagent_status <", value, "reagentStatus");
            return (Criteria) this;
        }

        public Criteria andReagentStatusLessThanOrEqualTo(String value) {
            addCriterion("reagent_status <=", value, "reagentStatus");
            return (Criteria) this;
        }

        public Criteria andReagentStatusLike(String value) {
            addCriterion("reagent_status like", value, "reagentStatus");
            return (Criteria) this;
        }

        public Criteria andReagentStatusNotLike(String value) {
            addCriterion("reagent_status not like", value, "reagentStatus");
            return (Criteria) this;
        }

        public Criteria andReagentStatusIn(List<String> values) {
            addCriterion("reagent_status in", values, "reagentStatus");
            return (Criteria) this;
        }

        public Criteria andReagentStatusNotIn(List<String> values) {
            addCriterion("reagent_status not in", values, "reagentStatus");
            return (Criteria) this;
        }

        public Criteria andReagentStatusBetween(String value1, String value2) {
            addCriterion("reagent_status between", value1, value2, "reagentStatus");
            return (Criteria) this;
        }

        public Criteria andReagentStatusNotBetween(String value1, String value2) {
            addCriterion("reagent_status not between", value1, value2, "reagentStatus");
            return (Criteria) this;
        }

        public Criteria andReagentTempIsNull() {
            addCriterion("reagent_temp is null");
            return (Criteria) this;
        }

        public Criteria andReagentTempIsNotNull() {
            addCriterion("reagent_temp is not null");
            return (Criteria) this;
        }

        public Criteria andReagentTempEqualTo(String value) {
            addCriterion("reagent_temp =", value, "reagentTemp");
            return (Criteria) this;
        }

        public Criteria andReagentTempNotEqualTo(String value) {
            addCriterion("reagent_temp <>", value, "reagentTemp");
            return (Criteria) this;
        }

        public Criteria andReagentTempGreaterThan(String value) {
            addCriterion("reagent_temp >", value, "reagentTemp");
            return (Criteria) this;
        }

        public Criteria andReagentTempGreaterThanOrEqualTo(String value) {
            addCriterion("reagent_temp >=", value, "reagentTemp");
            return (Criteria) this;
        }

        public Criteria andReagentTempLessThan(String value) {
            addCriterion("reagent_temp <", value, "reagentTemp");
            return (Criteria) this;
        }

        public Criteria andReagentTempLessThanOrEqualTo(String value) {
            addCriterion("reagent_temp <=", value, "reagentTemp");
            return (Criteria) this;
        }

        public Criteria andReagentTempLike(String value) {
            addCriterion("reagent_temp like", value, "reagentTemp");
            return (Criteria) this;
        }

        public Criteria andReagentTempNotLike(String value) {
            addCriterion("reagent_temp not like", value, "reagentTemp");
            return (Criteria) this;
        }

        public Criteria andReagentTempIn(List<String> values) {
            addCriterion("reagent_temp in", values, "reagentTemp");
            return (Criteria) this;
        }

        public Criteria andReagentTempNotIn(List<String> values) {
            addCriterion("reagent_temp not in", values, "reagentTemp");
            return (Criteria) this;
        }

        public Criteria andReagentTempBetween(String value1, String value2) {
            addCriterion("reagent_temp between", value1, value2, "reagentTemp");
            return (Criteria) this;
        }

        public Criteria andReagentTempNotBetween(String value1, String value2) {
            addCriterion("reagent_temp not between", value1, value2, "reagentTemp");
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

        public Criteria andQrCodeIsNull() {
            addCriterion("qr_code is null");
            return (Criteria) this;
        }

        public Criteria andQrCodeIsNotNull() {
            addCriterion("qr_code is not null");
            return (Criteria) this;
        }

        public Criteria andQrCodeEqualTo(String value) {
            addCriterion("qr_code =", value, "qrCode");
            return (Criteria) this;
        }

        public Criteria andQrCodeNotEqualTo(String value) {
            addCriterion("qr_code <>", value, "qrCode");
            return (Criteria) this;
        }

        public Criteria andQrCodeGreaterThan(String value) {
            addCriterion("qr_code >", value, "qrCode");
            return (Criteria) this;
        }

        public Criteria andQrCodeGreaterThanOrEqualTo(String value) {
            addCriterion("qr_code >=", value, "qrCode");
            return (Criteria) this;
        }

        public Criteria andQrCodeLessThan(String value) {
            addCriterion("qr_code <", value, "qrCode");
            return (Criteria) this;
        }

        public Criteria andQrCodeLessThanOrEqualTo(String value) {
            addCriterion("qr_code <=", value, "qrCode");
            return (Criteria) this;
        }

        public Criteria andQrCodeLike(String value) {
            addCriterion("qr_code like", value, "qrCode");
            return (Criteria) this;
        }

        public Criteria andQrCodeNotLike(String value) {
            addCriterion("qr_code not like", value, "qrCode");
            return (Criteria) this;
        }

        public Criteria andQrCodeIn(List<String> values) {
            addCriterion("qr_code in", values, "qrCode");
            return (Criteria) this;
        }

        public Criteria andQrCodeNotIn(List<String> values) {
            addCriterion("qr_code not in", values, "qrCode");
            return (Criteria) this;
        }

        public Criteria andQrCodeBetween(String value1, String value2) {
            addCriterion("qr_code between", value1, value2, "qrCode");
            return (Criteria) this;
        }

        public Criteria andQrCodeNotBetween(String value1, String value2) {
            addCriterion("qr_code not between", value1, value2, "qrCode");
            return (Criteria) this;
        }

        public Criteria andCodeValueIsNull() {
            addCriterion("code_value is null");
            return (Criteria) this;
        }

        public Criteria andCodeValueIsNotNull() {
            addCriterion("code_value is not null");
            return (Criteria) this;
        }

        public Criteria andCodeValueEqualTo(String value) {
            addCriterion("code_value =", value, "codeValue");
            return (Criteria) this;
        }

        public Criteria andCodeValueNotEqualTo(String value) {
            addCriterion("code_value <>", value, "codeValue");
            return (Criteria) this;
        }

        public Criteria andCodeValueGreaterThan(String value) {
            addCriterion("code_value >", value, "codeValue");
            return (Criteria) this;
        }

        public Criteria andCodeValueGreaterThanOrEqualTo(String value) {
            addCriterion("code_value >=", value, "codeValue");
            return (Criteria) this;
        }

        public Criteria andCodeValueLessThan(String value) {
            addCriterion("code_value <", value, "codeValue");
            return (Criteria) this;
        }

        public Criteria andCodeValueLessThanOrEqualTo(String value) {
            addCriterion("code_value <=", value, "codeValue");
            return (Criteria) this;
        }

        public Criteria andCodeValueLike(String value) {
            addCriterion("code_value like", value, "codeValue");
            return (Criteria) this;
        }

        public Criteria andCodeValueNotLike(String value) {
            addCriterion("code_value not like", value, "codeValue");
            return (Criteria) this;
        }

        public Criteria andCodeValueIn(List<String> values) {
            addCriterion("code_value in", values, "codeValue");
            return (Criteria) this;
        }

        public Criteria andCodeValueNotIn(List<String> values) {
            addCriterion("code_value not in", values, "codeValue");
            return (Criteria) this;
        }

        public Criteria andCodeValueBetween(String value1, String value2) {
            addCriterion("code_value between", value1, value2, "codeValue");
            return (Criteria) this;
        }

        public Criteria andCodeValueNotBetween(String value1, String value2) {
            addCriterion("code_value not between", value1, value2, "codeValue");
            return (Criteria) this;
        }

        public Criteria andBatchNoIsNull() {
            addCriterion("batch_no is null");
            return (Criteria) this;
        }

        public Criteria andBatchNoIsNotNull() {
            addCriterion("batch_no is not null");
            return (Criteria) this;
        }

        public Criteria andBatchNoEqualTo(String value) {
            addCriterion("batch_no =", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotEqualTo(String value) {
            addCriterion("batch_no <>", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoGreaterThan(String value) {
            addCriterion("batch_no >", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoGreaterThanOrEqualTo(String value) {
            addCriterion("batch_no >=", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoLessThan(String value) {
            addCriterion("batch_no <", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoLessThanOrEqualTo(String value) {
            addCriterion("batch_no <=", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoLike(String value) {
            addCriterion("batch_no like", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotLike(String value) {
            addCriterion("batch_no not like", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoIn(List<String> values) {
            addCriterion("batch_no in", values, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotIn(List<String> values) {
            addCriterion("batch_no not in", values, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoBetween(String value1, String value2) {
            addCriterion("batch_no between", value1, value2, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotBetween(String value1, String value2) {
            addCriterion("batch_no not between", value1, value2, "batchNo");
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

        public Criteria andExpireDateEqualTo(Date value) {
            addCriterionForJDBCDate("expire_date =", value, "expireDate");
            return (Criteria) this;
        }

        public Criteria andExpireDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("expire_date <>", value, "expireDate");
            return (Criteria) this;
        }

        public Criteria andExpireDateGreaterThan(Date value) {
            addCriterionForJDBCDate("expire_date >", value, "expireDate");
            return (Criteria) this;
        }

        public Criteria andExpireDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("expire_date >=", value, "expireDate");
            return (Criteria) this;
        }

        public Criteria andExpireDateLessThan(Date value) {
            addCriterionForJDBCDate("expire_date <", value, "expireDate");
            return (Criteria) this;
        }

        public Criteria andExpireDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("expire_date <=", value, "expireDate");
            return (Criteria) this;
        }

        public Criteria andExpireDateIn(List<Date> values) {
            addCriterionForJDBCDate("expire_date in", values, "expireDate");
            return (Criteria) this;
        }

        public Criteria andExpireDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("expire_date not in", values, "expireDate");
            return (Criteria) this;
        }

        public Criteria andExpireDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("expire_date between", value1, value2, "expireDate");
            return (Criteria) this;
        }

        public Criteria andExpireDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("expire_date not between", value1, value2, "expireDate");
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

        public Criteria andOpenPeriodEqualTo(Integer value) {
            addCriterion("open_period =", value, "openPeriod");
            return (Criteria) this;
        }

        public Criteria andOpenPeriodNotEqualTo(Integer value) {
            addCriterion("open_period <>", value, "openPeriod");
            return (Criteria) this;
        }

        public Criteria andOpenPeriodGreaterThan(Integer value) {
            addCriterion("open_period >", value, "openPeriod");
            return (Criteria) this;
        }

        public Criteria andOpenPeriodGreaterThanOrEqualTo(Integer value) {
            addCriterion("open_period >=", value, "openPeriod");
            return (Criteria) this;
        }

        public Criteria andOpenPeriodLessThan(Integer value) {
            addCriterion("open_period <", value, "openPeriod");
            return (Criteria) this;
        }

        public Criteria andOpenPeriodLessThanOrEqualTo(Integer value) {
            addCriterion("open_period <=", value, "openPeriod");
            return (Criteria) this;
        }

        public Criteria andOpenPeriodIn(List<Integer> values) {
            addCriterion("open_period in", values, "openPeriod");
            return (Criteria) this;
        }

        public Criteria andOpenPeriodNotIn(List<Integer> values) {
            addCriterion("open_period not in", values, "openPeriod");
            return (Criteria) this;
        }

        public Criteria andOpenPeriodBetween(Integer value1, Integer value2) {
            addCriterion("open_period between", value1, value2, "openPeriod");
            return (Criteria) this;
        }

        public Criteria andOpenPeriodNotBetween(Integer value1, Integer value2) {
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

        public Criteria andReagentPriceEqualTo(Double value) {
            addCriterion("reagent_price =", value, "reagentPrice");
            return (Criteria) this;
        }

        public Criteria andReagentPriceNotEqualTo(Double value) {
            addCriterion("reagent_price <>", value, "reagentPrice");
            return (Criteria) this;
        }

        public Criteria andReagentPriceGreaterThan(Double value) {
            addCriterion("reagent_price >", value, "reagentPrice");
            return (Criteria) this;
        }

        public Criteria andReagentPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("reagent_price >=", value, "reagentPrice");
            return (Criteria) this;
        }

        public Criteria andReagentPriceLessThan(Double value) {
            addCriterion("reagent_price <", value, "reagentPrice");
            return (Criteria) this;
        }

        public Criteria andReagentPriceLessThanOrEqualTo(Double value) {
            addCriterion("reagent_price <=", value, "reagentPrice");
            return (Criteria) this;
        }

        public Criteria andReagentPriceIn(List<Double> values) {
            addCriterion("reagent_price in", values, "reagentPrice");
            return (Criteria) this;
        }

        public Criteria andReagentPriceNotIn(List<Double> values) {
            addCriterion("reagent_price not in", values, "reagentPrice");
            return (Criteria) this;
        }

        public Criteria andReagentPriceBetween(Double value1, Double value2) {
            addCriterion("reagent_price between", value1, value2, "reagentPrice");
            return (Criteria) this;
        }

        public Criteria andReagentPriceNotBetween(Double value1, Double value2) {
            addCriterion("reagent_price not between", value1, value2, "reagentPrice");
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

        public Criteria andOverdueEqualTo(Integer value) {
            addCriterion("overdue =", value, "overdue");
            return (Criteria) this;
        }

        public Criteria andOverdueNotEqualTo(Integer value) {
            addCriterion("overdue <>", value, "overdue");
            return (Criteria) this;
        }

        public Criteria andOverdueGreaterThan(Integer value) {
            addCriterion("overdue >", value, "overdue");
            return (Criteria) this;
        }

        public Criteria andOverdueGreaterThanOrEqualTo(Integer value) {
            addCriterion("overdue >=", value, "overdue");
            return (Criteria) this;
        }

        public Criteria andOverdueLessThan(Integer value) {
            addCriterion("overdue <", value, "overdue");
            return (Criteria) this;
        }

        public Criteria andOverdueLessThanOrEqualTo(Integer value) {
            addCriterion("overdue <=", value, "overdue");
            return (Criteria) this;
        }

        public Criteria andOverdueIn(List<Integer> values) {
            addCriterion("overdue in", values, "overdue");
            return (Criteria) this;
        }

        public Criteria andOverdueNotIn(List<Integer> values) {
            addCriterion("overdue not in", values, "overdue");
            return (Criteria) this;
        }

        public Criteria andOverdueBetween(Integer value1, Integer value2) {
            addCriterion("overdue between", value1, value2, "overdue");
            return (Criteria) this;
        }

        public Criteria andOverdueNotBetween(Integer value1, Integer value2) {
            addCriterion("overdue not between", value1, value2, "overdue");
            return (Criteria) this;
        }

        public Criteria andRemainDayIsNull() {
            addCriterion("remain_day is null");
            return (Criteria) this;
        }

        public Criteria andRemainDayIsNotNull() {
            addCriterion("remain_day is not null");
            return (Criteria) this;
        }

        public Criteria andRemainDayEqualTo(Integer value) {
            addCriterion("remain_day =", value, "remainDay");
            return (Criteria) this;
        }

        public Criteria andRemainDayNotEqualTo(Integer value) {
            addCriterion("remain_day <>", value, "remainDay");
            return (Criteria) this;
        }

        public Criteria andRemainDayGreaterThan(Integer value) {
            addCriterion("remain_day >", value, "remainDay");
            return (Criteria) this;
        }

        public Criteria andRemainDayGreaterThanOrEqualTo(Integer value) {
            addCriterion("remain_day >=", value, "remainDay");
            return (Criteria) this;
        }

        public Criteria andRemainDayLessThan(Integer value) {
            addCriterion("remain_day <", value, "remainDay");
            return (Criteria) this;
        }

        public Criteria andRemainDayLessThanOrEqualTo(Integer value) {
            addCriterion("remain_day <=", value, "remainDay");
            return (Criteria) this;
        }

        public Criteria andRemainDayIn(List<Integer> values) {
            addCriterion("remain_day in", values, "remainDay");
            return (Criteria) this;
        }

        public Criteria andRemainDayNotIn(List<Integer> values) {
            addCriterion("remain_day not in", values, "remainDay");
            return (Criteria) this;
        }

        public Criteria andRemainDayBetween(Integer value1, Integer value2) {
            addCriterion("remain_day between", value1, value2, "remainDay");
            return (Criteria) this;
        }

        public Criteria andRemainDayNotBetween(Integer value1, Integer value2) {
            addCriterion("remain_day not between", value1, value2, "remainDay");
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

        public Criteria andEnterNoEqualTo(String value) {
            addCriterion("enter_no =", value, "enterNo");
            return (Criteria) this;
        }

        public Criteria andEnterNoNotEqualTo(String value) {
            addCriterion("enter_no <>", value, "enterNo");
            return (Criteria) this;
        }

        public Criteria andEnterNoGreaterThan(String value) {
            addCriterion("enter_no >", value, "enterNo");
            return (Criteria) this;
        }

        public Criteria andEnterNoGreaterThanOrEqualTo(String value) {
            addCriterion("enter_no >=", value, "enterNo");
            return (Criteria) this;
        }

        public Criteria andEnterNoLessThan(String value) {
            addCriterion("enter_no <", value, "enterNo");
            return (Criteria) this;
        }

        public Criteria andEnterNoLessThanOrEqualTo(String value) {
            addCriterion("enter_no <=", value, "enterNo");
            return (Criteria) this;
        }

        public Criteria andEnterNoLike(String value) {
            addCriterion("enter_no like", value, "enterNo");
            return (Criteria) this;
        }

        public Criteria andEnterNoNotLike(String value) {
            addCriterion("enter_no not like", value, "enterNo");
            return (Criteria) this;
        }

        public Criteria andEnterNoIn(List<String> values) {
            addCriterion("enter_no in", values, "enterNo");
            return (Criteria) this;
        }

        public Criteria andEnterNoNotIn(List<String> values) {
            addCriterion("enter_no not in", values, "enterNo");
            return (Criteria) this;
        }

        public Criteria andEnterNoBetween(String value1, String value2) {
            addCriterion("enter_no between", value1, value2, "enterNo");
            return (Criteria) this;
        }

        public Criteria andEnterNoNotBetween(String value1, String value2) {
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

        public Criteria andOutNoEqualTo(String value) {
            addCriterion("out_no =", value, "outNo");
            return (Criteria) this;
        }

        public Criteria andOutNoNotEqualTo(String value) {
            addCriterion("out_no <>", value, "outNo");
            return (Criteria) this;
        }

        public Criteria andOutNoGreaterThan(String value) {
            addCriterion("out_no >", value, "outNo");
            return (Criteria) this;
        }

        public Criteria andOutNoGreaterThanOrEqualTo(String value) {
            addCriterion("out_no >=", value, "outNo");
            return (Criteria) this;
        }

        public Criteria andOutNoLessThan(String value) {
            addCriterion("out_no <", value, "outNo");
            return (Criteria) this;
        }

        public Criteria andOutNoLessThanOrEqualTo(String value) {
            addCriterion("out_no <=", value, "outNo");
            return (Criteria) this;
        }

        public Criteria andOutNoLike(String value) {
            addCriterion("out_no like", value, "outNo");
            return (Criteria) this;
        }

        public Criteria andOutNoNotLike(String value) {
            addCriterion("out_no not like", value, "outNo");
            return (Criteria) this;
        }

        public Criteria andOutNoIn(List<String> values) {
            addCriterion("out_no in", values, "outNo");
            return (Criteria) this;
        }

        public Criteria andOutNoNotIn(List<String> values) {
            addCriterion("out_no not in", values, "outNo");
            return (Criteria) this;
        }

        public Criteria andOutNoBetween(String value1, String value2) {
            addCriterion("out_no between", value1, value2, "outNo");
            return (Criteria) this;
        }

        public Criteria andOutNoNotBetween(String value1, String value2) {
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

        public Criteria andUseTimeIsNull() {
            addCriterion("use_time is null");
            return (Criteria) this;
        }

        public Criteria andUseTimeIsNotNull() {
            addCriterion("use_time is not null");
            return (Criteria) this;
        }

        public Criteria andUseTimeEqualTo(Date value) {
            addCriterion("use_time =", value, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeNotEqualTo(Date value) {
            addCriterion("use_time <>", value, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeGreaterThan(Date value) {
            addCriterion("use_time >", value, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("use_time >=", value, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeLessThan(Date value) {
            addCriterion("use_time <", value, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeLessThanOrEqualTo(Date value) {
            addCriterion("use_time <=", value, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeIn(List<Date> values) {
            addCriterion("use_time in", values, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeNotIn(List<Date> values) {
            addCriterion("use_time not in", values, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeBetween(Date value1, Date value2) {
            addCriterion("use_time between", value1, value2, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeNotBetween(Date value1, Date value2) {
            addCriterion("use_time not between", value1, value2, "useTime");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIsNull() {
            addCriterion("device_id is null");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIsNotNull() {
            addCriterion("device_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceIdEqualTo(String value) {
            addCriterion("device_id =", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotEqualTo(String value) {
            addCriterion("device_id <>", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdGreaterThan(String value) {
            addCriterion("device_id >", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdGreaterThanOrEqualTo(String value) {
            addCriterion("device_id >=", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLessThan(String value) {
            addCriterion("device_id <", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLessThanOrEqualTo(String value) {
            addCriterion("device_id <=", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLike(String value) {
            addCriterion("device_id like", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotLike(String value) {
            addCriterion("device_id not like", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIn(List<String> values) {
            addCriterion("device_id in", values, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotIn(List<String> values) {
            addCriterion("device_id not in", values, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdBetween(String value1, String value2) {
            addCriterion("device_id between", value1, value2, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotBetween(String value1, String value2) {
            addCriterion("device_id not between", value1, value2, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceRegManIsNull() {
            addCriterion("device_reg_man is null");
            return (Criteria) this;
        }

        public Criteria andDeviceRegManIsNotNull() {
            addCriterion("device_reg_man is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceRegManEqualTo(Long value) {
            addCriterion("device_reg_man =", value, "deviceRegMan");
            return (Criteria) this;
        }

        public Criteria andDeviceRegManNotEqualTo(Long value) {
            addCriterion("device_reg_man <>", value, "deviceRegMan");
            return (Criteria) this;
        }

        public Criteria andDeviceRegManGreaterThan(Long value) {
            addCriterion("device_reg_man >", value, "deviceRegMan");
            return (Criteria) this;
        }

        public Criteria andDeviceRegManGreaterThanOrEqualTo(Long value) {
            addCriterion("device_reg_man >=", value, "deviceRegMan");
            return (Criteria) this;
        }

        public Criteria andDeviceRegManLessThan(Long value) {
            addCriterion("device_reg_man <", value, "deviceRegMan");
            return (Criteria) this;
        }

        public Criteria andDeviceRegManLessThanOrEqualTo(Long value) {
            addCriterion("device_reg_man <=", value, "deviceRegMan");
            return (Criteria) this;
        }

        public Criteria andDeviceRegManIn(List<Long> values) {
            addCriterion("device_reg_man in", values, "deviceRegMan");
            return (Criteria) this;
        }

        public Criteria andDeviceRegManNotIn(List<Long> values) {
            addCriterion("device_reg_man not in", values, "deviceRegMan");
            return (Criteria) this;
        }

        public Criteria andDeviceRegManBetween(Long value1, Long value2) {
            addCriterion("device_reg_man between", value1, value2, "deviceRegMan");
            return (Criteria) this;
        }

        public Criteria andDeviceRegManNotBetween(Long value1, Long value2) {
            addCriterion("device_reg_man not between", value1, value2, "deviceRegMan");
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