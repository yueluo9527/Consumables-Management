package jp.co.nss.hrm.backend.mapper;

import java.util.List;
import jp.co.nss.hrm.backend.model.ReagentInBill;
import jp.co.nss.hrm.backend.model.ReagentInBillExample;
import org.apache.ibatis.annotations.Param;

public interface ReagentInBillMapper {
    long countByExample(ReagentInBillExample example);

    int deleteByExample(ReagentInBillExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReagentInBill record);

    int insertSelective(ReagentInBill record);

    List<ReagentInBill> selectByExample(ReagentInBillExample example);

    ReagentInBill selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReagentInBill record, @Param("example") ReagentInBillExample example);

    int updateByExample(@Param("record") ReagentInBill record, @Param("example") ReagentInBillExample example);

    int updateByPrimaryKeySelective(ReagentInBill record);

    int updateByPrimaryKey(ReagentInBill record);
}