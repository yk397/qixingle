package com.sixandone.qixingle.service.userService;

import com.sixandone.qixingle.entity.SysUser;
import com.sixandone.qixingle.vo.resposeUser;
import com.sixandone.qixingle.vo.resposeToClientUser;


public interface userService {




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
