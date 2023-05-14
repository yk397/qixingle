package com.sixandone.qixingle.vo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName yk
 * @Descprition:微信配置参数
 * @Autor DELL
 * @Date 2023/5/9 21:00
 **/
@Data
@Component
@ConfigurationProperties(prefix = "${wxConfig}")
public class WxConfig {

    /**
     * 小程序appid
     */
    private String appid;

    /**
     * 小程序appSecret
     */
    private String secret;

}
