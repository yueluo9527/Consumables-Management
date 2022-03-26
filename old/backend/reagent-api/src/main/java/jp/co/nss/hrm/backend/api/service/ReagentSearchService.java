package jp.co.nss.hrm.backend.api.service;


import jp.co.nss.hrm.backend.model.ReagentSearch;

import java.util.List;

public interface ReagentSearchService {



    ReagentSearch getItem(Long id);


    /**
     * 获取所有库存信息列表
     */

    List<ReagentSearch> list();

    /**
     * 添加库存信息
     */
    int create(ReagentSearch search);

    /**
     * 修改库存信息
     */
    int update(Long id, ReagentSearch search);

    /**
     * 删除指定库存
     */
    int delete(Long id);

    /**
     * 分页获取库存列表
     */
    List<ReagentSearch> list(String keyword, Integer pageSize, Integer pageNum);

    List<ReagentSearch> search(String key1,String key2);
}



