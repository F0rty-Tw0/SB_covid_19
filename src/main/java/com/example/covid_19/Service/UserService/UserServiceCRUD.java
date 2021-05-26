package com.example.covid_19.Service.UserService;

import java.util.List;

import com.example.covid_19.Model.User;
import com.example.covid_19.Repository.UserRepo.UserInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceCRUD implements UserServiceInterface {
  @Autowired
  UserInterface userInterface;

  // CREATE
  @Override
  public int addUser(User user) {
    return userInterface.addUser(user);
  };

  // READ
  @Override
  public User findUserById(int userId) {
    return userInterface.findUserById(userId);
  };

  @Override
  public User findUserByCpr(int userCpr) {
    return userInterface.findUserByCpr(userCpr);
  };

  @Override
  public User findUserByEmail(String userEmail) {
    return userInterface.findUserByEmail(userEmail);
  };

  @Override
  public List<User> findUserByRole(String userRole) {
    return userInterface.findUserByRole(userRole);
  };

  @Override
  public List<User> viewAllUsers() {
    return userInterface.viewAllUsers();
  };

  // UPDATE
  @Override
  public int updateUser(User user) {
    return userInterface.updateUser(user);
  };

  @Override
  public int updateUserPassword(User user) {
    return userInterface.updateUserPassword(user);
  }

  @Override
  public int updateUserStatus(String userStatus, int userId) {
    return userInterface.updateUserStatus(userStatus, userId);
  };

  @Override
  public int updateUserRole(User user) {
    return userInterface.updateUserRole(user);
  };

  // DELETE
  @Override
  public int deleteUser(int userId) {
    return userInterface.deleteUser(userId);
  };
}
