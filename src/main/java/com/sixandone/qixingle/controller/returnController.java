package com.sixandone.qixingle.controller;

import cn.binarywang.wx.miniapp.api.WxMaService;
import com.sixandone.qixingle.vo.responseToClientOrder;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


/**
 * @ClassName yk
 * @Descprition: 还车接口
 * @Autor DELL
 * @Date 2023/5/16 10:35
 **/
@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/wx/return/{appid}")
public class returnController {
    private final WxMaService wxMaService;


    private final com.sixandone.qixingle.service.orderService orderService;

    @PostMapping(value = "/return",produces = "application/json",consumes = "application/json")
    public String returnBicycle(
            @PathVariable String appid,
            @RequestBody String requestBody,
            @RequestParam(name = "openid",required = true) String rentUserOpenid,
            @RequestParam(name = "order",required = true) responseToClientOrder order

    ){
        log.info("\n接收微信请求：[openid=[{}], order[{}],requestBody=[\n{}\n] ",
                rentUserOpenid,order, requestBody);

        if (!wxMaService.switchover(appid)) {
            throw new IllegalArgumentException(String.format("未找到对应appid=[%s]的配置，请核实！", appid));
        }

        //验证订单
        if (!orderService.checkOrder(order)) {
            throw new IllegalArgumentException(String.format("无效的订单orderNumber=[%s]，请核实！", order.getOrderUmber()));
        }
        //发送还车码
        ///////////////////////////////////////////


        return "successful";

    }

    @GetMapping(value = "/return{code}")
    public responseToClientOrder returnCode(
            @PathVariable(name = "appid")String appid,
            @PathVariable(name = "code")String code
    ){
        //校验还车码


        return null;
    }

}
