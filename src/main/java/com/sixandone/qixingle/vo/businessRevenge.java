package com.sixandone.qixingle.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName yk
 * @Descprition: 商家查看收益
 * @Autor DELL
 * @Date 2023/5/14 10:28
 **/
@Data
public class businessRevenge {

    private String orderNumber;//订单编号
    private String rentUser;//租户，用户名
    private String bookTime;//预定时间
    private BigDecimal money;//支付金额
    private Date payTime;//支付时间
    private String bicycleNumber;//自行车编号
}
