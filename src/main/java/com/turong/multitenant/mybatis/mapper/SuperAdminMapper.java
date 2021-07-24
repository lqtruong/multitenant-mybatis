package com.turong.multitenant.mybatis.mapper;

import com.turong.multitenant.mybatis.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SuperAdminMapper {

    @Select("select * from users")
    List<User> findUsers();

}
