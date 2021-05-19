package com.example.covid_19.Service.BookingService;

import com.example.covid_19.Model.Booking;
import java.sql.Date;
import java.util.List;

public interface BookingServiceInterface {
    // CREATE
    public int addBooking(Booking booking);

    // READ
    public Booking findBookingById(int bookingId);

    public List<Booking> findBookingByTime(int bookingTimeSlotId);

    public List<Booking> findBookingByDate(Date bookingDate);

    public List<Booking> viewAllBookings();

    // UPDATE
    public int editBooking(Booking booking);

    // DELETE
    public int deleteBooking(int bookingId);
}
