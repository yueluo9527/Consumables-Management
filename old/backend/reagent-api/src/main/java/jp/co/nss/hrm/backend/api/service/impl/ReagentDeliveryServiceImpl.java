package jp.co.nss.hrm.backend.api.service.impl;

import com.github.pagehelper.PageHelper;
import jp.co.nss.hrm.backend.api.service.ReagentDeliveryService;
import jp.co.nss.hrm.backend.mapper.ReagentOutBillMapper;
import jp.co.nss.hrm.backend.model.ReagentOutBill;
import jp.co.nss.hrm.backend.model.ReagentOutBillExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Service
public class ReagentDeliveryServiceImpl implements ReagentDeliveryService {


    @Autowired
    private ReagentOutBillMapper outBillMapper;
    /*@Autowired
    private ReagentDeliveryDao deliveryDao;*/


    /**
     * 获取所有库存列表
     */
    @Override
    public List<ReagentOutBill> list() {

        return outBillMapper.selectByExample(new ReagentOutBillExample());
    }

    /**
     * 添加科室
     *
     * @param delivery
     */
    @Override
    public int create(ReagentOutBill delivery) {

        delivery.setCreateTime(new Date());
        return outBillMapper.insert(delivery);
    }

    /**
     * 修改库存信息
     *
     * @param id
     * @param delivery
     */
    @Override
    public int update(Long id, ReagentOutBill delivery) {
        delivery.setId(id);
        return outBillMapper.updateByPrimaryKeySelective(delivery);
    }

    /**
     * 删除指定库存
     */

    @Override
    public int delete(Long id) {
        int count = outBillMapper.deleteByPrimaryKey(id);
        return count;
    }

    /**
     * 分页获取库存列表
     *
     * @param keyword
     * @param pageSize
     * @param pageNum
     */
    @Override
    public List<ReagentOutBill> list(String keyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        ReagentOutBillExample example = new ReagentOutBillExample();
        ReagentOutBillExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(keyword)) {
            criteria.andBillCodeEqualTo(keyword);
            example.or(example.createCriteria().andBillCreatorEqualTo("%" + keyword + "%"));
        }
        return outBillMapper.selectByExample(example);
    }


    @Override
    public ReagentOutBill getItem(Long id) {
        return outBillMapper.selectByPrimaryKey(id);
    }

    /*
    @Override
    public List<ReagentDelivery> search(Integer reagentId, String reagentName, String supplierName, String factory, String reagentStatus, String reagentTemp) {

        return stockCentreDao.searchByDouble(reagentId, reagentName, supplierName, factory, reagentStatus, reagentTemp);
    }*/

}

