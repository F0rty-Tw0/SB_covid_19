package com.example.covid_19.Repository.PasswordRepo;

import java.security.SecureRandom;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
public class Password implements PasswordInterface {

  BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(10, new SecureRandom());

  @Override
  public String encrypt(String password) {
    String encodedPassword = bCryptPasswordEncoder.encode(password);
    return encodedPassword;
  };

  @Override
  public boolean match(String password, String encodedPassword) {
    return bCryptPasswordEncoder.matches(password, encodedPassword);
  }
}
