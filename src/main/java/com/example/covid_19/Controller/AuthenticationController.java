package com.example.covid_19.Controller;

import java.time.LocalDate;

import javax.servlet.http.HttpSession;

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

    return "redirect:/";
  }

  @PostMapping("/login")
  public String logIn(@ModelAttribute("login") String login, @ModelAttribute("password") String password,
      HttpSession session) {
    User user;

    if (login.contains("@")) {
      try {
        user = users.findUserByEmail(login);
        validateUser(password, session, user);
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    } else {
      try {
        user = users.findUserByCpr(Integer.parseInt(login));
        validateUser(password, session, user);
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    }
    return "redirect:/";
  }

  @PostMapping("/logout")
  public String logOut(HttpSession session) {
    session.setAttribute("isValidated", false);
    return "redirect:/";
  }

  private void validateUser(String password, HttpSession session, User loggedUser) {
    if (this.password.match(password, loggedUser.getUserPassword())) {
      LocalDate date = LocalDate.now();
      session.setAttribute("isValidated", true);
      session.setAttribute("dateNow", date);
      session.setAttribute("loggedUser", loggedUser);
    } else {
      session.setAttribute("isValidated", false);
    }
  }
}
