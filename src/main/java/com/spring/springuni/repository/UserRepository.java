package com.spring.springuni.repository;

import com.spring.springuni.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository {

    User createUser(User user);
    //to add new user to the db

    User editUser(User user);
    //to edit existing user using id

    String deleteUser(int userId);
    //to delete user from the db using id

    User searchUser(int userId);
    //to search user by id

    List<User> allUsers();
    //to view all the users

}
