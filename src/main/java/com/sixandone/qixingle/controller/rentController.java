package com.sixandone.qixingle.controller;

import cn.binarywang.wx.miniapp.api.WxMaService;
import com.sixandone.qixingle.entity.Bicycle;
import com.sixandone.qixingle.entity.Business;
import com.sixandone.qixingle.entity.Orders;
import com.sixandone.qixingle.service.businessService;
import com.sixandone.qixingle.service.orderService;
import com.sixandone.qixingle.service.userService;
import com.sixandone.qixingle.service.userServiceImpl.bicycleService;
import com.sixandone.qixingle.vo.responseToClientOrder;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName yk
 * @Descprition: 提供租车接口
 * @Autor DELL
 * @Date 2023/5/14 10:41
 **/
@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/wx/rent/{appid}")
public class rentController {

    private final WxMaService wxMaService;


    private final orderService orderService;

    private final bicycleService bicycleService;

    private final businessService businessService;

    private final userService userService;

    //租车
    @PostMapping(value = "/rent",produces = "application/json",consumes = "application/json")
    public responseToClientOrder rentBicycle(
            @PathVariable String appid,
            @RequestBody String requestBody,
            @RequestParam(name = "openid",required = true) String rentUserOpenid,
            @RequestParam(name = "order",required = false) responseToClientOrder order,
            @RequestParam(name = "businessid",required = false) String businessId,
            @RequestParam(name = "bicyclenumber",required = false) List<String> bicycleIds

    ){
        log.info("\n接收微信请求：[openid=[{}], businessid=[{}], bicyclenumber=[{}]," +
                        " bookorrent=[{}], requestBody=[\n{}\n] ",
                rentUserOpenid, businessId, bicycleIds, requestBody);
        if (!wxMaService.switchover(appid)) {
            throw new IllegalArgumentException(String.format("未找到对应appid=[%s]的配置，请核实！", appid));
        }
        //检查是否预定
        if(!(order==null)){
            //将预制订单生效
            //检查订单是否有效
            if (!orderService.checkOrder(order)) {
                throw new IllegalArgumentException(String.format("无效的订单orderNumber=[%s]，请核实！", order.getOrderUmber()));
            }
            return (responseToClientOrder)orderService.effectOrder(order);

        } else if (!(businessId == null && bicycleIds == null)) {
            //进行租车流程
            try {
                //检查是否超额
                if (bicycleService.checkQuantity(bicycleIds)) {
                    throw new IllegalArgumentException(String.format("数量超额"));
                }
                //检查自行车是否空闲
                List<Bicycle> bicycles = bicycleService.queryBicycles(bicycleIds);
                if (bicycleService.hasNull(bicycles)) {
                    throw new IllegalArgumentException(String.format("未找到对应自行车=[%s]，请核实自行车编码！", bicycleIds));
                }
                if (!bicycleService.checkBicycleIsUsable(bicycles)) {
                    throw new IllegalArgumentException(String.format("自行车=[%s]已被预定或租用！", bicycleIds));
                }
                //检查商家是否营业
                Business business = businessService.queryBusinessById(businessId);
                if (business == null) {
                    throw new IllegalArgumentException(String.format("未找到对应自行车=[%s]，请核实自行车编码！",businessId));
                }
                if (!businessService.checkIsWork(business)) {
                    throw new IllegalArgumentException(String.format("不再营业时间！"));
                }
                //生成订单
                Orders order1 = (Orders) orderService.generateRentOrder(rentUserOpenid, bicycleIds);
                if (order1 == null) {
                    throw new IllegalArgumentException(String.format("订单生成异常"));
                }
                //存入数据库
                if (!orderService.addOrder(order1)) {
                    throw new IllegalArgumentException(String.format("请重试！"));
                }
                return responseToClientOrder.builder()
                        .orderUmber(order1.getOrderUmber())
                        .userName(userService.queryUserByOpenId(rentUserOpenid).getUserName())
                        .businessName(businessService.queryBusinessById(businessId).getBusinessName())
                        .bicycleNumbers(order1.getBicycleNumbers())
                        .bicyclePrice(order1.getBicyclePrice())
                        .createTime(order1.getCreateTime())
                        .effectTime(order1.getEffectTime())
                        .unEffectTime(order1.getUnEffectTime())
                        .orderStatus(order1.getOrderStatus())
                        .payStatus(order1.getPayStatus())
                        .payTime(order1.getPayTime())
                        .build();
            } catch (IllegalArgumentException e) {
                throw new RuntimeException(e);
            }
        }else {
            throw new IllegalArgumentException(String.format("未找到对应bicycleIds=[%s]，请核实！"), (Throwable) bicycleIds);
        }
    }


    /**
     * 预定自行车
     * @param appid appid
     * @param requestBody 请求体
     * @param rentUserOpenid useropenid
     * @param businessId businessid
     * @param bicycleIds
     * @return
     */
    @GetMapping(value = "/book",produces = "application/json",consumes = "application/json")
    public responseToClientOrder bookBicycle(
            @PathVariable String appid,
            @RequestBody String requestBody,
            @RequestParam(name = "openid", required = true)String rentUserOpenid,
            @RequestParam(name = "businessid",required = false) String businessId,
            @RequestParam(name = "bicyclenumber",required = true) List<String> bicycleIds
            ) {
        log.info("\n接收微信请求：[openid=[{}], businessid=[{}], bicyclenumber=[{}]," +
                        " bookorrent=[{}], requestBody=[\n{}\n] ",
                rentUserOpenid, businessId, bicycleIds, requestBody);

        if (!wxMaService.switchover(appid)) {
            throw new IllegalArgumentException(String.format("未找到对应appid=[%s]的配置，请核实！", appid));
        }
        try {
            //检查自行车是否空闲
            List<Bicycle> bicycles = bicycleService.queryBicycles(bicycleIds);
            if (bicycleService.hasNull(bicycles)) {
                throw new IllegalArgumentException(String.format("未找到对应自行车=[%s]，请核实自行车编码！", bicycleIds));
            }
            if (!bicycleService.checkBicycleIsUsable(bicycles)) {
                throw new IllegalArgumentException(String.format("自行车=[%s]已被预定或租用！", bicycleIds));
            }
            //检查商家是否营业
            Business business = businessService.queryBusinessById(businessId);
            if (business == null) {
                throw new IllegalArgumentException(String.format("未找到对应自行车=[%s]，请核实自行车编码！",businessId));
            }
            if (!businessService.checkIsWork(business)) {
                throw new IllegalArgumentException(String.format("不再营业时间！"));
            }
            //生成订单
            Orders order = (Orders) orderService.generateOrder(rentUserOpenid, bicycleIds);
            if (order == null) {
                throw new IllegalArgumentException(String.format("订单生成异常"));
            }
            //存入数据库
            if (!orderService.addOrder(order)) {
                throw new IllegalArgumentException(String.format("请重试！"));
            }
            return responseToClientOrder.builder()
                    .orderUmber(order.getOrderUmber())
                    .userName(userService.queryUserByOpenId(rentUserOpenid).getUserName())
                    .businessName(businessService.queryBusinessById(businessId).getBusinessName())
                    .bicycleNumbers(order.getBicycleNumbers())
                    .bicyclePrice(order.getBicyclePrice())
                    .createTime(order.getCreateTime())
                    .effectTime(order.getEffectTime())
                    .unEffectTime(order.getUnEffectTime())
                    .orderStatus(order.getOrderStatus())
                    .payStatus(order.getPayStatus())
                    .payTime(order.getPayTime())
                    .build();
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }

    }

}
