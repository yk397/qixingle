package com.sixandone.qixingle.service;

import com.sixandone.qixingle.entity.Business;
import com.sixandone.qixingle.vo.businessRevenge;


import java.util.List;

/**
 * name:商家服务接口
 * describe:系统内部调用接口，面向商家服务接口,面向管理员接口
 */
public interface businessService {

    /**
     * 添加商家
     * @param business 商户对象
     * @return boolean
     */
    boolean addBusiness(Business business);


    /**
     * 移除商家
     * @param businessId 商家id
     * @return boolean
     */
    boolean removeBusiness(String businessId);

    /**
     * 更具businessId查找对应商户
     * @param businessId 商户id
     * @return 商户对象
     */
    Business queryBusinessById(String businessId);

    /**
     * 管理员修改商户数据
     * @param item 修改项
     * @return boolean
     */
    boolean modifyBusiness(Object...item);

    /**
     * 查询对应项的商户
     * @param item 查询条件
     * @return 返回符合条件的Business列表
     */
    List<Business> queryBusiness(Object...item);


    //面向商户

    /**
     * 发送还车随机码
     * @param code 随机码
     * @return boolean
     */
    Boolean messageReturnCode(String code);

    /**
     * 查询商家的自行车租用记录
     * @param businessId 商家id
     * @return businessRevenge租用记录类
     */
    List<businessRevenge> queryRevengeCord(String businessId);


    /**
     * 检查商家是否在营业时间内
     * @param business 商户对象
     * @return boolean
     */
    boolean checkIsWork(Business business);

    /**
     * 查询商家图片
     * @param bicycleId 自行车编码
     * @return byte[]
     */
    public byte[] queryBusinessImg(String bicycleId);



}
