package jp.co.nss.hrm.backend.mapper;

import java.util.List;
import jp.co.nss.hrm.backend.model.ReagentMemberStatisticsInfo;
import jp.co.nss.hrm.backend.model.ReagentMemberStatisticsInfoExample;
import org.apache.ibatis.annotations.Param;

public interface ReagentMemberStatisticsInfoMapper {
    long countByExample(ReagentMemberStatisticsInfoExample example);

    int deleteByExample(ReagentMemberStatisticsInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReagentMemberStatisticsInfo record);

    int insertSelective(ReagentMemberStatisticsInfo record);

    List<ReagentMemberStatisticsInfo> selectByExample(ReagentMemberStatisticsInfoExample example);

    ReagentMemberStatisticsInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReagentMemberStatisticsInfo record, @Param("example") ReagentMemberStatisticsInfoExample example);

    int updateByExample(@Param("record") ReagentMemberStatisticsInfo record, @Param("example") ReagentMemberStatisticsInfoExample example);

    int updateByPrimaryKeySelective(ReagentMemberStatisticsInfo record);

    int updateByPrimaryKey(ReagentMemberStatisticsInfo record);
}