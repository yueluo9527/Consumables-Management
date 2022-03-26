package jp.co.nss.hrm.backend.mapper;

import java.util.List;
import jp.co.nss.hrm.backend.model.ReagentAdmin;
import jp.co.nss.hrm.backend.model.ReagentAdminExample;
import org.apache.ibatis.annotations.Param;

public interface ReagentAdminMapper {
    long countByExample(ReagentAdminExample example);

    int deleteByExample(ReagentAdminExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReagentAdmin record);

    int insertSelective(ReagentAdmin record);

    List<ReagentAdmin> selectByExample(ReagentAdminExample example);

    ReagentAdmin selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReagentAdmin record, @Param("example") ReagentAdminExample example);

    int updateByExample(@Param("record") ReagentAdmin record, @Param("example") ReagentAdminExample example);

    int updateByPrimaryKeySelective(ReagentAdmin record);

    int updateByPrimaryKey(ReagentAdmin record);
}