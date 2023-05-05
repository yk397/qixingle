package com.sixandone.qixingle.dao;

import com.sixandone.qixingle.entity.SysUser;

public interface SysUserDao {

    /**
     * 根据用户电话获取用户信息
     * @param phoneNumber 用户的电话号码
     * @return 系统用户对象 SysUser
     */
    SysUser getByPhoneNumber(String phoneNumber);

    /**
     * 添加用户信息
     * @param sysUser
     * @return
     */
    Integer addUser(SysUser sysUser);


    /**
     * 根据用户名查询用户信息
     * @param userName
     * @return
     */
    SysUser queryByUserName(String userName);
}

