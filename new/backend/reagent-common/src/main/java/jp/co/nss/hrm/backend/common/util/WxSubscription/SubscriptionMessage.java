package jp.co.nss.hrm.backend.common.util.WxSubscription;

import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class SubscriptionMessage {
    @Autowired
    private WxMpService wxMpService;

    /**
     * 医院下单后通知供货商
     */
    public static void sendOrderMsg(String appid,
                                    String appSecret,
                                    String userOpenid,
                                    String orderId,
                                    String hospitalName) {

        // 消息模板 ID
        // {{first.DATA}}
        // 订单编号：{{keyword1.DATA}}
        // 订货终端：{{keyword2.DATA}}
        // 下单时间：{{keyword3.DATA}}
        // {{remark.DATA}}
//        String OrderMsgTemplateId = "oFEM02kwy9zRR9vHTBU6kPEvNblMNRUSz8Osb4iDABI";
        String OrderMsgTemplateId = "Th5MwuyqSjfADUDOJ5PSGDf1swr1-nHmOtLYlVX8n_8";

        // 卡片详情跳转页
//        String detailUrl = "https://bing.com";

        SimpleDateFormat sdf = new SimpleDateFormat();  // 格式化时间
        sdf.applyPattern("yyyy-MM-dd HH:mm");   // a为am/pm的标记
        Date date = new Date(); // 获取当前时间
        String timeNow = sdf.format(date);  // 24小时制

        WxMpInMemoryConfigStorage wxStorage = new WxMpInMemoryConfigStorage();
        wxStorage.setAppId(appid);
        wxStorage.setSecret(appSecret);

        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxStorage);

        List<WxMpTemplateData> wxMpTemplateDataList = Arrays.asList(
                new WxMpTemplateData("first", "您有一个新的订货单", "#000000"),
                new WxMpTemplateData("keyword1", orderId),
                new WxMpTemplateData("keyword2", hospitalName),
                new WxMpTemplateData("keyword3", timeNow),
                new WxMpTemplateData("remark", "请登录系统查看订单详情并及时配货")
        );

        WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
                .toUser(userOpenid)
                .templateId(OrderMsgTemplateId)
                .data(wxMpTemplateDataList)
//                .url(detailUrl)
                .build();

        try {
            wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
        } catch (Exception e) {
            System.out.println("推送失败：" + e.getMessage());
        }

    }

}
