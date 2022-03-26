package jp.co.nss.hrm.backend.mapper;

import java.util.List;
import jp.co.nss.hrm.backend.model.ReagentMemberTag;
import jp.co.nss.hrm.backend.model.ReagentMemberTagExample;
import org.apache.ibatis.annotations.Param;

public interface ReagentMemberTagMapper {
    long countByExample(ReagentMemberTagExample example);

    int deleteByExample(ReagentMemberTagExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReagentMemberTag record);

    int insertSelective(ReagentMemberTag record);

    List<ReagentMemberTag> selectByExample(ReagentMemberTagExample example);

    ReagentMemberTag selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReagentMemberTag record, @Param("example") ReagentMemberTagExample example);

    int updateByExample(@Param("record") ReagentMemberTag record, @Param("example") ReagentMemberTagExample example);

    int updateByPrimaryKeySelective(ReagentMemberTag record);

    int updateByPrimaryKey(ReagentMemberTag record);
}