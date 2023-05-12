package com.sixandone.qixingle.service.userServiceImpl;

import com.sixandone.qixingle.dao.BicycleInfoDao;
import com.sixandone.qixingle.entity.Bicycle;
import com.sixandone.qixingle.vo.resposeToClientBicycle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName yk
 * @Descprition:自行车信息静态资源访问服务类
 * @Autor DELL
 * @Date 2023/5/7 8:25
 **/
@Service
@Slf4j
public class bicycleService {
    @Resource
    private BicycleInfoDao bicycleInfoDao;

    public List<resposeToClientBicycle> getBicycleInfo(){

        List<Bicycle> bicycles = bicycleInfoDao.queryBicycleInfo();
        List<resposeToClientBicycle> resposeToClientBicycles = new ArrayList<>();
        log.info("自行车信息查询成功",bicycles);

        for (Bicycle bicycle : bicycles) {
            resposeToClientBicycle resposeToClientBicycle = new resposeToClientBicycle();
            resposeToClientBicycle.setBicycleInfo(bicycle.getBicycleInfo());
            resposeToClientBicycle.setBicycleImage(bicycle.getBicycleImage());
            resposeToClientBicycle.setBicycleBrand(bicycle.getBicycleBrand());
            resposeToClientBicycle.setBicycleNumber(bicycle.getBicycleNumber());
            resposeToClientBicycle.setBicycleType(bicycle.getBicycleType());
            resposeToClientBicycle.setBicyclePrice(bicycle.getBicyclePrice());

            resposeToClientBicycles.add(resposeToClientBicycle);

        }


        return resposeToClientBicycles;
    }

}
