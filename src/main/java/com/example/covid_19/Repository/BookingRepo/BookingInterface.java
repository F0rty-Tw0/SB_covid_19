package com.example.covid_19.Repository.BookingRepo;

import java.sql.Date;
import java.util.List;

import com.example.covid_19.Model.Booking;

public interface BookingInterface {
    // CREATE
    public int addBooking(Booking booking);

    // READ
    public Booking findBookingById(int bookingId);

    public List<Booking> findBookingByTime(int bookingTimeSlotId);

    public List<Booking> findBookingByDate(Date bookingDate);

    public List<Booking> viewAllBookings();

    public int findLatestBookingById();
    // UPDATE
    public int editBooking(Booking booking);

    // DELETE
    public int deleteBooking(int bookingId);
}
