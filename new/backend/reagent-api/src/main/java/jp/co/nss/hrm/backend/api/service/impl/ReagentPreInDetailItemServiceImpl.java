package jp.co.nss.hrm.backend.api.service.impl;

import com.github.pagehelper.PageHelper;
import jp.co.nss.hrm.backend.api.dao.ReagentPreInDetailItemDao;
import jp.co.nss.hrm.backend.api.dao.ReagentStockDetailDao;
import jp.co.nss.hrm.backend.api.dto.ReagentPreInItem;
import jp.co.nss.hrm.backend.api.service.ReagentPreInItemService;
import jp.co.nss.hrm.backend.mapper.ReagentPreInDetailItemMapper;
import jp.co.nss.hrm.backend.model.ReagentPreInDetailItem;
import jp.co.nss.hrm.backend.model.ReagentPreInDetailItemExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReagentPreInDetailItemServiceImpl implements ReagentPreInItemService {

    @Autowired
    private ReagentPreInDetailItemDao preInItemDao;

    @Autowired
    private ReagentPreInDetailItemMapper preInItemMapper;

    @Autowired
    private ReagentStockDetailDao stockDetailDao;

    /**
     * 根据二维码获取试剂数据
     */
    @Override
    public ReagentPreInItem getPreItemByQrcode(String qrCode) {
        if(stockDetailDao.findReagentItem(qrCode) != null) return null;
        return preInItemDao.selectByInDetailQrcode(qrCode);
    }

    /**
     * 根据预入库详情号获取订单详细信息
     *
     * @param inDetailId
     */
    @Override
    public List<ReagentPreInDetailItem> getItemByID(String inDetailId) {
        return preInItemDao.selectByInDetailId(inDetailId);
    }

    /**
     * 根据预入库单号获取订单详细信息
     *
     * @param billCode
     */
    @Override
    public List<ReagentPreInDetailItem> getItemByBC(String billCode) {

        return preInItemDao.selectByBillCode(billCode);
    }

    /**
     * @param billCode
     * @param inDetailId
     * @return
     */
    @Override
    public List<ReagentPreInDetailItem> search(String billCode, String inDetailId, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        return preInItemDao.searchByDouble(billCode, inDetailId);
    }

    @Override
    public int delete(List<String> billCodes) {
        ReagentPreInDetailItemExample example = new ReagentPreInDetailItemExample();
        example.createCriteria().andBillCodeIn(billCodes);
        int count = preInItemMapper.deleteByExample(example);
        return count;
    }

    @Override
    public List<ReagentPreInDetailItem> list(String keyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        return preInItemDao.selectByInDetailId(keyword);
    }
}


