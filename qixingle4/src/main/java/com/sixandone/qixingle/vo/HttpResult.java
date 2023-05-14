package com.sixandone.qixingle.vo;

import lombok.Builder;
import lombok.Data;

/**
 * @ClassName yk
 * @Descprition: 统一token返回对象
 * @Autor DELL
 * @Date 2023/5/11 19:19
 **/
@Data
@Builder
public class HttpResult {

    /**
     * 响应码
     */
    private int code;

    /**
     * 响应消息
     */
    private String msg;

    /**
     * 响应数据
     */
    private String data;
}
