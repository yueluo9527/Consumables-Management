package jp.co.nss.hrm.backend.mapper;

import java.util.List;
import jp.co.nss.hrm.backend.model.ReagentSearch;
import jp.co.nss.hrm.backend.model.ReagentSearchExample;
import org.apache.ibatis.annotations.Param;

public interface ReagentSearchMapper {
    long countByExample(ReagentSearchExample example);

    int deleteByExample(ReagentSearchExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReagentSearch record);

    int insertSelective(ReagentSearch record);

    List<ReagentSearch> selectByExample(ReagentSearchExample example);

    ReagentSearch selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReagentSearch record, @Param("example") ReagentSearchExample example);

    int updateByExample(@Param("record") ReagentSearch record, @Param("example") ReagentSearchExample example);

    int updateByPrimaryKeySelective(ReagentSearch record);

    int updateByPrimaryKey(ReagentSearch record);
}