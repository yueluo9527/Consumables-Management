package jp.co.nss.hrm.backend.mapper;

import java.util.List;
import jp.co.nss.hrm.backend.model.ReagentRefund;
import jp.co.nss.hrm.backend.model.ReagentRefundExample;
import org.apache.ibatis.annotations.Param;

public interface ReagentRefundMapper {
    long countByExample(ReagentRefundExample example);

    int deleteByExample(ReagentRefundExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReagentRefund record);

    int insertSelective(ReagentRefund record);

    List<ReagentRefund> selectByExample(ReagentRefundExample example);

    ReagentRefund selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReagentRefund record, @Param("example") ReagentRefundExample example);

    int updateByExample(@Param("record") ReagentRefund record, @Param("example") ReagentRefundExample example);

    int updateByPrimaryKeySelective(ReagentRefund record);

    int updateByPrimaryKey(ReagentRefund record);
}