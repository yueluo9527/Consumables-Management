package jp.co.nss.hrm.backend.mapper;

import java.util.List;
import jp.co.nss.hrm.backend.model.ReagentRefundDetail;
import jp.co.nss.hrm.backend.model.ReagentRefundDetailExample;
import org.apache.ibatis.annotations.Param;

public interface ReagentRefundDetailMapper {
    long countByExample(ReagentRefundDetailExample example);

    int deleteByExample(ReagentRefundDetailExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReagentRefundDetail record);

    int insertSelective(ReagentRefundDetail record);

    List<ReagentRefundDetail> selectByExample(ReagentRefundDetailExample example);

    ReagentRefundDetail selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReagentRefundDetail record, @Param("example") ReagentRefundDetailExample example);

    int updateByExample(@Param("record") ReagentRefundDetail record, @Param("example") ReagentRefundDetailExample example);

    int updateByPrimaryKeySelective(ReagentRefundDetail record);

    int updateByPrimaryKey(ReagentRefundDetail record);
}