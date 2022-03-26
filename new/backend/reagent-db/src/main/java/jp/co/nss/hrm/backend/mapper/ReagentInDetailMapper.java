package jp.co.nss.hrm.backend.mapper;

import java.util.List;
import jp.co.nss.hrm.backend.model.ReagentInDetail;
import jp.co.nss.hrm.backend.model.ReagentInDetailExample;
import org.apache.ibatis.annotations.Param;

public interface ReagentInDetailMapper {
    long countByExample(ReagentInDetailExample example);

    int deleteByExample(ReagentInDetailExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReagentInDetail record);

    int insertSelective(ReagentInDetail record);

    List<ReagentInDetail> selectByExample(ReagentInDetailExample example);

    ReagentInDetail selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReagentInDetail record, @Param("example") ReagentInDetailExample example);

    int updateByExample(@Param("record") ReagentInDetail record, @Param("example") ReagentInDetailExample example);

    int updateByPrimaryKeySelective(ReagentInDetail record);

    int updateByPrimaryKey(ReagentInDetail record);
}