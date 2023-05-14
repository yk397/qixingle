package com.sixandone.qixingle.vo;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @ClassName yk
 * @Descprition: 返回前端的订单对象
 * @Autor DELL
 * @Date 2023/5/14 10:44
 **/
@Data
@Builder
public class responseToClientOrder {

    private String orderUmber;//订单编号
    private String userName;//租户名
    private String businessName;//商家名称
    private List<String> bicycleNumbers;//自行车编号
    private BigDecimal bicyclePrice;//租自行车总价价格
    private Date createTime;//创建时间
    private Date effectTime;//订单生效时间
    private Date unEffectTime;//订单失效时间
    private Integer orderStatus;//订单状态
    private Integer payStatus;//订单支付状态
    private Date payTime;//支付时间
}
