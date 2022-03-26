package jp.co.nss.hrm.backend.api.service.impl;

import com.github.pagehelper.PageHelper;
import jp.co.nss.hrm.backend.api.dao.ReagentRefundDetailItemDao;
import jp.co.nss.hrm.backend.api.service.ReagentRefundItemService;
import jp.co.nss.hrm.backend.mapper.ReagentRefundDetailItemMapper;
import jp.co.nss.hrm.backend.model.ReagentRefundDetailItem;
import jp.co.nss.hrm.backend.model.ReagentRefundDetailItemExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReagentRefundDetailItemServiceImpl implements ReagentRefundItemService {


    @Autowired
    private ReagentRefundDetailItemDao refundItemDao;

    @Autowired
    private ReagentRefundDetailItemMapper refundItemMapper;

    /**
     * 根据预入库详情号获取订单详细信息
     *
     * @param refundDetailId
     */
    @Override
    public List<ReagentRefundDetailItem> getItemByRDI(String refundDetailId) {
        return refundItemDao.selectByRefundDetailId(refundDetailId);
    }

    /**
     * 根据预入库单号获取订单详细信息
     *
     * @param refundCode
     */
    @Override
    public List<ReagentRefundDetailItem> getItemByRC(String refundCode) {
        return refundItemDao.selectByRefundCode(refundCode);
    }

    /**
     * @param refundCode
     * @param refundDetailId
     * @return
     */
    @Override
    public List<ReagentRefundDetailItem> search(String refundCode, String refundDetailId, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        return refundItemDao.searchByDouble(refundCode, refundDetailId);
    }

    @Override
    public int delete(List<String> refundCodes) {
        ReagentRefundDetailItemExample example = new ReagentRefundDetailItemExample();
        example.createCriteria().andRefundCodeIn(refundCodes);
        int count = refundItemMapper.deleteByExample(example);
        return count;
    }


    @Override
    public List<ReagentRefundDetailItem> list(String keyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        return refundItemDao.selectByRefundDetailId(keyword);
    }
}


