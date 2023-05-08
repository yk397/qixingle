package com.sixandone.qixingle.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sixandone.qixingle.service.userService.userService;
import com.sixandone.qixingle.service.userService.userServiceImpl.userServiceImpl;
import com.sixandone.qixingle.vo.reciveLoginInfo;
import com.sixandone.qixingle.vo.resposeToClientUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName yk
 * @Descprition:写接口
 * @Autor DELL
 * @Date 2023/5/1 10:11
 **/
@RestController
@Slf4j
@RequestMapping("/userLogin")
public class userController {

    @Resource
    private ObjectMapper objectMapper;

    @Autowired
    private userService userService;

    /**
     * @Author:yk
     * @url:/Login/userlogin
     * @return 用户服务
     */
    @GetMapping("userLogin1/{info}")
    @ResponseBody
    public resposeToClientUser userLogin1(@PathVariable("info")String info){
        try {
            reciveLoginInfo reciveLoginInfo = objectMapper.readValue(info, reciveLoginInfo.class);

            String jsCode = reciveLoginInfo.getJsCode();
            String phoneNumber = reciveLoginInfo.getPhoneNumber();
            String userName = reciveLoginInfo.getUserName();

            return userService.loginIn(jsCode, phoneNumber, userName);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
