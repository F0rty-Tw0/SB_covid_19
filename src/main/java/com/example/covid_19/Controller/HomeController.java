package com.example.covid_19.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
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

    @GetMapping("/success")
    public String success(HttpSession session) {
        if (session.getAttribute("isValidated") != null) {
            return "success";
        }
        return "index";
    }

}
