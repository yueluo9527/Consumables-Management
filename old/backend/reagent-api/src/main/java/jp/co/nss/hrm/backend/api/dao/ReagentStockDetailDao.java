package jp.co.nss.hrm.backend.api.dao;

import jp.co.nss.hrm.backend.api.dto.*;
import jp.co.nss.hrm.backend.model.ReagentStock;
import jp.co.nss.hrm.backend.model.ReagentStockDetail;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * 库存详细信息管理Dao
 * Created by macro on 2021/3/8.
 */
public interface ReagentStockDetailDao {

    int updateRemainDay(@Param("id") Long id, @Param("remainDay") int remainDay);

    String countBatchNo(@Param("reagentId") String reagentId, @Param("batchNo") String batchNo);

    List<ReagentStockDetail> selectAll();

    List<ReagentEcharts> chartPie(@Param("stockType") String stockType, @Param("branch") String branch);

    List<ReagentEcharts> chartBar(@Param("stockType") String stockType, @Param("branch") String branch);

    List<ReagentEcharts> chartBarTop(@Param("outType") String outType, @Param("branch") String branch);

    /**
     * 根据库存编号获取库存详细信息第二层
     */
    List<ReagentStockDetail> selectByStockNo(@Param("keyword") String keyword, @Param("reagentCode") String reagentCode,
                                             @Param("batchNo") String batchNo, @Param("expireDate") String expireDate,
                                             @Param("enterTime") String enterTime, @Param("enterNo") String enterNo,
                                             @Param("enterMan") String enterMan, @Param("applyMan") String applyMan,
                                             @Param("outTime") String outTime, @Param("outNo") String outNo,
                                             @Param("outMan") String outMan, @Param("branch") String branch);

    /**
     * 根据库存编号获取库存详细信息第二层
     */
    List<ReagentStockDetail> fetchSearch(@Param("reagentCode") String reagentCode,
                                         @Param("batchNo") String batchNo, @Param("expireDate") String expireDate,
                                         @Param("enterTime") String enterTime, @Param("enterNo") String enterNo,
                                         @Param("enterMan") String enterMan, @Param("applyMan") String applyMan,
                                         @Param("outTime") String outTime, @Param("outNo") String outNo,
                                         @Param("outMan") String outMan, @Param("reagentName") String reagentName,
                                         @Param("manufacturerName") String manufacturerName, @Param("supplierShortName") String supplierShortName,
                                         @Param("reagentStatus") String reagentStatus, @Param("reagentTemp") String reagentTemp,
                                         @Param("branch") String branch);

    List<ReagentStockDetail> selectLoss(@Param("reagentId") String reagentId, @Param("branch") String branch, @Param("reagentStatus") String reagentStatus);

    List<ReagentLossSummary> lossSummary(@Param("keyword") String keyword, @Param("branch") String branch);


    /**
     * 批量插入
     */
    int insertStockDetail(List<ReagentStockDetail> reagentStockDetailList);

    /**
     * 根据库存编号修改库存数量
     */
    int deleteDetailByQuantity(@Param("stockNo") String stockNo, @Param("quantity") Integer quantity);

    ReagentStockDetail selectQrcode(@Param("stockNo") String stockNo, @Param("reagentId") String reagentId);

    int updateStatus(@Param("qrCode") String qrCode, @Param("lossId") String lossId);

    /**
     * 查找库存编号
     */
    String searchStockNo(@Param("qrCode") String qrCode);

    /**
     * 查找二维码数据
     */
    String searchCodeValue(@Param("qrCode") String qrCode);

    /**
     * PDA批量更新库损状态
     */
    int updateFetchStatus(@Param("statusType") String statusType, List<String> qrList, String collectNo);

    /**
     * PDA批量更新领用人
     */
    int updateApplyMan(@Param("applyMan") String applyMan, List<String> qrList);

