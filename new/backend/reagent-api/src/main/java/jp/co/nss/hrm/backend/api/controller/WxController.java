package jp.co.nss.hrm.backend.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jp.co.nss.hrm.backend.api.aop.annotation.OperationLogAnnotation;
import jp.co.nss.hrm.backend.api.dto.WxUser;
import jp.co.nss.hrm.backend.api.service.ReagentSupplierService;
import jp.co.nss.hrm.backend.api.service.WxService;
import jp.co.nss.hrm.backend.common.api.CommonResult;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

@Controller
@Api(tags="WxController")
@RequestMapping("/wx")
public class WxController {

    @Value("${wx.mp.appid}")
    private String APPID;

    @Value("${wx.mp.appSecret}")
    private String APP_SECRET;

    private static final String TOKEN = "321";

    @Autowired
    private WxMpService wxMpService;

    @Autowired
    private WxService wxService;

    @Autowired
    private ReagentSupplierService reagentSupplierService;

    @OperationLogAnnotation(operaModule = "微信", operaDesc = "微信授权")
    @ApiOperation("微信授权")
    @RequestMapping(value = "/weChatToken", method = RequestMethod.GET)
    @ResponseBody
    /**
     * 微信与当前服务器建立连接，根据token，校验服务器
     * signature 微信加密签名
     * timestamp 时间戳
     * nonce 随机数
     * echostr 随机字符串
     */
    public String weChatToken(@RequestParam(value = "signature") String signature,
                                    @RequestParam(value = "timestamp") String timestamp,
                                    @RequestParam(value = "nonce") String nonce,
                                    @RequestParam(value = "echostr") String echostr) {
        String sortStr = sort(TOKEN, timestamp, nonce);
        String mySignature = shal(sortStr);

        if (!"".equals(signature) && !"".equals(mySignature) && signature.equals(mySignature)) {
            System.out.println("------微信签名校验通过------");
            return echostr;
        } else {
            System.out.println("------微信签名校验失败------");
        }

        return null;
    }

    @OperationLogAnnotation(operaModule = "微信", operaDesc = "获取用户code")
    @ApiOperation("微信获取用户code")
    @RequestMapping(value = "/getUserCode", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<String> getUserCode(@RequestParam(value = "redirectUrl") String url,
                                    @RequestParam(value = "state") String state) {
        // 不跳出授权页面只能获取用到的openid信息
        String _scope = "snsapi_base";

        /*
        * https://open.weixin.qq.com/connect/oauth2/authorize?
        *   appid=APPID&
        *   redirect_uri=回调地址&
        *   response_type=code&
        *   scope=选择的作用域&
        *   state=如果有附带信息就写没有就是null#wechat_redirect
        * */

        String result = null;

        try {
            result = wxMpService.oauth2buildAuthorizationUrl(url,
                    _scope,
                    URLEncoder.encode(state, String.valueOf(StandardCharsets.UTF_8)));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return CommonResult.success(result);

    }

    @OperationLogAnnotation(operaModule = "微信", operaDesc = "微信公众号获取用户openid")
    @ApiOperation("微信获取用户openid")
    @RequestMapping(value = "/getUserOpenid")
    @ResponseBody
    public CommonResult<String> getUserOpenid(@RequestParam(value = "code") String code) {
        try {
            //未登录过获取openId进行授权
            String openid = null;
            WxMpOAuth2AccessToken accessToken = wxMpService.oauth2getAccessToken(code);
            openid = accessToken.getOpenId();

            return CommonResult.success(openid);

        }catch (WxErrorException e) {
            // e.printStackTrace();    //尽量不要使用这个打印异常，会造成内存锁，使用log日志就好
//            log.error(e.getError().getErrorMsg());
            return CommonResult.failed("获取用户openid失败");
        }
    }


    @ApiOperation("根据手机号绑定用户微信")
    @RequestMapping(value = "/bindWxByPhoneNumber")
    @ResponseBody
    public CommonResult bindWxByPhoneNumber(@RequestParam(value = "phoneNumber") String phoneNumber,
                                            @RequestParam(value = "openid") String openid) {
        // 根据 openid 查找用户是否已注册
        WxUser wxUser = wxService.getWxUserByOpenid(openid);
        if (wxUser != null) {   // 当前微信号已注册
            return CommonResult.success("当前微信号已注册");
        }

        // 根据手机号查找供货商联系人
        String supplierCode = reagentSupplierService.getSupplierCodeByPhoneNumber(phoneNumber);
        if (supplierCode == null) {
            return CommonResult.success("该手机号未注册");
        }

        int result = wxService.insertWxUserBySupplierCode(openid, supplierCode);

        return CommonResult.success(result);
    }



    /**
     * 参数排序
     * @param token
     * @param timestamp
     * @param nonce
     * @return
     */
    public String sort(String token, String timestamp, String nonce) {
        String[] strArray = {token, timestamp, nonce};
        Arrays.sort(strArray);
        StringBuilder sb = new StringBuilder();
        for (String str : strArray) {
            sb.append(str);
        }
        return sb.toString();
    }

    /**
     * 字符串进行shal加密
     * @param str
     * @return
     */
    public String shal(String str){
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.update(str.getBytes());
            byte messageDigest[] = digest.digest();

            StringBuffer hexString = new StringBuffer();
            // 字节数组转换为 十六进制 数
            for (int i = 0; i < messageDigest.length; i++) {
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

}
