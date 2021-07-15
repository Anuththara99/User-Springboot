package com.spring.springuni.controller;

import com.spring.springuni.domain.User;
import com.spring.springuni.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
        return userRepository.createUser(user);
    }

    @PutMapping("/user/{id}")
    public User updateUser(@RequestBody User user) {
        return userRepository.editUser(user);
    }

    @GetMapping("/user/{userId}")
    public User searchUser(@PathVariable("userId") int userId) {
        return userRepository.searchUser(userId);
    }

    @GetMapping("/users")
    public List<User> viewUser() {
        return userRepository.allUsers();
    }

    @DeleteMapping("/user/{userId}")
    public String deleteUser(@PathVariable("userId") int userId) {
        return userRepository.deleteUser(userId);
    }

}
