package jp.co.nss.hrm.backend.mapper;

import java.util.List;
import jp.co.nss.hrm.backend.model.ReagentMemberTask;
import jp.co.nss.hrm.backend.model.ReagentMemberTaskExample;
import org.apache.ibatis.annotations.Param;

public interface ReagentMemberTaskMapper {
    long countByExample(ReagentMemberTaskExample example);

    int deleteByExample(ReagentMemberTaskExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReagentMemberTask record);

    int insertSelective(ReagentMemberTask record);

    List<ReagentMemberTask> selectByExample(ReagentMemberTaskExample example);

    ReagentMemberTask selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReagentMemberTask record, @Param("example") ReagentMemberTaskExample example);

    int updateByExample(@Param("record") ReagentMemberTask record, @Param("example") ReagentMemberTaskExample example);

    int updateByPrimaryKeySelective(ReagentMemberTask record);

    int updateByPrimaryKey(ReagentMemberTask record);
}