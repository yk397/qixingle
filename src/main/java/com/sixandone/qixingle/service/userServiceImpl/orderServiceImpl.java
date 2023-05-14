package com.sixandone.qixingle.service.userServiceImpl;

import com.sixandone.qixingle.entity.Orders;
import com.sixandone.qixingle.service.orderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * @ClassName yk
 * @Descprition: 订单服务接口实现
 * @Autor DELL
 * @Date 2023/5/14 14:33
 **/
@Service
@Slf4j
public class orderServiceImpl implements orderService {

    @Override
    public Object generateOrder(String rentUserOpenId, List<String> bicycleNumbers) {
        return null;
    }
    public Object generateOrder(String rentUserOpenId, String bicycleNumber) {
        return null;
    }

    @Override
    public String generateNumber(Object order) {
        return null;
    }

    @Override
    public Boolean addOrder(Orders orders) {
        return null;
    }

    @Override
    public Boolean cancelOrder(Object order) {
        return null;
    }

    @Override
    public Boolean modifyOrder(Object order) {
        return null;
    }

    @Override
    public void printOrder(Object order) {

    }

    @Override
    public void destroyOrder(Object order) {

    }

    @Override
    public Boolean isExpired(Object order) {
        return null;
    }

    @Override
    public Integer orderStatus(Object order) {
        return null;
    }

    @Override
    public Integer payStatus(Object order) {
        return null;
    }

    @Override
    public Object getOrderInfo(Object template, Object... info) {
        return null;
    }

    @Override
    public BigDecimal calculateTotal(Object order) {
        return null;
    }
}
