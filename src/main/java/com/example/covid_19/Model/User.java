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
  private int userPasswordId;
  private String userEmail;
  private int userCpr;
  private int userPhone;
  private String userAddress;
  private int userStatusId;
  private int userRoleId;

  public User(int userId, String userName, int userPasswordId, String userEmail, int userCpr, int userPhone,
      String userAddress, int userStatusId, int userRoleId) {
    this.userId = userId;
    this.userName = userName;
    this.userPasswordId = userPasswordId;
    this.userEmail = userEmail;
    this.userCpr = userCpr;
    this.userPhone = userPhone;
    this.userAddress = userAddress;
    this.userStatusId = userStatusId;
    this.userRoleId = userRoleId;
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

  public int getUserPassword() {
    return userPasswordId;
  }

  public void setUserPassword(int userPasswordId) {
    this.userPasswordId = userPasswordId;
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

  public int getUserStatusId() {
    return userStatusId;
  }

  public void setUserStatusId(int userStatusId) {
    this.userStatusId = userStatusId;
  }

  public int getUserRoleId() {
    return userRoleId;
  }

  public void setUserRoleId(int userRoleId) {
    this.userRoleId = userRoleId;
  }
}
