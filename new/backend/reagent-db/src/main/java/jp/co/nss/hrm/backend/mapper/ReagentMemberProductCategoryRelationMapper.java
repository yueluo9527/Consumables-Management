package jp.co.nss.hrm.backend.mapper;

import java.util.List;
import jp.co.nss.hrm.backend.model.ReagentMemberProductCategoryRelation;
import jp.co.nss.hrm.backend.model.ReagentMemberProductCategoryRelationExample;
import org.apache.ibatis.annotations.Param;

public interface ReagentMemberProductCategoryRelationMapper {
    long countByExample(ReagentMemberProductCategoryRelationExample example);

    int deleteByExample(ReagentMemberProductCategoryRelationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReagentMemberProductCategoryRelation record);

    int insertSelective(ReagentMemberProductCategoryRelation record);

    List<ReagentMemberProductCategoryRelation> selectByExample(ReagentMemberProductCategoryRelationExample example);

    ReagentMemberProductCategoryRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReagentMemberProductCategoryRelation record, @Param("example") ReagentMemberProductCategoryRelationExample example);

    int updateByExample(@Param("record") ReagentMemberProductCategoryRelation record, @Param("example") ReagentMemberProductCategoryRelationExample example);

    int updateByPrimaryKeySelective(ReagentMemberProductCategoryRelation record);

    int updateByPrimaryKey(ReagentMemberProductCategoryRelation record);
}