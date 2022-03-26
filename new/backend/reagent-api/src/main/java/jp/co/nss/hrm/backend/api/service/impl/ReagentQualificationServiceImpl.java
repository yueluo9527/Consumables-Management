package jp.co.nss.hrm.backend.api.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jp.co.nss.hrm.backend.api.dao.ReagentAdminDao;
import jp.co.nss.hrm.backend.api.dao.ReagentAdminRoleRelationDao;
import jp.co.nss.hrm.backend.api.dao.ReagentProdQualificationDao;
import jp.co.nss.hrm.backend.api.service.ReagentQualificationService;
import jp.co.nss.hrm.backend.mapper.ReagentCopQualificationMapper;
import jp.co.nss.hrm.backend.mapper.ReagentProdQualificationMapper;
import jp.co.nss.hrm.backend.model.ReagentCopQualification;
import jp.co.nss.hrm.backend.model.ReagentCopQualificationExample;
import jp.co.nss.hrm.backend.model.ReagentProdQualification;
import jp.co.nss.hrm.backend.model.ReagentProdQualificationExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;

@Service
public class ReagentQualificationServiceImpl implements ReagentQualificationService {

    @Autowired
    private ReagentCopQualificationMapper copQualificationMapper;
    @Autowired
    private ReagentProdQualificationMapper prodQualificationMapper;
    @Autowired
    private ReagentAdminDao adminDao;
    @Autowired
    private ReagentProdQualificationDao qualificationDao;
    @Autowired
    private ReagentAdminRoleRelationDao adminRoleRelationDao;

    /**
     * 分页获取公司资质列表
     *
     * @param username
     * @param pageSize
     * @param pageNum
     */
    @Override
    public List<ReagentCopQualification> copList(String username, Integer pageSize, Integer pageNum) {
        String supplier = adminDao.selectSupplier(username);
        PageHelper.startPage(pageNum, pageSize);
        if (supplier != null && !supplier.equals("")) {
            //如果是供货商，只获得自己公司的公司资质信息
            ReagentCopQualificationExample copQualificationExample = new ReagentCopQualificationExample();
            copQualificationExample.createCriteria().andSupplierShortNameEqualTo(supplier);
            List<ReagentCopQualification> copQualificationList;
            copQualificationList = copQualificationMapper.selectByExample(copQualificationExample);
            return copQualificationList;
        } else {
            //如果是库管，获得该医院下所有公司的资质信息
            List<ReagentCopQualification> copQualificationList;
            copQualificationList = copQualificationMapper.selectByExample(new ReagentCopQualificationExample());
            return copQualificationList;
        }
    }

    /**
     * 分页获取产品资质列表
     */
    @Override
    public PageInfo<ReagentProdQualification> prodList(String username, String supplierShortName, String reagentName, Integer pageSize, Integer pageNum) {
        //创建Page类
        Page<ReagentProdQualification> page = new Page<>(pageNum, pageSize);
        int total;

        Long adminId = adminDao.selectByUser(username);
        Long roleId = adminRoleRelationDao.selectByAdmin(adminId);
        String userSupplier = adminDao.selectSupplier(username);
        String supplier = null;
        if (roleId == 5) {
            supplier = userSupplier;
        }
        //最终结果
        List<ReagentProdQualification> prodList = qualificationDao.prodList(supplier, supplierShortName, reagentName);

        //为Page类中的total属性赋值
        total = prodList.size();
        page.setTotal(total);
        //计算当前需要显示的数据下标起始值
        int startIndex = (pageNum - 1) * pageSize;
        int endIndex = Math.min(startIndex + pageSize, total);
        page.addAll(prodList.subList(startIndex, endIndex));
        //以Page创建PageInfo
        return new PageInfo<>(page);
    }

