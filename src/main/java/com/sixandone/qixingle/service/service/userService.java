package com.sixandone.qixingle.service.service;

import com.sixandone.qixingle.entity.SysUser;

import java.util.List;


public interface userService {


    /**
     * 添加用户信息到数据库
     * @param sysUser
     * @return
     */
    Boolean addSysUser(SysUser sysUser);

    /**
     * 更新用户信息
     * @param sysUser
     * @return
     */
    Boolean modifyUser(SysUser sysUser);


    /**
     * 设为过期用户
     * @param sysUser
     * @return
     */
    Boolean setUserExpired(SysUser sysUser);

    /**
     * 用户是否过期
     * @param userExpired
     * @return
     */
    Boolean isUserExpired(int userExpired);


    /**
     * 将用户锁定
     * @param sysUser
     * @return
     */
    Boolean setUserLocked(SysUser sysUser);

    /**
     * 用户是否锁定
     * @param userLocked
     * @return
     */
    Boolean isUserLocked(int userLocked);


    /**
     * 检查是否启用用户
     * @param isUserLocked
     * @param isUserExpired
     * @return
     */
    Boolean checkIsEnabled(boolean isUserLocked,boolean isUserExpired);


    /**
     * 通过用户名查找是否有该用户
     * @param username
     * @return
     */
    Boolean checkUserByUserName(String username);


    /**
     * oepnid查找用户信息
     * @param openid
     * @return SysUser 用户信息
     */
     SysUser queryUserByOpenId(String openid);


    /**
     * username查找用户信息
     * @param username
     * @return SysUser 用户信息
     */
    SysUser queryUserByUserName(String username);


    /**
     * 查找不同角色的用户
     * @param Role
     * @return List<SysUser> 用户信息列表
     */
    List<SysUser> queryUsersByRole(String Role);









}
