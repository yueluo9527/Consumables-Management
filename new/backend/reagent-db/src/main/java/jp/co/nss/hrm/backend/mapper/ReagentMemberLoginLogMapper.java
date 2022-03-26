package jp.co.nss.hrm.backend.mapper;

import java.util.List;
import jp.co.nss.hrm.backend.model.ReagentMemberLoginLog;
import jp.co.nss.hrm.backend.model.ReagentMemberLoginLogExample;
import org.apache.ibatis.annotations.Param;

public interface ReagentMemberLoginLogMapper {
    long countByExample(ReagentMemberLoginLogExample example);

    int deleteByExample(ReagentMemberLoginLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReagentMemberLoginLog record);

    int insertSelective(ReagentMemberLoginLog record);

    List<ReagentMemberLoginLog> selectByExample(ReagentMemberLoginLogExample example);

    ReagentMemberLoginLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReagentMemberLoginLog record, @Param("example") ReagentMemberLoginLogExample example);

    int updateByExample(@Param("record") ReagentMemberLoginLog record, @Param("example") ReagentMemberLoginLogExample example);

    int updateByPrimaryKeySelective(ReagentMemberLoginLog record);

    int updateByPrimaryKey(ReagentMemberLoginLog record);
}