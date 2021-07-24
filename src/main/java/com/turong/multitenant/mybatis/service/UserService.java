package com.turong.multitenant.mybatis.service;

import com.turong.multitenant.mybatis.controller.UserResponse;
import com.turong.multitenant.mybatis.entity.User;

public interface UserService {

    UserResponse getUser(String id);

    User create(User userToCreate);

    int deleteByEmail(String email);

    int deleteById(String id);
}
