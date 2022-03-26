package jp.co.nss.hrm.backend.mapper;

import java.util.List;
import jp.co.nss.hrm.backend.model.ReagentAdminLoginLog;
import jp.co.nss.hrm.backend.model.ReagentAdminLoginLogExample;
import org.apache.ibatis.annotations.Param;

public interface ReagentAdminLoginLogMapper {
    long countByExample(ReagentAdminLoginLogExample example);

    int deleteByExample(ReagentAdminLoginLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReagentAdminLoginLog record);

    int insertSelective(ReagentAdminLoginLog record);

    List<ReagentAdminLoginLog> selectByExample(ReagentAdminLoginLogExample example);

    ReagentAdminLoginLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReagentAdminLoginLog record, @Param("example") ReagentAdminLoginLogExample example);

    int updateByExample(@Param("record") ReagentAdminLoginLog record, @Param("example") ReagentAdminLoginLogExample example);

    int updateByPrimaryKeySelective(ReagentAdminLoginLog record);

    int updateByPrimaryKey(ReagentAdminLoginLog record);
}