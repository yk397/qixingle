package com.sixandone.qixingle;

import com.sixandone.qixingle.dao.SysUserDao;
import com.sixandone.qixingle.entity.SysUser;
import com.sixandone.qixingle.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

public class MybatisTest {
    @Test
    public void TestInsert(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        SysUserDao userDao = sqlSession.getMapper(SysUserDao.class);
        int i = userDao.addUser();
        System.out.println(i);
        sqlSession.commit();
    }

    @Test
    public void  TestSelect(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        SysUserDao userDao = sqlSession.getMapper(SysUserDao.class);
        SysUser user = userDao.getByPhoneNumber();
        System.out.println(user);
    }
}
