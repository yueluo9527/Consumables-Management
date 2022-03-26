package jp.co.nss.hrm.backend.api.service;

import jp.co.nss.hrm.backend.model.ReagentDevice;

import java.util.List;

public interface ReagentDeviceService {
    /**
     * 根据设备名称获取
     */
    List<ReagentDevice> getAllByDeviceName(String deviceName);

    ReagentDevice getItem(Long id);

    /**
     * 获取所有设备列表
     */

    List<ReagentDevice> list();

    /**
     * 添加设备
     */
    int create(ReagentDevice device);

    /**
     * 修改设备信息
     */
    int update(Long id, ReagentDevice device);

    /**
     * 删除指定设备
     */
    int delete(Long id);

    /**
     * 分页获取设备列表
     */
    List<ReagentDevice> list(String keyword, String createBy, Integer pageSize, Integer pageNum);

    /**
     * 根据设备二维码获取设备信息
     */
    ReagentDevice getItemByQrcode(String qrcode);

    /**
     * 修改设备状态
     */
    int updateStatus(Long id, ReagentDevice device);

    /**
     * 根据用户名所属科室获取设备列表
     *
     * @param username
     */
    List<ReagentDevice> getDeviceList(String username);
}
