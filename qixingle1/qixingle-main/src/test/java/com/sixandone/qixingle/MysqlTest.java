package com.sixandone.qixingle;

import com.sixandone.qixingle.dao.SysMenuDao;
import com.sixandone.qixingle.dao.SysUserDao;
import com.sixandone.qixingle.entity.SysUser;
import com.sixandone.qixingle.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MysqlTest {
    @Test
    public void TestgetByPhoneNumber(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        SysUserDao userDao = sqlSession.getMapper(SysUserDao.class);
        SysUser sysUseruser = userDao.getByPhoneNumber("151-7334-2228");
        System.out.println(sysUseruser);
    }

    @Test
    public void TestInsertSysUser(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        SysUserDao userDao = sqlSession.getMapper(SysUserDao.class);
        SysUser user = new SysUser(null,"BBBBBB","199-8887-5855","杨笑傲","003BAIYE",0,0,0);
        Integer sysUser = userDao.addUser(user);
        sqlSession.commit();
        System.out.println(sysUser);
    }

    @Test
    public void TestqueryPermissionsByRole(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        SysMenuDao menuDao = sqlSession.getMapper(SysMenuDao.class);
        List<String> Auths = menuDao.queryPermissionsByRole("RENTOUT");
        for (String Auth : Auths){
            System.out.println(Auth);
        }
    }

    @Test
    public void TestaddUserRoleByUserId(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        SysMenuDao menuDao = sqlSession.getMapper(SysMenuDao.class);
        Integer adduer = menuDao.addUserRoleByUserId("AAAAAA", "3");
        sqlSession.commit();
        System.out.println(adduer);

    }

    @Test
    public void TestqueryPermissionByUserId(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        SysMenuDao menuDao = sqlSession.getMapper(SysMenuDao.class);
        List<String> Auths = menuDao.queryPermissionByUserId(54);
        for (String Auth : Auths){
            System.out.println(Auth);
        }
    }
}
