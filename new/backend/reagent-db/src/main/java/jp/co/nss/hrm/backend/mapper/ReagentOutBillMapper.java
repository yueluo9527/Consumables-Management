package jp.co.nss.hrm.backend.mapper;

import java.util.List;
import jp.co.nss.hrm.backend.model.ReagentOutBill;
import jp.co.nss.hrm.backend.model.ReagentOutBillExample;
import org.apache.ibatis.annotations.Param;

public interface ReagentOutBillMapper {
    long countByExample(ReagentOutBillExample example);

    int deleteByExample(ReagentOutBillExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReagentOutBill record);

    int insertSelective(ReagentOutBill record);

    List<ReagentOutBill> selectByExample(ReagentOutBillExample example);

    ReagentOutBill selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReagentOutBill record, @Param("example") ReagentOutBillExample example);

    int updateByExample(@Param("record") ReagentOutBill record, @Param("example") ReagentOutBillExample example);

    int updateByPrimaryKeySelective(ReagentOutBill record);

    int updateByPrimaryKey(ReagentOutBill record);
}