package com.sixandone.qixingle.dao;

import com.sixandone.qixingle.entity.Bicycle;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BicycleInfoDao {

    /**
     * 查询被使用次数前20，且使用次数不重复的数据。
     * @return
     */
    public List<Bicycle> queryBicycleInfo();

    /**
     * 用自行车编号查询自行车对象
     * @param bicycleNumber 自行车编号
     * @return 自行车对象
     */
    public Bicycle queryBicycleByNumber(String bicycleNumber);
}
