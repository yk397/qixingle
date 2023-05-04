package com.sixandone.qixingle.service.userService;

import com.sixandone.qixingle.entity.SysUser;
import com.sixandone.qixingle.vo.resposeUser;
import com.sixandone.qixingle.vo.resposeToClientUser;


public interface userService {


    /**
     * 调用微信登录接口
     * @return 微信接口返回内容的包装对象
     */
    public resposeUser loginInWx(String jsCode);

    /**
     * 将用户信息保存到数据库
     * @param resposeUser
     * @return
     */
    public Integer addSysUser(resposeUser resposeUser,String phoneNumber,String userName);


    /**
     * 包装用于返回客户端的用户数据
     * @param jsCode
     * @param phoneNumber
     * @param userName
     * @return
     */
    public resposeToClientUser loginIn(String jsCode,String phoneNumber,String userName);


    /**
     * 调用微信获取用户信息接口
     * @return
     */
    public SysUser getUserInfoFromWx();

}
