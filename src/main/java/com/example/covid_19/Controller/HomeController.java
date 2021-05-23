package com.example.covid_19.Controller;

import java.security.SecureRandom;
import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.example.covid_19.Model.Booking;
import com.example.covid_19.Model.TimeSlot;
import com.example.covid_19.Model.User;
import com.example.covid_19.Service.UserService.UserServiceInterface;
import com.example.covid_19.Service.BookingService.BookingServiceInterface;
import com.example.covid_19.Service.PasswordService.PasswordServiceInterface;
import com.example.covid_19.Service.TimeSlotService.TimeSlotServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    private UserServiceInterface users;

    @Autowired
    private BookingServiceInterface bookings;

    @Autowired
    private PasswordServiceInterface password;

    @Autowired
    private TimeSlotServiceInterface timeSlots;

    @GetMapping("/")
    public String index() {
        // User user = new User(83, "Nikolai Tofan", password.encrypt("string"),
        // "sart@gmail.com", 1934565, 9999999, "TESAT WAY", 1, 1) {
        // };

        // try {
        // users.addUser(user);
        // } catch (RuntimeException e) {
        // System.out.println(e.getMessage());
        // }

        // User user = users.findUserById(111);

        // System.out.println(password.match("string", user.getUserPassword()));

        String str = "2015-03-31";
        Date date = Date.valueOf(str); // converting string into sql date
        // Booking booking = new Booking(0, "Nikolai", 3, date);
        // bookings.addBooking(booking);
        List<Booking> listOfBookings = bookings.findBookingByDate(date);
        List<TimeSlot> listOfTimeSlots = timeSlots.viewAllTimeSlots();
        System.out.println(listOfTimeSlots.size());

        for (int i = 0; i < listOfBookings.size(); i++) {
            System.out.println(listOfBookings.get(i).getBookingTimeSlotId());
            int removingTimeSlot = listOfBookings.get(i).getBookingTimeSlotId();

            listOfTimeSlots.removeIf(timeSlot -> timeSlot.getTimeSlotId() == removingTimeSlot);
        }

        for (int i = 0; i < listOfTimeSlots.size(); i++) {
            System.out.println(listOfTimeSlots.get(i).getTimeSlotId());
        }

        return "index";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @GetMapping("/vaccine")
    public String vaccine() {
        return "vaccine";
    }

    @GetMapping("/user")
    public String user() {
        return "user";
    }

}
