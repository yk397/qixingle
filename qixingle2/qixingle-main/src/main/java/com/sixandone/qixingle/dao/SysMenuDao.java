package com.sixandone.qixingle.dao;

import com.sixandone.qixingle.entity.SysUser;

import java.util.List;

public interface SysMenuDao {

    /**
     * 根据用户角色查询权限
     * @param role 用户角色
     * @return
     */
    List<String> queryPermissionsByRole(String role);

    /**
     * 根据用户id查询用户权限
     * @param userId
     * @return
     */
    List<String> queryPermissionByUserId(Integer userId);


    /**
     * 添加用户的角色
     * @param userOpenId
     * @param Role
     * @return
     */
    Integer addUserRoleByUserId(String userOpenId,String Role);
}
