package com.spring.springuni.repository;

import com.spring.springuni.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository {

    User createUser(User user);

    User editUser(User user);

    String deleteUser(int userId);

    User searchUser(int userId);

    List<User> allUsers();

}
