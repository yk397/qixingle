package com.sixandone.qixingle.service.userService;

import java.util.List;

public interface SysMenuService {

    List<String> queryPermissionsByRole(String role);

    Integer addUserRoleByUserId(String userOpenId,String Role);
}
