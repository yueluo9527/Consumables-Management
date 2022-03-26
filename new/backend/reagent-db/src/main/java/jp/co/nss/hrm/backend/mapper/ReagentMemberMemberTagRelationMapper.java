package jp.co.nss.hrm.backend.mapper;

import java.util.List;
import jp.co.nss.hrm.backend.model.ReagentMemberMemberTagRelation;
import jp.co.nss.hrm.backend.model.ReagentMemberMemberTagRelationExample;
import org.apache.ibatis.annotations.Param;

public interface ReagentMemberMemberTagRelationMapper {
    long countByExample(ReagentMemberMemberTagRelationExample example);

    int deleteByExample(ReagentMemberMemberTagRelationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReagentMemberMemberTagRelation record);

    int insertSelective(ReagentMemberMemberTagRelation record);

    List<ReagentMemberMemberTagRelation> selectByExample(ReagentMemberMemberTagRelationExample example);

    ReagentMemberMemberTagRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReagentMemberMemberTagRelation record, @Param("example") ReagentMemberMemberTagRelationExample example);

    int updateByExample(@Param("record") ReagentMemberMemberTagRelation record, @Param("example") ReagentMemberMemberTagRelationExample example);

    int updateByPrimaryKeySelective(ReagentMemberMemberTagRelation record);

    int updateByPrimaryKey(ReagentMemberMemberTagRelation record);
}