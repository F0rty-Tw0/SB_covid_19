package com.example.covid_19.Repository.UserRepo;

import java.util.List;

import com.example.covid_19.Model.User;

public interface UserInterface {
  // CREATE
  public int addUser(User user);

  // READ
  public User findUserById(int userId);

  public User findUserByCpr(int userCpr);

  public User findUserByEmail(String userEmail);

  public List<User> findUserByRole(int userRoleId);

  public List<User> viewAllUsers();

  // UPDATE
  public int updateUser(User user);

  public int updateUserPassword(User user);

  public int updateUserStatus(User user);

  public int updateUserRole(User user);


  // DELETE
  public int deleteUser(int userId);
}
