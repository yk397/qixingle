package com.sixandone.qixingle.dao;


import java.util.List;

public interface SysMenuDao {

    /**
     * 根据用户角色查询权限
     * @param role 用户角色
     * @return
     */
    List<String> queryPermissionsByRole(String role);

    /**
     * 根据用户useropenid查询用户权限
     * @param userOpenId
     * @return
     */
    List<String> queryPermissionByUserId(String userOpenId);


    /**
     * 添加用户的角色
     * @param userOpenId
     * @param Role
     * @return
     */
    Integer addUserRoleByUserId(String userOpenId,String Role);
}
