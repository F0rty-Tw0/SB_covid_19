package com.example.covid_19.Service.BookingService;

import com.example.covid_19.Model.Booking;
import com.example.covid_19.Repository.BookingRepo.BookingInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class BookingServiceCRUD implements BookingServiceInterface{
    @Autowired
    BookingInterface bookingInterface;

    public int addBooking(Booking booking){return bookingInterface.addBooking(booking); }

    // READ
    public Booking findBookingById(int bookingId){return bookingInterface.findBookingById(bookingId);}

    public List<Booking> findBookingByTime(int bookingTimeSlotId){return bookingInterface.findBookingByTime(bookingTimeSlotId);}

    public List<Booking> findBookingByDate(Date bookingDate) {return bookingInterface.findBookingByDate(bookingDate);}

    public List<Booking> viewAllBookings(){return bookingInterface.viewAllBookings();}

    public int findLatestBookingById() {return bookingInterface.findLatestBookingById();}

    // UPDATE
    public int editBooking(Booking booking){return bookingInterface.editBooking(booking);}

    // DELETE
    public int deleteBooking(int bookingId){return bookingInterface.deleteBooking(bookingId);}
}
