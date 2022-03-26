package jp.co.nss.hrm.backend.mapper;

import java.util.List;
import jp.co.nss.hrm.backend.model.ReagentResource;
import jp.co.nss.hrm.backend.model.ReagentResourceExample;
import org.apache.ibatis.annotations.Param;

public interface ReagentResourceMapper {
    long countByExample(ReagentResourceExample example);

    int deleteByExample(ReagentResourceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReagentResource record);

    int insertSelective(ReagentResource record);

    List<ReagentResource> selectByExample(ReagentResourceExample example);

    ReagentResource selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReagentResource record, @Param("example") ReagentResourceExample example);

    int updateByExample(@Param("record") ReagentResource record, @Param("example") ReagentResourceExample example);

    int updateByPrimaryKeySelective(ReagentResource record);

    int updateByPrimaryKey(ReagentResource record);
}