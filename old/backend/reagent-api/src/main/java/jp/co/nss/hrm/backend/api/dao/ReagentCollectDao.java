package jp.co.nss.hrm.backend.api.dao;

import jp.co.nss.hrm.backend.api.dto.ReagentPreInBillMess;
import jp.co.nss.hrm.backend.api.dto.ReagentStatus;
import jp.co.nss.hrm.backend.model.ReagentCollect;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReagentCollectDao {


    List<ReagentPreInBillMess> getPrintData(@Param("keyword") String keyword);
    /**
     * 领用报表
     */
    List<ReagentStatus> countCollect(@Param("startTime") String startTime, @Param("endTime") String endTime);

    /**
     * 根据入库单类型获取预入库列表
     */
    List<ReagentCollect> getAllByApplyType(@Param("applyType") String applyType);

    /**
     * 根据入库单号修改入库单状态
     */
    int updateByCN(@Param("collectNo") String collectNo, @Param("collectStatus") String collectStatus);

    List<ReagentCollect> searchList(@Param("applyType") String applyType, @Param("keyword") String keyword);

    /**
     *
     * @param antiCollectStatus 反状态查询条件
     * @return List<ReagentCollect>
     */
    List<ReagentCollect> selectByBranch(@Param("applyType") String applyType,
                                        @Param("keyword") String keyword,
                                        @Param("branch") String branch,
                                        @Param("collectStatus") String collectStatus,
                                        @Param("antiCollectStatus") String antiCollectStatus);

}
