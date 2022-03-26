package jp.co.nss.hrm.backend.mapper;

import java.util.List;
import jp.co.nss.hrm.backend.model.MaxCode;
import jp.co.nss.hrm.backend.model.MaxCodeExample;
import org.apache.ibatis.annotations.Param;

public interface MaxCodeMapper {
    long countByExample(MaxCodeExample example);

    int deleteByExample(MaxCodeExample example);

    int insert(MaxCode record);

    int insertSelective(MaxCode record);

    List<MaxCode> selectByExample(MaxCodeExample example);

    int updateByExampleSelective(@Param("record") MaxCode record, @Param("example") MaxCodeExample example);

    int updateByExample(@Param("record") MaxCode record, @Param("example") MaxCodeExample example);
}