package jp.co.nss.hrm.backend.mapper;

import java.util.List;
import jp.co.nss.hrm.backend.model.ReagentGrowthChangeHistory;
import jp.co.nss.hrm.backend.model.ReagentGrowthChangeHistoryExample;
import org.apache.ibatis.annotations.Param;

public interface ReagentGrowthChangeHistoryMapper {
    long countByExample(ReagentGrowthChangeHistoryExample example);

    int deleteByExample(ReagentGrowthChangeHistoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReagentGrowthChangeHistory record);

    int insertSelective(ReagentGrowthChangeHistory record);

    List<ReagentGrowthChangeHistory> selectByExample(ReagentGrowthChangeHistoryExample example);

    ReagentGrowthChangeHistory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReagentGrowthChangeHistory record, @Param("example") ReagentGrowthChangeHistoryExample example);

    int updateByExample(@Param("record") ReagentGrowthChangeHistory record, @Param("example") ReagentGrowthChangeHistoryExample example);

    int updateByPrimaryKeySelective(ReagentGrowthChangeHistory record);

    int updateByPrimaryKey(ReagentGrowthChangeHistory record);
}