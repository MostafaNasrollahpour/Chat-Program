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
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "userName TEXT NOT NULL, " +
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

    public void closeDataBase(){
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}