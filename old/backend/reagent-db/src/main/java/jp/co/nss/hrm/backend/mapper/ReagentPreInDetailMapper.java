package jp.co.nss.hrm.backend.mapper;

import java.util.List;
import jp.co.nss.hrm.backend.model.ReagentPreInDetail;
import jp.co.nss.hrm.backend.model.ReagentPreInDetailExample;
import org.apache.ibatis.annotations.Param;

public interface ReagentPreInDetailMapper {
    long countByExample(ReagentPreInDetailExample example);

    int deleteByExample(ReagentPreInDetailExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReagentPreInDetail record);

    int insertSelective(ReagentPreInDetail record);

    List<ReagentPreInDetail> selectByExample(ReagentPreInDetailExample example);

    ReagentPreInDetail selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReagentPreInDetail record, @Param("example") ReagentPreInDetailExample example);

    int updateByExample(@Param("record") ReagentPreInDetail record, @Param("example") ReagentPreInDetailExample example);

    int updateByPrimaryKeySelective(ReagentPreInDetail record);

    int updateByPrimaryKey(ReagentPreInDetail record);
}