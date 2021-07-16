package com.spring.springuni.repository.impl;

import com.spring.springuni.domain.User;
import com.spring.springuni.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public abstract class UserRepositoryImpl implements UserRepository {

    private static final String INSERT_QUERY = "INSERT INTO User(userId,userName,dOB,userTel)" +
            "VALUES(?,?,?,?)";
    private static final String UPDATE_QUERY = "UPDATE User set userName=? WHERE userId=?";
    private static final String SELECT_QUERY = "SELECT * FROM User";
    private static final String SEARCH_QUERY = "SELECT * FROM User WHERE userId=?";
    private static final String DELETE_QUERY = "DELETE FROM User WHERE userId=?";
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public User createUser(User user) {
        jdbcTemplate.update(INSERT_QUERY, user.getUserId(), user.getUserName(), user.getdOB(), user.getUserTel());
        return user;
    }

    @Override
    public User editUser(User user) {
        jdbcTemplate.update(UPDATE_QUERY, user.getUserName(), user.getUserId());
        return user;
    }

    @Override
    public String deleteUser(int userId) {
        jdbcTemplate.update(DELETE_QUERY, userId);
        return "Successfully Deleted where id =" + userId + " !!";
    }

    @Override
    public User searchUser(int userId) {
        return jdbcTemplate.queryForObject(SEARCH_QUERY, ((resultSet, i) -> {
            return new User(resultSet.getInt("userId"), resultSet.getString("userName"),
                    resultSet.getDate("dOB"), resultSet.getString("userTel"));
        }), userId);
    }

    @Override
    public List<User> allUsers() {
        return jdbcTemplate.query(SELECT_QUERY, (resultSet, i) -> {
            return new User(resultSet.getInt("userId"), resultSet.getString("userName"),
                    resultSet.getDate("dOB"), resultSet.getString("userTel"));
        });
    }
}
