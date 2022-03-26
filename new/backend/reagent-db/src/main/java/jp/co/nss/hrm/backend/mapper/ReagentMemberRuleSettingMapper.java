package jp.co.nss.hrm.backend.mapper;

import java.util.List;
import jp.co.nss.hrm.backend.model.ReagentMemberRuleSetting;
import jp.co.nss.hrm.backend.model.ReagentMemberRuleSettingExample;
import org.apache.ibatis.annotations.Param;

public interface ReagentMemberRuleSettingMapper {
    long countByExample(ReagentMemberRuleSettingExample example);

    int deleteByExample(ReagentMemberRuleSettingExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReagentMemberRuleSetting record);

    int insertSelective(ReagentMemberRuleSetting record);

    List<ReagentMemberRuleSetting> selectByExample(ReagentMemberRuleSettingExample example);

    ReagentMemberRuleSetting selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReagentMemberRuleSetting record, @Param("example") ReagentMemberRuleSettingExample example);

    int updateByExample(@Param("record") ReagentMemberRuleSetting record, @Param("example") ReagentMemberRuleSettingExample example);

    int updateByPrimaryKeySelective(ReagentMemberRuleSetting record);

    int updateByPrimaryKey(ReagentMemberRuleSetting record);
}