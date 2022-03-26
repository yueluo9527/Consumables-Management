package jp.co.nss.hrm.backend.mapper;

import java.util.List;
import jp.co.nss.hrm.backend.model.ReagentOutApplication;
import jp.co.nss.hrm.backend.model.ReagentOutApplicationExample;
import org.apache.ibatis.annotations.Param;

public interface ReagentOutApplicationMapper {
    long countByExample(ReagentOutApplicationExample example);

    int deleteByExample(ReagentOutApplicationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReagentOutApplication record);

    int insertSelective(ReagentOutApplication record);

    List<ReagentOutApplication> selectByExample(ReagentOutApplicationExample example);

    ReagentOutApplication selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReagentOutApplication record, @Param("example") ReagentOutApplicationExample example);

    int updateByExample(@Param("record") ReagentOutApplication record, @Param("example") ReagentOutApplicationExample example);

    int updateByPrimaryKeySelective(ReagentOutApplication record);

    int updateByPrimaryKey(ReagentOutApplication record);
}