package com.duongvb.SecuritySystem.service;

import com.duongvb.SecuritySystem.dto.request.UserCreationRequest;
import com.duongvb.SecuritySystem.dto.request.UserUpdateRequest;
import com.duongvb.SecuritySystem.dto.response.UserResponse;
import com.duongvb.SecuritySystem.entity.User;
import com.duongvb.SecuritySystem.exception.ErrorCode;
import com.duongvb.SecuritySystem.mapper.UserMapper;
import com.duongvb.SecuritySystem.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor(onConstructor_ = {@Autowired})
@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {
    UserRepository userRepository;
    UserMapper userMapper;

    public UserResponse createUser(UserCreationRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException(ErrorCode.UNCATEGORIZED_EXCEPTION.getMessage());
        }
        User user = userMapper.toUser(request);
        return userMapper.toUserResponse(userRepository.save(user));
    }

    public List<User> getAllUsers() {
        return (userRepository.findAll());
    }

    public User findUserById(String userId) {
        return userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User updateUser(String userId, UserUpdateRequest request) {
        User user = findUserById(userId);

        userMapper.updateUser(user, request);
        return userRepository.save(user);
    }

    public String deleteUser(String userId) {
        userRepository.deleteById(userId);
        return "User has been deleted";
    }
}
