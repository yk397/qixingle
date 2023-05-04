package com.sixandone.qixingle.controller;

import com.sixandone.qixingle.service.userService.userServiceImpl.userServiceImpl;
import com.sixandone.qixingle.vo.resposeToClientUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


    /**
     * @Author:yk
     * @url:/Login/userlogin
     * @return 用户服务
     */
    @GetMapping("userLogin1/{jscode}/{phoneNumber}/{userName}")
    public resposeToClientUser userLogin1(@PathVariable("jscode")String jsCode, @PathVariable("phoneNumber")String phoneNumber, @PathVariable("userName")String userName){
        return new userServiceImpl().loginIn(jsCode,phoneNumber,userName);
    }

}
