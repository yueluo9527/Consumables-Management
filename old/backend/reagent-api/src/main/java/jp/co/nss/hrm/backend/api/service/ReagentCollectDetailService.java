package jp.co.nss.hrm.backend.api.service;

import jp.co.nss.hrm.backend.model.ReagentCollectDetail;

import java.util.List;

public interface ReagentCollectDetailService {

    List<ReagentCollectDetail> getItem(String collectNo);

    ReagentCollectDetail getItem(Long id);

    /**
     * 获取所有领用详细信息列表
     */

    List<ReagentCollectDetail> list();

    /**
     * 添加领用详细信息
     */
    int create(ReagentCollectDetail collectDetail);

    /**
     * 修改领用详细信息
     */
    int update(ReagentCollectDetail collectDetail);

    /**
     * 删除指定领用详细信息
     */
    int delete(List<String> collectNos);

    /**
     * 删除指定领用详细信息
     */
    int delete(Long id);

    /**
     * 分页获取领用详细信息
     */
    List<ReagentCollectDetail> list(String keyword, Integer pageSize, Integer pageNum);
}


