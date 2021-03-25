package com.baizhi.um.test;

import com.baizhi.um.dao.UserDao;
import com.baizhi.um.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {
    @Autowired
    private UserDao userDao;
    @Test
    public void testSaveUser(){
        userDao.saveUser(new User(101,"zhangsan","123456","a.png",0,new Date(),"123@qq.com"));
    }
    @Test
    public void testQueryUserById(){
        User user = userDao.queryUserById(1);
        System.out.println(user);
    }

}
