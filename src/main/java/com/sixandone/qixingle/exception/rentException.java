package com.sixandone.qixingle.exception;

import lombok.Data;

/**
 * @ClassName yk
 * @Descprition: 业务异常类信息
 * @Autor DELL
 * @Date 2023/5/15 11:49
 **/

@Data
public class rentException extends RuntimeException {

    /**
     * 错误码
     */
    private final ErrorCode errorCode;

    private final String descreption;

    /**
     * 冗余字段
     */
    private String code;


    /**
     * 无参默认构造UNSPECIFIED
     */
    public rentException() {
        super(rentErrorCodeEnum.UNSPECIFIED.getDescription());
        this.errorCode = rentErrorCodeEnum.UNSPECIFIED;
        this.descreption = this.errorCode.getDescription();
    }

    /**
     * 指定错误码构造通用异常
     * @param errorCode 错误码
     */
    public rentException(final ErrorCode errorCode) {
        super(errorCode.getDescription());
        this.errorCode = errorCode;
        this.descreption = this.errorCode.getDescription();
    }

    /**
     * 指定详细描述构造通用异常
     * @param detailMessage 详细描述
     */
    public rentException(final String detailMessage) {
        super(detailMessage);
        this.errorCode = rentErrorCodeEnum.UNSPECIFIED;
        this.descreption = this.errorCode.getDescription();
    }

    /**
     * 根据导火索构造通用异常
     * @param throwable 导火索
     */
    public rentException(final Throwable throwable) {
        super(throwable);
        this.errorCode = rentErrorCodeEnum.UNSPECIFIED;
        this.descreption = this.errorCode.getDescription();
    }


    /**
     * 根据导火索、错误码构造通用异常
     * @param errorCode 错误码
     * @param throwable 导火索
     */
    public rentException(final ErrorCode errorCode,final Throwable throwable) {
        super(errorCode.getDescription(),throwable);
        this.errorCode = errorCode;
        this.descreption = this.errorCode.getDescription();
    }

    /**
     * 根据详细描述、错误码构造通用异常
     * @param errorCode 错误码
     * @param detailMessage 导火索
     */
    public rentException(final ErrorCode errorCode,final String detailMessage) {
        super(detailMessage);
        this.errorCode = errorCode;
        this.descreption = this.errorCode.getDescription();
    }

    /**
     * 根据导火索、详细描述构造通用异常
     * @param detailMessage 详细描述
     * @param throwable 导火索
     */
    public rentException(final String detailMessage,final Throwable throwable) {
        super(detailMessage,throwable);
        this.errorCode = rentErrorCodeEnum.UNSPECIFIED;
        this.descreption = this.errorCode.getDescription();
    }

    /**
     * 构造通用异常
     * @param errorCode 错误码
     * @param throwable 导火索
     * @param detailMessage 详细描述
     */
    public rentException(final ErrorCode errorCode,final Throwable throwable,
                         final String detailMessage) {
        super(detailMessage,throwable);
        this.errorCode = errorCode;
        this.descreption = this.errorCode.getDescription();
    }

}
