package com.sixandone.qixingle.service.userServiceImpl;

import com.sixandone.qixingle.entity.Business;
import com.sixandone.qixingle.service.businessService;
import com.sixandone.qixingle.vo.businessRevenge;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName yk
 * @Descprition: businessService实现类
 * @Autor DELL
 * @Date 2023/5/14 21:46
 **/
@Service
@Slf4j
public class businessServiceImpl implements businessService {

    @Override
    public boolean addBusiness(Business business) {
        return false;
    }

    @Override
    public boolean removeBusiness(String businessId) {
        return false;
    }

    @Override
    public Business queryBusinessById(String businessId) {
        return null;
    }

    @Override
    public boolean modifyBusiness(Object... item) {
        return false;
    }

    @Override
    public List<Business> queryBusiness(Object... item) {
        return null;
    }

    @Override
    public Boolean messageReturnCode(String code) {
        return null;
    }

    @Override
    public List<businessRevenge> queryRevengeCord(String businessId) {
        return null;
    }

    @Override
    public boolean checkIsWork(Business business) {
        return false;
    }
}
