package jp.co.nss.hrm.backend.api.service.impl;

import jp.co.nss.hrm.backend.api.dao.ReagentAdminDao;
import jp.co.nss.hrm.backend.api.dao.ReagentAdminRoleRelationDao;
import jp.co.nss.hrm.backend.api.service.ReagentMenuService;
import jp.co.nss.hrm.backend.mapper.ReagentMenuMapper;
import jp.co.nss.hrm.backend.model.ReagentMenu;
import jp.co.nss.hrm.backend.model.ReagentMenuExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 后台资源管理Service实现类
 * Created by macro on 2020/2/2.
 */
@Service
public class ReagentMenuServiceImpl implements ReagentMenuService {
    @Autowired
    private ReagentMenuMapper menuMapper;
    @Autowired
    private ReagentAdminDao adminDao;
    @Autowired
    private ReagentAdminRoleRelationDao adminRoleDao;

    @Override
    public List<ReagentMenu> list(String username) {
        Long adminId = adminDao.selectByUser(username);
        Long roleId = adminRoleDao.selectByAdmin(adminId);
        List<ReagentMenu> reagentMenuAll = menuMapper.selectByExample(new ReagentMenuExample());
        List<ReagentMenu> reagentMenuList = new ArrayList<>();
        List<Long> menuOneList = new ArrayList<>();
        List<Long> menuTwoList = new ArrayList<>();
        Collections.addAll(menuOneList, 3L, 4L, 5L, 9L, 10L, 11L, 12L, 14L, 15L, 16L, 18L, 19L, 20L,
                21L, 30L, 34L, 35L, 38L, 39L, 51L, 56L, 57L, 60L, 61L, 63L, 64L, 65L, 66L, 67L, 68L, 69L, 70L, 71L, 72L,
                73L, 74L, 75L);
        Collections.addAll(menuTwoList, 3L, 4L, 5L, 8L, 9L, 10L, 11L, 12L, 14L, 16L, 17L, 18L, 19L, 20L, 22L,
                30L, 31L, 34L, 36L, 38L, 40L, 41L, 42L, 47L, 49L, 52L, 53L, 54L, 56L, 58L, 59L, 60L, 61L, 62L, 63L, 64L,
                65L, 66L, 67L, 68L, 69L, 70L, 71L, 72L, 73L, 74L, 75L);

        if (roleId == 7) {
            for (ReagentMenu reagentMenu : reagentMenuAll) {
                if (menuOneList.contains(reagentMenu.getId())) {
                    reagentMenuList.add(reagentMenu);
                }
            }
            return reagentMenuList;
        } else if (roleId == 8) {
            for (ReagentMenu reagentMenu : reagentMenuAll) {
                if (menuTwoList.contains(reagentMenu.getId())) {
                    reagentMenuList.add(reagentMenu);
                }
            }
            return reagentMenuList;
        } else if (roleId == 1) {
            return reagentMenuAll;
        }
        return null;
    }
}
