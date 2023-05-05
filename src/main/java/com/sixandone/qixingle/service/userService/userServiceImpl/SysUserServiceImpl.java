package com.sixandone.qixingle.service.userService.userServiceImpl;

import com.sixandone.qixingle.dao.SysUserDao;
import com.sixandone.qixingle.entity.SysUser;
import com.sixandone.qixingle.service.userService.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName yk
 * @Descprition:系统用户信息服务
 * @Autor DELL
 * @Date 2023/5/2 23:38
 **/
@Service
@Slf4j
public class SysUserServiceImpl implements SysUserService {
    @Resource
    private SysUserDao sysUserDao;


    @Override
    public SysUser getByUserPhoneNumber(String phoneNumber) {
        return sysUserDao.getByPhoneNumber(phoneNumber);
    }

    @Override
    public Integer addUser(SysUser sysUser) {
        return sysUserDao.addUser(sysUser);
    }

    @Override
    public SysUser getByUserName(String userName) {
        return sysUserDao.queryByUserName(userName);
    }
}
