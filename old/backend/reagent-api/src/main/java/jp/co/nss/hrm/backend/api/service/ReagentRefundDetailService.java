package jp.co.nss.hrm.backend.api.service;

import jp.co.nss.hrm.backend.model.ReagentRefundDetail;
import java.util.List;

public interface ReagentRefundDetailService {

    List<ReagentRefundDetail> getItem(String refundCode);

    ReagentRefundDetail getItem(Long id);

    /**
     * 获取所有领用详细信息列表
     */

    List<ReagentRefundDetail> list();

    /**
     * 添加领用详细信息
     */
    int create(ReagentRefundDetail refundDetail);

    /**
     * 修改领用详细信息
     */
    int update(ReagentRefundDetail refundDetail);

    /**
     * 删除指定领用详细信息
     */
    int delete(List<String> refundCodes);

    /**
     * 删除指定领用详细信息
     */
    int delete(Long id);

    /**
     * 分页获取领用详细信息
     */
    List<ReagentRefundDetail> list(String keyword, Integer pageSize, Integer pageNum);

}


