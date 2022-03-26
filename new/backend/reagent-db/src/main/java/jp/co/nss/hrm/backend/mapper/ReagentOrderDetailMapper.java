package jp.co.nss.hrm.backend.mapper;

import java.util.List;
import jp.co.nss.hrm.backend.model.ReagentOrderDetail;
import jp.co.nss.hrm.backend.model.ReagentOrderDetailExample;
import org.apache.ibatis.annotations.Param;

public interface ReagentOrderDetailMapper {
    long countByExample(ReagentOrderDetailExample example);

    int deleteByExample(ReagentOrderDetailExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReagentOrderDetail record);

    int insertSelective(ReagentOrderDetail record);

    List<ReagentOrderDetail> selectByExample(ReagentOrderDetailExample example);

    ReagentOrderDetail selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReagentOrderDetail record, @Param("example") ReagentOrderDetailExample example);

    int updateByExample(@Param("record") ReagentOrderDetail record, @Param("example") ReagentOrderDetailExample example);

    int updateByPrimaryKeySelective(ReagentOrderDetail record);

    int updateByPrimaryKey(ReagentOrderDetail record);
}