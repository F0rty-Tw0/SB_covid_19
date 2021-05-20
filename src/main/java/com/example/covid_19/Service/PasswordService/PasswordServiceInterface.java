package com.example.covid_19.Service.PasswordService;

public interface PasswordServiceInterface {
  public String encrypt(String password);

  public boolean match(String password, String encodedPassword);
}
