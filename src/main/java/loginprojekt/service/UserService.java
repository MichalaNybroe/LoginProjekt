package loginprojekt.service;

import loginprojekt.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserService {

  private User user;

  public void createUser(String userName, String password){
    this.user = new User(userName, password);
  }

  public User getUser(){
    return this.user;
  }

  public boolean checkUser(String query){
    Connection c = DBManager.getConnection();
    PreparedStatement preparedStatement;

    try {
      preparedStatement = c.prepareStatement(query);
      ResultSet resultSet = preparedStatement.executeQuery();

      //HVAD SKAL VI BRUGE RESULTSET TIL????

      return true;

    }catch (SQLException e){
      System.out.println(e.getErrorCode());
    }

    return false;
  }
}

