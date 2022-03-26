package jp.co.nss.hrm.backend.api.service.impl;

import com.github.pagehelper.PageHelper;
import jp.co.nss.hrm.backend.api.dao.ReagentSupplierDao;
import jp.co.nss.hrm.backend.api.service.ReagentSupplierService;
import jp.co.nss.hrm.backend.mapper.ReagentCopQualificationMapper;
import jp.co.nss.hrm.backend.mapper.ReagentSupplierMapper;
import jp.co.nss.hrm.backend.model.ReagentCopQualification;
import jp.co.nss.hrm.backend.model.ReagentSupplier;
import jp.co.nss.hrm.backend.model.ReagentSupplierExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ReagentSupplierServiceImpl implements ReagentSupplierService {

    @Autowired
    private ReagentSupplierMapper supplierMapper;
    @Autowired
    private ReagentSupplierDao supplierDao;
    @Autowired
    private ReagentCopQualificationMapper copQualificationMapper;

    /**
     * 获取所有供应商列表
     */
    @Override
    public List<ReagentSupplier> list() {
        List<ReagentSupplier> supplierListAll;
        List<ReagentSupplier> supplierList = new ArrayList<>();
        supplierListAll = supplierMapper.selectByExample(new ReagentSupplierExample());
        //筛选出只有正常状态的供货商才能被添加试剂时选择
        for (ReagentSupplier supplier : supplierListAll) {
            if (supplier.getStatus() == 1) supplierList.add(supplier);
        }
        return supplierList;
    }

    /**
     * 添加供应商
     *
     * @param supplier
     */
    @Override
    public int create(ReagentSupplier supplier) {
        supplier.setCreateTime(new Date());
        supplier.setUpdateTime(new Date());
        //查询是否有相同名的供应商supplier_short_name
        ReagentSupplierExample example = new ReagentSupplierExample();
        example.createCriteria().andSupplierShortNameEqualTo(supplier.getSupplierShortName());
        List<ReagentSupplier> reagentSupplierList = supplierMapper.selectByExample(example);
        if (reagentSupplierList.size() > 0) {
            return 0;
        }

        String count;
        count = supplierDao.getMaxId();

        if (StringUtils.isEmpty(count)) count = "0";
        Integer newCount = Integer.parseInt(count) + 1;
        supplier.setSupplierCode(String.valueOf(newCount));

        //写入公司资质表
        ReagentCopQualification copQualification = new ReagentCopQualification();
        copQualification.setSupplierId(String.valueOf(newCount));
        copQualification.setSupplierShortName(supplier.getSupplierShortName());
        copQualification.setCreateTime(new Date());
        copQualification.setUpdateTime(new Date());

        copQualificationMapper.insert(copQualification);

        return supplierMapper.insert(supplier);
    }

    /**
     * 修改供应商状态
     *
     * @param id
     * @param supplier
     */
    @Override
    public int updateStatus(Long id, ReagentSupplier supplier) {
        supplier.setId(id);
        supplier.setUpdateTime(new Date());
        int count = supplierMapper.updateByPrimaryKeySelective(supplier);
        return count;
    }

    /**
     * 修改供应商信息
     *
     * @param id
     * @param supplier
     */
    @Override
    public int update(Long id, ReagentSupplier supplier) {
        supplier.setId(id);
        supplier.setUpdateTime(new Date());

        //查询是否有相同名的用户supplier_short_name
        ReagentSupplierExample example = new ReagentSupplierExample();
        example.createCriteria().andSupplierShortNameEqualTo(supplier.getSupplierShortName());
        List<ReagentSupplier> reagentSupplierList = supplierMapper.selectByExample(example);
        if (reagentSupplierList.size() > 0 && !reagentSupplierList.get(0).getId().equals(id)) {
            return 0;
        }

        //级联更新基础信息中的供货商名
        int count = supplierMapper.updateByPrimaryKeySelective(supplier);
        //baseInfoDao.updateBS();
        return count;
    }

    /**
     * 删除指定用户
     */

    @Override
    public int delete(Long id) {
        int count = supplierMapper.deleteByPrimaryKey(id);
        //int updateId = supplierDao.updateId(id);
        return count;
    }

    /**
     * 分页获取供应商列表
     *
     * @param keyword
     * @param pageSize
     * @param pageNum
     */
    @Override
    public List<ReagentSupplier> list(String keyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        ReagentSupplierExample example = new ReagentSupplierExample();
        ReagentSupplierExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(keyword)) {
            criteria.andSupplierCodeLike("%" + keyword + "%");
            example.or(example.createCriteria().andSupplierNameLike("%" + keyword + "%"));
        }
        return supplierMapper.selectByExample(example);
    }


    @Override
    public ReagentSupplier getItem(Long id) {
        return supplierMapper.selectByPrimaryKey(id);
    }

    @Override
    public String[] getPhonesNumBySuppliersID(List<String> suppliersID) {
        return supplierDao.getPhonesBySuppliersID(suppliersID);
    }

    @Override
    public Long getSupplierIdByPhoneNumber(String phoneNumber) {
        ReagentSupplierExample example = new ReagentSupplierExample();
        ReagentSupplierExample.Criteria criteria = example.createCriteria();

        criteria.andContactsPhoneEqualTo(phoneNumber);

        List<ReagentSupplier> result = supplierMapper.selectByExample(example);

        if (result.size() > 0) {
            return result.get(0).getId();
        } else {
            return null;
        }
    }

    @Override
    public String getSupplierCodeByPhoneNumber(String phoneNumber) {
        ReagentSupplierExample example = new ReagentSupplierExample();
        ReagentSupplierExample.Criteria criteria = example.createCriteria();

        criteria.andContactsPhoneEqualTo(phoneNumber);

        List<ReagentSupplier> result = supplierMapper.selectByExample(example);

        if (result.size() > 0) {
            return result.get(0).getSupplierCode();
        } else {
            return null;
        }
    }

}
