package jp.co.nss.hrm.backend.mapper;

import java.util.List;
import jp.co.nss.hrm.backend.model.ReagentRoleResourceRelation;
import jp.co.nss.hrm.backend.model.ReagentRoleResourceRelationExample;
import org.apache.ibatis.annotations.Param;

public interface ReagentRoleResourceRelationMapper {
    long countByExample(ReagentRoleResourceRelationExample example);

    int deleteByExample(ReagentRoleResourceRelationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReagentRoleResourceRelation record);

    int insertSelective(ReagentRoleResourceRelation record);

    List<ReagentRoleResourceRelation> selectByExample(ReagentRoleResourceRelationExample example);

    ReagentRoleResourceRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReagentRoleResourceRelation record, @Param("example") ReagentRoleResourceRelationExample example);

    int updateByExample(@Param("record") ReagentRoleResourceRelation record, @Param("example") ReagentRoleResourceRelationExample example);

    int updateByPrimaryKeySelective(ReagentRoleResourceRelation record);

    int updateByPrimaryKey(ReagentRoleResourceRelation record);
}