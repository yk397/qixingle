package com.sixandone.qixingle.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @ClassName yk
 * @Descprition:系统存储的自行车
 * @Autor DELL
 * @Date 2023/5/7 8:01
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bicycle {

    private String bicycleNumber;//自行车编号
    private String bicycleBrand;//自行车品牌
    private BigDecimal bicyclePrice;//自行车价格
    private String bicycleType;//自行车类型
    private byte[] bicycleImage;//自行车图片
    private String bicycleInfo;//自行车备注
    private Integer isRented;//自行车是否被租用，0：空闲，1：租用
    private Integer isReserved;//自行车是否被预定，0：空闲，1：预定
    private Integer isUsable;//自行车是否损坏，0：没损坏，1：损坏
    private Integer usedCount;//自行车被使用的次数

}
