package jp.co.nss.hrm.backend.mapper;

import java.util.List;
import jp.co.nss.hrm.backend.model.ReagentStockBranch;
import jp.co.nss.hrm.backend.model.ReagentStockBranchExample;
import org.apache.ibatis.annotations.Param;

public interface ReagentStockBranchMapper {
    long countByExample(ReagentStockBranchExample example);

    int deleteByExample(ReagentStockBranchExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReagentStockBranch record);

    int insertSelective(ReagentStockBranch record);

    List<ReagentStockBranch> selectByExample(ReagentStockBranchExample example);

    ReagentStockBranch selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReagentStockBranch record, @Param("example") ReagentStockBranchExample example);

    int updateByExample(@Param("record") ReagentStockBranch record, @Param("example") ReagentStockBranchExample example);

    int updateByPrimaryKeySelective(ReagentStockBranch record);

    int updateByPrimaryKey(ReagentStockBranch record);
}