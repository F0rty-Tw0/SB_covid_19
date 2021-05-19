package com.example.covid_19.Controller.Model;

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
  private int userStatusId;
  private int userRoleId;

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
