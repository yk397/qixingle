package com.sixandone.qixingle.exception;

import org.apache.commons.lang3.StringUtils;

/**
 * Description:业务错误码
 *
 */
public enum rentErrorCodeEnum implements ErrorCode {

    /**
     * 未指明的异常
     */
    UNSPECIFIED("500","网络异常，请稍后再试"),
    NO_SERVICE("404","网络异常，服务器熔断"),


    /**
     * 租车类
     */
    INVALID_BICYCLE_NUMBER("6000","无效自信车编码"),
    INVALID_ORDER_NUMBER("6001","无效订单编码"),
    LACK_RENT_CONDITION("6002","无预定且没有指定自行车编码"),
    BICYCLE_ON_BUSY("6003","自行车正在出租"),
    BUSINESS_CLOSED("6004","商家未服务"),
    BICYCLE_QUANTITY_OVER("6005","自行车数量超额"),


    ;

    /**
     * 错误码
     */
    private final String code;

    /**
     * 描述
     */
    private final String description;

    /**
     *
     * @param code 错误码
     * @param description 描述
     */
    private rentErrorCodeEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    /**
     * 根据错误码查询枚举
     * @param code 错误码
     * @return 枚举
     */
    public static rentErrorCodeEnum getByCode(String code) {
        for (rentErrorCodeEnum value : rentErrorCodeEnum.values()) {
            if (StringUtils.equals(code, value.geCode())) {
                return value;
            }
        }
        return UNSPECIFIED;
    }

    /**
     * 查询是否包含次编码
     * @param code 错误码
     * @return boolean
     */
    public static boolean contains(String code) {
        for (rentErrorCodeEnum value : rentErrorCodeEnum.values()) {
            if (StringUtils.equals(code, value.geCode())) {
                return true;
            }
        }
        return false;
    }


    @Override
    public String geCode() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }
}
