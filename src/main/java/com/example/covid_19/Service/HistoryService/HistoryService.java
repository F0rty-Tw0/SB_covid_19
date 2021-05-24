package com.example.covid_19.Service.HistoryService;

import com.example.covid_19.Repository.HistoryRepo.HistoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoryService implements HistoryServiceInterface {
    @Autowired
    HistoryInterface historyInterface;
    @Override
    public int addHistory(int userId, int bookingId) { return historyInterface.addHistory(userId, bookingId); }
}
