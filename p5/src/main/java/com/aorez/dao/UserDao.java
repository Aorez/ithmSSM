package com.aorez.dao;

import com.aorez.domain.User;

import java.util.List;

public interface UserDao {
    public List<User> findAll();

    public Long save(User user);

    void saveUserRoleRelation(Long userId, Long[] roleIds);

    void delUserRoleRelation(Long userId);

    void delUser(Long userId);

    User fineByUsernameAndPassword(String username, String password);
}
