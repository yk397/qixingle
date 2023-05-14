package com.sixandone.qixingle.service.userServiceImpl;

import com.sixandone.qixingle.dao.SysUserDao;
import com.sixandone.qixingle.entity.SysUser;
import com.sixandone.qixingle.enums.Role;
import com.sixandone.qixingle.service.SysMenuService;
import com.sixandone.qixingle.service.userService;
import com.sixandone.qixingle.util.JwtUtils;
import com.sixandone.qixingle.vo.resposeUser;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName yk
 * @Descprition:提供用户登录服务
 * @Autor DELL
 * @Date 2023/5/1 10:37
 **/
@Service
@Slf4j
@NoArgsConstructor
public class userServiceImpl implements userService {


    @Resource
    private SysMenuService sysMenuService;

    @Resource
    private SysUserDao sysUserDao;

    @Resource
    private JwtUtils jwt;





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
            sysUserDao.addUser(sysUser);//系统用户入库
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

    @Override
    public Boolean addSysUser(SysUser sysUser) {
        return null;
    }

    @Override
    public Boolean modifyUser(SysUser sysUser) {
        return null;
    }

    @Override
    public Boolean setUserExpired(SysUser sysUser) {
        return null;
    }

    @Override
    public Boolean isUserExpired(int userExpired) {
        return null;
    }

    @Override
    public Boolean setUserLocked(SysUser sysUser) {
        return null;
    }

    @Override
    public Boolean isUserLocked(int userLocked) {
        return null;
    }

    @Override
    public Boolean checkIsEnabled(boolean isUserLocked, boolean isUserExpired) {
        return null;
    }

    @Override
    public Boolean checkUserByOpenid(String openid) {
        return null;
    }

    @Override
    public SysUser queryUserByUserName(String username) {
        return null;
    }

    @Override
    public Boolean checkUserByUserName(String username) {
        return null;
    }

    @Override
    public SysUser queryUserByOpenId(String openid) {
        return null;
    }

    @Override
    public List<SysUser> queryUsersByRole(String Role) {
        return null;
    }

    @Override
    public List<String> queryUserAuthorities(Role Role) {
        return null;
    }
}
