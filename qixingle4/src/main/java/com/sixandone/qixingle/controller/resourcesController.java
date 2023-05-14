package com.sixandone.qixingle.controller;

import com.sixandone.qixingle.service.userServiceImpl.bicycleService;
import com.sixandone.qixingle.vo.resposeToClientBicycle;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName yk
 * @Descprition:提供小程序资源访问
 * @Autor DELL
 * @Date 2023/5/7 7:49
 **/
@RestController
@RequestMapping("/resources")
@NoArgsConstructor
@AllArgsConstructor
public class resourcesController {

    @Resource
    private bicycleService bicycleService;


    /**
     * 获取自行车信息
     * @return
     */
    @GetMapping("/getBicycles")
    @ResponseBody
    public List<resposeToClientBicycle> getBicycleShow(){

        return bicycleService.getBicycleInfo();
    }

}
