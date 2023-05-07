package com.sixandone.qixingle.service.userService.userServiceImpl;

import com.sixandone.qixingle.entity.SysUser;
import com.sixandone.qixingle.service.userService.SysMenuService;
import com.sixandone.qixingle.service.userService.SysUserService;
import com.sixandone.qixingle.service.userService.userService;
import com.sixandone.qixingle.util.JwtUtils;
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
 * @Descprition:TODO
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
    private final RestTemplate restTemplate;

    public userServiceImpl() {
        restTemplate = new RestTemplate();
    }

    @Resource
    private SysUserService sysUserService;

    @Resource
    private SysMenuService sysMenuService;

    @Resource
    private userService userService;


    /**
     * 调用微信登录接口
     * @param jsCode
     * @return resposeUser类，用于接收微信接口的返回参数类
     */
    @Override
    public resposeUser loginInWx(String jsCode) {
        //final ResponseEntity<resposeUser> forEntity = restTemplate.getForEntity(url, resposeUser.class, appid, SECRET, jsCode, grantType);
        resposeUser resposeUser = null;
        try {
            resposeUser = restTemplate.getForObject(url, resposeUser.class, appid, SECRET, jsCode, grantType);
        } catch (RestClientException e) {
            log.error("code2Session",e);
        }
        return resposeUser;
    }

    @Override
    public SysUser getUserInfoFromWx() {
        return null;
    }


    @Override
    public Integer addSysUser(resposeUser resposeUser,String phoneNumber,String userName) {
        SysUser sysUser = new SysUser();//系统用户
        sysUser.setPhoneNumber(phoneNumber);
        sysUser.setUserName(userName);
        sysUser.setOpenid(resposeUser.getOpenid());
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

    public resposeToClientUser loginIn(String jsCode,String phoneNumber,String userName){
        resposeUser resposeUser = userService.loginInWx(jsCode);
        int isAdd = userService.addSysUser(resposeUser,userName,phoneNumber);
        if(isAdd == -1){
            return null;
        }
        resposeToClientUser resposeToClientUser = new resposeToClientUser();
        JwtUtils jwtUtils = new JwtUtils();


        return resposeToClientUser;
    }


}
