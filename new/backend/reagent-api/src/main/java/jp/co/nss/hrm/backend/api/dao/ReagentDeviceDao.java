package jp.co.nss.hrm.backend.api.dao;

import jp.co.nss.hrm.backend.model.ReagentDevice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReagentDeviceDao {

    /**
     * 根据科室名称获取列表
     */
    List<ReagentDevice> getAllByDeviceName(@Param("deviceName") String deviceName);

    String getMaxCode();

    ReagentDevice getItemByQrcode(@Param("qrcode") String qrcode);

    List<ReagentDevice> getDeviceList(@Param("keyword") String keyword, @Param("branch") String branch);
}
