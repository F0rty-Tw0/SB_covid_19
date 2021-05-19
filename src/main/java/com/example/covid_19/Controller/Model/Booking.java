package com.example.covid_19.Controller.Model;

import org.springframework.data.annotation.Id;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "booking")
public class Booking {
  @Id
  private int bookingId;
  private String bookingName;
  private int bookingTimeSlotId;
  private Date bookingDate;

  @javax.persistence.Id
  public int getBookingId() {
    return bookingId;
  }

  public void setBookingId(int bookingId) {
    this.bookingId = bookingId;
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