package com.example.covid_19.Repository.UserRepo;

import java.util.List;

import com.example.covid_19.Model.User;

public interface UserInterface {
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
