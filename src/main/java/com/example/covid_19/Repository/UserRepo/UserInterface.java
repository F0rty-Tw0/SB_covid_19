package com.example.covid_19.Controller.Repository.UserRepo;

import com.example.covid_19.Controller.Model.User;

import java.util.List;

public interface UserInterface {
  // CREATE

  public User addUser(User user);

  // READ
public User findUserById(int userId);

public User findUserByCpr(int userCpr);

public List<User> findUserByRole(int userRoleId);

public List<User> viewAllUsers();
  // UPDATE
public User updateUser(int UserId, User user);
  // DELETE
  public User deleteUser(int userId);
}
