package com.example.covid_19.Model;

import org.springframework.data.annotation.Id;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "booking")

public class Booking {
  @Id
  private int bookingId;
  private int bookingUserId;
  private String bookingName;
  private int bookingTimeSlotId;
  private Date bookingDate;

  public Booking(int bookingId, int bookingUserId, String bookingName, int bookingTimeSlotId, Date bookingDate) {
    this.bookingId = bookingId;
    this.bookingUserId = bookingUserId;
    this.bookingName = bookingName;
    this.bookingTimeSlotId = bookingTimeSlotId;
    this.bookingDate = bookingDate;
  }

  public Booking() {
  }

  @javax.persistence.Id
  public int getBookingId() {
    return bookingId;
  }

  public void setBookingId(int bookingId) {
    this.bookingId = bookingId;
  }

  public int getBookingUserId() {
    return bookingUserId;
  }

  public void setBookingUserId(int bookingUserId) {
    this.bookingUserId = bookingUserId;
  }

  public String getBookingName() {
    return bookingName;
  }

  public void setBookingName(String bookingName) {
    this.bookingName = bookingName;
  }

  public int getBookingTimeSlotId() {
    return bookingTimeSlotId;
  }

  public void setBookingTimeSlotId(int bookingTimeSlotId) {
    this.bookingTimeSlotId = bookingTimeSlotId;
  }

  public Date getBookingDate() {
    return bookingDate;
  }

  public void setBookingDate(Date bookingDate) {
    this.bookingDate = bookingDate;
  }

}
