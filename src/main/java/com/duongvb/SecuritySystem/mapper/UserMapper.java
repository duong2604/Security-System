package com.duongvb.SecuritySystem.mapper;

import com.duongvb.SecuritySystem.dto.request.UserCreationRequest;
import com.duongvb.SecuritySystem.dto.request.UserUpdateRequest;
import com.duongvb.SecuritySystem.dto.response.UserResponse;
import com.duongvb.SecuritySystem.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);

    UserResponse toUserResponse(User user);

    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
