package com.example.covid_19.Service.TimeSlotService;

import com.example.covid_19.Model.TimeSlot;
import com.example.covid_19.Repository.TimeSlotRepo.TimeSlotInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeSlotCrud implements TimeSlotServiceInterface {

    @Autowired
    TimeSlotInterface timeSlotInterface;

    @Override
    public List<TimeSlot> viewAllTimeSlots() {
        return timeSlotInterface.viewAllTimeSlots();
    }

    @Override
    public String findTimeSlotById(int timeSlotId) {
        return timeSlotInterface.findTimeSlotById(timeSlotId);
    };
}
