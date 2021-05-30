package com.example.covid_19.Controller;

import java.time.LocalDate;

import javax.servlet.http.HttpSession;

import com.example.covid_19.Model.User;
import com.example.covid_19.Service.PasswordService.PasswordServiceInterface;
import com.example.covid_19.Service.UserService.UserServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthenticationController {
  @Autowired
  private UserServiceInterface userService;

  @Autowired
  private PasswordServiceInterface passwordService;

  @PostMapping("/register")
  public String register(@ModelAttribute User user, RedirectAttributes redirectAttributes, HttpSession session) {
    try {
      userService.addUser(user);
      // After the user is registered successfully we log him in with the details he provided. 
      logIn(user.getUserEmail(), user.getUserPassword(), session, redirectAttributes);
    } catch (Exception e) {
      // We are adding a flash attribute to display the error message.
      redirectAttributes.addFlashAttribute("error", e.getMessage());
      return "redirect:/";
    }
    return "redirect:/user";
  }

  @PostMapping("/login")
  public String logIn(@ModelAttribute("login") String login, @ModelAttribute("password") String password,
      HttpSession session, RedirectAttributes redirectAttributes) {
    User user;
    // We check if the login is an email else it should be CPR
    if (login.contains("@")) {
      try {
        user = userService.findUserByEmail(login);
        validateUser(password, session, user);
      } catch (Exception e) {
        // If the email doesn't match to the user we throw this error
        if (e instanceof EmptyResultDataAccessException) {
          redirectAttributes.addFlashAttribute("error", "There is no such user with this Email");
        } else {
          redirectAttributes.addFlashAttribute("error", e.getMessage());
        }
      }
    } else {
      try {
        user = userService.findUserByCpr(Long.parseLong(login));
        validateUser(password, session, user);
      } catch (Exception e) {
        System.out.println(e);
        // If the inputted CPR contains letters we throw this error
        if (e instanceof NumberFormatException)
          redirectAttributes.addFlashAttribute("error", "Your CPR must contain only numbers!");
        // If the CPR doesn't match to the user we throw this error
        else if (e instanceof EmptyResultDataAccessException) {
          redirectAttributes.addFlashAttribute("error", "There is no such user with this CPR");
        } else {
          redirectAttributes.addFlashAttribute("error", e.getMessage());
        }
      }
    }
    return "redirect:/";
  }

  @PostMapping("/logout")
  public String logOut(HttpSession session) {
    // When logged out, the validated session is false
    session.setAttribute("isValidated", false);
    return "redirect:/";
  }

  private void validateUser(String password, HttpSession session, User loggedUser) {
    // We compare the password of user if it matches with the input password
    if (this.passwordService.match(password, loggedUser.getUserPassword())) {
      LocalDate date = LocalDate.now();
      session.setAttribute("isValidated", true);
      //We also set the date now to compare the future bookings.
      session.setAttribute("dateNow", date);
      session.setAttribute("loggedUser", loggedUser);
    } else {
      session.setAttribute("isValidated", false);
      throw new UnsupportedOperationException("The password is incorrect");
    }
  }
}
