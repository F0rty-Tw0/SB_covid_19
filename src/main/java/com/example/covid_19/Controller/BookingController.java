package com.example.covid_19.Controller;

import java.sql.Date;
import java.util.List;

import com.example.covid_19.Model.Booking;
import com.example.covid_19.Model.TimeSlot;
import com.example.covid_19.Model.User;
import com.example.covid_19.Service.BookingService.BookingServiceInterface;
import com.example.covid_19.Service.HistoryService.HistoryServiceInterface;
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
  HistoryServiceInterface history;
  @Autowired
  BookingServiceInterface bookings;
  @Autowired
  private TimeSlotServiceInterface timeSlots;

  @PostMapping("selectedDate")
  public String selectDate(@RequestParam(value = "bookingDate", required = true, defaultValue = "") String bookingDate,
      Model model) {
    Date date = Date.valueOf(bookingDate); // converting string into sql date
    System.out.println(date);
    List<Booking> listOfBookings = bookings.findBookingByDate(date);
    List<TimeSlot> listOfTimeSlots = timeSlots.viewAllTimeSlots();

    for (Booking booking : listOfBookings) {
      int removingTimeSlot = booking.getBookingTimeSlotId();
      listOfTimeSlots.removeIf(timeSlot -> timeSlot.getTimeSlotId() == removingTimeSlot);
    }

    model.addAttribute("listOfTimeSlots", listOfTimeSlots);
    model.addAttribute("bookingDate", bookingDate);
    return "index";
  }

  @PostMapping("makeBooking")
  public String makeBooking(@ModelAttribute Booking booking, HttpSession session) {
    bookings.addBooking(booking);
    User user = (User) session.getAttribute("loggedUser");
    System.out.println(user.getUserId());


    history.addHistory(user.getUserId(),bookings.findLatestBookingById());
    return "redirect:/";
  }

}
