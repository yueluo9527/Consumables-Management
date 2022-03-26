package jp.co.nss.hrm.backend.mapper;

import java.util.List;
import jp.co.nss.hrm.backend.model.ReagentMemberLevel;
import jp.co.nss.hrm.backend.model.ReagentMemberLevelExample;
import org.apache.ibatis.annotations.Param;

public interface ReagentMemberLevelMapper {
    long countByExample(ReagentMemberLevelExample example);

    int deleteByExample(ReagentMemberLevelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReagentMemberLevel record);

    int insertSelective(ReagentMemberLevel record);

    List<ReagentMemberLevel> selectByExample(ReagentMemberLevelExample example);

    ReagentMemberLevel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReagentMemberLevel record, @Param("example") ReagentMemberLevelExample example);

    int updateByExample(@Param("record") ReagentMemberLevel record, @Param("example") ReagentMemberLevelExample example);

    int updateByPrimaryKeySelective(ReagentMemberLevel record);

    int updateByPrimaryKey(ReagentMemberLevel record);
}