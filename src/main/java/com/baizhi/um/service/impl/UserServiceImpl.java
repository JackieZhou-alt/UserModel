package com.baizhi.um.service.impl;

import com.baizhi.um.dao.UserDao;
import com.baizhi.um.entity.User;
import com.baizhi.um.service.UserService;
import com.sun.scenario.effect.Offset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User queryUserByNameAndPassword(User user) {
        return userDao.queryUserByNameAndPassword(user);
    }

    @Override
    public List<User> queryUserByPage(Integer pageIndex, Integer pageSize, String column, Object value) {
        List<User> users = userDao.queryUserByPage(pageIndex, pageSize, column, value);
        return users;
    }

    @Override
    public int queryUserCount(String column, Object value) {
        return userDao.queryCount(column,value);
    }

    @Override
    public User queryUserById(Integer id) {
        return userDao.queryUserById(id);
    }

    @Override
    public void deleteByUserIds(Integer[] ids) {
        userDao.deleteByUserIds(ids);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }
}
