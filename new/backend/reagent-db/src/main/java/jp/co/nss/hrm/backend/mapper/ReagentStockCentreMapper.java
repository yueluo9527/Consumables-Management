package jp.co.nss.hrm.backend.mapper;

import java.util.List;
import jp.co.nss.hrm.backend.model.ReagentStockCentre;
import jp.co.nss.hrm.backend.model.ReagentStockCentreExample;
import org.apache.ibatis.annotations.Param;

public interface ReagentStockCentreMapper {
    long countByExample(ReagentStockCentreExample example);

    int deleteByExample(ReagentStockCentreExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReagentStockCentre record);

    int insertSelective(ReagentStockCentre record);

    List<ReagentStockCentre> selectByExample(ReagentStockCentreExample example);

    ReagentStockCentre selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReagentStockCentre record, @Param("example") ReagentStockCentreExample example);

    int updateByExample(@Param("record") ReagentStockCentre record, @Param("example") ReagentStockCentreExample example);

    int updateByPrimaryKeySelective(ReagentStockCentre record);

    int updateByPrimaryKey(ReagentStockCentre record);
}