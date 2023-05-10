package com.sixandone.qixingle.service.userService;

import com.sixandone.qixingle.util.erro.WxErrorException;
import com.sixandone.qixingle.vo.WxPhoneNumberInfo;
import com.sixandone.qixingle.vo.WxUserInfo;
import com.sixandone.qixingle.vo.resposeUser;
import com.sixandone.qixingle.vo.resposeToClientUser;


/**
 * 用户微信接口调用
 */
public interface userService {




    /**
     * 包装用于返回客户端的用户数据
     * @param jsCode
     * @param phoneNumber
     * @param userName
     * @return
     */
    public resposeToClientUser loginIn(String jsCode,String phoneNumber,String userName);


    /**
     * 获取登录后的session信息.
     *
     * @param jsCode 登录时获取的 code
     * @return .
     */
    resposeUser getSessionInfo(String jsCode);

    /**
     * 解密用户敏感数据.
     *
     * @param sessionKey    会话密钥
     * @param encryptedData 消息密文
     * @param ivStr         加密算法的初始向量
     */
    WxUserInfo getUserInfo(String sessionKey, String encryptedData, String ivStr);


    /**
     * 获取手机号信息,基础库:2.21.2及以上
     *
     * @param code 动态令牌
     * @return .
     */
    WxPhoneNumberInfo getPhoneNoInfo(String code) throws WxErrorException;


    /**
     * 验证用户信息完整性.
     *
     * @param sessionKey 会话密钥
     * @param rawData    微信用户基本信息
     * @param signature  数据签名
     * @return .
     */
    boolean checkUserInfo(String sessionKey, String rawData, String signature);



}
