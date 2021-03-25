package com.baizhi.um.controller;

import com.baizhi.um.entity.User;
import com.baizhi.um.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/formUserManager")
public class FormUserController {
    @Autowired
    private UserService userService;
    @PostMapping(value = "/registerUser")
    public User registerUser(User user, MultipartFile multipartFile) throws IOException {
        user = new User(null, "zhangsan2", "123456", "a.png", 0, new Date(), "123@qq.com");
        userService.saveUser(user);
        return user;
    }

    @PostMapping(value = "/userLogin")
    public User userLogin(User user){
        return user = new User(null, "zhangsan2", "123456", "a.png", 0, new Date(), "123@qq.com");
    }

    @PutMapping(value = "/updateUser")
    public void updateUser(User user,MultipartFile multipartFile) throws IOException{
        userService.updateUser(user);
    }

    @DeleteMapping(value = "/deleteUserByIds")
    public void delteUserByIds(Integer[] ids){}

    @GetMapping(value = "/queryUserByPage")
    public List<User> queryUserByPage(@RequestParam(value = "pageIndex",defaultValue = "1")
                                              Integer pageIndex,
                                      @RequestParam(value = "rows",defaultValue =
                                              "10") Integer pageSize,
                                      @RequestParam(value = "column",required = false)
                                              String column,
                                      @RequestParam(value = "value",required = false)
                                              String value){
        List<User> users = userService.queryUserByPage(pageIndex, pageSize, column, value);
        return users;
    }

    @GetMapping(value = "/queryUserCount")
    public Integer queryUserCount(String column,String value){
        int count = userService.queryUserCount(column, value);
        return count;
    }

    @GetMapping(value = "/queryUserById")
    public User queryUserById(Integer id){
        User user = userService.queryUserById(id);
        return user;
    }
}
