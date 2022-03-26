package jp.co.nss.hrm.backend.api.service.impl;

import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import jp.co.nss.hrm.backend.api.service.ReagentResourceService;
import jp.co.nss.hrm.backend.mapper.ReagentResourceMapper;
import jp.co.nss.hrm.backend.model.ReagentResource;
import jp.co.nss.hrm.backend.model.ReagentResourceExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 后台资源管理Service实现类
 * Created by macro on 2020/2/2.
 */
@Service
public class ReagentResourceServiceImpl implements ReagentResourceService {
    @Autowired
    private ReagentResourceMapper resourceMapper;
    @Override
    public int create(ReagentResource ReagentResource) {
        ReagentResource.setCreateTime(new Date());
        return resourceMapper.insert(ReagentResource);
    }

    @Override
    public int update(Long id, ReagentResource ReagentResource) {
        ReagentResource.setId(id);
        int count = resourceMapper.updateByPrimaryKeySelective(ReagentResource);
        return count;
    }

    @Override
    public ReagentResource getItem(Long id) {
        return resourceMapper.selectByPrimaryKey(id);
    }

    @Override
    public int delete(Long id) {
        int count = resourceMapper.deleteByPrimaryKey(id);
        return count;
    }

    @Override
    public List<ReagentResource> list(Long categoryId, String nameKeyword, String urlKeyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        ReagentResourceExample example = new ReagentResourceExample();
        ReagentResourceExample.Criteria criteria = example.createCriteria();
        if(categoryId!=null){
            criteria.andCategoryIdEqualTo(categoryId);
        }
        if(StrUtil.isNotEmpty(nameKeyword)){
            criteria.andNameLike('%'+nameKeyword+'%');
        }
        if(StrUtil.isNotEmpty(urlKeyword)){
            criteria.andUrlLike('%'+urlKeyword+'%');
        }
        return resourceMapper.selectByExample(example);
    }

    @Override
    public List<ReagentResource> listAll() {
        return resourceMapper.selectByExample(new ReagentResourceExample());
    }
}
