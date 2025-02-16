package com.duongvb.SecuritySystem.controller;

import com.duongvb.SecuritySystem.dto.request.UserCreationRequest;
import com.duongvb.SecuritySystem.dto.request.UserUpdateRequest;
import com.duongvb.SecuritySystem.entity.User;
import com.duongvb.SecuritySystem.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private  UserService userService;

    @PostMapping
    User createUser(@RequestBody @Valid UserCreationRequest request) {
        return userService.createUser(request);
    }

    @GetMapping
    List<User> getAllUsers() {
        return userService.getAllUsers();
    }


    @GetMapping("/{userId}")
    User getUserById(@PathVariable("userId") String userId) {
        return userService.findUserById(userId);
    }

    @PutMapping("/{userId}")
    User updateUserById(@PathVariable("userId") String userId, @RequestBody UserUpdateRequest request) {
        return userService.updateUser(userId, request);
    }

    @DeleteMapping("/{userId}")
    String deleteUserById(@PathVariable("userId") String userId) {
        return userService.deleteUser(userId);
    }

}
