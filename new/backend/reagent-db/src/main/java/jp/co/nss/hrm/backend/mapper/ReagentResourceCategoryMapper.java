package jp.co.nss.hrm.backend.mapper;

import java.util.List;
import jp.co.nss.hrm.backend.model.ReagentResourceCategory;
import jp.co.nss.hrm.backend.model.ReagentResourceCategoryExample;
import org.apache.ibatis.annotations.Param;

public interface ReagentResourceCategoryMapper {
    long countByExample(ReagentResourceCategoryExample example);

    int deleteByExample(ReagentResourceCategoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReagentResourceCategory record);

    int insertSelective(ReagentResourceCategory record);

    List<ReagentResourceCategory> selectByExample(ReagentResourceCategoryExample example);

    ReagentResourceCategory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReagentResourceCategory record, @Param("example") ReagentResourceCategoryExample example);

    int updateByExample(@Param("record") ReagentResourceCategory record, @Param("example") ReagentResourceCategoryExample example);

    int updateByPrimaryKeySelective(ReagentResourceCategory record);

    int updateByPrimaryKey(ReagentResourceCategory record);
}