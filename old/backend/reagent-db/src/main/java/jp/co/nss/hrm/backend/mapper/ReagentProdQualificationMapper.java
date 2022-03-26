package jp.co.nss.hrm.backend.mapper;

import java.util.List;
import jp.co.nss.hrm.backend.model.ReagentProdQualification;
import jp.co.nss.hrm.backend.model.ReagentProdQualificationExample;
import org.apache.ibatis.annotations.Param;

public interface ReagentProdQualificationMapper {
    long countByExample(ReagentProdQualificationExample example);

    int deleteByExample(ReagentProdQualificationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReagentProdQualification record);

    int insertSelective(ReagentProdQualification record);

    List<ReagentProdQualification> selectByExample(ReagentProdQualificationExample example);

    ReagentProdQualification selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReagentProdQualification record, @Param("example") ReagentProdQualificationExample example);

    int updateByExample(@Param("record") ReagentProdQualification record, @Param("example") ReagentProdQualificationExample example);

    int updateByPrimaryKeySelective(ReagentProdQualification record);

    int updateByPrimaryKey(ReagentProdQualification record);
}