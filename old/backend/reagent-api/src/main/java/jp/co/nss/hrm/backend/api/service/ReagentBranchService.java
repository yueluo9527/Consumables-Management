package jp.co.nss.hrm.backend.api.service;

import jp.co.nss.hrm.backend.model.ReagentBranch;
import java.util.List;

public interface ReagentBranchService {
    /**
     * 根据科室名称获取
     */
    List<ReagentBranch> getAllByBranchName(String branchName);

    ReagentBranch getItem(Long id);

    /**
     * 获取所有科室列表
     */

    List<ReagentBranch> list();

    /**
     * 添加科室
     */
    int create(ReagentBranch branch);

    /**
     * 修改科室信息
     */
    int update(Long id, ReagentBranch branch);

    /**
     * 删除指定用户
     */
    int delete(Long id);

    /**
     * 分页获取科室列表
     */
    List<ReagentBranch> list(String keyword, Integer pageSize, Integer pageNum);
}
