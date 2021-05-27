package com.example.covid_19.Service.BookingService;

import com.example.covid_19.Model.Booking;
import java.sql.Date;
import java.util.List;

public interface BookingServiceInterface {
    // CREATE
    public int addBooking(Booking booking);

    // READ
    public List<Booking> findBookingByDate(Date bookingDate);

    public List<Booking> findBookingByUserId(int bookingUserId);

    // DELETE
    public int deleteBooking(int bookingId);
}
