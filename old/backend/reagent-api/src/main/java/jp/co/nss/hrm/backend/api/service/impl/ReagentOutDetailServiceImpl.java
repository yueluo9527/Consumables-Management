package jp.co.nss.hrm.backend.api.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jp.co.nss.hrm.backend.api.dao.ReagentAdminDao;
import jp.co.nss.hrm.backend.api.dao.ReagentAdminRoleRelationDao;
import jp.co.nss.hrm.backend.api.dao.ReagentOutDetailDao;
import jp.co.nss.hrm.backend.api.service.ReagentOutDetailService;
import jp.co.nss.hrm.backend.mapper.ReagentOutDetailMapper;
import jp.co.nss.hrm.backend.model.ReagentOutDetail;
import jp.co.nss.hrm.backend.model.ReagentOutDetailExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReagentOutDetailServiceImpl implements ReagentOutDetailService {
    @Autowired
    private ReagentOutDetailMapper outDetailMapper;
    @Autowired
    private ReagentOutDetailDao outDetailDao;
    @Autowired
    private ReagentAdminDao adminDao;
    @Autowired
    private ReagentAdminRoleRelationDao adminRoleDao;

    /**
     * 根据出库编号获取出库详细信息
     *
     * @param billCode
     */
    @Override
    public List<ReagentOutDetail> getItem(String billCode) {

        return outDetailDao.selectByBillCode(billCode);
    }

    @Override
    public int delete(List<String> billCodes) {
        ReagentOutDetailExample example = new ReagentOutDetailExample();
        example.createCriteria().andBillCodeIn(billCodes);
        int count = outDetailMapper.deleteByExample(example);
        return count;
    }

    @Override
    public List<ReagentOutDetail> list(String keyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        return outDetailDao.selectByBillCode(keyword);
    }

    /**
     * 试剂出库报表
     */
    @Override
    public PageInfo<ReagentOutDetail> outSummary(String username, String reagentName, String startTime, String endTime, Integer pageSize, Integer pageNum) {
        String branch = adminDao.selectBranch(username);

        List<ReagentOutDetail> outSummaryList = outDetailDao.outSummary(branch, reagentName, startTime, endTime);
        //创建Page类
        Page<ReagentOutDetail> page = new Page<>(pageNum, pageSize);
        int total;
        //为Page类中的total属性赋值
        total = outSummaryList.size();
        page.setTotal(total);
        //计算当前需要显示的数据下标起始值
        int startIndex = (pageNum - 1) * pageSize;
        int endIndex = Math.min(startIndex + pageSize, total);
        if (startIndex > endIndex) startIndex = 0;
        page.addAll(outSummaryList.subList(startIndex, endIndex));

        //以Page创建PageInfo
        return new PageInfo<>(page);
    }

}


