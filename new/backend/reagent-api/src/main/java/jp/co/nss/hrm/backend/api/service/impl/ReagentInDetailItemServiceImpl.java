package jp.co.nss.hrm.backend.api.service.impl;

import com.github.pagehelper.PageHelper;
import jp.co.nss.hrm.backend.api.dao.ReagentInDetailItemDao;
import jp.co.nss.hrm.backend.api.service.ReagentInBillItemService;
import jp.co.nss.hrm.backend.mapper.ReagentInDetailItemMapper;
import jp.co.nss.hrm.backend.model.ReagentInDetailItem;
import jp.co.nss.hrm.backend.model.ReagentInDetailItemExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReagentInDetailItemServiceImpl implements ReagentInBillItemService {


    @Autowired
    private ReagentInDetailItemMapper inDetailItemMapper;
    @Autowired
    private ReagentInDetailItemDao inDetailItemDao;


    /**
     * 根据入库单号获取入库单详细信息
     *
     * @param inDetailId
     */
    @Override
    public List<ReagentInDetailItem> getInBillItem(String inDetailId) {
        return inDetailItemDao.selectByInDetailId(inDetailId);
    }

    @Override
    public int delete(List<String> billCodes) {
        ReagentInDetailItemExample example = new ReagentInDetailItemExample();
        example.createCriteria().andBillCodeIn(billCodes);
        int count = inDetailItemMapper.deleteByExample(example);
        return count;
    }

    /**
     * 分页获取订单详细信息
     *
     * @param keyword
     * @param pageSize
     * @param pageNum
     */
    @Override
    public List<ReagentInDetailItem> list(String keyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        return inDetailItemDao.selectByInDetailId(keyword);
    }
}


