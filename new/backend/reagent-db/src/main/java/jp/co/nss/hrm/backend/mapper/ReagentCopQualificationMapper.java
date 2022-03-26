package jp.co.nss.hrm.backend.mapper;

import java.util.List;
import jp.co.nss.hrm.backend.model.ReagentCopQualification;
import jp.co.nss.hrm.backend.model.ReagentCopQualificationExample;
import org.apache.ibatis.annotations.Param;

public interface ReagentCopQualificationMapper {
    long countByExample(ReagentCopQualificationExample example);

    int deleteByExample(ReagentCopQualificationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReagentCopQualification record);

    int insertSelective(ReagentCopQualification record);

    List<ReagentCopQualification> selectByExample(ReagentCopQualificationExample example);

    ReagentCopQualification selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReagentCopQualification record, @Param("example") ReagentCopQualificationExample example);

    int updateByExample(@Param("record") ReagentCopQualification record, @Param("example") ReagentCopQualificationExample example);

    int updateByPrimaryKeySelective(ReagentCopQualification record);

    int updateByPrimaryKey(ReagentCopQualification record);
}