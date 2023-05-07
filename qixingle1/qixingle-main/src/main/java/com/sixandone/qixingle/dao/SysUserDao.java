package com.sixandone.qixingle.dao;

import com.sixandone.qixingle.entity.SysUser;
import org.apache.ibatis.annotations.Param;

public interface SysUserDao {

    /**
     * 根据用户电话获取用户信息
     * @param phoneNumber 用户的电话号码
     * @return 系统用户对象 SysUser
     */
    SysUser getByPhoneNumber(@Param("phoneNumber") String phoneNumber);

    /**
     * 添加用户信息
     * @param sysUser
     * @return
     */
    Integer addUser(@Param("sysUser") SysUser sysUser);
}

