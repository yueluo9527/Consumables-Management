package jp.co.nss.hrm.backend.mapper;

import java.util.List;
import jp.co.nss.hrm.backend.model.ReagentStockItem;
import jp.co.nss.hrm.backend.model.ReagentStockItemExample;
import org.apache.ibatis.annotations.Param;

public interface ReagentStockItemMapper {
    long countByExample(ReagentStockItemExample example);

    int deleteByExample(ReagentStockItemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReagentStockItem record);

    int insertSelective(ReagentStockItem record);

    List<ReagentStockItem> selectByExample(ReagentStockItemExample example);

    ReagentStockItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReagentStockItem record, @Param("example") ReagentStockItemExample example);

    int updateByExample(@Param("record") ReagentStockItem record, @Param("example") ReagentStockItemExample example);

    int updateByPrimaryKeySelective(ReagentStockItem record);

    int updateByPrimaryKey(ReagentStockItem record);
}