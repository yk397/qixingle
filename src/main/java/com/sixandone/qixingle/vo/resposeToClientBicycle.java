package com.sixandone.qixingle.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @ClassName yk
 * @Descprition:返回客户端的自行车json数据
 * @Autor DELL
 * @Date 2023/5/7 8:02
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class resposeToClientBicycle implements Serializable {

    private String bicycleNumber;//自行车编号
    private String bicycleBrand;//自行车品牌
    private String bicyclePrice;//自行车价格
    private String bicycleType;//自行车类型
    private String businessId;//自行车所属人id
    private String bicycleInfo;//自行车备注
}
