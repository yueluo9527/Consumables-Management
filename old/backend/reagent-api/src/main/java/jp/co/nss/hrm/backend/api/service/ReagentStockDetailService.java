package jp.co.nss.hrm.backend.api.service;

import com.github.pagehelper.PageInfo;
import jp.co.nss.hrm.backend.api.dto.*;
import jp.co.nss.hrm.backend.model.ReagentStock;
import jp.co.nss.hrm.backend.model.ReagentStockDetail;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ReagentStockDetailService {

    //List<ReagentStockDetail> getItem(String stockNo);

    //ReagentStockDetail getItem(Long id);


    List<ReagentLossSummary> lossSummary(String keyword, String username, Integer pageSize, Integer pageNum);


    /**
     * 获取所有库存详细信息列表
     */

    List<ReagentStockDetail> list();

    /**
     * 添加库存详细信息
     */
    int create(ReagentStockDetail stockDetail);

    /**
     * 修改库存详细信息
     */
    int update(Long id, ReagentStockDetail stockDetail);

    /**
     * 删除指定库存详细信息
     */
    int delete(Long allocId);

    /**
     * 判断试剂信息是否在库
     */
    String isInStock(Long code);

    /**
     * 判断供货商对应试剂信息是否在库
     */
    String isSupInStock(String shortName);

    /**
     * 分页获取库存详细信息
     */
    List<ReagentStockDetail> list(ReagentStockDetailReq stockDetailReq);

    List<ReagentStockDetail> fetchSearch(ReagentStockDetailReq stockDetailReq);

    List<ReagentStockDetail> lossList(String reagentId, String reagentStatus, String username, Integer pageSize, Integer pageNum);

    /**
     * 修改试剂库损情况
     */
    @Transactional
    int updateStatus(String qrcode, String lossId);

    /**
     * PDA批量更新库损状态
     */
    int updateStatusList(ReagentStockReqPost stockLoss);

    /**
     * 试剂查询
     */
    GetReagentItem findReagentItem(String qrCode, String username, String isMore);

    /**
     * 获取当前用户库存中可用的 早于某个试剂 过期的数组
     *
     * @param reagent
     * @param username
     * @return
     */
    List<ReagentItem> getReagentEarlier(ReagentItem reagent, String username);


    /**
     * 库损报表
     */

    List<ReagentStatus> lossCount(String username, String startTime, String endTime, Integer pageSize, Integer pageNum);

    /**
     * 出入库报表
     */

    List<ReagentStatus> countOutIn(String username, String supplier, String startTime, String endTime, Integer pageSize, Integer pageNum);

    /**
     * 试剂出入库报表
     */
    PageInfo<ReagentOutIn> reagentOutIn(String username, String supplier, String reagentName, String branchName, String startTime, String endTime, Integer pageSize, Integer pageNum);

    /**
     * 试剂总和报表
     */
    PageInfo<ReagentStock> reagentOverall(String username, String supplier, String reagentName, String branchName, String startTime, String endTime, Integer pageSize, Integer pageNum);


    /**
     * 试剂使用记录报表
     */
    PageInfo<ReagentDetailReq> reagentUseLog(String username, String keyword, String reagentName, String startTime, String endTime, Integer pageSize, Integer pageNum);

    /**
     * 试剂终结
     */
    int endReagent(ReagentStockReqPost stockEnd);

    /**
     * 获取试剂操作员名下的试剂
     *
     * @param username 用户名
     * @return List<ReagentStock>
     */
    List<ReagentStock> getOperatorList(String username, String stockType);

    /**
     * 更新单个试剂的开启有效期
     *
     * @param username String
     * @param days     String
     * @param qrcode   String
     * @return int
     */
    int updateEffectiveOpenTime(String username, String days, String qrcode);

    /**
     * 设备开始上机使用，更新设备字段
     *
     * @param qrcode   试剂二维码
     * @param deviceId 设备ID
     * @param userId   用户ID
     */
    int updateDevice(String qrcode, Long deviceId, Long userId);

    /**
     * 获取科室库同类型试剂的数量
     */
    int getDeptStockNumberByReagentId(long reagentId);
}
