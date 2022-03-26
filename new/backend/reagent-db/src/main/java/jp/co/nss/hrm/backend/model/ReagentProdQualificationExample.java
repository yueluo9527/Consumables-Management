package jp.co.nss.hrm.backend.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReagentProdQualificationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReagentProdQualificationExample() {
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

        public Criteria andSupplierIdIsNull() {
            addCriterion("supplier_id is null");
            return (Criteria) this;
        }

        public Criteria andSupplierIdIsNotNull() {
            addCriterion("supplier_id is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierIdEqualTo(String value) {
            addCriterion("supplier_id =", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdNotEqualTo(String value) {
            addCriterion("supplier_id <>", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdGreaterThan(String value) {
            addCriterion("supplier_id >", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdGreaterThanOrEqualTo(String value) {
            addCriterion("supplier_id >=", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdLessThan(String value) {
            addCriterion("supplier_id <", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdLessThanOrEqualTo(String value) {
            addCriterion("supplier_id <=", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdLike(String value) {
            addCriterion("supplier_id like", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdNotLike(String value) {
            addCriterion("supplier_id not like", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdIn(List<String> values) {
            addCriterion("supplier_id in", values, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdNotIn(List<String> values) {
            addCriterion("supplier_id not in", values, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdBetween(String value1, String value2) {
            addCriterion("supplier_id between", value1, value2, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdNotBetween(String value1, String value2) {
            addCriterion("supplier_id not between", value1, value2, "supplierId");
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

        public Criteria andManufacturerBusinessLicenseIsNull() {
            addCriterion("manufacturer_business_license is null");
            return (Criteria) this;
        }

        public Criteria andManufacturerBusinessLicenseIsNotNull() {
            addCriterion("manufacturer_business_license is not null");
            return (Criteria) this;
        }

        public Criteria andManufacturerBusinessLicenseEqualTo(String value) {
            addCriterion("manufacturer_business_license =", value, "manufacturerBusinessLicense");
            return (Criteria) this;
        }

        public Criteria andManufacturerBusinessLicenseNotEqualTo(String value) {
            addCriterion("manufacturer_business_license <>", value, "manufacturerBusinessLicense");
            return (Criteria) this;
        }

        public Criteria andManufacturerBusinessLicenseGreaterThan(String value) {
            addCriterion("manufacturer_business_license >", value, "manufacturerBusinessLicense");
            return (Criteria) this;
        }

        public Criteria andManufacturerBusinessLicenseGreaterThanOrEqualTo(String value) {
            addCriterion("manufacturer_business_license >=", value, "manufacturerBusinessLicense");
            return (Criteria) this;
        }

        public Criteria andManufacturerBusinessLicenseLessThan(String value) {
            addCriterion("manufacturer_business_license <", value, "manufacturerBusinessLicense");
            return (Criteria) this;
        }

        public Criteria andManufacturerBusinessLicenseLessThanOrEqualTo(String value) {
            addCriterion("manufacturer_business_license <=", value, "manufacturerBusinessLicense");
            return (Criteria) this;
        }

        public Criteria andManufacturerBusinessLicenseLike(String value) {
            addCriterion("manufacturer_business_license like", value, "manufacturerBusinessLicense");
            return (Criteria) this;
        }

        public Criteria andManufacturerBusinessLicenseNotLike(String value) {
            addCriterion("manufacturer_business_license not like", value, "manufacturerBusinessLicense");
            return (Criteria) this;
        }

        public Criteria andManufacturerBusinessLicenseIn(List<String> values) {
            addCriterion("manufacturer_business_license in", values, "manufacturerBusinessLicense");
            return (Criteria) this;
        }

        public Criteria andManufacturerBusinessLicenseNotIn(List<String> values) {
            addCriterion("manufacturer_business_license not in", values, "manufacturerBusinessLicense");
            return (Criteria) this;
        }

        public Criteria andManufacturerBusinessLicenseBetween(String value1, String value2) {
            addCriterion("manufacturer_business_license between", value1, value2, "manufacturerBusinessLicense");
            return (Criteria) this;
        }

        public Criteria andManufacturerBusinessLicenseNotBetween(String value1, String value2) {
            addCriterion("manufacturer_business_license not between", value1, value2, "manufacturerBusinessLicense");
            return (Criteria) this;
        }

        public Criteria andDeviceProdLicenseIsNull() {
            addCriterion("device_prod_license is null");
            return (Criteria) this;
        }

        public Criteria andDeviceProdLicenseIsNotNull() {
            addCriterion("device_prod_license is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceProdLicenseEqualTo(String value) {
            addCriterion("device_prod_license =", value, "deviceProdLicense");
            return (Criteria) this;
        }

        public Criteria andDeviceProdLicenseNotEqualTo(String value) {
            addCriterion("device_prod_license <>", value, "deviceProdLicense");
            return (Criteria) this;
        }

        public Criteria andDeviceProdLicenseGreaterThan(String value) {
            addCriterion("device_prod_license >", value, "deviceProdLicense");
            return (Criteria) this;
        }

        public Criteria andDeviceProdLicenseGreaterThanOrEqualTo(String value) {
            addCriterion("device_prod_license >=", value, "deviceProdLicense");
            return (Criteria) this;
        }

        public Criteria andDeviceProdLicenseLessThan(String value) {
            addCriterion("device_prod_license <", value, "deviceProdLicense");
            return (Criteria) this;
        }

        public Criteria andDeviceProdLicenseLessThanOrEqualTo(String value) {
            addCriterion("device_prod_license <=", value, "deviceProdLicense");
            return (Criteria) this;
        }

        public Criteria andDeviceProdLicenseLike(String value) {
            addCriterion("device_prod_license like", value, "deviceProdLicense");
            return (Criteria) this;
        }

        public Criteria andDeviceProdLicenseNotLike(String value) {
            addCriterion("device_prod_license not like", value, "deviceProdLicense");
            return (Criteria) this;
        }

        public Criteria andDeviceProdLicenseIn(List<String> values) {
            addCriterion("device_prod_license in", values, "deviceProdLicense");
            return (Criteria) this;
        }

        public Criteria andDeviceProdLicenseNotIn(List<String> values) {
            addCriterion("device_prod_license not in", values, "deviceProdLicense");
            return (Criteria) this;
        }

        public Criteria andDeviceProdLicenseBetween(String value1, String value2) {
            addCriterion("device_prod_license between", value1, value2, "deviceProdLicense");
            return (Criteria) this;
        }

        public Criteria andDeviceProdLicenseNotBetween(String value1, String value2) {
            addCriterion("device_prod_license not between", value1, value2, "deviceProdLicense");
            return (Criteria) this;
        }

        public Criteria andEquipmentBusinessLicenseIsNull() {
            addCriterion("equipment_business_license is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentBusinessLicenseIsNotNull() {
            addCriterion("equipment_business_license is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentBusinessLicenseEqualTo(String value) {
            addCriterion("equipment_business_license =", value, "equipmentBusinessLicense");
            return (Criteria) this;
        }

        public Criteria andEquipmentBusinessLicenseNotEqualTo(String value) {
            addCriterion("equipment_business_license <>", value, "equipmentBusinessLicense");
            return (Criteria) this;
        }

        public Criteria andEquipmentBusinessLicenseGreaterThan(String value) {
            addCriterion("equipment_business_license >", value, "equipmentBusinessLicense");
            return (Criteria) this;
        }

        public Criteria andEquipmentBusinessLicenseGreaterThanOrEqualTo(String value) {
            addCriterion("equipment_business_license >=", value, "equipmentBusinessLicense");
            return (Criteria) this;
        }

        public Criteria andEquipmentBusinessLicenseLessThan(String value) {
            addCriterion("equipment_business_license <", value, "equipmentBusinessLicense");
            return (Criteria) this;
        }

        public Criteria andEquipmentBusinessLicenseLessThanOrEqualTo(String value) {
            addCriterion("equipment_business_license <=", value, "equipmentBusinessLicense");
            return (Criteria) this;
        }

        public Criteria andEquipmentBusinessLicenseLike(String value) {
            addCriterion("equipment_business_license like", value, "equipmentBusinessLicense");
            return (Criteria) this;
        }

        public Criteria andEquipmentBusinessLicenseNotLike(String value) {
            addCriterion("equipment_business_license not like", value, "equipmentBusinessLicense");
            return (Criteria) this;
        }

        public Criteria andEquipmentBusinessLicenseIn(List<String> values) {
            addCriterion("equipment_business_license in", values, "equipmentBusinessLicense");
            return (Criteria) this;
        }

        public Criteria andEquipmentBusinessLicenseNotIn(List<String> values) {
            addCriterion("equipment_business_license not in", values, "equipmentBusinessLicense");
            return (Criteria) this;
        }

        public Criteria andEquipmentBusinessLicenseBetween(String value1, String value2) {
            addCriterion("equipment_business_license between", value1, value2, "equipmentBusinessLicense");
            return (Criteria) this;
        }

        public Criteria andEquipmentBusinessLicenseNotBetween(String value1, String value2) {
            addCriterion("equipment_business_license not between", value1, value2, "equipmentBusinessLicense");
            return (Criteria) this;
        }

        public Criteria andProductRegistrationFormIsNull() {
            addCriterion("product_registration_form is null");
            return (Criteria) this;
        }

        public Criteria andProductRegistrationFormIsNotNull() {
            addCriterion("product_registration_form is not null");
            return (Criteria) this;
        }

        public Criteria andProductRegistrationFormEqualTo(String value) {
            addCriterion("product_registration_form =", value, "productRegistrationForm");
            return (Criteria) this;
        }

        public Criteria andProductRegistrationFormNotEqualTo(String value) {
            addCriterion("product_registration_form <>", value, "productRegistrationForm");
            return (Criteria) this;
        }

        public Criteria andProductRegistrationFormGreaterThan(String value) {
            addCriterion("product_registration_form >", value, "productRegistrationForm");
            return (Criteria) this;
        }

        public Criteria andProductRegistrationFormGreaterThanOrEqualTo(String value) {
            addCriterion("product_registration_form >=", value, "productRegistrationForm");
            return (Criteria) this;
        }

        public Criteria andProductRegistrationFormLessThan(String value) {
            addCriterion("product_registration_form <", value, "productRegistrationForm");
            return (Criteria) this;
        }

        public Criteria andProductRegistrationFormLessThanOrEqualTo(String value) {
            addCriterion("product_registration_form <=", value, "productRegistrationForm");
            return (Criteria) this;
        }

        public Criteria andProductRegistrationFormLike(String value) {
            addCriterion("product_registration_form like", value, "productRegistrationForm");
            return (Criteria) this;
        }

        public Criteria andProductRegistrationFormNotLike(String value) {
            addCriterion("product_registration_form not like", value, "productRegistrationForm");
            return (Criteria) this;
        }

        public Criteria andProductRegistrationFormIn(List<String> values) {
            addCriterion("product_registration_form in", values, "productRegistrationForm");
            return (Criteria) this;
        }

        public Criteria andProductRegistrationFormNotIn(List<String> values) {
            addCriterion("product_registration_form not in", values, "productRegistrationForm");
            return (Criteria) this;
        }

        public Criteria andProductRegistrationFormBetween(String value1, String value2) {
            addCriterion("product_registration_form between", value1, value2, "productRegistrationForm");
            return (Criteria) this;
        }

        public Criteria andProductRegistrationFormNotBetween(String value1, String value2) {
            addCriterion("product_registration_form not between", value1, value2, "productRegistrationForm");
            return (Criteria) this;
        }

        public Criteria andProductionRecordCertificateIsNull() {
            addCriterion("production_record_certificate is null");
            return (Criteria) this;
        }

        public Criteria andProductionRecordCertificateIsNotNull() {
            addCriterion("production_record_certificate is not null");
            return (Criteria) this;
        }

        public Criteria andProductionRecordCertificateEqualTo(String value) {
            addCriterion("production_record_certificate =", value, "productionRecordCertificate");
            return (Criteria) this;
        }

        public Criteria andProductionRecordCertificateNotEqualTo(String value) {
            addCriterion("production_record_certificate <>", value, "productionRecordCertificate");
            return (Criteria) this;
        }

        public Criteria andProductionRecordCertificateGreaterThan(String value) {
            addCriterion("production_record_certificate >", value, "productionRecordCertificate");
            return (Criteria) this;
        }

        public Criteria andProductionRecordCertificateGreaterThanOrEqualTo(String value) {
            addCriterion("production_record_certificate >=", value, "productionRecordCertificate");
            return (Criteria) this;
        }

        public Criteria andProductionRecordCertificateLessThan(String value) {
            addCriterion("production_record_certificate <", value, "productionRecordCertificate");
            return (Criteria) this;
        }

        public Criteria andProductionRecordCertificateLessThanOrEqualTo(String value) {
            addCriterion("production_record_certificate <=", value, "productionRecordCertificate");
            return (Criteria) this;
        }

        public Criteria andProductionRecordCertificateLike(String value) {
            addCriterion("production_record_certificate like", value, "productionRecordCertificate");
            return (Criteria) this;
        }

        public Criteria andProductionRecordCertificateNotLike(String value) {
            addCriterion("production_record_certificate not like", value, "productionRecordCertificate");
            return (Criteria) this;
        }

        public Criteria andProductionRecordCertificateIn(List<String> values) {
            addCriterion("production_record_certificate in", values, "productionRecordCertificate");
            return (Criteria) this;
        }

        public Criteria andProductionRecordCertificateNotIn(List<String> values) {
            addCriterion("production_record_certificate not in", values, "productionRecordCertificate");
            return (Criteria) this;
        }

        public Criteria andProductionRecordCertificateBetween(String value1, String value2) {
            addCriterion("production_record_certificate between", value1, value2, "productionRecordCertificate");
            return (Criteria) this;
        }

        public Criteria andProductionRecordCertificateNotBetween(String value1, String value2) {
            addCriterion("production_record_certificate not between", value1, value2, "productionRecordCertificate");
            return (Criteria) this;
        }

        public Criteria andDeviceRegistrationCertificateIsNull() {
            addCriterion("device_registration_certificate is null");
            return (Criteria) this;
        }

        public Criteria andDeviceRegistrationCertificateIsNotNull() {
            addCriterion("device_registration_certificate is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceRegistrationCertificateEqualTo(String value) {
            addCriterion("device_registration_certificate =", value, "deviceRegistrationCertificate");
            return (Criteria) this;
        }

        public Criteria andDeviceRegistrationCertificateNotEqualTo(String value) {
            addCriterion("device_registration_certificate <>", value, "deviceRegistrationCertificate");
            return (Criteria) this;
        }

        public Criteria andDeviceRegistrationCertificateGreaterThan(String value) {
            addCriterion("device_registration_certificate >", value, "deviceRegistrationCertificate");
            return (Criteria) this;
        }

        public Criteria andDeviceRegistrationCertificateGreaterThanOrEqualTo(String value) {
            addCriterion("device_registration_certificate >=", value, "deviceRegistrationCertificate");
            return (Criteria) this;
        }

        public Criteria andDeviceRegistrationCertificateLessThan(String value) {
            addCriterion("device_registration_certificate <", value, "deviceRegistrationCertificate");
            return (Criteria) this;
        }

        public Criteria andDeviceRegistrationCertificateLessThanOrEqualTo(String value) {
            addCriterion("device_registration_certificate <=", value, "deviceRegistrationCertificate");
            return (Criteria) this;
        }

        public Criteria andDeviceRegistrationCertificateLike(String value) {
            addCriterion("device_registration_certificate like", value, "deviceRegistrationCertificate");
            return (Criteria) this;
        }

        public Criteria andDeviceRegistrationCertificateNotLike(String value) {
            addCriterion("device_registration_certificate not like", value, "deviceRegistrationCertificate");
            return (Criteria) this;
        }

        public Criteria andDeviceRegistrationCertificateIn(List<String> values) {
            addCriterion("device_registration_certificate in", values, "deviceRegistrationCertificate");
            return (Criteria) this;
        }

        public Criteria andDeviceRegistrationCertificateNotIn(List<String> values) {
            addCriterion("device_registration_certificate not in", values, "deviceRegistrationCertificate");
            return (Criteria) this;
        }

        public Criteria andDeviceRegistrationCertificateBetween(String value1, String value2) {
            addCriterion("device_registration_certificate between", value1, value2, "deviceRegistrationCertificate");
            return (Criteria) this;
        }

        public Criteria andDeviceRegistrationCertificateNotBetween(String value1, String value2) {
            addCriterion("device_registration_certificate not between", value1, value2, "deviceRegistrationCertificate");
            return (Criteria) this;
        }

        public Criteria andOtherIsNull() {
            addCriterion("other is null");
            return (Criteria) this;
        }

        public Criteria andOtherIsNotNull() {
            addCriterion("other is not null");
            return (Criteria) this;
        }

        public Criteria andOtherEqualTo(String value) {
            addCriterion("other =", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotEqualTo(String value) {
            addCriterion("other <>", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherGreaterThan(String value) {
            addCriterion("other >", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherGreaterThanOrEqualTo(String value) {
            addCriterion("other >=", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherLessThan(String value) {
            addCriterion("other <", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherLessThanOrEqualTo(String value) {
            addCriterion("other <=", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherLike(String value) {
            addCriterion("other like", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotLike(String value) {
            addCriterion("other not like", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherIn(List<String> values) {
            addCriterion("other in", values, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotIn(List<String> values) {
            addCriterion("other not in", values, "other");
            return (Criteria) this;
        }

        public Criteria andOtherBetween(String value1, String value2) {
            addCriterion("other between", value1, value2, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotBetween(String value1, String value2) {
            addCriterion("other not between", value1, value2, "other");
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