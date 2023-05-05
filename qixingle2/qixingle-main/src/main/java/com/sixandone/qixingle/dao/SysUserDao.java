package com.sixandone.qixingle.dao;

import com.sixandone.qixingle.entity.SysUser;
import org.apache.ibatis.annotations.Param;

public interface SysUserDao {

    /**
     * 根据用户电话获取用户信息
     *  用户的电话号码
     * @return 系统用户对象 SysUser
     */
    SysUser getByPhoneNumber();

    /**
     * 添加用户信息
     */
    int addUser();


    /**
     *
     * @param username
     * @return 系统用户对象 SysUser
     */
    SysUser getUserByUsername( String username);



}

