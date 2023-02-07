package com.aorez.dao;

import com.aorez.domain.Role;

import java.util.List;

public interface RoleDao {
    public List<Role> findAll();

    public void save(Role role);

    public List<Role> findRoleByUserId(Long userId);
}
