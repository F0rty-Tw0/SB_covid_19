package com.example.covid_19.Service.BookingService;

import com.example.covid_19.Model.Booking;
import com.example.covid_19.Repository.BookingRepo.BookingInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class BookingServiceCRUD implements BookingServiceInterface {
    @Autowired
    BookingInterface bookingInterface;

    public int addBooking(Booking booking) {
        return bookingInterface.addBooking(booking);
    }

    // READ

    public List<Booking> findBookingByDate(Date bookingDate) {
        return bookingInterface.findBookingByDate(bookingDate);
    }

    public List<Booking> findBookingByUserId(int bookingUserId) {
        return bookingInterface.findBookingByUserId(bookingUserId);
    }

    // DELETE
    public int deleteBooking(int bookingId) {
        return bookingInterface.deleteBooking(bookingId);
    }
}
