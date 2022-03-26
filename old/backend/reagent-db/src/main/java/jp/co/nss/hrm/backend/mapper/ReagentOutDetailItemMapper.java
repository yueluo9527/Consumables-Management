package jp.co.nss.hrm.backend.mapper;

import java.util.List;
import jp.co.nss.hrm.backend.model.ReagentOutDetailItem;
import jp.co.nss.hrm.backend.model.ReagentOutDetailItemExample;
import org.apache.ibatis.annotations.Param;

public interface ReagentOutDetailItemMapper {
    long countByExample(ReagentOutDetailItemExample example);

    int deleteByExample(ReagentOutDetailItemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReagentOutDetailItem record);

    int insertSelective(ReagentOutDetailItem record);

    List<ReagentOutDetailItem> selectByExample(ReagentOutDetailItemExample example);

    ReagentOutDetailItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReagentOutDetailItem record, @Param("example") ReagentOutDetailItemExample example);

    int updateByExample(@Param("record") ReagentOutDetailItem record, @Param("example") ReagentOutDetailItemExample example);

    int updateByPrimaryKeySelective(ReagentOutDetailItem record);

    int updateByPrimaryKey(ReagentOutDetailItem record);
}