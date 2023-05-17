package com.sixandone.qixingle.dao;

import com.sixandone.qixingle.entity.Orders;

public interface orderDao {

    /**
     * 将订单存入数据库
     * @param orders 订单对象
     * @return boelean
     */
    Boolean addOrder(Orders orders);

}