    /**
     * 导入信息
     */
    @Override
    public String fileUpload(MultipartFile file, long id, int cell, int flag) {
        String newFilePath = null;
        String filePath;
        try {
            String fileName = file.getOriginalFilename();
            if (flag == 0) {
                //服务器项目路径
                filePath = System.getProperty("user.dir") + File.separator + "web" + File.separator + "static" + File.separator + "prodQualificationFile";
                //本地项目路径
                //filePath = System.getProperty("user.dir") + File.separator + "frontend" + File.separator + "static" + File.separator + "prodQualificationFile";

                //服务器项目路径
                //newFilePath = File.separator + "static" + File.separator + "prodQualificationFile" + File.separator + fileName;
                //本地项目路径
                newFilePath = File.separator + "static" + File.separator + "prodQualificationFile" + File.separator + fileName;

                ReagentProdQualification prodQualification = new ReagentProdQualification();
                prodQualification.setUpdateTime(new Date());
                switch (cell) {
                    case 0:
                        prodQualification.setManufacturerBusinessLicense(newFilePath);
                        break;
                    case 1:
                        prodQualification.setDeviceProdLicense(newFilePath);
                        break;
                    case 2:
                        prodQualification.setEquipmentBusinessLicense(newFilePath);
                        break;
                    case 3:
                        prodQualification.setProductRegistrationForm(newFilePath);
                        break;
                    case 4:
                        prodQualification.setProductionRecordCertificate(newFilePath);
                        break;
                    case 5:
                        prodQualification.setDeviceRegistrationCertificate(newFilePath);
                        break;
                    case 6:
                        prodQualification.setOther(newFilePath);
                        break;
                }

                ReagentProdQualificationExample prodQualificationExample = new ReagentProdQualificationExample();
                prodQualificationExample.createCriteria().andIdEqualTo(id);

                prodQualificationMapper.updateByExampleSelective(prodQualification, prodQualificationExample);

            } else if (flag == 1) {
                //服务器项目路径
                filePath = System.getProperty("user.dir") + File.separator + "web" + File.separator + "static" + File.separator + "copQualificationFile";
                //本地项目路径
                //filePath = System.getProperty("user.dir") + File.separator + "frontend" + File.separator + "static" + File.separator + "copQualificationFile";

                //服务器项目路径
                //newFilePath = File.separator + "static" + File.separator + "copQualificationFile" + File.separator + fileName;
                //本地项目路径
                newFilePath = File.separator + "static" + File.separator + "copQualificationFile" + File.separator + fileName;

                ReagentCopQualification copQualification = new ReagentCopQualification();
                copQualification.setUpdateTime(new Date());
                switch (cell) {
                    case 0:
                        copQualification.setBusinessLicense(newFilePath);
                        break;
                    case 1:
                        copQualification.setMedicalEquipmentBusinessLicense(newFilePath);
                        break;
                    case 2:
                        copQualification.setLegalPersonPowerOfAttorney(newFilePath);
                        break;
                    case 3:
                        copQualification.setClientIdCard(newFilePath);
                        break;
                    case 4:
                        copQualification.setQualityAssuranceGreement(newFilePath);
                        break;
                    case 5:
                        copQualification.setOther(newFilePath);
                        break;
                }
                ReagentCopQualificationExample copQualificationExample = new ReagentCopQualificationExample();
                copQualificationExample.createCriteria().andIdEqualTo(id);
                copQualificationMapper.updateByExampleSelective(copQualification, copQualificationExample);

            } else {
                return null;
            }

            //将文件路径写入到表中
            uploadFile(file.getBytes(), filePath, fileName);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return newFilePath;
    }

    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            boolean wasSuccessful = targetFile.mkdirs();
            System.out.println("wasSuccessful:" + wasSuccessful);
        }
        filePath += File.separator;
        FileOutputStream out = new FileOutputStream(filePath + fileName);
        out.write(file);
        out.flush();
        out.close();
    }

    /**
     * 获取检验报告地址
     */
    public String getReportPath(long row, int column, int flag) {
        String reportPath = null;
        if (flag == 0) {
            ReagentProdQualificationExample prodQualificationExample = new ReagentProdQualificationExample();
            prodQualificationExample.createCriteria().andIdEqualTo(row);
            List<ReagentProdQualification> prodQualifications = prodQualificationMapper.selectByExample(prodQualificationExample);
            if (!prodQualifications.isEmpty()) {
                switch (column) {
                    case 0:
                        reportPath = prodQualifications.get(0).getManufacturerBusinessLicense();
                        break;
                    case 1:
                        reportPath = prodQualifications.get(0).getDeviceProdLicense();
                        break;
                    case 2:
                        reportPath = prodQualifications.get(0).getEquipmentBusinessLicense();
                        break;
                    case 3:
                        reportPath = prodQualifications.get(0).getProductRegistrationForm();
                        break;
                    case 4:
                        reportPath = prodQualifications.get(0).getProductionRecordCertificate();
                        break;
                    case 5:
                        reportPath = prodQualifications.get(0).getDeviceRegistrationCertificate();
                        break;
                    case 6:
                        reportPath = prodQualifications.get(0).getOther();
                        break;
                }
            }
        } else if (flag == 1) {
            ReagentCopQualificationExample copQualificationExample = new ReagentCopQualificationExample();
            copQualificationExample.createCriteria().andIdEqualTo(row);
            List<ReagentCopQualification> copQualificationList = copQualificationMapper.selectByExample(copQualificationExample);
            if (!copQualificationList.isEmpty()) {
                switch (column) {
                    case 0:
                        reportPath = copQualificationList.get(0).getBusinessLicense();
                        break;
                    case 1:
                        reportPath = copQualificationList.get(0).getMedicalEquipmentBusinessLicense();
                        break;
                    case 2:
                        reportPath = copQualificationList.get(0).getLegalPersonPowerOfAttorney();
                        break;
                    case 3:
                        reportPath = copQualificationList.get(0).getClientIdCard();
                        break;
                    case 4:
                        reportPath = copQualificationList.get(0).getQualityAssuranceGreement();
                        break;
                }
            }
        } else {
            return null;
        }
        return reportPath;
    }
}
