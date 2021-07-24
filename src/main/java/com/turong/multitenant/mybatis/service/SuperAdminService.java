package com.turong.multitenant.mybatis.service;

import com.turong.multitenant.mybatis.entity.User;

import java.util.List;

public interface SuperAdminService {

    List<User> searchAllUsers(final SearchCriteria criteria);

}
