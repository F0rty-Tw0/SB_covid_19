package com.example.covid_19.Service.UserService;

import com.example.covid_19.Model.User;

import java.util.List;

public interface UserServiceInterface {
    // CREATE
    public int addUser(User user);

    // READ
    public User findUserById(int userId);

    public User findUserByCpr(long userCpr);

    public User findUserByEmail(String userEmail);

    public List<User> viewAllUsers();

    // UPDATE
    public int updateUser(User user);

    public int updateUserStatus(String userStatus, int userId);

    // DELETE
    public int deleteUser(int userId);
}
