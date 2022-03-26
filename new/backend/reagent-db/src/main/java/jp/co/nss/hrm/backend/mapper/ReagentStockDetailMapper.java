package jp.co.nss.hrm.backend.mapper;

import java.util.List;
import jp.co.nss.hrm.backend.model.ReagentStockDetail;
import jp.co.nss.hrm.backend.model.ReagentStockDetailExample;
import org.apache.ibatis.annotations.Param;

public interface ReagentStockDetailMapper {
    long countByExample(ReagentStockDetailExample example);

    int deleteByExample(ReagentStockDetailExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReagentStockDetail record);

    int insertSelective(ReagentStockDetail record);

    List<ReagentStockDetail> selectByExample(ReagentStockDetailExample example);

    ReagentStockDetail selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReagentStockDetail record, @Param("example") ReagentStockDetailExample example);

    int updateByExample(@Param("record") ReagentStockDetail record, @Param("example") ReagentStockDetailExample example);

    int updateByPrimaryKeySelective(ReagentStockDetail record);

    int updateByPrimaryKey(ReagentStockDetail record);
}