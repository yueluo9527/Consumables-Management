package jp.co.nss.hrm.backend.mapper;

import java.util.List;
import jp.co.nss.hrm.backend.model.ReagentStockBranchDetail;
import jp.co.nss.hrm.backend.model.ReagentStockBranchDetailExample;
import org.apache.ibatis.annotations.Param;

public interface ReagentStockBranchDetailMapper {
    long countByExample(ReagentStockBranchDetailExample example);

    int deleteByExample(ReagentStockBranchDetailExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReagentStockBranchDetail record);

    int insertSelective(ReagentStockBranchDetail record);

    List<ReagentStockBranchDetail> selectByExample(ReagentStockBranchDetailExample example);

    ReagentStockBranchDetail selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReagentStockBranchDetail record, @Param("example") ReagentStockBranchDetailExample example);

    int updateByExample(@Param("record") ReagentStockBranchDetail record, @Param("example") ReagentStockBranchDetailExample example);

    int updateByPrimaryKeySelective(ReagentStockBranchDetail record);

    int updateByPrimaryKey(ReagentStockBranchDetail record);
}