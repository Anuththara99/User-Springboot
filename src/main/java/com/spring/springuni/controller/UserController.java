package com.spring.springuni.controller;

import com.spring.springuni.domain.User;
import com.spring.springuni.repository.UserRepository;
import com.spring.springuni.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    //to add user using user repository
    @PostMapping("/stud")
    public User createUser(@RequestBody User user) {
        return userRepository.createUser(user);
    }

    //to edit user using user repository
    @PutMapping("/stud/{id}")
    public User updateUser(@RequestBody User user) {
        return userRepository.editUser(user);
    }

    //search by id using user repository
    @GetMapping("/stud/{userId}")
    public User searchUser(@PathVariable("userId") int userId) {
        return userRepository.searchUser(userId);
    }

    //view users using user repository
    @GetMapping("/studs")
    public List<User> viewUsers() {
        return userRepository.allUsers();
    }

    //delete user by id using user repository
    @DeleteMapping("/studs/{userId}")
    public String deleteUser(@PathVariable("userId") int userId) {
        return userRepository.deleteUser(userId);
    }

    /**
     * using User Service
     */


    //add user using userService
    @PostMapping("/user")
    public User addUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    //view all user using userService
    @GetMapping("/users")
    public List<User> viewAllUser() {
        return userService.getUsers();
    }
    //search user by id using userService
    @GetMapping("/users/{userId}")
    public User searchUserById(@PathVariable int userId) {
        return userService.getUserById(userId);
    }

    //search user by userName using userService
    @GetMapping("/usern/{userName}")
    public User searchUserByName(@PathVariable String userName) {
        return userService.getUserByName(userName);
    }

    //edit user by id using userService
    @PutMapping("/user/{userId}")
    public User editUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    //delete user by id using userService
    @DeleteMapping("/user/{userId}")
    public String removeUser(@PathVariable int userId) {
        return userService.deleteUser(userId);
    }


}
