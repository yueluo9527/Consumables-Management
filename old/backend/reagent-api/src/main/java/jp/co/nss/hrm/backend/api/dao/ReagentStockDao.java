package jp.co.nss.hrm.backend.api.dao;

import jp.co.nss.hrm.backend.api.dto.ReagentInfo;
import jp.co.nss.hrm.backend.api.dto.ReagentStockDetailReq;
import jp.co.nss.hrm.backend.api.dto.ReagentStockReqPost;
import jp.co.nss.hrm.backend.model.ReagentStock;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReagentStockDao {

    List<ReagentStock> selectAll();

    /**
     * 根据六条件查询中心库库存详细信息
     */

    List<ReagentStock> selectEcharts();

    /**
     * 批量插入
     */
    int insertStock(List<ReagentStock> reagentStockList);

    /**
     * 根据库存编号查找
     */
    List<ReagentStock> selectByStockNo(@Param("stockNo") String stockNo);

    /**
     * 根据试剂 billID 查找
     */
    ReagentStock selectByBillId(@Param("stockNo") String stockNo);

    /**
     * 根据试剂ID查找
     */
    List<ReagentStock> selectByReagentId(String reagentId);

    String stockCount();

    String stockCount(String stockType, String branch);

    List<ReagentStockReqPost> lowStockCount(String stockType, String branch);

    String overdueCount(String stockType, String branch);

    int updateOverdueStock(@Param("stockNo") String stockNo, @Param("overdueStock") int overdueStock);

    /**
     * 根据库存编号修改库存数量
     */
    int updateQBySN(@Param("stockNo") String stockNo, @Param("quantity") Integer quantity);

    List<ReagentInfo> getStockList(@Param("batchNo") String batchNo, @Param("qrCode") String qrCode);

    ReagentStock findReagentItem(@Param("qrCode") String qrCode);

    Long selectQuantity(@Param("stockNo") String stockNo);

    List<ReagentStock> selectByBranch(String stockType, String reagentName, String supplierName,
                                      String factory, String reagentTemp, String branch);

    List<ReagentStock> selectLow(String stockType, String reagentId,
                                 String reagentName, String supplierName, String branch);

    List<ReagentStock> selectOver(String stockType, String reagentId,
                                  String reagentName, String supplierName, String branch);


    List<ReagentStock> searchByDouble(String stockType, String reagentId, String reagentName, String supplierName,
                                      String factory, String reagentStatus, String reagentTemp);

    /**
     * 根据 stockNo 查找对应科室名的试剂数量
     *
     * @param branch
     * @param StockNo
     */
    String getDetailNum(@Param("stockNo") String StockNo, @Param("branch") String branch);

    String getDetailNumByOperator(@Param("stockNo") String stockNo, @Param("branch") String branch);

    String getDetailRemainDay(@Param("stockNo") String StockNo, @Param("branch") String branch);

    String getOverDueCount(String branch);

    String getBranchLowStockCount(String branch);

    String getCenterLowStockCount(String branch);

    String getBranchStockCount(String branch);

    String getCenterStockCount(String branch);

    /**
     * 获取试剂的详细数据-过期时间、批号
     *
     * @param stockNo
     * @return
     */
    ReagentInfo getDetailData(@Param("stockNo") String stockNo);

    List<ReagentStock> relocationList(@Param("stockType") String stockType, @Param("branch") String branch, @Param("keyword") String keyword);

    List<ReagentStockDetailReq> selectForPlace(@Param("branch") String branch);
}
