package com.duongvb.SecuritySystem.service;

import com.duongvb.SecuritySystem.dto.request.UserCreationRequest;
import com.duongvb.SecuritySystem.dto.request.UserUpdateRequest;
import com.duongvb.SecuritySystem.entity.User;
import com.duongvb.SecuritySystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(UserCreationRequest request) {
        User user = new User();
        if(userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("User existed.");
        }
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());

        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User findUserById(String userId) {
        return userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User updateUser(String userId, UserUpdateRequest request) {
        User user = findUserById(userId);
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());

        return userRepository.save(user);
    }

    public String deleteUser(String userId) {
        userRepository.deleteById(userId);
        return "User has been deleted";
    }
}
