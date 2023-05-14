package com.sixandone.qixingle.dao;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysMenuDao {

    /**
     * 根据用户角色查询权限
     * @param role 用户角色
     * @return
     */
    List<String> queryPermissionsByRole(@Param("role") String role);

    /**
     * 根据用户useropenid查询用户权限
     * @param userOpenId
     * @return
     */
    List<String> queryPermissionByUserId(@Param("userOpenId") String userOpenId);



    /**
     * 添加用户的角色
     * @param userOpenId
     * @param Role
     * @return
     */
    Integer addUserRoleByUserId(@Param("userOpenId")String userOpenId,@Param("Role")String Role);
}
