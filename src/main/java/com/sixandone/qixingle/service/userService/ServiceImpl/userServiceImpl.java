package com.sixandone.qixingle.service.userService.ServiceImpl;

import com.sixandone.qixingle.entity.SysUser;
import com.sixandone.qixingle.service.userService.SysMenuService;
import com.sixandone.qixingle.service.userService.SysUserService;
import com.sixandone.qixingle.service.userService.userService;
import com.sixandone.qixingle.util.JwtUtils;
import com.sixandone.qixingle.vo.WxPhoneNumberInfo;
import com.sixandone.qixingle.vo.WxUserInfo;
import com.sixandone.qixingle.vo.resposeToClientUser;
import com.sixandone.qixingle.vo.resposeUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @ClassName yk
 * @Descprition:提供用户登录服务
 * @Autor DELL
 * @Date 2023/5/1 10:37
 **/
@Service
@Slf4j
public class userServiceImpl implements userService {

    @Value("${userService.url}")
    private String url;
    @Value("${userService.grantType}")
    private String grantType;
    @Value("${userService.SECRET}")
    private String SECRET;
    @Value("${userService.appid}")
    private String appid;

    @Resource
    private RestTemplate restTemplate;


    @Resource
    private SysUserService sysUserService;

    @Resource
    private SysMenuService sysMenuService;

    @Resource
    private JwtUtils jwt;



    /**
     * 调用微信登录接口
     * @param jsCode
     * @return resposeUser类，用于接收微信接口的返回参数类
     */
    public resposeUser loginInWx(String jsCode) {
        resposeUser resposeUser = null;
        try {
            resposeUser = restTemplate.getForObject(url, resposeUser.class, appid, SECRET, jsCode, grantType);
            log.info("微信接口调用成功");
        } catch (RestClientException e) {
            log.error("code2Session",e);
        }
        return resposeUser;
    }


    /**
     * 存储用户信息到数据库，存储用户的角色
     * @param resposeUser
     * @param phoneNumber
     * @param userName
     * @return
     */
    public Integer addSysUser(resposeUser resposeUser,String phoneNumber,String userName) {
        SysUser sysUser = new SysUser();//系统用户
        sysUser.setPhoneNumber(phoneNumber);
        sysUser.setUserName(userName);
        sysUser.setOpenid(resposeUser.getOpenid());
        sysUser.setSessionKey(resposeUser.getSessionKey());
        sysUser.setUnionId(resposeUser.getUnionId());
        sysUser.setEnabled(1);
        sysUser.setAccountNoExpired(1);
        sysUser.setAccountNoLocked(1);

        try {
            sysUserService.addUser(sysUser);//系统用户入库
        } catch (Exception e) {
            log.error("addUser",e);
            return -1;
        }
        try {
            sysMenuService.addUserRoleByUserId(resposeUser.getOpenid(),resposeUser.getRole());//添加用户角色
        } catch (Exception e) {
            log.error("addUserRoleByUserId",e);
            return -1;
        }
        return 1;
    }

    /**
     * 产生相应客户端的数据
     * @param jsCode
     * @param phoneNumber
     * @param userName
     * @return
     */
    public resposeToClientUser loginIn(String jsCode,String phoneNumber,String userName){
        resposeUser resposeUser = loginInWx(jsCode);
        int isAdd = addSysUser(resposeUser,userName,phoneNumber);
        if(isAdd == -1){
            return null;
        }


        resposeToClientUser resposeToClientUser = new resposeToClientUser();
        resposeToClientUser.setErrCode(resposeUser.getErrCode());
        resposeToClientUser.setErrMsg(resposeUser.getErrMsg());
        resposeToClientUser.setToken(jwt.createJwt(resposeUser.getOpenid(),userName,sysMenuService.queryPermissionsByUserOpenId(resposeUser.getOpenid())));


        return resposeToClientUser;
    }

    @Override
    public resposeUser getSessionInfo(String jsCode) {
        return null;
    }

    @Override
    public WxUserInfo getUserInfo(String sessionKey, String encryptedData, String ivStr) {
        return null;
    }

    @Override
    public WxPhoneNumberInfo getPhoneNoInfo(String code) {
        return null;
    }

    @Override
    public boolean checkUserInfo(String sessionKey, String rawData, String signature) {
        return false;
    }





}
