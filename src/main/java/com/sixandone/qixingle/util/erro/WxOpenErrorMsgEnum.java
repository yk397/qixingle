package com.sixandone.qixingle.util.erro;

import lombok.Getter;

/**
 * 微信开放平台错误码信息
 */
@Getter
public enum WxOpenErrorMsgEnum {

    CODE_0(0,"无定义");
    private final int code;
    private final String msg;

    WxOpenErrorMsgEnum(int code, String msg) {
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
