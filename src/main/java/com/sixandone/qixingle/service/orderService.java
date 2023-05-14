package com.sixandone.qixingle.service;


import com.sixandone.qixingle.entity.Orders;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 * name:订单处理接口
 * describe:面向用户接口，和系统内部调用接口，管理员调用接口
 */
public interface orderService {


    /**
     * 生成订单
     * @Param rentUserOpenid 租户openid，bicycleNumber 自行车编号
     * @return 订单对象
     */
    Object generateOrder(String rentUserOpenId, List<String> bicycleNumbers);

    /**
     * 生成唯一的订单编号
     * @param order 订单对象
     * @return 编号
     */
    String generateNumber(Object order);

    /**
     * 将订单存入数据库
     * @param orders 订单对象
     * @return boelean
     */
    Boolean addOrder(Orders orders);

    /**
     * 取消订单
     * @param order 订单对象
     * @return boolean
     */
    Boolean cancelOrder(Object order);

    /**
     * 更新订单（更新订payStatus,orderStatus,effectTime,UnEffectTime,pyaTime)
     * @param order 订单对象
     * @return
     */
    Boolean modifyOrder(Object order);


    /**
     * 打印订单
     * @param order 订单对象
     */
    void printOrder(Object order);

    /**
     * 销毁订单
     * @param order
     */
    void destroyOrder(Object order);

    /**
     * 是否过期
     * @param order 订单对象
     * @return boolean
     */
    Boolean isExpired(Object order);

    /**
     * 订单状态
     * @param order 订单对象
     * @return 订单status(0:失效，-1、生效前(预定)，1、生效中)
     */
    Integer orderStatus(Object order);

    /**
     * 订单支付状态
     * @param order 订单对象
     * @return status(0:不可支付，1:已支付,-1:等待支付)
     */
    Integer payStatus(Object order);

    /**
     * 获取订单信息
     * 使用时创建信息模板，传入想要获取的信息名称
     * @param info：想要获取的信息列表 template信息模板
     * @return 信息模板
     */
    Object getOrderInfo(Object template,Object...info);

    /**
     * 计算总价
     * @param order 订单对象
     * @return BigDecimal 金额
     */
    BigDecimal calculateTotal(Object order);
}
