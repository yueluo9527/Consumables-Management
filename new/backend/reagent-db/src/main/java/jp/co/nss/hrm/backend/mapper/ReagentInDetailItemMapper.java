package jp.co.nss.hrm.backend.mapper;

import java.util.List;
import jp.co.nss.hrm.backend.model.ReagentInDetailItem;
import jp.co.nss.hrm.backend.model.ReagentInDetailItemExample;
import org.apache.ibatis.annotations.Param;

public interface ReagentInDetailItemMapper {
    long countByExample(ReagentInDetailItemExample example);

    int deleteByExample(ReagentInDetailItemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReagentInDetailItem record);

    int insertSelective(ReagentInDetailItem record);

    List<ReagentInDetailItem> selectByExample(ReagentInDetailItemExample example);

    ReagentInDetailItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReagentInDetailItem record, @Param("example") ReagentInDetailItemExample example);

    int updateByExample(@Param("record") ReagentInDetailItem record, @Param("example") ReagentInDetailItemExample example);

    int updateByPrimaryKeySelective(ReagentInDetailItem record);

    int updateByPrimaryKey(ReagentInDetailItem record);
}