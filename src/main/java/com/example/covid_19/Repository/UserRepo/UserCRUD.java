package com.example.covid_19.Repository.UserRepo;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import com.example.covid_19.Model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserCRUD implements UserInterface {

  @Autowired
  JdbcTemplate jdbc;
  private final String table = "users";
  // CREATE

  @Override
  public int addUser(User user) {
    User queryUser = findUserByEmail(user.getUserEmail());
    User CprUser = findUserByCpr(user.getUserCpr());
    if (queryUser == CprUser) if (queryUser.getUserEmail().equals(user.getUserEmail())) {
      throw new RuntimeException(user.getUserEmail() + " already exists in the database");
    } else if (CprUser.getUserCpr() == user.getUserCpr()) {
      throw new RuntimeException(user.getUserCpr() + " already exists in the database");
    } else {
      String sql = "INSERT INTO " + table + " VALUES(?,?,?,?,?,?,?,?,?)";
      return jdbc.update(sql, null, user.getUserName(), user.getUserPassword(), user.getUserEmail(), user.getUserCpr(),
              user.getUserPhone(), user.getUserAddress(), 1, 1);

    }
    return 1;
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
  public User findUserByCpr(int userCpr) {
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
  public List<User> findUserByRole(int userRoleId) {
    String sql = "SELECT * FROM " + table + " WHERE userRoleId = ?";
    RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
    return jdbc.query(sql, rowMapper, userRoleId);
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
        + " SET userName = ?, userEmail = ?, userCpr = ?, userPhone = ?, userAddress = ? WHERE userId = ?";
    return jdbc.update(sql, user.getUserName(), user.getUserEmail(), user.getUserCpr(), user.getUserPhone(),
        user.getUserAddress(), user.getUserId());
  };

  @Override
  public int updateUserStatus(User user) {
    String sql = "UPDATE " + table + " SET userStatusId = ? WHERE userId = ?";
    return jdbc.update(sql, user.getUserStatusId(), user.getUserId());
  };

  @Override
  public int updateUserRole(User user) {
    String sql = "UPDATE " + table + " SET userRoleId = ? WHERE userId = ?";
    return jdbc.update(sql, user.getUserRoleId(), user.getUserId());
  };

  // DELETE
  @Override
  public int deleteUser(int userId) {
    String sql = "DELETE FROM " + table + " WHERE userId = ?";
    return jdbc.update(sql, userId);
  };
}
