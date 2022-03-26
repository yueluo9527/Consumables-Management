package jp.co.nss.hrm.backend.api.service.impl;

import com.github.pagehelper.PageHelper;
import jp.co.nss.hrm.backend.api.dao.ReagentSearchDao;
import jp.co.nss.hrm.backend.api.service.ReagentSearchService;
import jp.co.nss.hrm.backend.mapper.ReagentSearchMapper;
import jp.co.nss.hrm.backend.model.ReagentSearch;
import jp.co.nss.hrm.backend.model.ReagentSearchExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class ReagentSearchServiceImpl implements ReagentSearchService {
    @Autowired
    private ReagentSearchMapper searchMapper;
    @Autowired
    private ReagentSearchDao searchDao;

    /**
     * 获取所有库存列表
     */
    @Override
    public List<ReagentSearch> list() {

        return searchMapper.selectByExample(new ReagentSearchExample());
    }

    /**
     * 添加科室findReagentItem
     *
     * @param search
     */
    @Override
    public int create(ReagentSearch search) {
        return searchMapper.insert(search);
    }

    /**
     * 修改库存信息
     *
     * @param id
     * @param search
     */
    @Override
    public int update(Long id, ReagentSearch search) {
        search.setId(id);
        return searchMapper.updateByPrimaryKeySelective(search);
    }

    /**
     * 删除指定库存
     */

    @Override
    public int delete(Long id) {
        int count = searchMapper.deleteByPrimaryKey(id);
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
    public List<ReagentSearch> list(String keyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        ReagentSearchExample example = new ReagentSearchExample();
        ReagentSearchExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(keyword)) {
            criteria.andGroupnameLike("%" + keyword + "%");
            example.or(example.createCriteria().andKindLike("%" + keyword + "%"));
        }
        return searchMapper.selectByExample(example);
    }

    @Override
    public List<ReagentSearch> search(String key1, String key2) {

        return searchDao.searchByDouble(key1, key2);
    }

    @Override
    public ReagentSearch getItem(Long id) {
        return searchMapper.selectByPrimaryKey(id);
    }

}

