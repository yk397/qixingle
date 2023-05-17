package com.sixandone.qixingle.dao;

import com.sixandone.qixingle.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
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
    Integer addUser( SysUser sysUser);

    /**
     * 根据openID修改用户信息
     * @param openID
     * @param phoneNumber
     * @param username
     * @param address
     * @return
     */
    Integer modifyUser(@Param("openID") String openID, @Param("phoneNmber") String phoneNumber ,@Param("username") String username ,@Param("address") String address);

    /**
     * 根据用户名查询用户信息
     * @param userName
     * @return
     */
    SysUser queryByUserName(@Param("userName") String userName);


    /**
     * 根据用户的openid查询用户信息
     * @param openid
     * @return
     */
    SysUser queryUserByOpenID(@Param("openid")String openid);


    /**
     * 根据权限查找用户（管理员端）
     * @param Role
     * @return
     */
    List<SysUser> queryUsersByRole(String Role);


    /**
     * 检测是否启用用户
     * @param openID
     * @return
     */
    String  checkIsEnabled(@Param("openID") String openID);






}

