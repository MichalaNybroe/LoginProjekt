package loginprojekt.repositories;

import loginprojekt.domain.models.User;
import loginprojekt.repositories.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserService {

    //SKAL DEN OMNAVNGIVES TIL USERREPOSITORY???

    private User user;

    public void createUser(String userName, String password) {
        String insert = "INSERT INTO users(user_name, user_password) VALUES(?,?)";
        Connection connection = DBManager.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);
            preparedStatement.executeUpdate();

            this.user = new User(userName, password);
        } catch (SQLException err) {
            err.printStackTrace();
        }
    }

    //SKAL VI IKKE BARE SLETTE DEN?? - bruges ikke længere
    public User getUser() {
        return this.user;
    }

    public boolean isValidUser(String query, String username, String password) {
        //String query =
        Connection c = DBManager.getConnection();
        PreparedStatement preparedStatement;

        try {
            preparedStatement = c.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
        }
        return false;
    }
}

