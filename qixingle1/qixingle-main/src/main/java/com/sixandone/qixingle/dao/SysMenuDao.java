package com.sixandone.qixingle.dao;

import com.sixandone.qixingle.entity.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysMenuDao {

    /**
     * 根据用户角色查询权限
     * @param Role 用户角色
     * @return
     */
    List<String> queryPermissionsByRole(@Param("Role") String Role);

    /**
     * 根据用户id查询用户权限
     * @param userId
     * @return
     */
    List<String> queryPermissionByUserId(@Param("userId") Integer userId);


    /**
     * 添加用户的角色
     * @param userOpenId
     * @param Role
     * @return
     */
    Integer addUserRoleByUserId(@Param("userOpenId") String userOpenId,@Param("Role") String Role);



}
