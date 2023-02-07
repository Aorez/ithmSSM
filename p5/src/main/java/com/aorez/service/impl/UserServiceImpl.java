package com.aorez.service.impl;

import com.aorez.dao.RoleDao;
import com.aorez.dao.UserDao;
import com.aorez.domain.Role;
import com.aorez.domain.User;
import com.aorez.service.UserService;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao;
    private RoleDao roleDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<User> list() {
        List<User> userList = userDao.findAll();
        for (User user : userList) {
            Long id = user.getId();
            List<Role> roleList = roleDao.findRoleByUserId(id);
            user.setRoles(roleList);
        }
        return userList;
    }

    @Override
    public void save(User user, Long[] roleIds) {
        Long userId = userDao.save(user);
        userDao.saveUserRoleRelation(userId, roleIds);
    }

    @Override
    public void del(Long userId) {
        userDao.delUserRoleRelation(userId);
        userDao.delUser(userId);
    }

    @Override
    public User login(String username, String password) {
        try {
            User user = userDao.fineByUsernameAndPassword(username, password);
            return user;
        }
        catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
