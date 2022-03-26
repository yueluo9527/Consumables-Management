package jp.co.nss.hrm.backend.mapper;

import java.util.List;
import jp.co.nss.hrm.backend.model.ReagentStockCentreDetail;
import jp.co.nss.hrm.backend.model.ReagentStockCentreDetailExample;
import org.apache.ibatis.annotations.Param;

public interface ReagentStockCentreDetailMapper {
    long countByExample(ReagentStockCentreDetailExample example);

    int deleteByExample(ReagentStockCentreDetailExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReagentStockCentreDetail record);

    int insertSelective(ReagentStockCentreDetail record);

    List<ReagentStockCentreDetail> selectByExample(ReagentStockCentreDetailExample example);

    ReagentStockCentreDetail selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReagentStockCentreDetail record, @Param("example") ReagentStockCentreDetailExample example);

    int updateByExample(@Param("record") ReagentStockCentreDetail record, @Param("example") ReagentStockCentreDetailExample example);

    int updateByPrimaryKeySelective(ReagentStockCentreDetail record);

    int updateByPrimaryKey(ReagentStockCentreDetail record);
}