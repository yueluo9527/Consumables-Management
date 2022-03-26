package jp.co.nss.hrm.backend.mapper;

import java.util.List;
import jp.co.nss.hrm.backend.model.ReagentRoleMenuRelation;
import jp.co.nss.hrm.backend.model.ReagentRoleMenuRelationExample;
import org.apache.ibatis.annotations.Param;

public interface ReagentRoleMenuRelationMapper {
    long countByExample(ReagentRoleMenuRelationExample example);

    int deleteByExample(ReagentRoleMenuRelationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReagentRoleMenuRelation record);

    int insertSelective(ReagentRoleMenuRelation record);

    List<ReagentRoleMenuRelation> selectByExample(ReagentRoleMenuRelationExample example);

    ReagentRoleMenuRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReagentRoleMenuRelation record, @Param("example") ReagentRoleMenuRelationExample example);

    int updateByExample(@Param("record") ReagentRoleMenuRelation record, @Param("example") ReagentRoleMenuRelationExample example);

    int updateByPrimaryKeySelective(ReagentRoleMenuRelation record);

    int updateByPrimaryKey(ReagentRoleMenuRelation record);
}