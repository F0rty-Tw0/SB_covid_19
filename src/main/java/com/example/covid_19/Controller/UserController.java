package com.example.covid_19.Controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.covid_19.Model.Booking;
import com.example.covid_19.Model.User;
import com.example.covid_19.Service.BookingService.BookingServiceInterface;
import com.example.covid_19.Service.TimeSlotService.TimeSlotServiceInterface;
import com.example.covid_19.Service.UserService.UserServiceInterface;
import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
  LocalDate date;

  @Autowired
  private BookingServiceInterface bookings;

  @Autowired
  private TimeSlotServiceInterface timeSlots;

  @Autowired
  private UserServiceInterface users;

  @GetMapping("/user")
  public String user(Model model, HttpSession session) {
    User user = (User) session.getAttribute("loggedUser");
    List<Booking> listOfUserBookings = bookings.findBookingByUserId(user.getUserId());
    List<Booking> upcomingBookings = new ArrayList<Booking>();

    for (Booking booking : listOfUserBookings) {
      if (booking.getBookingName().equals("Vaccine")) {
        String firstVaccineDate = booking.getBookingDate().toString();
        model.addAttribute("firstVaccineDate", firstVaccineDate);
        model.addAttribute("secondVaccineDate", secondVaccine(firstVaccineDate));
      }
      if (LocalDate.now().plusDays(1).isBefore(LocalDate.parse(booking.getBookingDate().toString()))) {
        upcomingBookings.add(booking);
      }
    }

    sortBookings(listOfUserBookings);
    sortBookings(upcomingBookings);

    model.addAttribute("upcomingBookings", upcomingBookings);
    model.addAttribute("listOfUserBookings", listOfUserBookings);
    model.addAttribute("timeSlots", timeSlots);
    return "user";
  }

  public void sortBookings(List<Booking> listOfBookings) {
    Collections.sort(listOfBookings,
        (booking1, booking2) -> booking1.getBookingDate().compareTo(booking2.getBookingDate()));
  }

  public String secondVaccine(String firstVaccineDate) {
    return LocalDate.parse(firstVaccineDate).plusDays(30).toString();
  }

  @GetMapping("/usersAutocomplete")
  @ResponseBody
  public List<User> usersAutocomplete(HttpSession session) {
    User user = (User) session.getAttribute("loggedUser");
    if (user.getUserRoleId() == 2) {
      List<User> suggestions = users.viewAllUsers();
      return suggestions;
    }
    return null;
  }
}
