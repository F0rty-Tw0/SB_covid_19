package com.example.covid_19.Repository.TimeSlotRepo;

import com.example.covid_19.Model.TimeSlot;

import java.util.List;

public interface TimeSlotInterface {
    public List<TimeSlot> viewAllTimeSlots();

    public String findTimeSlotById(int timeSlotId);
}
