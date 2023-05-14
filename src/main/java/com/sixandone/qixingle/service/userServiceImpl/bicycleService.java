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

    /**
     * 获取展示前台的自行车信息
     * @return List<reposeToClientBicycle> 自行车信息列表
     */
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

    public Boolean checkBicycleIsUsable(List<Bicycle> bicycles) {
        for (Bicycle bicycle : bicycles) {
            if (!checkBicycleIsUsable(bicycle)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 检查自行车是否能被租用
     * @param bicycle 自行车对象
     * @return boolean
     */
    public Boolean checkBicycleIsUsable(Bicycle bicycle) {
        if(!isUsable(bicycle)){
            return false;
        }
        if (isRented(bicycle)) {
            return false;
        }
        if (isBooked(bicycle)) {
            return false;
        }
        return true;
    }
    private Boolean isUsable(Bicycle bicycle){
        if (bicycle.getIsUsable().equals(0)) {
            return true;
        } else {
            return false;
        }
    }
    private Boolean isRented(Bicycle bicycle){
        if (bicycle.getIsRented().equals(0)) {
            return false;
        }else {return true;}
    }
    private Boolean isBooked(Bicycle bicycle){
        if (bicycle.getIsReserved().equals(0)) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 查询自行车对象
     * @param bicycleNumber 自行车编号
     * @return 自行车对象
     */
    public Bicycle queryBicycle(String bicycleNumber){
        return bicycleInfoDao.queryBicycleByNumber(bicycleNumber);
    }

    /**
     * 查询对应编号自行车
     * @param bicycleIds 编号列表
     * @return 自信车对象列表
     */
    public List<Bicycle> queryBicycles(List<String> bicycleIds){
        return null;
    }

    public boolean hasNull(List<Bicycle> bicycles) {
        for (Bicycle bicycle : bicycles) {
            if (bicycle == null) {
                return false;
            }
        }
        return true;
    }
}
