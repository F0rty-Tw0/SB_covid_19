package com.example.covid_19.Repository.UserRepo;

import java.util.List;

import com.example.covid_19.Model.User;
import com.example.covid_19.Service.PasswordService.PasswordServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserCRUD implements UserInterface {

  @Autowired
  JdbcTemplate jdbc;

  @Autowired
  private PasswordServiceInterface password;
  private final String table = "users";
  // CREATE

  @Override
  public int addUser(User user) {
    String sql = "INSERT INTO " + table + " VALUES(?,?,?,?,?,?,?,?,?)";
    String encryptedPassword = password.encrypt(user.getUserPassword());

    try {
      return jdbc.update(sql, null, user.getUserName(), encryptedPassword, user.getUserEmail(), user.getUserCpr(),
          user.getUserPhone(), user.getUserAddress(), "Unknown", "User");
    } catch (RuntimeException e) {
      if (e.getMessage().contains("userCpr_UNIQUE"))
        throw new RuntimeException(user.getUserCpr() + " CPR already exists!");
      else if (e.getMessage().contains("userEmail_UNIQUE"))
        throw new RuntimeException(user.getUserEmail() + " already exists!");
      else
        throw new RuntimeException(e.getMessage());
    }
  };

  // READ
  @Override
  public User findUserById(int userId) {
    String sql = "SELECT * FROM " + table + " WHERE userId = ?";
    RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
    User myUser = jdbc.queryForObject(sql, rowMapper, userId);
    return myUser;
  };

  @Override
  public User findUserByCpr(long userCpr) {
    String sql = "SELECT * FROM " + table + " WHERE userCpr = ?";
    RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
    User myUser = jdbc.queryForObject(sql, rowMapper, userCpr);
    return myUser;
  };

  @Override
  public User findUserByEmail(String userEmail) {
    String sql = "SELECT * FROM " + table + " WHERE userEmail = ?";
    RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
    User myUser = jdbc.queryForObject(sql, rowMapper, userEmail);
    return myUser;
  };

  @Override
  public List<User> viewAllUsers() {
    String sql = "SELECT * FROM " + table;
    RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
    return jdbc.query(sql, rowMapper);
  };

  // UPDATE
  @Override
  public int updateUser(User user) {
    String sql = "UPDATE " + table
        + " SET userName = ?, userEmail = ?, userCpr = ?, userPhone = ?, userAddress = ?, userRole = ? WHERE userId = ?";
    try {
      return jdbc.update(sql, user.getUserName(), user.getUserEmail(), user.getUserCpr(), user.getUserPhone(),
          user.getUserAddress(), user.getUserRole(), user.getUserId());
    } catch (RuntimeException e) {
      if (e.getMessage().contains("userCpr_UNIQUE"))
        throw new RuntimeException(user.getUserCpr() + " CPR already exists!");
      else if (e.getMessage().contains("userEmail_UNIQUE"))
        throw new RuntimeException(user.getUserEmail() + " already exists!");
      else
        throw new RuntimeException(e.getMessage());
    }
  };

  @Override
  public int updateUserStatus(String userStatus, int userId) {
    String sql = "UPDATE " + table + " SET userStatus = ? WHERE userId = ?";
    return jdbc.update(sql, userStatus, userId);
  };

  // DELETE
  @Override
  public int deleteUser(int userId) {
    String sql = "DELETE FROM " + table + " WHERE userId = ?";
    return jdbc.update(sql, userId);
  };
}
