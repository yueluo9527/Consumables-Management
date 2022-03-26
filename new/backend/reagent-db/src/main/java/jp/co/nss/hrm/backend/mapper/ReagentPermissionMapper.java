package jp.co.nss.hrm.backend.mapper;

import java.util.List;
import jp.co.nss.hrm.backend.model.ReagentPermission;
import jp.co.nss.hrm.backend.model.ReagentPermissionExample;
import org.apache.ibatis.annotations.Param;

public interface ReagentPermissionMapper {
    long countByExample(ReagentPermissionExample example);

    int deleteByExample(ReagentPermissionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReagentPermission record);

    int insertSelective(ReagentPermission record);

    List<ReagentPermission> selectByExample(ReagentPermissionExample example);

    ReagentPermission selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReagentPermission record, @Param("example") ReagentPermissionExample example);

    int updateByExample(@Param("record") ReagentPermission record, @Param("example") ReagentPermissionExample example);

    int updateByPrimaryKeySelective(ReagentPermission record);

    int updateByPrimaryKey(ReagentPermission record);
}