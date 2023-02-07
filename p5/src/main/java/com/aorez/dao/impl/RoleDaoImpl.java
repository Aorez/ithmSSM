package com.aorez.dao.impl;

import com.aorez.dao.RoleDao;
import com.aorez.domain.Role;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class RoleDaoImpl implements RoleDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Role> findAll() {
        List<Role> roleList = jdbcTemplate.query("select * from sys_role", new BeanPropertyRowMapper<>(Role.class));
        return roleList;
    }

    @Override
    public void save(Role role) {
        jdbcTemplate.update("insert into sys_role values (?,?,?)",null,role.getRoleName(),role.getRoleDesc());
    }

    @Override
    public List<Role> findRoleByUserId(Long userId) {
        List<Role> roleList = jdbcTemplate.query("select * from sys_role r, sys_user_role ur where ur.userId=? and ur.roleId = r.id", new BeanPropertyRowMapper<>(Role.class), userId);
        return roleList;
    }
}
