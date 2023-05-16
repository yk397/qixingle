package com.sixandone.qixingle;

import com.sixandone.qixingle.dao.SysMenuDao;
import com.sixandone.qixingle.dao.SysUserDao;
import com.sixandone.qixingle.entity.SysUser;
import com.sixandone.qixingle.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MysqlTest {
    @Test
    public void TestgetByPhoneNumber(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        SysUserDao userDao = sqlSession.getMapper(SysUserDao.class);
        SysUser sysUseruser = userDao.getByPhoneNumber("193-5572-1200");
        System.out.println(sysUseruser);
    }


    @Test
    public void TestaddUser(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        SysUserDao userDao = sqlSession.getMapper(SysUserDao.class);
        SysUser user = new SysUser();
        user.setOpenid("EEEEEE");
        user.setSessionKey("eeeeee");
        user.setUnionId("eeeeee");
        user.setPhoneNumber("111-888-9999");
        user.setUserName("撒比");
        user.setCreateTime(new Date());
        user.setAddress("baiyilu1hao");
        user.setEnabled(0);
        user.setAccountNoExpired(0);
        user.setAccountNoLocked(1);
        Integer addUser = userDao.addUser(user);
        sqlSession.commit();
        System.out.println(addUser);
        sqlSession.close();
    }





    @Test
    public void TestqueryByUserName(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        SysUserDao userDao = sqlSession.getMapper(SysUserDao.class);
        SysUser user = userDao.queryByUserName("常璐");
        System.out.println(user);
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
    public void TestqueryPermissionByUserId() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        SysMenuDao menuDao = sqlSession.getMapper(SysMenuDao.class);
        List<String> cccccc = menuDao.queryPermissionByUserId("CCCCCC");
        for (String Auth : cccccc){
            System.out.println(Auth);
        }
    }
}
