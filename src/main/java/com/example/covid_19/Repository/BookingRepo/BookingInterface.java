package com.example.covid_19.Repository.BookingRepo;

import java.sql.Date;
import java.util.List;

import com.example.covid_19.Model.Booking;

public interface BookingInterface {
    // CREATE
    public int addBooking(Booking booking);

    // READ
    public List<Booking> findBookingByDate(Date bookingDate);

    public List<Booking> findBookingByUserId(int bookingUserId);

    // DELETE
    public int deleteBooking(int bookingId);
}
