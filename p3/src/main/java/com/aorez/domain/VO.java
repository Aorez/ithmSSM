package com.aorez.domain;

import java.util.List;

public class VO {
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "VO{" +
                "users=" + users +
                '}';
    }
}
