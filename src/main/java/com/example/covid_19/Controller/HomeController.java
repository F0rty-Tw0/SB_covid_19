package com.example.covid_19.Controller;

import java.sql.Date;

import com.example.covid_19.Model.Booking;
import com.example.covid_19.Model.User;
import com.example.covid_19.Service.UserService.UserServiceInterface;
import com.example.covid_19.Service.BookingService.BookingServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    private UserServiceInterface users;
    User user = new User(83, "Nikolai Tofan", 1, "art@gmail.com", 1234565, 9999999, "TESAT WAY", 1, 1) {
    };

    String str = "2015-03-31";
    Date date = Date.valueOf(str);// converting string into sql date

    @Autowired
    private BookingServiceInterface bookings;

    Booking booking = new Booking(2, "Nikolai", 2, date);

    @GetMapping("/")
    public String index() {
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
