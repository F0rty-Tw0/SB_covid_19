package com.example.covid_19.Controller;


import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {
    @GetMapping("/")
    public String index(){
        return "index";

    }
}
