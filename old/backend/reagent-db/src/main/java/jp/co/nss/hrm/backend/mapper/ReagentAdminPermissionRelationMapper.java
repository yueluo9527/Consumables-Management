package jp.co.nss.hrm.backend.mapper;

import java.util.List;
import jp.co.nss.hrm.backend.model.ReagentAdminPermissionRelation;
import jp.co.nss.hrm.backend.model.ReagentAdminPermissionRelationExample;
import org.apache.ibatis.annotations.Param;

public interface ReagentAdminPermissionRelationMapper {
    long countByExample(ReagentAdminPermissionRelationExample example);

    int deleteByExample(ReagentAdminPermissionRelationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReagentAdminPermissionRelation record);

    int insertSelective(ReagentAdminPermissionRelation record);

    List<ReagentAdminPermissionRelation> selectByExample(ReagentAdminPermissionRelationExample example);

    ReagentAdminPermissionRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReagentAdminPermissionRelation record, @Param("example") ReagentAdminPermissionRelationExample example);

    int updateByExample(@Param("record") ReagentAdminPermissionRelation record, @Param("example") ReagentAdminPermissionRelationExample example);

    int updateByPrimaryKeySelective(ReagentAdminPermissionRelation record);

    int updateByPrimaryKey(ReagentAdminPermissionRelation record);
}