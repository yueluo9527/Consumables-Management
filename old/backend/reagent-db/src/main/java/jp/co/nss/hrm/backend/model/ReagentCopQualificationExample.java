package jp.co.nss.hrm.backend.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReagentCopQualificationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReagentCopQualificationExample() {
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

        public Criteria andBusinessLicenseIsNull() {
            addCriterion("business_license is null");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseIsNotNull() {
            addCriterion("business_license is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseEqualTo(String value) {
            addCriterion("business_license =", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseNotEqualTo(String value) {
            addCriterion("business_license <>", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseGreaterThan(String value) {
            addCriterion("business_license >", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseGreaterThanOrEqualTo(String value) {
            addCriterion("business_license >=", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseLessThan(String value) {
            addCriterion("business_license <", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseLessThanOrEqualTo(String value) {
            addCriterion("business_license <=", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseLike(String value) {
            addCriterion("business_license like", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseNotLike(String value) {
            addCriterion("business_license not like", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseIn(List<String> values) {
            addCriterion("business_license in", values, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseNotIn(List<String> values) {
            addCriterion("business_license not in", values, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseBetween(String value1, String value2) {
            addCriterion("business_license between", value1, value2, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseNotBetween(String value1, String value2) {
            addCriterion("business_license not between", value1, value2, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andMedicalEquipmentBusinessLicenseIsNull() {
            addCriterion("medical_equipment_business_license is null");
            return (Criteria) this;
        }

        public Criteria andMedicalEquipmentBusinessLicenseIsNotNull() {
            addCriterion("medical_equipment_business_license is not null");
            return (Criteria) this;
        }

        public Criteria andMedicalEquipmentBusinessLicenseEqualTo(String value) {
            addCriterion("medical_equipment_business_license =", value, "medicalEquipmentBusinessLicense");
            return (Criteria) this;
        }

        public Criteria andMedicalEquipmentBusinessLicenseNotEqualTo(String value) {
            addCriterion("medical_equipment_business_license <>", value, "medicalEquipmentBusinessLicense");
            return (Criteria) this;
        }

        public Criteria andMedicalEquipmentBusinessLicenseGreaterThan(String value) {
            addCriterion("medical_equipment_business_license >", value, "medicalEquipmentBusinessLicense");
            return (Criteria) this;
        }

        public Criteria andMedicalEquipmentBusinessLicenseGreaterThanOrEqualTo(String value) {
            addCriterion("medical_equipment_business_license >=", value, "medicalEquipmentBusinessLicense");
            return (Criteria) this;
        }

        public Criteria andMedicalEquipmentBusinessLicenseLessThan(String value) {
            addCriterion("medical_equipment_business_license <", value, "medicalEquipmentBusinessLicense");
            return (Criteria) this;
        }

        public Criteria andMedicalEquipmentBusinessLicenseLessThanOrEqualTo(String value) {
            addCriterion("medical_equipment_business_license <=", value, "medicalEquipmentBusinessLicense");
            return (Criteria) this;
        }

        public Criteria andMedicalEquipmentBusinessLicenseLike(String value) {
            addCriterion("medical_equipment_business_license like", value, "medicalEquipmentBusinessLicense");
            return (Criteria) this;
        }

        public Criteria andMedicalEquipmentBusinessLicenseNotLike(String value) {
            addCriterion("medical_equipment_business_license not like", value, "medicalEquipmentBusinessLicense");
            return (Criteria) this;
        }

        public Criteria andMedicalEquipmentBusinessLicenseIn(List<String> values) {
            addCriterion("medical_equipment_business_license in", values, "medicalEquipmentBusinessLicense");
            return (Criteria) this;
        }

        public Criteria andMedicalEquipmentBusinessLicenseNotIn(List<String> values) {
            addCriterion("medical_equipment_business_license not in", values, "medicalEquipmentBusinessLicense");
            return (Criteria) this;
        }

        public Criteria andMedicalEquipmentBusinessLicenseBetween(String value1, String value2) {
            addCriterion("medical_equipment_business_license between", value1, value2, "medicalEquipmentBusinessLicense");
            return (Criteria) this;
        }

        public Criteria andMedicalEquipmentBusinessLicenseNotBetween(String value1, String value2) {
            addCriterion("medical_equipment_business_license not between", value1, value2, "medicalEquipmentBusinessLicense");
            return (Criteria) this;
        }

        public Criteria andLegalPersonPowerOfAttorneyIsNull() {
            addCriterion("legal_person_power_of_attorney is null");
            return (Criteria) this;
        }

        public Criteria andLegalPersonPowerOfAttorneyIsNotNull() {
            addCriterion("legal_person_power_of_attorney is not null");
            return (Criteria) this;
        }

        public Criteria andLegalPersonPowerOfAttorneyEqualTo(String value) {
            addCriterion("legal_person_power_of_attorney =", value, "legalPersonPowerOfAttorney");
            return (Criteria) this;
        }

        public Criteria andLegalPersonPowerOfAttorneyNotEqualTo(String value) {
            addCriterion("legal_person_power_of_attorney <>", value, "legalPersonPowerOfAttorney");
            return (Criteria) this;
        }

        public Criteria andLegalPersonPowerOfAttorneyGreaterThan(String value) {
            addCriterion("legal_person_power_of_attorney >", value, "legalPersonPowerOfAttorney");
            return (Criteria) this;
        }

        public Criteria andLegalPersonPowerOfAttorneyGreaterThanOrEqualTo(String value) {
            addCriterion("legal_person_power_of_attorney >=", value, "legalPersonPowerOfAttorney");
            return (Criteria) this;
        }

        public Criteria andLegalPersonPowerOfAttorneyLessThan(String value) {
            addCriterion("legal_person_power_of_attorney <", value, "legalPersonPowerOfAttorney");
            return (Criteria) this;
        }

        public Criteria andLegalPersonPowerOfAttorneyLessThanOrEqualTo(String value) {
            addCriterion("legal_person_power_of_attorney <=", value, "legalPersonPowerOfAttorney");
            return (Criteria) this;
        }

        public Criteria andLegalPersonPowerOfAttorneyLike(String value) {
            addCriterion("legal_person_power_of_attorney like", value, "legalPersonPowerOfAttorney");
            return (Criteria) this;
        }

        public Criteria andLegalPersonPowerOfAttorneyNotLike(String value) {
            addCriterion("legal_person_power_of_attorney not like", value, "legalPersonPowerOfAttorney");
            return (Criteria) this;
        }

        public Criteria andLegalPersonPowerOfAttorneyIn(List<String> values) {
            addCriterion("legal_person_power_of_attorney in", values, "legalPersonPowerOfAttorney");
            return (Criteria) this;
        }

        public Criteria andLegalPersonPowerOfAttorneyNotIn(List<String> values) {
            addCriterion("legal_person_power_of_attorney not in", values, "legalPersonPowerOfAttorney");
            return (Criteria) this;
        }

        public Criteria andLegalPersonPowerOfAttorneyBetween(String value1, String value2) {
            addCriterion("legal_person_power_of_attorney between", value1, value2, "legalPersonPowerOfAttorney");
            return (Criteria) this;
        }

        public Criteria andLegalPersonPowerOfAttorneyNotBetween(String value1, String value2) {
            addCriterion("legal_person_power_of_attorney not between", value1, value2, "legalPersonPowerOfAttorney");
            return (Criteria) this;
        }

        public Criteria andClientIdCardIsNull() {
            addCriterion("client_id_card is null");
            return (Criteria) this;
        }

        public Criteria andClientIdCardIsNotNull() {
            addCriterion("client_id_card is not null");
            return (Criteria) this;
        }

        public Criteria andClientIdCardEqualTo(String value) {
            addCriterion("client_id_card =", value, "clientIdCard");
            return (Criteria) this;
        }

        public Criteria andClientIdCardNotEqualTo(String value) {
            addCriterion("client_id_card <>", value, "clientIdCard");
            return (Criteria) this;
        }

        public Criteria andClientIdCardGreaterThan(String value) {
            addCriterion("client_id_card >", value, "clientIdCard");
            return (Criteria) this;
        }

        public Criteria andClientIdCardGreaterThanOrEqualTo(String value) {
            addCriterion("client_id_card >=", value, "clientIdCard");
            return (Criteria) this;
        }

        public Criteria andClientIdCardLessThan(String value) {
            addCriterion("client_id_card <", value, "clientIdCard");
            return (Criteria) this;
        }

        public Criteria andClientIdCardLessThanOrEqualTo(String value) {
            addCriterion("client_id_card <=", value, "clientIdCard");
            return (Criteria) this;
        }

        public Criteria andClientIdCardLike(String value) {
            addCriterion("client_id_card like", value, "clientIdCard");
            return (Criteria) this;
        }

        public Criteria andClientIdCardNotLike(String value) {
            addCriterion("client_id_card not like", value, "clientIdCard");
            return (Criteria) this;
        }

        public Criteria andClientIdCardIn(List<String> values) {
            addCriterion("client_id_card in", values, "clientIdCard");
            return (Criteria) this;
        }

        public Criteria andClientIdCardNotIn(List<String> values) {
            addCriterion("client_id_card not in", values, "clientIdCard");
            return (Criteria) this;
        }

        public Criteria andClientIdCardBetween(String value1, String value2) {
            addCriterion("client_id_card between", value1, value2, "clientIdCard");
            return (Criteria) this;
        }

        public Criteria andClientIdCardNotBetween(String value1, String value2) {
            addCriterion("client_id_card not between", value1, value2, "clientIdCard");
            return (Criteria) this;
        }

        public Criteria andQualityAssuranceGreementIsNull() {
            addCriterion("quality_assurance_greement is null");
            return (Criteria) this;
        }

        public Criteria andQualityAssuranceGreementIsNotNull() {
            addCriterion("quality_assurance_greement is not null");
            return (Criteria) this;
        }

        public Criteria andQualityAssuranceGreementEqualTo(String value) {
            addCriterion("quality_assurance_greement =", value, "qualityAssuranceGreement");
            return (Criteria) this;
        }

        public Criteria andQualityAssuranceGreementNotEqualTo(String value) {
            addCriterion("quality_assurance_greement <>", value, "qualityAssuranceGreement");
            return (Criteria) this;
        }

        public Criteria andQualityAssuranceGreementGreaterThan(String value) {
            addCriterion("quality_assurance_greement >", value, "qualityAssuranceGreement");
            return (Criteria) this;
        }

        public Criteria andQualityAssuranceGreementGreaterThanOrEqualTo(String value) {
            addCriterion("quality_assurance_greement >=", value, "qualityAssuranceGreement");
            return (Criteria) this;
        }

        public Criteria andQualityAssuranceGreementLessThan(String value) {
            addCriterion("quality_assurance_greement <", value, "qualityAssuranceGreement");
            return (Criteria) this;
        }

        public Criteria andQualityAssuranceGreementLessThanOrEqualTo(String value) {
            addCriterion("quality_assurance_greement <=", value, "qualityAssuranceGreement");
            return (Criteria) this;
        }

        public Criteria andQualityAssuranceGreementLike(String value) {
            addCriterion("quality_assurance_greement like", value, "qualityAssuranceGreement");
            return (Criteria) this;
        }

        public Criteria andQualityAssuranceGreementNotLike(String value) {
            addCriterion("quality_assurance_greement not like", value, "qualityAssuranceGreement");
            return (Criteria) this;
        }

        public Criteria andQualityAssuranceGreementIn(List<String> values) {
            addCriterion("quality_assurance_greement in", values, "qualityAssuranceGreement");
            return (Criteria) this;
        }

        public Criteria andQualityAssuranceGreementNotIn(List<String> values) {
            addCriterion("quality_assurance_greement not in", values, "qualityAssuranceGreement");
            return (Criteria) this;
        }

        public Criteria andQualityAssuranceGreementBetween(String value1, String value2) {
            addCriterion("quality_assurance_greement between", value1, value2, "qualityAssuranceGreement");
            return (Criteria) this;
        }

        public Criteria andQualityAssuranceGreementNotBetween(String value1, String value2) {
            addCriterion("quality_assurance_greement not between", value1, value2, "qualityAssuranceGreement");
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