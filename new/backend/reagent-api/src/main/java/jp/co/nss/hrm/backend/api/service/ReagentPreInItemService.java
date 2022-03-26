package jp.co.nss.hrm.backend.api.service;

import jp.co.nss.hrm.backend.api.dto.ReagentPreInItem;
import jp.co.nss.hrm.backend.model.ReagentPreInDetailItem;

import java.util.List;

public interface ReagentPreInItemService {

    List<ReagentPreInDetailItem> getItemByID(String inDetailId);

    List<ReagentPreInDetailItem> getItemByBC(String billCode);

    /**
     * 通过二维码查询试剂数据
     */
    ReagentPreInItem getPreItemByQrcode(String qrCode);

    /**
     * 组合查询
     */
    List<ReagentPreInDetailItem> search(String billCode, String inDetailId, Integer pageSize, Integer pageNum);

    /**
     * 删除指定订单详细信息
     */
    int delete(List<String> billCodes);

    List<ReagentPreInDetailItem> list(String keyword, Integer pageSize, Integer pageNum);
}


