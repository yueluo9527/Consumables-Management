package jp.co.nss.hrm.backend.mapper;

import java.util.List;
import jp.co.nss.hrm.backend.model.ReagentRole;
import jp.co.nss.hrm.backend.model.ReagentRoleExample;
import org.apache.ibatis.annotations.Param;

public interface ReagentRoleMapper {
    long countByExample(ReagentRoleExample example);

    int deleteByExample(ReagentRoleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReagentRole record);

    int insertSelective(ReagentRole record);

    List<ReagentRole> selectByExample(ReagentRoleExample example);

    ReagentRole selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReagentRole record, @Param("example") ReagentRoleExample example);

    int updateByExample(@Param("record") ReagentRole record, @Param("example") ReagentRoleExample example);

    int updateByPrimaryKeySelective(ReagentRole record);

    int updateByPrimaryKey(ReagentRole record);
}