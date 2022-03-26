package jp.co.nss.hrm.backend.mapper;

import java.util.List;
import jp.co.nss.hrm.backend.model.ReagentDevice;
import jp.co.nss.hrm.backend.model.ReagentDeviceExample;
import org.apache.ibatis.annotations.Param;

public interface ReagentDeviceMapper {
    long countByExample(ReagentDeviceExample example);

    int deleteByExample(ReagentDeviceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReagentDevice record);

    int insertSelective(ReagentDevice record);

    List<ReagentDevice> selectByExample(ReagentDeviceExample example);

    ReagentDevice selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReagentDevice record, @Param("example") ReagentDeviceExample example);

    int updateByExample(@Param("record") ReagentDevice record, @Param("example") ReagentDeviceExample example);

    int updateByPrimaryKeySelective(ReagentDevice record);

    int updateByPrimaryKey(ReagentDevice record);
}