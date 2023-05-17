package com.sixandone.qixingle.entity;


import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;


/**
 * @ClassName yk
 * @Descprition: 商家实体类
 * @Autor DELL
 * @Date 2023/5/13 9:22
 **/
@Data
public class Business {

    private String businessId;//商家id
    private String businessName;//店铺名称
    private String businessInfo;//商户简介

    private String location;//商户粗略位置
    private Date accessionTime;//商家加入时间
    private Integer serviceStatus;//服务状态(0:在服务，1:微服务）
    private Date serviceStartTime;//营业开始时间
    private Date serviceEndTime;//打烊时间
    private BigDecimal revenge;//收入金额



}
