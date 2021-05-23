package com.example.covid_19.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "timeslots")


public class TimeSlot {
    @Id
    private int timeSlotId;
    private String timeSlotName;

    public TimeSlot() {
    }

    public TimeSlot(int timeSlotId, String timeSlotName) {
        this.timeSlotId = timeSlotId;
        this.timeSlotName = timeSlotName;
    }

    public int getTimeSlotId() {
        return timeSlotId;
    }

    public void setTimeSlotId(int timeSlotId) {
        this.timeSlotId = timeSlotId;
    }

    public String getTimeSlotName() {
        return timeSlotName;
    }

    public void setTimeSlotName(String timeSlotName) {
        this.timeSlotName = timeSlotName;
    }
}
