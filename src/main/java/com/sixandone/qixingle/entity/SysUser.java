package com.sixandone.qixingle.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName yk
 * @Descprition:系统存储的用户
 * @Autor DELL
 * @Date 2023/5/2 22:19
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SysUser implements Serializable {

    private Integer userId;//用户id
    private String openid;//微信用户唯一标识
    private String sessionKey;//会话密钥
    private String unionId;//用户在开放平台的唯一标识
    private String phoneNumber;//用户电话号码
    private String userName;//用户名
    private String address;//用户所在地址
    private Integer enabled;//是否启用
    private Integer accountNoExpired;//账户是否过期
    private Integer accountNoLocked;//账户是否锁定


}
