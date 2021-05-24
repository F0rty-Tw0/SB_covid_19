package com.example.covid_19.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userhistory")
public class History {

  @Id
  private int userHistoryId;
  private int userHistoryUserId;
  private int userHistoryBookingId;

  @javax.persistence.Id
  public int getUserHistoryId() {
    return userHistoryId;
  }

  public void setUserHistoryId(int userHistoryId) {
    this.userHistoryId = userHistoryId;
  }

  public int getUserHistoryUserId() {
    return userHistoryUserId;
  }

  public void setUserHistoryUserId(int userHistoryUserId) {
    this.userHistoryUserId = userHistoryUserId;
  }

  public int getUserHistoryBookingId() {
    return userHistoryBookingId;
  }

  public void setUserHistoryBookingId(int userHistoryBookingId) {
    this.userHistoryBookingId = userHistoryBookingId;
  }
}
