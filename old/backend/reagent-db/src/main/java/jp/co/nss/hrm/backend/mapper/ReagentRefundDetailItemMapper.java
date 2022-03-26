package jp.co.nss.hrm.backend.mapper;

import java.util.List;
import jp.co.nss.hrm.backend.model.ReagentRefundDetailItem;
import jp.co.nss.hrm.backend.model.ReagentRefundDetailItemExample;
import org.apache.ibatis.annotations.Param;

public interface ReagentRefundDetailItemMapper {
    long countByExample(ReagentRefundDetailItemExample example);

    int deleteByExample(ReagentRefundDetailItemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReagentRefundDetailItem record);

    int insertSelective(ReagentRefundDetailItem record);

    List<ReagentRefundDetailItem> selectByExample(ReagentRefundDetailItemExample example);

    ReagentRefundDetailItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReagentRefundDetailItem record, @Param("example") ReagentRefundDetailItemExample example);

    int updateByExample(@Param("record") ReagentRefundDetailItem record, @Param("example") ReagentRefundDetailItemExample example);

    int updateByPrimaryKeySelective(ReagentRefundDetailItem record);

    int updateByPrimaryKey(ReagentRefundDetailItem record);
}