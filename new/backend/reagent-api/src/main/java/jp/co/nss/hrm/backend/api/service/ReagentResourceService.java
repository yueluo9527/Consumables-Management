package jp.co.nss.hrm.backend.api.service;

import jp.co.nss.hrm.backend.model.ReagentResource;

import java.util.List;

/**
 * 后台资源管理Service
 * Created by macro on 2020/2/2.
 */
public interface ReagentResourceService {
    /**
     * 添加资源
     */
    int create(ReagentResource ReagentResource);

    /**
     * 修改资源
     */
    int update(Long id, ReagentResource ReagentResource);

    /**
     * 获取资源详情
     */
    ReagentResource getItem(Long id);

    /**
     * 删除资源
     */
    int delete(Long id);

    /**
     * 分页查询资源
     */
    List<ReagentResource> list(Long categoryId, String nameKeyword, String urlKeyword, Integer pageSize, Integer pageNum);

    /**
     * 查询全部资源
     */
    List<ReagentResource> listAll();
}
