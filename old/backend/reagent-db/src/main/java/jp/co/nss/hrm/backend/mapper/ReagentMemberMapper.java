package jp.co.nss.hrm.backend.mapper;

import java.util.List;
import jp.co.nss.hrm.backend.model.ReagentMember;
import jp.co.nss.hrm.backend.model.ReagentMemberExample;
import org.apache.ibatis.annotations.Param;

public interface ReagentMemberMapper {
    long countByExample(ReagentMemberExample example);

    int deleteByExample(ReagentMemberExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReagentMember record);

    int insertSelective(ReagentMember record);

    List<ReagentMember> selectByExample(ReagentMemberExample example);

    ReagentMember selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReagentMember record, @Param("example") ReagentMemberExample example);

    int updateByExample(@Param("record") ReagentMember record, @Param("example") ReagentMemberExample example);

    int updateByPrimaryKeySelective(ReagentMember record);

    int updateByPrimaryKey(ReagentMember record);
}