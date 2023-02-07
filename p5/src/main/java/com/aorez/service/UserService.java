package com.aorez.service;

import com.aorez.domain.User;

import java.util.List;

public interface UserService {
    public List<User> list();

    public void save(User user, Long[] roleIds);

    void del(Long userId);

    User login(String username, String password);
}
