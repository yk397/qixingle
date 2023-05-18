package com.sixandone.qixingle.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @ClassName yk
 * @Descprition: 系统订单实体类
 * @Autor DELL
 * @Date 2023/5/13 7:37
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Orders {

    private String orderUmber;//订单编号
    private Integer bicycleCount;//租用单品数量
    private String rentUserOpenid;//租户openid
    private String businessId;//商家id
    private List<String> bicycleNumbers;//自行车编号
    private BigDecimal bicyclePrice;//租自行车总价价格
    private Date createTime;//创建时间
    private Date effectTime;//订单生效时间
    private Date unEffectTime;//订单失效时间
    private Integer orderStatus;//订单状态(0:失效，-1、生效前(预定)，1、生效中)
    private Integer payStatus;//订单支付状态(0:不可支付，1:已支付,-1:等待支付)
    private Date payTime;//支付时间
}
