package jp.co.nss.hrm.backend.mapper;

import java.util.List;
import jp.co.nss.hrm.backend.model.ReagentPreInDetailItem;
import jp.co.nss.hrm.backend.model.ReagentPreInDetailItemExample;
import org.apache.ibatis.annotations.Param;

public interface ReagentPreInDetailItemMapper {
    long countByExample(ReagentPreInDetailItemExample example);

    int deleteByExample(ReagentPreInDetailItemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReagentPreInDetailItem record);

    int insertSelective(ReagentPreInDetailItem record);

    List<ReagentPreInDetailItem> selectByExample(ReagentPreInDetailItemExample example);

    ReagentPreInDetailItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReagentPreInDetailItem record, @Param("example") ReagentPreInDetailItemExample example);

    int updateByExample(@Param("record") ReagentPreInDetailItem record, @Param("example") ReagentPreInDetailItemExample example);

    int updateByPrimaryKeySelective(ReagentPreInDetailItem record);

    int updateByPrimaryKey(ReagentPreInDetailItem record);
}