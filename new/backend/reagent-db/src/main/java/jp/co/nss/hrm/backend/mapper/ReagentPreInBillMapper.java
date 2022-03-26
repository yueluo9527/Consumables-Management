package jp.co.nss.hrm.backend.mapper;

import java.util.List;
import jp.co.nss.hrm.backend.model.ReagentPreInBill;
import jp.co.nss.hrm.backend.model.ReagentPreInBillExample;
import org.apache.ibatis.annotations.Param;

public interface ReagentPreInBillMapper {
    long countByExample(ReagentPreInBillExample example);

    int deleteByExample(ReagentPreInBillExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReagentPreInBill record);

    int insertSelective(ReagentPreInBill record);

    List<ReagentPreInBill> selectByExample(ReagentPreInBillExample example);

    ReagentPreInBill selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReagentPreInBill record, @Param("example") ReagentPreInBillExample example);

    int updateByExample(@Param("record") ReagentPreInBill record, @Param("example") ReagentPreInBillExample example);

    int updateByPrimaryKeySelective(ReagentPreInBill record);

    int updateByPrimaryKey(ReagentPreInBill record);
}