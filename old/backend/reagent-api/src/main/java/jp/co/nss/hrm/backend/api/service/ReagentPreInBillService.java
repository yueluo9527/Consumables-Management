package jp.co.nss.hrm.backend.api.service;

import com.github.pagehelper.PageInfo;
import jp.co.nss.hrm.backend.api.dto.ReagentItem;
import jp.co.nss.hrm.backend.api.dto.ReagentPreInBillMess;
import jp.co.nss.hrm.backend.api.dto.ReagentPreInBillPost;
import jp.co.nss.hrm.backend.model.ReagentPreInBill;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ReagentPreInBillService {

    ReagentPreInBill getItem(Long id);

    /**
     * 获取所有预入库信息列表
     */

    List<ReagentPreInBill> list();

    /**
     * 添加预入库
     */
    int create(ReagentPreInBillPost preInBill);

    /**
     * 修改预入库信息
     */
    int update(Long id, ReagentPreInBill preInBill);

    /**
     * 删除指定预入库单汇总信息
     */
    int delete(List<Long> ids);

    /**
     * 分页获取预入库列表
     */
    PageInfo<ReagentPreInBill> list(String keyword, String username, Integer pageSize, Integer pageNum);

    /**
     * 获取部分打印所需数据
     */
    List<ReagentPreInBillMess> getPrintData(String keyword, String printType, String billType, Integer pageSize, Integer pageNum);

    /**
     * 根据预入库单状态查询
     */
    List<ReagentPreInBill> searchByBS(String billStatus, Integer pageSize, Integer pageNum);

    List<ReagentItem> searchCodeList(String billCode);

    /**
     * 导入质检报告单
     */
    String fileUpload(MultipartFile file, String inDetailId, int cell);
}


