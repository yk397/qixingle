package com.sixandone.qixingle.dao;

import com.sixandone.qixingle.entity.Bicycle;

import java.util.List;

public interface BicycleInfoDao {

    /**
     * 查询被使用次数前20，且使用次数不重复的数据。
     * @return
     */
    public List<Bicycle> queryBicycleInfo();
}