    /**
     * PDA批量更新出库信息
     */
    int updateOutInfo(@Param("adminId") Long adminId, @Param("outMan") String outMan, @Param("outTime") Date outTime, List<String> qrList);

    /**
     * PDA移库操作更新库存科室名称
     */
    int updateFetchBranch(@Param("branch") String branch, List<String> qrList);

    /**
     * PDA在库检索信息
     */
    ReagentItem findReagentItem(@Param("qrCode") String qrCode);

    /**
     * 获取当前用户库存中可用的 早于某个试剂 过期的数组
     *
     * @param reagent  要查询的试剂数据
     * @param branch   科室名
     * @param applyMan 操作员
     * @return 早于指定试剂过期的试剂数组
     */
    List<ReagentItem> getReagentEarlier(@Param("reagent") ReagentItem reagent,
                                        @Param("branch") String branch,
                                        @Param("applyMan") String applyMan);

    /**
     * 库损报表
     */
    List<ReagentStatus> countStatus(@Param("stockType") String stockType, @Param("branch") String branch, @Param("startTime") String startTime, @Param("endTime") String endTime);

    /**
     * 出入库报表
     */
    List<ReagentStatus> countOutIn(@Param("stockType") String stockType, @Param("startTime") String startTime, @Param("endTime") String endTime);

    /**
     * 判断试剂信息是否在库
     */
    List<String> isInStock(@Param("code") Long code);

    /**
     * 判断供应商对应的试剂信息是否在库
     */
    List<String> isSupInStock(@Param("shortName") String shortName);

    /**
     * 根据移库单号查询试剂二维码
     */
    List<String> getQrCodeByCN(@Param("collectNo") String collectNo);

    /**
     * 根据移库单号查询试剂二维码
     */
    List<ReagentCollectMess> getReloList(@Param("collectNo") String collectNo);

    /**
     * 根据移库单号，试剂id，批号查询试剂二维码，二维码值，试剂编号
     */
    List<ReagentCollectMess> searchThreeValue(@Param("collectNo") String collectNo, @Param("reagentId") String reagentId, @Param("batchNo") String batchNo);

    /**
     * 根据试剂编号查询在库数量
     */
    int searchInStockNum(@Param("reagentCode") String reagentCode, @Param("branch") String branch, @Param("stockType") String stockType);

    Date findMinDate(@Param("stockNo") String stockNo, @Param("branch") String branch);


    /**
     * 获取试剂操作员名下的试剂
     *
     * @param stockType     type
     * @param username      user
     * @param reagentStatus status
     * @return List<ReagentStock>
     */
    List<ReagentStock> selectByOperator(String stockType, String username, String branch, String reagentStatus);

    /**
     * 更新单个试剂的开启有效期
     *
     * @param adminId Long
     * @param days    int 天数
     * @param qrcode  String 二维码
     * @return int
     */
    int updateEffectiveOpenTime(Long adminId, int days, String qrcode);

    /**
     * 试剂终结时更新其设备字段
     *
     * @param qrcode   String   试剂二维码
     * @param deviceId Long     设备id
     * @param userId   Long     上机人
     * @param timeNow  Date     使用时间
     */
    int updateDeviceInfo(String qrcode, Long deviceId, Long userId, Date timeNow);

    /**
     * 试剂使用记录报表
     */
    List<ReagentDetailReq> reagentUseLog(@Param("keyword") String keyword, @Param("branch") String branch, @Param("reagentName") String reagentName, @Param("startTime") String startTime, @Param("endTime") String endTime);

    String getMoneyCount(@Param("branch") String branch);

    List<ReagentStock> reagentOverall(@Param("branchName") String branchName, @Param("supplier") String supplier, @Param("reagentName") String reagentName, @Param("startTime") String startTime, @Param("endTime") String endTime);

    /**
     * 获取科室库同类型试剂数量
     */
    int getDeptStockNumberByReagentId(long reagentId);

}
