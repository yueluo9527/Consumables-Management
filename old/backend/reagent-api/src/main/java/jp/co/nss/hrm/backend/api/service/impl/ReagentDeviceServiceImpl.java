package jp.co.nss.hrm.backend.api.service.impl;

import com.github.pagehelper.PageHelper;
import jp.co.nss.hrm.backend.api.dao.ReagentAdminDao;
import jp.co.nss.hrm.backend.api.dao.ReagentDeviceDao;
import jp.co.nss.hrm.backend.api.service.ReagentDeviceService;
import jp.co.nss.hrm.backend.mapper.ReagentBranchMapper;
import jp.co.nss.hrm.backend.mapper.ReagentDeviceMapper;
import jp.co.nss.hrm.backend.model.ReagentBranch;
import jp.co.nss.hrm.backend.model.ReagentBranchExample;
import jp.co.nss.hrm.backend.model.ReagentDevice;
import jp.co.nss.hrm.backend.model.ReagentDeviceExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Service
public class ReagentDeviceServiceImpl implements ReagentDeviceService {

    @Autowired
    private ReagentDeviceMapper deviceMapper;
    @Autowired
    private ReagentBranchMapper branchMapper;
    @Autowired
    private ReagentDeviceDao deviceDao;
    @Autowired
    private ReagentAdminDao adminDao;

    /**
     * 根据设备名称获取列表
     *
     * @param deviceName
     */
    @Override
    public List<ReagentDevice> getAllByDeviceName(String deviceName) {
        return deviceDao.getAllByDeviceName(deviceName);
    }

    /**
     * 获取所有设备列表
     */
    @Override
    public List<ReagentDevice> list() {

        return deviceMapper.selectByExample(new ReagentDeviceExample());
    }

    /**
     * 添加设备
     *
     * @param device
     */
    @Override
    public int create(ReagentDevice device) {
        device.setCreateTime(new Date());
        device.setUpdateTime(new Date());

        String branch = adminDao.selectBranch(device.getCreateBy());
        ReagentBranchExample branchExample = new ReagentBranchExample();
        branchExample.createCriteria().andBranchNameEqualTo(branch);

        List<ReagentBranch> branchList;
        branchList = branchMapper.selectByExample(branchExample);
        Long branchId;
        if (!branchList.isEmpty()) {
            branchId = branchList.get(0).getId();
            device.setBranchId(branchId);
        }

        String count;
        count = deviceDao.getMaxCode();

        if (StringUtils.isEmpty(count)) count = "0";
        Integer newCount = Integer.parseInt(count) + 1;

        //查询是否有相同编号的设备device_code
        ReagentDeviceExample example = new ReagentDeviceExample();
        example.createCriteria().andDeviceCodeEqualTo(String.valueOf(newCount));
        List<ReagentDevice> deviceList = deviceMapper.selectByExample(example);
        if (deviceList.size() > 0) {
            return 0;
        } else {
            device.setDeviceCode(String.valueOf(newCount));
        }

        Long time1 = new Date().getTime();
        String qr = time1 + String.valueOf(newCount);
        device.setDeviceQrCode(qr);

        //生成二维码信息
        String codeValue = "设备名称: <br/>" + device.getDeviceName() + "<br/><br/>设备编号: " + newCount;
        device.setDeviceCodeValue(codeValue);

        return deviceMapper.insert(device);
    }

    /**
     * 修改设备信息
     *
     * @param id
     * @param device
     */
    @Override
    public int update(Long id, ReagentDevice device) {
        //查询是否有相同编号的设备device_code
        ReagentDeviceExample example = new ReagentDeviceExample();
        example.createCriteria().andDeviceCodeEqualTo(device.getDeviceCode());
        List<ReagentDevice> deviceList = deviceMapper.selectByExample(example);
        if (deviceList.size() > 0 && !deviceList.get(0).getId().equals(id)) {
            return 0;
        }
        device.setId(id);
        device.setUpdateTime(new Date());

        Long time1 = new Date().getTime();
        String qr = time1 + String.valueOf(device.getDeviceCode());
        device.setDeviceQrCode(qr);

        //生成二维码信息
        String codeValue = "设备名称: <br/>" + device.getDeviceName() + "<br/><br/>设备编号: " + device.getDeviceCode();
        device.setDeviceCodeValue(codeValue);

        return deviceMapper.updateByPrimaryKeySelective(device);
    }

    /**
     * 删除指定设备
     */
    @Override
    public int delete(Long id) {
       /* int count = deviceMapper.deleteByPrimaryKey(id);
        return count;*/
        return 0;
    }

    /**
     * 分页获取设备列表
     *
     * @param keyword
     * @param pageSize
     * @param pageNum
     */
    @Override
    public List<ReagentDevice> list(String keyword, String createBy, Integer pageSize, Integer pageNum) {
        String branch = adminDao.selectBranch(createBy);
        List<ReagentDevice> deviceList;
        PageHelper.startPage(pageNum, pageSize);
        deviceList = deviceDao.getDeviceList(keyword, branch);
        return deviceList;
    }

    /**
     * 根据用户名所属科室获取设备列表
     *
     * @param username
     */
    @Override
    public List<ReagentDevice> getDeviceList(String username) {
        String branch = adminDao.selectBranch(username);
        List<ReagentDevice> deviceList;
        deviceList = deviceDao.getDeviceList(null, branch);
        return deviceList;
    }

    @Override
    public ReagentDevice getItem(Long id) {
        return deviceMapper.selectByPrimaryKey(id);
    }

    /**
     * 根据设备二维码获取设备信息
     */
    @Override
    public ReagentDevice getItemByQrcode(String qrcode) {
        return deviceDao.getItemByQrcode(qrcode);
    }

    /**
     * 修改设备状态
     *
     * @param id
     * @param device
     */
    @Override
    public int updateStatus(Long id, ReagentDevice device) {
        device.setId(id);
        device.setUpdateTime(new Date());
        return deviceMapper.updateByPrimaryKeySelective(device);
    }
}
