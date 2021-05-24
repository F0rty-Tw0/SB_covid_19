package com.example.covid_19.Repository.HistoryRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class History implements HistoryInterface {

    @Autowired
    JdbcTemplate jdbc;
    private final String table = "userhistory";

    @Override
    public int addHistory(int userId, int bookingId) {
        String sql = "INSERT INTO " + table + " VALUES(?,?,?)";

        return jdbc.update(sql,null, userId, bookingId);

    }

}
