package jp.co.nss.hrm.backend.api.service;

import jp.co.nss.hrm.backend.api.dto.ReagentItem;
import jp.co.nss.hrm.backend.model.ReagentPreInDetail;

import java.util.List;

public interface ReagentPreInDetailService {

    List<ReagentPreInDetail> getItem(String billCode);

    ReagentPreInDetail getItem(Long id);

    /**
     * 获取所有预入库详细信息列表
     */

    List<ReagentPreInDetail> list();

    /**
     * 添加预入库详细信息
     */
    int create(ReagentPreInDetail preInDetail);

    /**
     * 修改预入库详细信息
     */
    int update(Long id, ReagentPreInDetail preInDetail);

    /**
     * 删除指定预入库详细信息
     */
    int delete(List<String> billCodes);

    /**
     * 分页获取预入库详细信息
     */
    List<ReagentPreInDetail> list(String keyword, Integer pageSize, Integer pageNum);

    List<ReagentItem> searchByBillCode(String keyword, Integer pageSize, Integer pageNum);

    String getReportPath(String keyword, int column);
}


