package com.example.covid_19.Controller;

import java.sql.Date;
import java.util.List;

import com.example.covid_19.Model.Booking;
import com.example.covid_19.Model.TimeSlot;
import com.example.covid_19.Model.User;
import com.example.covid_19.Service.BookingService.BookingServiceInterface;
import com.example.covid_19.Service.TimeSlotService.TimeSlotServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class BookingController {

  @Autowired
  BookingServiceInterface bookingService;
  @Autowired
  private TimeSlotServiceInterface timeSlotService;

  @PostMapping("selectedDate")
  public String selectDate(@RequestParam(value = "bookingDate", required = true, defaultValue = "") String bookingDate,
      Model model, HttpSession session) {
    Date date = Date.valueOf(bookingDate);
    User user = (User) session.getAttribute("loggedUser");
    List<Booking> listOfBookings = bookingService.findBookingByDate(date);
    List<TimeSlot> listOfTimeSlots = timeSlotService.viewAllTimeSlots();
    List<Booking> listOfUserBookings = bookingService.findBookingByUserId(user.getUserId());

    for (Booking booking : listOfBookings) {
      int removingTimeSlot = booking.getBookingTimeSlotId();
      listOfTimeSlots.removeIf(timeSlot -> timeSlot.getTimeSlotId() == removingTimeSlot);
    }
    model.addAttribute("listOfTimeSlots", listOfTimeSlots);
    model.addAttribute("bookingDate", bookingDate);
    model.addAttribute("hasVaccine", containsVaccine(listOfUserBookings));
    return "index";
  }

  @PostMapping("makeBooking")
  public String makeBooking(@ModelAttribute Booking booking) {
    bookingService.addBooking(booking);
    return "redirect:/success";
  }

  public boolean containsVaccine(final List<Booking> listOfUserBookings) {
    return listOfUserBookings.stream().anyMatch(user -> user.getBookingName().equals("Vaccine"));
  }

}
