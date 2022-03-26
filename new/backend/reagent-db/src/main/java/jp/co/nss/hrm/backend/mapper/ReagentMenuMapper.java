package jp.co.nss.hrm.backend.mapper;

import java.util.List;
import jp.co.nss.hrm.backend.model.ReagentMenu;
import jp.co.nss.hrm.backend.model.ReagentMenuExample;
import org.apache.ibatis.annotations.Param;

public interface ReagentMenuMapper {
    long countByExample(ReagentMenuExample example);

    int deleteByExample(ReagentMenuExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReagentMenu record);

    int insertSelective(ReagentMenu record);

    List<ReagentMenu> selectByExample(ReagentMenuExample example);

    ReagentMenu selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReagentMenu record, @Param("example") ReagentMenuExample example);

    int updateByExample(@Param("record") ReagentMenu record, @Param("example") ReagentMenuExample example);

    int updateByPrimaryKeySelective(ReagentMenu record);

    int updateByPrimaryKey(ReagentMenu record);
}