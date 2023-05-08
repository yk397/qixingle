package com.sixandone.qixingle.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName yk
 * @Descprition:TODO
 * @Autor DELL
 * @Date 2023/5/2 7:08
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class resposeUser {
    private final String Role = "RENTUSER";//用户角色

    @JsonProperty(value = "openid",required = true)
    private String openid;//唯一用户标识

    @JsonProperty(value = "sessionkey",required = true)
    private String sessionKey;//会话密钥

    @JsonProperty(value = "unionid",required = true)
    private String unionId;//用户在开放平台的唯一标识

    @JsonProperty(value = "errcode",required = true)
    private String errCode;//错误信息

    @JsonProperty(value = "errmsg",required = true)
    private String errMsg;//错误码

}
