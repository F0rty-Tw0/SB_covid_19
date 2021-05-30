package com.example.covid_19.Repository.PasswordRepo;

public interface PasswordInterface {
  public String encrypt(String password);

  public boolean match(String password, String encodedPassword);
}
