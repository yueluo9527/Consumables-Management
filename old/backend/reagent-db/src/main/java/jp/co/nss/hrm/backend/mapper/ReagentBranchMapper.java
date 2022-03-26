package jp.co.nss.hrm.backend.mapper;

import java.util.List;
import jp.co.nss.hrm.backend.model.ReagentBranch;
import jp.co.nss.hrm.backend.model.ReagentBranchExample;
import org.apache.ibatis.annotations.Param;

public interface ReagentBranchMapper {
    long countByExample(ReagentBranchExample example);

    int deleteByExample(ReagentBranchExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReagentBranch record);

    int insertSelective(ReagentBranch record);

    List<ReagentBranch> selectByExample(ReagentBranchExample example);

    ReagentBranch selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReagentBranch record, @Param("example") ReagentBranchExample example);

    int updateByExample(@Param("record") ReagentBranch record, @Param("example") ReagentBranchExample example);

    int updateByPrimaryKeySelective(ReagentBranch record);

    int updateByPrimaryKey(ReagentBranch record);
}