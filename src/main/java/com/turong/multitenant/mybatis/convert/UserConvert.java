package com.turong.multitenant.mybatis.convert;

import com.turong.multitenant.mybatis.controller.UserResponse;
import com.turong.multitenant.mybatis.controller.AllUsersResponse;
import com.turong.multitenant.mybatis.controller.UserSaveRequest;
import com.turong.multitenant.mybatis.entity.User;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UserConvert {

    User toUser(final UserSaveRequest userSaveRequest);

    UserResponse toResponse(final User user);

    default AllUsersResponse toUserListResponse(final List<User> allUsers) {
        return AllUsersResponse.of(allUsers.stream()
                .filter(Objects::nonNull)
                .map(this::toResponse)
                .collect(Collectors.toList())
        );
    }
}
