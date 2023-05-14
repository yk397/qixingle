package com.sixandone.qixingle.service.userService;

import com.sixandone.qixingle.util.erro.WxErrorException;
import com.sixandone.qixingle.vo.WxKeFuMessage;

/**
 * 微信消息发送接口
 */
public interface WxMsgService{
    /**
     * <pre>
     * 发送客服消息
     * 详情请见: <a href="https://developers.weixin.qq.com/miniprogram/dev/api-backend/customerServiceMessage.send.html">发送客服消息</a>
     * 接口url格式：https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN
     * </pre>
     *
     * @param message 客服消息
     * @return
     */
    boolean sendKefuMsg(WxKeFuMessage message) throws WxErrorException;



}
