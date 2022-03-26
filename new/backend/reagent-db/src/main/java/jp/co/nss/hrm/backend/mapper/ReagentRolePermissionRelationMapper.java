package jp.co.nss.hrm.backend.mapper;

import java.util.List;
import jp.co.nss.hrm.backend.model.ReagentRolePermissionRelation;
import jp.co.nss.hrm.backend.model.ReagentRolePermissionRelationExample;
import org.apache.ibatis.annotations.Param;

public interface ReagentRolePermissionRelationMapper {
    long countByExample(ReagentRolePermissionRelationExample example);

    int deleteByExample(ReagentRolePermissionRelationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReagentRolePermissionRelation record);

    int insertSelective(ReagentRolePermissionRelation record);

    List<ReagentRolePermissionRelation> selectByExample(ReagentRolePermissionRelationExample example);

    ReagentRolePermissionRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReagentRolePermissionRelation record, @Param("example") ReagentRolePermissionRelationExample example);

    int updateByExample(@Param("record") ReagentRolePermissionRelation record, @Param("example") ReagentRolePermissionRelationExample example);

    int updateByPrimaryKeySelective(ReagentRolePermissionRelation record);

    int updateByPrimaryKey(ReagentRolePermissionRelation record);
}