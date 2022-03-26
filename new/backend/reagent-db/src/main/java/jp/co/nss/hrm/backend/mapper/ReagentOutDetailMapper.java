package jp.co.nss.hrm.backend.mapper;

import java.util.List;
import jp.co.nss.hrm.backend.model.ReagentOutDetail;
import jp.co.nss.hrm.backend.model.ReagentOutDetailExample;
import org.apache.ibatis.annotations.Param;

public interface ReagentOutDetailMapper {
    long countByExample(ReagentOutDetailExample example);

    int deleteByExample(ReagentOutDetailExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReagentOutDetail record);

    int insertSelective(ReagentOutDetail record);

    List<ReagentOutDetail> selectByExample(ReagentOutDetailExample example);

    ReagentOutDetail selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReagentOutDetail record, @Param("example") ReagentOutDetailExample example);

    int updateByExample(@Param("record") ReagentOutDetail record, @Param("example") ReagentOutDetailExample example);

    int updateByPrimaryKeySelective(ReagentOutDetail record);

    int updateByPrimaryKey(ReagentOutDetail record);
}