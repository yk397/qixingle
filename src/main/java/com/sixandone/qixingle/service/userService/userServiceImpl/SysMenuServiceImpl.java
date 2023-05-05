package com.sixandone.qixingle.service.userService.userServiceImpl;

import com.sixandone.qixingle.dao.SysMenuDao;
import com.sixandone.qixingle.service.userService.SysMenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName yk
 * @Descprition:权限服务
 * @Autor DELL
 * @Date 2023/5/3 8:17
 **/
@Service
@Slf4j
public class SysMenuServiceImpl implements SysMenuService {

    @Resource
    private SysMenuDao sysMenuDao;


    /**
     * 根据角色查询对应权限
     * @param role
     * @return
     */
    @Override
    public List<String> queryPermissionsByRole(String role) {
        return sysMenuDao.queryPermissionsByRole(role);
    }

    /**
     * 添加用户Openid和角色对应信息
     * @param userOpenId
     * @param Role
     * @return
     */
    public Integer addUserRoleByUserId(String userOpenId, String Role) {
        return sysMenuDao.addUserRoleByUserId(userOpenId,Role);
    }

    /**
     * 根据openid查询对应权限
     * @param userOpenId
     * @return
     */
    @Override
    public List<String> queryPermissionsByUserOpenId(String userOpenId) {
        return sysMenuDao.queryPermissionByUserId(userOpenId);
    }
}
