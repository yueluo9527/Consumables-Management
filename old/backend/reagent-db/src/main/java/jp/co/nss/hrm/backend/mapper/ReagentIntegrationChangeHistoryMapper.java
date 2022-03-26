package jp.co.nss.hrm.backend.mapper;

import java.util.List;
import jp.co.nss.hrm.backend.model.ReagentIntegrationChangeHistory;
import jp.co.nss.hrm.backend.model.ReagentIntegrationChangeHistoryExample;
import org.apache.ibatis.annotations.Param;

public interface ReagentIntegrationChangeHistoryMapper {
    long countByExample(ReagentIntegrationChangeHistoryExample example);

    int deleteByExample(ReagentIntegrationChangeHistoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReagentIntegrationChangeHistory record);

    int insertSelective(ReagentIntegrationChangeHistory record);

    List<ReagentIntegrationChangeHistory> selectByExample(ReagentIntegrationChangeHistoryExample example);

    ReagentIntegrationChangeHistory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReagentIntegrationChangeHistory record, @Param("example") ReagentIntegrationChangeHistoryExample example);

    int updateByExample(@Param("record") ReagentIntegrationChangeHistory record, @Param("example") ReagentIntegrationChangeHistoryExample example);

    int updateByPrimaryKeySelective(ReagentIntegrationChangeHistory record);

    int updateByPrimaryKey(ReagentIntegrationChangeHistory record);
}