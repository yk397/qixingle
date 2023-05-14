package com.sixandone.qixingle.service;

import com.sixandone.qixingle.entity.SysUser;
import com.sixandone.qixingle.enums.Role;

import java.util.List;


public interface userService {


    /**
     * 添加用户信息到数据库
     * @param sysUser 系统用户
     * @return boolean
     */
    Boolean addSysUser(SysUser sysUser);

    /**
     * 更新用户信息
     * @param sysUser 系统用户
     * @return boolean
     */
    Boolean modifyUser(SysUser sysUser);


    /**
     * 设为过期用户
     * @param sysUser 系统用户
     * @return boolean
     */
    Boolean setUserExpired(SysUser sysUser);

    /**
     * 用户是否过期
     * @param userExpired 0过期 1没过期
     * @return booean
     */
    Boolean isUserExpired(int userExpired);


    /**
     * 将用户锁定
     * @param sysUser 系统用户
     * @return boolean
     */
    Boolean setUserLocked(SysUser sysUser);

    /**
     * 用户是否锁定
     * @param userLocked 0锁定 1没锁定
     * @return boolean
     */
    Boolean isUserLocked(int userLocked);


    /**
     * 检查是否启用用户
     * @param isUserLocked 是否锁定
     * @param isUserExpired 是否过期
     * @return boolean 是否可用
     */
    Boolean checkIsEnabled(boolean isUserLocked,boolean isUserExpired);


    /**
     * 通过用户名查找是否有该用户
     * @param username 用户名
     * @return boolean
     */
    Boolean checkUserByUserName(String username);


    /**
     * openid检查是否有该用户
     * @param openid openid
     * @return boolean
     */
    Boolean checkUserByOpenid(String openid);


    /**
     * oepnid查找用户信息
     * @param openid openid
     * @return SysUser 用户信息
     */
     SysUser queryUserByOpenId(String openid);


    /**
     * username查找用户信息
     * @param username 用户名
     * @return SysUser 用户信息
     */
    SysUser queryUserByUserName(String username);


    /**
     * 查找不同角色的用户
     * @param Role 角色
     * @return List<SysUser> 用户信息列表
     */
    List<SysUser> queryUsersByRole(String Role);


    /**
     * Role查询用户权限
     * @param Role 角色
     * @return List<String> 权限列表
     */
    List<String> queryUserAuthorities(Role Role);






}
