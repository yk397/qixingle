package com.sixandone.qixingle.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @ClassName yk
 * @Descprition:返回客户端的自行车json数据
 * @Autor DELL
 * @Date 2023/5/7 8:02
 **/
@Data
public class resposeToClientBicycle {

    private String bicycleNumber;//自行车编号
    private String bicycleBrand;//自行车品牌
    private BigDecimal bicyclePrice;//自行车价格
    private String bicycleType;//自行车类型
    private byte[] bicycleImage;//自行车图片
    private String bicycleInfo;//自行车备注
}
