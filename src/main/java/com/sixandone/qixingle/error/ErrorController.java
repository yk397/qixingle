package com.sixandone.qixingle.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName yk
 * @Descprition: 全局抓取异常返回固定格式
 * @Autor DELL
 * @Date 2023/5/10 11:11
 **/
@Controller
@RequestMapping("/error")
public class ErrorController {

    @GetMapping(value = "/404")
    public String error404() {
        return "error";
    }

    @GetMapping(value = "/500")
    public String error500() {
        return "error";
    }

}
