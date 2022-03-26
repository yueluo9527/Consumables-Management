package jp.co.nss.hrm.backend.api.service.impl;

import com.github.pagehelper.PageHelper;
import jp.co.nss.hrm.backend.api.dao.ReagentOutItemDao;
import jp.co.nss.hrm.backend.api.service.ReagentOutItemService;
import jp.co.nss.hrm.backend.mapper.ReagentOutDetailItemMapper;
import jp.co.nss.hrm.backend.mapper.ReagentStockItemMapper;
import jp.co.nss.hrm.backend.api.dto.ReagentOutDetailItem;
import jp.co.nss.hrm.backend.model.ReagentOutDetailItemExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReagentOutItemServiceImpl implements ReagentOutItemService {


    @Autowired
    private ReagentOutDetailItemMapper outDetailItemMapper;
    @Autowired
    private ReagentOutItemDao outDetailItemDao;

    @Autowired
    private ReagentStockItemMapper stockItemMapper;


    /**
     * 根据出库号获取出库详细信息
     *
     * @param outDetailId
     */
    @Override
    public List<ReagentOutDetailItem> getItem(String outDetailId) {
        return outDetailItemDao.selectByOutDetailId(outDetailId);
    }

    @Override
    public int delete(List<String> billCodes) {
        ReagentOutDetailItemExample example = new ReagentOutDetailItemExample();
        example.createCriteria().andBillCodeIn(billCodes);
        int count = outDetailItemMapper.deleteByExample(example);
        return count;
    }


    @Override
    public List<ReagentOutDetailItem> list(String keyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        return outDetailItemDao.selectByOutDetailId(keyword);
    }

}


