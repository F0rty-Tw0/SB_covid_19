package com.example.covid_19.Controller;

import com.example.covid_19.Model.User;
import com.example.covid_19.Service.PasswordService.PasswordServiceInterface;
import com.example.covid_19.Service.UserService.UserServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthenticationController {
  @Autowired
  private UserServiceInterface users;

  @Autowired
  private PasswordServiceInterface password;

  @PostMapping("/register")
  public String register(@ModelAttribute User user) {
    System.out.println(user.getUserPassword());
    try {
      users.addUser(user);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

    return "index";
  }
}
