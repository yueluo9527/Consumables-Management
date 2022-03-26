package jp.co.nss.hrm.backend.mapper;

import java.util.List;
import jp.co.nss.hrm.backend.model.ReagentAdminRoleRelation;
import jp.co.nss.hrm.backend.model.ReagentAdminRoleRelationExample;
import org.apache.ibatis.annotations.Param;

public interface ReagentAdminRoleRelationMapper {
    long countByExample(ReagentAdminRoleRelationExample example);

    int deleteByExample(ReagentAdminRoleRelationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReagentAdminRoleRelation record);

    int insertSelective(ReagentAdminRoleRelation record);

    List<ReagentAdminRoleRelation> selectByExample(ReagentAdminRoleRelationExample example);

    ReagentAdminRoleRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReagentAdminRoleRelation record, @Param("example") ReagentAdminRoleRelationExample example);

    int updateByExample(@Param("record") ReagentAdminRoleRelation record, @Param("example") ReagentAdminRoleRelationExample example);

    int updateByPrimaryKeySelective(ReagentAdminRoleRelation record);

    int updateByPrimaryKey(ReagentAdminRoleRelation record);
}