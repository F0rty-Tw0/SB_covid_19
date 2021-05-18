package com.example.covid_19.Controller.Repository.BookingRepo;

import java.sql.Date;

public interface BookingInterface {
    // CREATE
    public Booking addBooking(Booking booking);

    // READ
    public Booking findBookingById(int bookingId);

    public Booking findBookingByName(String bookingName);

    public Booking findBookingByTime(int bookingTimeSlotId);

    public Booking findBookingByDate(Date bookingDate);

    public List<Booking> viewAllBookings();

    // UPDATE
    public Booking editBooking(int bookingId, Booking booking);

    // DELETE
    public Booking deleteBooking(int bookingId);
}
