package jp.co.nss.hrm.backend.mapper;

import java.util.List;
import jp.co.nss.hrm.backend.model.ReagentStockLoss;
import jp.co.nss.hrm.backend.model.ReagentStockLossExample;
import org.apache.ibatis.annotations.Param;

public interface ReagentStockLossMapper {
    long countByExample(ReagentStockLossExample example);

    int deleteByExample(ReagentStockLossExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReagentStockLoss record);

    int insertSelective(ReagentStockLoss record);

    List<ReagentStockLoss> selectByExample(ReagentStockLossExample example);

    ReagentStockLoss selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReagentStockLoss record, @Param("example") ReagentStockLossExample example);

    int updateByExample(@Param("record") ReagentStockLoss record, @Param("example") ReagentStockLossExample example);

    int updateByPrimaryKeySelective(ReagentStockLoss record);

    int updateByPrimaryKey(ReagentStockLoss record);
}