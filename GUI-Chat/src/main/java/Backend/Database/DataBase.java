package Backend.Database;


import java.sql.*;
import java.util.Objects;


public class DataBase {
    Connection connection = null;

    public DataBase(){

        try {
            Class.forName("org.sqlite.JDBC");

            connection = DriverManager.getConnection("jdbc:sqlite:sample.db");

            Statement statement = connection.createStatement();

            String sql = "CREATE TABLE IF NOT EXISTS users (" +
                    "userName TEXT PRIMARY KEY, " +
                    "password TEXT NOT NULL)";

            statement.executeUpdate(sql);

            System.out.println("Table created successfully");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            closeDataBase();
        }
    }

    public String signIn(String userName, String password){

        var result = checkExist(userName);

        if(!result.equals("OK")){
            return result;
        }

        result = insertUser(userName, password);
        return result;
    }


    private String checkExist(String userName){
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT userName FROM users");
            while (resultSet.next()) {
                String name = resultSet.getString("userName");
                if(Objects.equals(name, userName)) {
                    return "User Name Already Exist";
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            closeDataBase();
            return "Unexpected";
        }
        return "OK";
    }

    private String insertUser(String userName, String password){

        try {
            String sql = "INSERT INTO users (userName, password) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);
            preparedStatement.executeUpdate();

            return "OK";
        } catch (SQLException e) {
            e.printStackTrace();
            closeDataBase();
            return "Unexpected";
        }
    }

    public void closeDataBase(){
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // this is for debugging
    public void showTable(){
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("userName");
                String pass = resultSet.getString("password");
                System.out.println(id + " " + name + " " + pass);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            closeDataBase();

        }

    }

}