package com.example.covid_19.Repository.BookingRepo;

import com.example.covid_19.Model.Booking;
import com.example.covid_19.Model.User;
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
    private final String table = "booking";


    @Override
    public int addBooking(Booking booking){
        String sql = "INSERT INTO " + table + "VALUES(?,?,?,?)";
        return jdbc.update(sql, null, booking.getBookingName(), booking.getBookingTimeSlotId(), booking.getBookingDate());
    }

    // READ
    @Override
    public Booking findBookingById(int bookingId) {
        String sql = "SELECT * FROM " + table + " WHERE bookingId = ?";
        RowMapper<Booking>  rowMapper = new BeanPropertyRowMapper<>(Booking.class);
        Booking myBooking = jdbc.queryForObject(sql, rowMapper, bookingId);
        return myBooking;
    }

    @Override
    public List<Booking> findBookingByTime(int bookingTimeSlotId){
        String sql = "SELECT * FROM " + table + " WHERE bookingTimeSlotId = ?";
        RowMapper<Booking> rowMapper = new BeanPropertyRowMapper<>(Booking.class);
        return jdbc.query(sql, rowMapper, bookingTimeSlotId);
    }
    @Override
    public List<Booking> findBookingByDate(Date bookingDate){
        String sql = "SELECT * FROM " + table + " WHERE bookingDate = ?";
        RowMapper<Booking> rowMapper = new BeanPropertyRowMapper<>(Booking.class);
        return jdbc.query(sql, rowMapper, bookingDate);
    }
    @Override
    public List<Booking> viewAllBookings(){
        String sql = "SELECT * FROM " + table;
        RowMapper<Booking> rowMapper = new BeanPropertyRowMapper<>(Booking.class);
        return jdbc.query(sql, rowMapper);
    }

    // UPDATE
    @Override
    public int editBooking(Booking booking){
        String sql = "UPDATE " + table + "SET bookingName = ?, bookingTimeSlotId = ?, bookingDate = ? WHERE bookingId = ?";
        return jdbc.update(booking.getBookingName(), booking.getBookingTimeSlotId(), booking.getBookingDate(), booking.getBookingId());
    }

    // DELETE
    @Override
    public int deleteBooking(int bookingId){
        String sql = "DELETE FROM " + table + " WHERE bookingId = ?";
        return jdbc.update(sql, bookingId);
    }

}
