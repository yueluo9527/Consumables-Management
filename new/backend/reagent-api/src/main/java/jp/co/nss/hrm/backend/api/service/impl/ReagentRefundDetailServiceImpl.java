package jp.co.nss.hrm.backend.api.service.impl;

import com.github.pagehelper.PageHelper;
import jp.co.nss.hrm.backend.api.dao.ReagentRefundDetailDao;
import jp.co.nss.hrm.backend.api.service.ReagentRefundDetailService;
import jp.co.nss.hrm.backend.mapper.ReagentRefundDetailMapper;
import jp.co.nss.hrm.backend.model.ReagentRefundDetail;
import jp.co.nss.hrm.backend.model.ReagentRefundDetailExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReagentRefundDetailServiceImpl implements ReagentRefundDetailService {

    @Autowired
    private ReagentRefundDetailMapper refundDetailMapper;
    @Autowired
    private ReagentRefundDetailDao refundDetailDao;

    /**
     * 获取所有领用详细信息
     */
    @Override
    public List<ReagentRefundDetail> list() {

        return refundDetailMapper.selectByExample(new ReagentRefundDetailExample());
    }

    /**
     * 添加领用详细信息
     *
     * @param refund
     */
    @Override
    public int create(ReagentRefundDetail refund) {

        refund.setCreateTime(new Date());
        return refundDetailMapper.insert(refund);
    }

    /**
     * 修改领用详细信息
     *
     * @param refund
     */
    @Override
    public int update(ReagentRefundDetail refund) {

        return refundDetailMapper.updateByPrimaryKeySelective(refund);
    }

    /**
     * 级联删除领用详细信息
     *
     * @param refundCodes
     */

    @Override
    public int delete(List<String> refundCodes) {
        ReagentRefundDetailExample example = new ReagentRefundDetailExample();
        example.createCriteria().andRefundCodeIn(refundCodes);
        int count = refundDetailMapper.deleteByExample(example);
        return count;
    }

    /**
     * 删除指定领用详情
     */

    @Override
    public int delete(Long id) {
        int count = refundDetailMapper.deleteByPrimaryKey(id);
        return count;
    }

    /**
     * 分页获取领用详细信息
     *
     * @param keyword
     * @param pageSize
     * @param pageNum
     */
    @Override
    public List<ReagentRefundDetail> list(String keyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        return refundDetailDao.selectByRefundCode(keyword);
    }

    /**
     * 根据领用号获取领用详细信息
     *
     * @param refundCode
     */
    @Override
    public List<ReagentRefundDetail> getItem(String refundCode) {

        return refundDetailDao.selectByRefundCode(refundCode);
    }

    @Override
    public ReagentRefundDetail getItem(Long id) {

        return refundDetailMapper.selectByPrimaryKey(id);
    }

}
