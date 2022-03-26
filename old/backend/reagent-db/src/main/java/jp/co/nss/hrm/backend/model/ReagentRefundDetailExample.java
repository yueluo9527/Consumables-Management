package jp.co.nss.hrm.backend.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReagentRefundDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReagentRefundDetailExample() {
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

        public Criteria andRefundCodeIsNull() {
            addCriterion("refund_code is null");
            return (Criteria) this;
        }

        public Criteria andRefundCodeIsNotNull() {
            addCriterion("refund_code is not null");
            return (Criteria) this;
        }

        public Criteria andRefundCodeEqualTo(String value) {
            addCriterion("refund_code =", value, "refundCode");
            return (Criteria) this;
        }

        public Criteria andRefundCodeNotEqualTo(String value) {
            addCriterion("refund_code <>", value, "refundCode");
            return (Criteria) this;
        }

        public Criteria andRefundCodeGreaterThan(String value) {
            addCriterion("refund_code >", value, "refundCode");
            return (Criteria) this;
        }

        public Criteria andRefundCodeGreaterThanOrEqualTo(String value) {
            addCriterion("refund_code >=", value, "refundCode");
            return (Criteria) this;
        }

        public Criteria andRefundCodeLessThan(String value) {
            addCriterion("refund_code <", value, "refundCode");
            return (Criteria) this;
        }

        public Criteria andRefundCodeLessThanOrEqualTo(String value) {
            addCriterion("refund_code <=", value, "refundCode");
            return (Criteria) this;
        }

        public Criteria andRefundCodeLike(String value) {
            addCriterion("refund_code like", value, "refundCode");
            return (Criteria) this;
        }

        public Criteria andRefundCodeNotLike(String value) {
            addCriterion("refund_code not like", value, "refundCode");
            return (Criteria) this;
        }

        public Criteria andRefundCodeIn(List<String> values) {
            addCriterion("refund_code in", values, "refundCode");
            return (Criteria) this;
        }

        public Criteria andRefundCodeNotIn(List<String> values) {
            addCriterion("refund_code not in", values, "refundCode");
            return (Criteria) this;
        }

        public Criteria andRefundCodeBetween(String value1, String value2) {
            addCriterion("refund_code between", value1, value2, "refundCode");
            return (Criteria) this;
        }

        public Criteria andRefundCodeNotBetween(String value1, String value2) {
            addCriterion("refund_code not between", value1, value2, "refundCode");
            return (Criteria) this;
        }

        public Criteria andRefundDetailIdIsNull() {
            addCriterion("refund_detail_id is null");
            return (Criteria) this;
        }

        public Criteria andRefundDetailIdIsNotNull() {
            addCriterion("refund_detail_id is not null");
            return (Criteria) this;
        }

        public Criteria andRefundDetailIdEqualTo(String value) {
            addCriterion("refund_detail_id =", value, "refundDetailId");
            return (Criteria) this;
        }

        public Criteria andRefundDetailIdNotEqualTo(String value) {
            addCriterion("refund_detail_id <>", value, "refundDetailId");
            return (Criteria) this;
        }

        public Criteria andRefundDetailIdGreaterThan(String value) {
            addCriterion("refund_detail_id >", value, "refundDetailId");
            return (Criteria) this;
        }

        public Criteria andRefundDetailIdGreaterThanOrEqualTo(String value) {
            addCriterion("refund_detail_id >=", value, "refundDetailId");
            return (Criteria) this;
        }

        public Criteria andRefundDetailIdLessThan(String value) {
            addCriterion("refund_detail_id <", value, "refundDetailId");
            return (Criteria) this;
        }

        public Criteria andRefundDetailIdLessThanOrEqualTo(String value) {
            addCriterion("refund_detail_id <=", value, "refundDetailId");
            return (Criteria) this;
        }

        public Criteria andRefundDetailIdLike(String value) {
            addCriterion("refund_detail_id like", value, "refundDetailId");
            return (Criteria) this;
        }

        public Criteria andRefundDetailIdNotLike(String value) {
            addCriterion("refund_detail_id not like", value, "refundDetailId");
            return (Criteria) this;
        }

        public Criteria andRefundDetailIdIn(List<String> values) {
            addCriterion("refund_detail_id in", values, "refundDetailId");
            return (Criteria) this;
        }

        public Criteria andRefundDetailIdNotIn(List<String> values) {
            addCriterion("refund_detail_id not in", values, "refundDetailId");
            return (Criteria) this;
        }

        public Criteria andRefundDetailIdBetween(String value1, String value2) {
            addCriterion("refund_detail_id between", value1, value2, "refundDetailId");
            return (Criteria) this;
        }

        public Criteria andRefundDetailIdNotBetween(String value1, String value2) {
            addCriterion("refund_detail_id not between", value1, value2, "refundDetailId");
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

        public Criteria andReagentSpecificationIsNull() {
            addCriterion("reagent_specification is null");
            return (Criteria) this;
        }

        public Criteria andReagentSpecificationIsNotNull() {
            addCriterion("reagent_specification is not null");
            return (Criteria) this;
        }

        public Criteria andReagentSpecificationEqualTo(String value) {
            addCriterion("reagent_specification =", value, "reagentSpecification");
            return (Criteria) this;
        }

        public Criteria andReagentSpecificationNotEqualTo(String value) {
            addCriterion("reagent_specification <>", value, "reagentSpecification");
            return (Criteria) this;
        }

        public Criteria andReagentSpecificationGreaterThan(String value) {
            addCriterion("reagent_specification >", value, "reagentSpecification");
            return (Criteria) this;
        }

        public Criteria andReagentSpecificationGreaterThanOrEqualTo(String value) {
            addCriterion("reagent_specification >=", value, "reagentSpecification");
            return (Criteria) this;
        }

        public Criteria andReagentSpecificationLessThan(String value) {
            addCriterion("reagent_specification <", value, "reagentSpecification");
            return (Criteria) this;
        }

        public Criteria andReagentSpecificationLessThanOrEqualTo(String value) {
            addCriterion("reagent_specification <=", value, "reagentSpecification");
            return (Criteria) this;
        }

        public Criteria andReagentSpecificationLike(String value) {
            addCriterion("reagent_specification like", value, "reagentSpecification");
            return (Criteria) this;
        }

        public Criteria andReagentSpecificationNotLike(String value) {
            addCriterion("reagent_specification not like", value, "reagentSpecification");
            return (Criteria) this;
        }

        public Criteria andReagentSpecificationIn(List<String> values) {
            addCriterion("reagent_specification in", values, "reagentSpecification");
            return (Criteria) this;
        }

        public Criteria andReagentSpecificationNotIn(List<String> values) {
            addCriterion("reagent_specification not in", values, "reagentSpecification");
            return (Criteria) this;
        }

        public Criteria andReagentSpecificationBetween(String value1, String value2) {
            addCriterion("reagent_specification between", value1, value2, "reagentSpecification");
            return (Criteria) this;
        }

        public Criteria andReagentSpecificationNotBetween(String value1, String value2) {
            addCriterion("reagent_specification not between", value1, value2, "reagentSpecification");
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

        public Criteria andTotalIsNull() {
            addCriterion("total is null");
            return (Criteria) this;
        }

        public Criteria andTotalIsNotNull() {
            addCriterion("total is not null");
            return (Criteria) this;
        }

        public Criteria andTotalEqualTo(Double value) {
            addCriterion("total =", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotEqualTo(Double value) {
            addCriterion("total <>", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalGreaterThan(Double value) {
            addCriterion("total >", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalGreaterThanOrEqualTo(Double value) {
            addCriterion("total >=", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalLessThan(Double value) {
            addCriterion("total <", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalLessThanOrEqualTo(Double value) {
            addCriterion("total <=", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalIn(List<Double> values) {
            addCriterion("total in", values, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotIn(List<Double> values) {
            addCriterion("total not in", values, "total");
            return (Criteria) this;
        }

        public Criteria andTotalBetween(Double value1, Double value2) {
            addCriterion("total between", value1, value2, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotBetween(Double value1, Double value2) {
            addCriterion("total not between", value1, value2, "total");
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