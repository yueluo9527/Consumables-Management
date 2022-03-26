package jp.co.nss.hrm.backend.mapper;

import java.util.List;
import jp.co.nss.hrm.backend.model.ReagentCollectDetail;
import jp.co.nss.hrm.backend.model.ReagentCollectDetailExample;
import org.apache.ibatis.annotations.Param;

public interface ReagentCollectDetailMapper {
    long countByExample(ReagentCollectDetailExample example);

    int deleteByExample(ReagentCollectDetailExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReagentCollectDetail record);

    int insertSelective(ReagentCollectDetail record);

    List<ReagentCollectDetail> selectByExample(ReagentCollectDetailExample example);

    ReagentCollectDetail selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReagentCollectDetail record, @Param("example") ReagentCollectDetailExample example);

    int updateByExample(@Param("record") ReagentCollectDetail record, @Param("example") ReagentCollectDetailExample example);

    int updateByPrimaryKeySelective(ReagentCollectDetail record);

    int updateByPrimaryKey(ReagentCollectDetail record);
}