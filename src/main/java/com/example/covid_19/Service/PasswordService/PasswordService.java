package com.example.covid_19.Service.PasswordService;

import com.example.covid_19.Repository.PasswordRepo.PasswordInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PasswordService implements PasswordServiceInterface {

  @Autowired
  PasswordInterface passwordInterface;

  @Override
  public String encrypt(String password) {
    return passwordInterface.encrypt(password);
  };

  @Override
  public boolean match(String password, String encodedPassword) {
    return passwordInterface.match(password, encodedPassword);
  }
}
