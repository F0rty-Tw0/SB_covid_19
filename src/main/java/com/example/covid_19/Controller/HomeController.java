package com.example.covid_19.Controller;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.HashMap;
import java.util.Map;

@Controller
public class HomeController {
    @GetMapping("/")
    public String index() {
        // minimumRequirements();
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
        // We check if the user was logged in then he has access to that success page
        if (session.getAttribute("isValidated") != null) {
            return "success";
        }
        return "index";
    }

    private void minimumRequirements() {
        // And messages wouldn't be stored in a map
        Map<Integer, String> messages = new HashMap<Integer, String>();

        int i = 0;
        while (i < 5) {
            messages.put(i, "File created on number: " + i);
            i++;
        }

        i = 0;
        do {
            System.out.println(messages.get(i));
            i++;
        } while (i < messages.size());
    }
}
