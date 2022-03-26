package jp.co.nss.hrm.backend.mapper;

import java.util.List;
import jp.co.nss.hrm.backend.model.ReagentSupplier;
import jp.co.nss.hrm.backend.model.ReagentSupplierExample;
import org.apache.ibatis.annotations.Param;

public interface ReagentSupplierMapper {
    long countByExample(ReagentSupplierExample example);

    int deleteByExample(ReagentSupplierExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReagentSupplier record);

    int insertSelective(ReagentSupplier record);

    List<ReagentSupplier> selectByExample(ReagentSupplierExample example);

    ReagentSupplier selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReagentSupplier record, @Param("example") ReagentSupplierExample example);

    int updateByExample(@Param("record") ReagentSupplier record, @Param("example") ReagentSupplierExample example);

    int updateByPrimaryKeySelective(ReagentSupplier record);

    int updateByPrimaryKey(ReagentSupplier record);
}