package jp.co.nss.hrm.backend.mapper;

import java.util.List;
import jp.co.nss.hrm.backend.model.ReagentMemberReceiveAddress;
import jp.co.nss.hrm.backend.model.ReagentMemberReceiveAddressExample;
import org.apache.ibatis.annotations.Param;

public interface ReagentMemberReceiveAddressMapper {
    long countByExample(ReagentMemberReceiveAddressExample example);

    int deleteByExample(ReagentMemberReceiveAddressExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReagentMemberReceiveAddress record);

    int insertSelective(ReagentMemberReceiveAddress record);

    List<ReagentMemberReceiveAddress> selectByExample(ReagentMemberReceiveAddressExample example);

    ReagentMemberReceiveAddress selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReagentMemberReceiveAddress record, @Param("example") ReagentMemberReceiveAddressExample example);

    int updateByExample(@Param("record") ReagentMemberReceiveAddress record, @Param("example") ReagentMemberReceiveAddressExample example);

    int updateByPrimaryKeySelective(ReagentMemberReceiveAddress record);

    int updateByPrimaryKey(ReagentMemberReceiveAddress record);
}