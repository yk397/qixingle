package com.sixandone.qixingle.vo;

import lombok.Builder;
import lombok.Data;
import com.sixandone.qixingle.exception.rentErrorCodeEnum;

/**
 * @ClassName yk
 * @Descprition: 统一token返回对象
 * @Autor DELL
 * @Date 2023/5/11 19:19
 **/
@Data
@Builder
public class HttpResult<T> {

    /**
     * 响应码
     */
    private String code;

    /**
     * 响应消息
     */
    private String msg;

    /**
     * 响应数据
     */
    private T data;

    /**
     * 接口请求时间
     */
    private long timestamp;


    public static <T> HttpResult<T> success(T data){
        return (HttpResult<T>) HttpResult.builder()
                .code(rentErrorCodeEnum.SUCCESS.geCode())
                .msg(rentErrorCodeEnum.SUCCESS.getDescription())
                .data(data)
                .timestamp(System.currentTimeMillis())
                .build();

    }

    public static <T> HttpResult<T> fail(T data){
        return (HttpResult<T>) HttpResult.builder()
                .code(rentErrorCodeEnum.UNSPECIFIED.geCode())
                .msg(rentErrorCodeEnum.UNSPECIFIED.getDescription())
                .data(data)
                .timestamp(System.currentTimeMillis())
                .build();

    }
}
