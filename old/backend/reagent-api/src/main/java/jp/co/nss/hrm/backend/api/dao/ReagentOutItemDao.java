package jp.co.nss.hrm.backend.api.dao;

import jp.co.nss.hrm.backend.api.dto.ReagentOutDetailItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReagentOutItemDao {

    /**
     * 根据角出库编号获取出库订单详细信息
     */
    List<ReagentOutDetailItem> selectByOutDetailId(@Param("keyword") String keyword);


    /**
     * 批量插入
     */
    int insertItem(List<ReagentOutDetailItem> outDetailItemList);



}
