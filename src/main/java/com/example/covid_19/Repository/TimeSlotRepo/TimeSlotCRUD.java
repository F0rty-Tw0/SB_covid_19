package com.example.covid_19.Repository.TimeSlotRepo;

import com.example.covid_19.Model.TimeSlot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class TimeSlotCRUD implements TimeSlotInterface{

    @Autowired
    JdbcTemplate jdbc;
    private final String table = "timeslots";

    @Override
    public List<TimeSlot> viewAllTimeSlots(){
        String sql = "SELECT * FROM" + table;
        RowMapper <TimeSlot> rowMapper = new BeanPropertyRowMapper<>(TimeSlot.class);
        return jdbc.query(sql, rowMapper);



    };
}
