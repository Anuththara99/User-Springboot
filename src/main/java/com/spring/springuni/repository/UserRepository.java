package com.spring.springuni.repository;

import com.spring.springuni.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

    User createUser(User user);
    //to add new user to the db

    User editUser(User user);
    //to edit existing user using id

    String deleteUser(int userId);
    //to delete user from the db using id

    User searchUser(int userId);
    //to search user by id

    List<User> allUsers();

    User findByUserName(String userName);
    //to view all the users

}
