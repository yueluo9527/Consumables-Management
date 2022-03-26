package jp.co.nss.hrm.backend.api.dao;

import jp.co.nss.hrm.backend.model.ReagentCollectDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 领用信息管理Dao
 * Created by macro on 2020/3/31.
 */
public interface ReagentCollectDetailDao {

    /**
     * 根据角领用编号获取领用详细信息
     */
    List<ReagentCollectDetail> selectByCollectNo(@Param("keyword") String keyword);

    /**
     * 批量插入
     */
    int insertCollectDetail(List<ReagentCollectDetail> collectDetailList);

    /**
     * 移库时查询移库单中是否有已提交单据，用来锁库存
     */
    String getDetailNum(String reagentId);

}
