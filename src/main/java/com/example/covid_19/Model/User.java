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
  private long userCpr;
  private int userPhone;
  private String userAddress;
  private String userStatus;
  private String userRole;

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

  public long getUserCpr() {
    return userCpr;
  }

  public void setUserCpr(long userCpr) {
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
