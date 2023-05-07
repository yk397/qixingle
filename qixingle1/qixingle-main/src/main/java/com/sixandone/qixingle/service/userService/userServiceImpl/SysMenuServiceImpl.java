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
 * @Descprition:TODO
 * @Autor DELL
 * @Date 2023/5/3 8:17
 **/
@Service
@Slf4j
public class SysMenuServiceImpl implements SysMenuService {

    @Resource
    private SysMenuDao sysMenuDao;


    @Override
    public List<String> queryPermissionsByRole(String role) {
        return sysMenuDao.queryPermissionsByRole(role);
    }

    public Integer addUserRoleByUserId(String userOpenId, String Role) {
        return sysMenuDao.addUserRoleByUserId(userOpenId,Role);
    }
}
