package com.example.covid_19.Repository.BookingRepo;

import com.example.covid_19.Model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public class BookingCRUD implements BookingInterface {

    @Autowired
    JdbcTemplate jdbc;
    private final String table = "bookings";

    @Override
    public int addBooking(Booking booking) {
        String sql = "INSERT INTO " + table + " VALUES(?,?,?,?,?)";
        return jdbc.update(sql, null, booking.getBookingUserId(), booking.getBookingName(),
                booking.getBookingTimeSlotId(), booking.getBookingDate());
    }

    // READ
    @Override
    public List<Booking> findBookingByDate(Date bookingDate) {
        String sql = "SELECT * FROM " + table + " WHERE bookingDate = ?";
        RowMapper<Booking> rowMapper = new BeanPropertyRowMapper<>(Booking.class);
        return jdbc.query(sql, rowMapper, bookingDate);
    }

    @Override
    public List<Booking> findBookingByUserId(int bookingUserId) {
        String sql = "SELECT * FROM " + table + " WHERE bookingUserId = ?";
        RowMapper<Booking> rowMapper = new BeanPropertyRowMapper<>(Booking.class);
        return jdbc.query(sql, rowMapper, bookingUserId);
    }

    // DELETE
    @Override
    public int deleteBooking(int bookingId) {
        String sql = "DELETE FROM " + table + " WHERE bookingId = ?";
        return jdbc.update(sql, bookingId);
    }
}
