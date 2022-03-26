package jp.co.nss.hrm.backend.mapper;

import java.util.List;
import jp.co.nss.hrm.backend.model.ReagentOperationLog;
import jp.co.nss.hrm.backend.model.ReagentOperationLogExample;
import org.apache.ibatis.annotations.Param;

public interface ReagentOperationLogMapper {
    long countByExample(ReagentOperationLogExample example);

    int deleteByExample(ReagentOperationLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReagentOperationLog record);

    int insertSelective(ReagentOperationLog record);

    List<ReagentOperationLog> selectByExampleWithBLOBs(ReagentOperationLogExample example);

    List<ReagentOperationLog> selectByExample(ReagentOperationLogExample example);

    ReagentOperationLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReagentOperationLog record, @Param("example") ReagentOperationLogExample example);

    int updateByExampleWithBLOBs(@Param("record") ReagentOperationLog record, @Param("example") ReagentOperationLogExample example);

    int updateByExample(@Param("record") ReagentOperationLog record, @Param("example") ReagentOperationLogExample example);

    int updateByPrimaryKeySelective(ReagentOperationLog record);

    int updateByPrimaryKeyWithBLOBs(ReagentOperationLog record);

    int updateByPrimaryKey(ReagentOperationLog record);
}