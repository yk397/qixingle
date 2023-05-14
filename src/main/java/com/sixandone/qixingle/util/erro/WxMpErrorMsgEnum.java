package com.sixandone.qixingle.util.erro;

import lombok.Getter;

/**
 * 微信公众平台错误码返回
 */
@Getter
public enum WxMpErrorMsgEnum {

    CODE_0(0,"无定义");

    private final int code;
    private final String msg;

    WxMpErrorMsgEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    /**
     * 通过错误代码查找其中文含义..
     */
    public static String findMsgByCode(int code){
        return null;
    }

}
