package jp.co.nss.hrm.backend.api.service;

import com.github.pagehelper.PageInfo;
import jp.co.nss.hrm.backend.model.ReagentCopQualification;
import jp.co.nss.hrm.backend.model.ReagentProdQualification;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ReagentQualificationService {

    /**
     * 分页获取公司资质列表
     */
    List<ReagentCopQualification> copList(String username, Integer pageSize, Integer pageNum);

    /**
     * 分页获取产品资质列表
     */
    PageInfo<ReagentProdQualification> prodList(String username, String supplierShortName, String reagentName, Integer pageSize, Integer pageNum);

    /**
     * 导入报告单
     */
    String fileUpload(MultipartFile file, long id, int cell, int flag);

    String getReportPath(long row, int column, int flag);
}

