package com.baizhi.um.test;

import com.baizhi.um.entity.User;
import com.baizhi.um.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void testSaveUser(){
        userService.saveUser(new User(101,"lisi","123456","a2.png",0,new Date(),"123@qq.com"));
    }
    @Test
    public void testQueryUserByNameAndPassword(){
        User user = userService.queryUserByNameAndPassword(new User(null, "zhangsan", "123456", null, 0, null, null));
        System.out.println(user);
    }
    @Test
    public void testQueryUserById(){
        User user = userService.queryUserById(1);
        System.out.println(user);
    }

    @Test
    public void testUpdateUser(){
        userService.updateUser(new User(2,"lisi","123666","a2.png",1,new Date(),"123@qq.com"));
    }

    @Test
    public void testDeleteByUserIds(){
        Integer[] ids = {new Integer(6),new Integer(7)};
        userService.deleteByUserIds(ids);
    }

    @Test
    public void testQueryUserByPage(){
        List<User> users = userService.queryUserByPage(1, 4, "name", "zhang");
        users.forEach(user -> System.out.println(user));
    }
    @Test
    public void testQueryUserCount(){
        int count = userService.queryUserCount("name", "zhangsan");
        System.out.println(count);
    }
}
