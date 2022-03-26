package jp.co.nss.hrm.backend.mapper;

import java.util.List;
import jp.co.nss.hrm.backend.model.ReagentIntegrationConsumeSetting;
import jp.co.nss.hrm.backend.model.ReagentIntegrationConsumeSettingExample;
import org.apache.ibatis.annotations.Param;

public interface ReagentIntegrationConsumeSettingMapper {
    long countByExample(ReagentIntegrationConsumeSettingExample example);

    int deleteByExample(ReagentIntegrationConsumeSettingExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReagentIntegrationConsumeSetting record);

    int insertSelective(ReagentIntegrationConsumeSetting record);

    List<ReagentIntegrationConsumeSetting> selectByExample(ReagentIntegrationConsumeSettingExample example);

    ReagentIntegrationConsumeSetting selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReagentIntegrationConsumeSetting record, @Param("example") ReagentIntegrationConsumeSettingExample example);

    int updateByExample(@Param("record") ReagentIntegrationConsumeSetting record, @Param("example") ReagentIntegrationConsumeSettingExample example);

    int updateByPrimaryKeySelective(ReagentIntegrationConsumeSetting record);

    int updateByPrimaryKey(ReagentIntegrationConsumeSetting record);
}