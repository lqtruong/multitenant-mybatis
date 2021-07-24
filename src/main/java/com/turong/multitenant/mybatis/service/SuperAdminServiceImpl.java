package com.turong.multitenant.mybatis.service;

import com.turong.multitenant.mybatis.config.AppContextHolder;
import com.turong.multitenant.mybatis.entity.User;
import com.turong.multitenant.mybatis.mapper.SuperAdminMapper;
import com.turong.multitenant.mybatis.mapper.SupportedTenant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class SuperAdminServiceImpl implements SuperAdminService {

    private SuperAdminMapper mapper;

    SuperAdminServiceImpl(@Autowired final SuperAdminMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<User> searchAllUsers(final SearchCriteria criteria) {
        if (Objects.isNull(criteria)) {

        }

        return Arrays
                .stream(SupportedTenant.values())
                .map(SupportedTenant::getTenant)
                .map(this::searchUsersInTenant)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

    }

    private List<User> searchUsersInTenant(final String tenant) {
        AppContextHolder.setTenant(tenant);
        return mapper.findUsers();
    }

}
