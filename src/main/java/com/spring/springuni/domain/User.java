package com.spring.springuni.domain;

import lombok.Data;

import java.util.Date;
@Data
public class User {
    private int userId;
    private String userName;
    private Date dOB;
    private String userTel;

    public User(int userId, String userName, Date dOB, String userTel) {
        this.userId = userId;
        this.userName = userName;
        this.dOB = dOB;
        this.userTel = userTel;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getdOB() {
        return dOB;
    }

    public void setdOB(Date dOB) {
        this.dOB = dOB;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", dOB=" + dOB +
                ", userTel='" + userTel + '\'' +
                '}';
    }
}
