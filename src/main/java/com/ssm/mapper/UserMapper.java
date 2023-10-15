package com.ssm.mapper;

import com.ssm.po.User;

public interface UserMapper {
    public User findUserByName(String username);
    public int addUser(User user);
}
