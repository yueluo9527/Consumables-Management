package jp.co.nss.hrm.backend.api.config;

import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class WxMpConfig {
    @Value("${wx.mp.appid}")
    private String APPID;

    @Value("${wx.mp.appSecret}")
    private String APP_SECRET;

    @Bean
    public WxMpService wxMpService(){
        WxMpService wxMpService = new WxMpServiceImpl();
        WxMpInMemoryConfigStorage ConfigStorage = new WxMpInMemoryConfigStorage();
        ConfigStorage.setAppId(APPID);
        ConfigStorage.setSecret(APP_SECRET);
        wxMpService.setWxMpConfigStorage(ConfigStorage);
        return wxMpService;
    }
}
