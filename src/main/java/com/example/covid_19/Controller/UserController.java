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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

  @Autowired
  private BookingServiceInterface bookingService;

  @Autowired
  private TimeSlotServiceInterface timeSlotService;

  @Autowired
  private UserServiceInterface userService;

  @GetMapping("/user")
  public String user(Model model, HttpSession session) {
    User user = (User) session.getAttribute("loggedUser");
    fetchUser(model, user);
    return "user";
  }

  @GetMapping("/usersAutocomplete")
  @ResponseBody
  public List<User> usersAutocomplete(HttpSession session) {
    User user = (User) session.getAttribute("loggedUser");
    if (!user.getUserRole().equals("User")) {
      List<User> suggestions = userService.viewAllUsers();
      return suggestions;
    }
    return null;
  }

  @GetMapping("/userPass")
  public String pass(@ModelAttribute("passAvailable") String passAvailable, @ModelAttribute("userId") int userId,
      @ModelAttribute("firstVaccineDate") String firstVaccineDate, Model model) {
    if (passAvailable.equals("true")) {
      User user = userService.findUserById(userId);
      if (!firstVaccineDate.equals("")) {
        model.addAttribute("firstVaccineDate", firstVaccineDate);
        model.addAttribute("secondVaccineDate", secondVaccine(firstVaccineDate));
      }
      fetchUser(model, user);
      return "userPass";
    }
    return "index";
  }

  @PostMapping("/findUser")
  public String findUser(Model model, HttpSession session, @ModelAttribute("userDetails") String userDetails) {
    if (userDetails.contains("@")) {
      try {
        User foundUser = (User) userService.findUserByEmail(userDetails);
        fetchUser(model, foundUser);
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    } else {
      try {
        User foundUser = (User) userService.findUserByCpr(Integer.parseInt(userDetails));
        fetchUser(model, foundUser);
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    }
    return "user";
  }

  @PostMapping("/deleteUser")
  public String user(@ModelAttribute("userId") int userId, HttpSession session) {
    User user = (User) session.getAttribute("loggedUser");
    if (userId != user.getUserId()) {
      userService.deleteUser(userId);
    }
    return "redirect:/user";
  }

  @PostMapping("/updateUser")
  public String updateUser(@ModelAttribute User user, Model model) {
    try {
      userService.updateUser(user);
    } catch (Exception e) {
      System.out.println(e);
      model.addAttribute("error", e.getMessage());
    }
    fetchUser(model, user);
    return "user";
  }

  @PostMapping("/updateStatus")
  public String updateStatus(@ModelAttribute("userStatus") String userStatus, @ModelAttribute("userId") int userId,
      Model model) {
    userService.updateUserStatus(userStatus, userId);
    User user = userService.findUserById(userId);
    fetchUser(model, user);
    return "user";
  }

  private void fetchUser(Model model, User user) {
    List<Booking> listOfUserBookings = new ArrayList<Booking>();
    List<Booking> upcomingBookings = new ArrayList<Booking>();
    listOfUserBookings.clear();
    listOfUserBookings = bookingService.findBookingByUserId(user.getUserId());

    for (Booking booking : listOfUserBookings) {
      if (booking.getBookingName().equals("Vaccine")) {
        String firstVaccineDate = booking.getBookingDate().toString();
        if (LocalDate.now().isAfter(LocalDate.parse(secondVaccine(firstVaccineDate)))) {
          model.addAttribute("passAvailable", true);
        }
        model.addAttribute("firstVaccineDate", firstVaccineDate);
        model.addAttribute("secondVaccineDate", secondVaccine(firstVaccineDate));
      }
      if (LocalDate.now().plusDays(1).isBefore(LocalDate.parse(booking.getBookingDate().toString()))) {
        upcomingBookings.add(booking);
      }
    }

    sortBookings(listOfUserBookings);
    sortBookings(upcomingBookings);

    model.addAttribute("user", user);
    model.addAttribute("timeSlotService", timeSlotService);
    model.addAttribute("upcomingBookings", upcomingBookings);
    model.addAttribute("listOfUserBookings", listOfUserBookings);
    listOfUserBookings = bookingService.findBookingByUserId(user.getUserId());
  }

  @PostMapping("deleteBooking")
  public String deleteBooking(@ModelAttribute("bookingId") int bookingId, @ModelAttribute("userId") int userId,
      Model model) {
    User user = userService.findUserById(userId);
    bookingService.deleteBooking(bookingId);
    fetchUser(model, user);
    return "user";
  }

  private void sortBookings(List<Booking> listOfBookings) {
    Collections.sort(listOfBookings,
        (booking1, booking2) -> booking1.getBookingDate().compareTo(booking2.getBookingDate()));
  }

  private String secondVaccine(String firstVaccineDate) {
    return LocalDate.parse(firstVaccineDate).plusDays(30).toString();
  }

}
