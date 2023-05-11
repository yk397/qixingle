package com.sixandone.qixingle.service.service;

import java.util.List;

public interface SysMenuService {

    List<String> queryPermissionsByRole(String role);

    Integer addUserRoleByUserId(String userOpenId,String Role);

    List<String> queryPermissionsByUserOpenId(String userOpenId);
}
