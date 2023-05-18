package com.sixandone.qixingle.service.userServiceImpl;

import com.sixandone.qixingle.entity.Orders;
import com.sixandone.qixingle.service.orderService;
import com.sixandone.qixingle.util.NumberUtil;
import com.sixandone.qixingle.vo.responseToClientOrder;
import com.sixandone.qixingle.exception.rentException;
import com.sixandone.qixingle.exception.rentErrorCodeEnum;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @ClassName yk
 * @Descprition: 订单服务接口实现
 * @Autor DELL
 * @Date 2023/5/14 14:33
 **/
@Service
@Slf4j
@AllArgsConstructor
public class orderServiceImpl implements orderService {

    private final bicycleService bicycleService;

    @Override
    public Object generateRentOrder(String rentUserOpenId,String businessId, List<String> bicycleNumbers) {
        Orders orders = Orders.builder()
                .orderUmber(NumberUtil.getOrderCode(rentUserOpenId))
                .bicycleCount(getListCount(bicycleNumbers))
                .rentUserOpenid(rentUserOpenId)
                .businessId(businessId)
                .bicycleNumbers(bicycleNumbers)
                .bicyclePrice(null)
                .createTime(new Date())
                .effectTime(new Date())
                .unEffectTime(null)
                .orderStatus(1)
                .payStatus(0)
                .payTime(null)
                .build();
        if (orders == null) {
            throw new rentException(rentErrorCodeEnum.CREATE_ORDER_EXCEPTION,"订单生成失败");
        }
        return orders;

    }

    @Override
    public Object generateOrder(String rentUserOpenId,String businessId, List<String> bicycleNumbers) {
        Orders orders = Orders.builder()
                .orderUmber(NumberUtil.getOrderCode(rentUserOpenId))
                .bicycleCount(getListCount(bicycleNumbers))
                .rentUserOpenid(rentUserOpenId)
                .businessId(businessId)
                .bicycleNumbers(bicycleNumbers)
                .bicyclePrice(null)
                .createTime(new Date())
                .effectTime(null)
                .unEffectTime(null)
                .orderStatus(-1)
                .payStatus(0)
                .payTime(null)
                .build();
        if (orders == null) {
            throw new rentException(rentErrorCodeEnum.CREATE_ORDER_EXCEPTION,"订单生成失败");
        }
        return orders;
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



    @Override
    public Object effectOrder(Object order) {
        return null;
    }

    @Override
    public Boolean checkOrder(responseToClientOrder orders) {
        return null;
    }

    private int getListCount(List<String> strings){
        int counts = 0;
        for (String str:strings
             ) {
            ++counts;
        }
        return counts;
    }
}
