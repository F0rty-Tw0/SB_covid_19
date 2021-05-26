package com.example.covid_19.Model;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "users")

public class User {
  @Id
  private int userId;
  private String userName;
  private String userPassword;
  private String userEmail;
  private int userCpr;
  private int userPhone;
  private String userAddress;
  private String userStatus;
  private String userRole;

  public User(int userId, String userName, String userPassword, String userEmail, int userCpr, int userPhone,
      String userAddress, String userStatus, String userRole) {
    this.userId = userId;
    this.userName = userName;
    this.userPassword = userPassword;
    this.userEmail = userEmail;
    this.userCpr = userCpr;
    this.userPhone = userPhone;
    this.userAddress = userAddress;
    this.userStatus = userStatus;
    this.userRole = userRole;
  };

  public User() {
  };

  @javax.persistence.Id
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

  public String getUserPassword() {
    return userPassword;
  }

  public void setUserPassword(String userPassword) {
    this.userPassword = userPassword;
  }

  public String getUserEmail() {
    return userEmail;
  }

  public void setUserEmail(String userEmail) {
    this.userEmail = userEmail;
  }

  public int getUserCpr() {
    return userCpr;
  }

  public void setUserCpr(int userCpr) {
    this.userCpr = userCpr;
  }

  public int getUserPhone() {
    return userPhone;
  }

  public void setUserPhone(int userPhone) {
    this.userPhone = userPhone;
  }

  public String getUserAddress() {
    return userAddress;
  }

  public void setUserAddress(String userAddress) {
    this.userAddress = userAddress;
  }

  public String getUserStatus() {
    return userStatus;
  }

  public void setUserStatus(String userStatus) {
    this.userStatus = userStatus;
  }

  public String getUserRole() {
    return userRole;
  }

  public void setUserRole(String userRole) {
    this.userRole = userRole;
  }
}
