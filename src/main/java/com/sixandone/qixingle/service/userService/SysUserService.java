package com.sixandone.qixingle.service.userService;

import com.sixandone.qixingle.entity.SysUser;

public interface SysUserService {

    /**
     * 根据用户手机号获取用户信息
     * @return SysUser系统用户对象
     */
    SysUser getByUserPhoneNumber(String phoneNumber);

    /**
     * 存储用户信息
     * @param sysUser
     * @return null
     */
    Integer addUser(SysUser sysUser);


    /**
     * 根据用户名查询用户信息
     * @param userName
     * @return SysUser系统用户对象
     */
    SysUser getByUserName(String userName);
}
