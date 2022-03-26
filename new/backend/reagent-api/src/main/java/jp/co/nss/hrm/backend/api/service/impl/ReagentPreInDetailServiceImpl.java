package jp.co.nss.hrm.backend.api.service.impl;

import com.github.pagehelper.PageHelper;
import jp.co.nss.hrm.backend.api.dao.ReagentPreInDetailDao;
import jp.co.nss.hrm.backend.api.dto.ReagentItem;
import jp.co.nss.hrm.backend.api.service.ReagentPreInDetailService;
import jp.co.nss.hrm.backend.mapper.ReagentPreInBillMapper;
import jp.co.nss.hrm.backend.mapper.ReagentPreInDetailMapper;
import jp.co.nss.hrm.backend.model.ReagentPreInBill;
import jp.co.nss.hrm.backend.model.ReagentPreInBillExample;
import jp.co.nss.hrm.backend.model.ReagentPreInDetail;
import jp.co.nss.hrm.backend.model.ReagentPreInDetailExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ReagentPreInDetailServiceImpl implements ReagentPreInDetailService {

    @Autowired
    private ReagentPreInDetailMapper preInDetailMapper;
    @Autowired
    private ReagentPreInBillMapper preInBillMapper;
    @Autowired
    private ReagentPreInDetailDao preInDetailDao;

    /**
     * 获取所有科预入库详细信息
     */
    @Override
    public List<ReagentPreInDetail> list() {

        return preInDetailMapper.selectByExample(new ReagentPreInDetailExample());
    }

    /**
     * 添加预入库详细信息
     *
     * @param preInDetail
     */
    @Override
    public int create(ReagentPreInDetail preInDetail) {

        preInDetail.setCreateTime(new Date());
        return preInDetailMapper.insert(preInDetail);
    }

    /**
     * 修改预入库详细信息
     *
     * @param id
     * @param preInDetail
     */
    @Override
    public int update(Long id, ReagentPreInDetail preInDetail) {
        preInDetail.setId(id);
        return preInDetailMapper.updateByPrimaryKeySelective(preInDetail);
    }

    /**
     * 批量删除预入库详细信息
     *
     * @param billCodes
     */

    @Override
    public int delete(List<String> billCodes) {
        ReagentPreInDetailExample example = new ReagentPreInDetailExample();
        example.createCriteria().andBillCodeIn(billCodes);
        int count = preInDetailMapper.deleteByExample(example);
        return count;
    }

    /**
     * 分页获取预入库详细信息
     *
     * @param keyword
     * @param pageSize
     * @param pageNum
     */
    @Override
    public List<ReagentPreInDetail> list(String keyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        return preInDetailDao.selectByBillCode(keyword);
    }

    @Override
    public List<ReagentItem> searchByBillCode(String keyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        List<ReagentItem> detailList;
        detailList = preInDetailDao.searchByBillCode(keyword);

        return detailList;
    }

    /**
     * 根据订单号获取预入库详细信息
     *
     * @param billCode
     */
    @Override
    public List<ReagentPreInDetail> getItem(String billCode) {
        return preInDetailDao.selectByBillCode(billCode);
    }

    @Override
    public ReagentPreInDetail getItem(Long id) {
        return preInDetailMapper.selectByPrimaryKey(id);
    }

    /**
     * 获取检验报告地址
     *
     * @param inDetailId
     */
    public String getReportPath(String inDetailId, int column) {
        String reportPath = null;
        switch (column) {
            case 0:
                ReagentPreInDetailExample preInDetailExample = new ReagentPreInDetailExample();
                preInDetailExample.createCriteria().andInDetailIdEqualTo(inDetailId);
                List<ReagentPreInDetail> preInDetails = preInDetailMapper.selectByExample(preInDetailExample);
                if (!preInDetails.isEmpty()) {
                    reportPath = preInDetails.get(0).getReportAddress();
                }
                break;
            case 1:
                ReagentPreInBillExample preInBillExample = new ReagentPreInBillExample();
                preInBillExample.createCriteria().andIdEqualTo(Long.valueOf(inDetailId));
                List<ReagentPreInBill> preInBills = preInBillMapper.selectByExample(preInBillExample);

                if (!preInBills.isEmpty()) {
                    reportPath = preInBills.get(0).getElectronicInvoice();
                }
                break;
        }

        return reportPath;
    }
}
