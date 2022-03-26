package jp.co.nss.hrm.backend.api.service;

import jp.co.nss.hrm.backend.model.ReagentMenu;

import java.util.List;

/**
 * 后台按钮管理Service
 * Created by macro on 2018/9/30.
 */
public interface ReagentMenuService {

    /**
     * 获取所有按钮列表
     */
    List<ReagentMenu> list(String username);
}
