package com.sixandone.qixingle.service.userService;
import com.sixandone.qixingle.util.erro.WxErrorException;
import com.sixandone.qixingle.util.http.RequestHttp;
import com.sixandone.qixingle.vo.WxConfig;
import com.sixandone.qixingle.vo.resposeUser;

/**
 * 微信接口调用
 */
public interface wxUserService extends wxService{
    /**
     * 获取access_token.
     */
    String GET_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s";

    /**
     * The constant JSCODE_TO_SESSION_URL.
     */
    String JSCODE_TO_SESSION_URL = "https://api.weixin.qq.com/sns/jscode2session";
    /**
     * getPaidUnionId
     */
    String GET_PAID_UNION_ID_URL = "https://api.weixin.qq.com/wxa/getpaidunionid";




    /**
     * 获取登录后的session信息.
     *
     * @param jsCode 登录时获取的 code
     * @return the wx ma jscode 2 session result
     * @throws WxErrorException the wx error exception
     */
    resposeUser jsCode2SessionInfo(String jsCode) throws WxErrorException;



    /**
     * 验证消息的确来自服务器
     * 详情请见: http://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421135319&token=&lang=zh_CN
     * @param timestamp
     * @param nonce
     * @param signature
     * @return
     */
    boolean checkSignature(String timestamp, String nonce, String signature);


    /**
     * 不强制刷新
     * 获取accessToken
     * @return the access token
     * @throws WxErrorException
     */
    String getAccessToken() throws WxErrorException;


    /**
     *获取access_token，本方法线程安全.
     *
     *且在多线程同时刷新时只刷新一次，避免超出2000次/日的调用次数上限
     *
     * 另：本service的所有方法都会在access_token过期是调用此方法
     *
     * 详情请见: http://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140183&token=&lang=zh_CN
     * @param forceRefresh 强制刷新
     * @return the access token
     * @throws WxErrorException
     */
    String getAccessToken(boolean forceRefresh) throws WxErrorException;


    /**
     * 设置当微信系统相应繁忙时，最大重试次数
     *
     * 默认：5次
     * @param retrySleepMillis 最大重试次数
     */
    void setRetrySleepMillis(int retrySleepMillis);


    /**
     * 获取config对象
     * @return WxConfig
     */
    WxConfig getWxConfig();


    /**
     * 返回消息（客服消息和模版消息）发送接口方法实现类，以方便调用其各个接口.
     *
     * @return WxMaMsgService msg service
     */
    WxMsgService getMsgService();


    /**
     * 返回用户相关接口方法的实现类对象，以方便调用其各个接口.
     *
     * @return WxMaUserService user service
     */
    userService getUserService();


    /**
     * 返回内容安全相关接口服务对象.
     *
     * @return WxMaShareService sec check service
     */
    WxSecCheckService getSecCheckService();


    /**
     * 初始化http请求对象.
     */
    void initHttp();


    /**
     * 请求http请求相关信息.
     *
     * @return . request http
     */
    RequestHttp getRequestHttp();


    /**
     * 获取服务端网络接口服务对象
     *
     * @return 。internet service
     */
    WxMaInternetService getInternetService();

    /**
     * 返回小程序交易组件-售后服务接口
     *
     * @return
     */
    WxMaShopAfterSaleService getShopAfterSaleService();

    /**
     * 返回小程序交易组件-订单服务接口
     *
     * @return
     */
    WxMaShopOrderService getShopOrderService();


    /**
     * 返回小程序交易组件-接入申请接口
     *
     * @return
     */
    WxMaShopRegisterService getShopRegisterService();

    /**
     * 返回小程序交易组件-商户入驻接口
     *
     * @return
     */
    WxMaShopAccountService getShopAccountService();

    /**
     * 小程序交易组件-接入商品前必需接口-类目相关
     *
     * @return
     */
    WxMaShopCatService getShopCatService();

    /**
     * 小程序交易组件-接入商品前必需接口-上传图片
     *
     * @return
     */
    WxMaShopImgService getShopImgService();

    /**
     * 小程序交易组件-接入商品前必需接口-审核相关接口
     *
     * @return
     */
    WxMaShopAuditService getShopAuditService();

    /**
     * 小程序支付管理-订单支付
     * @return getWxMaShopPayService
     */
    WxMaShopPayService getWxMaShopPayService();



}
