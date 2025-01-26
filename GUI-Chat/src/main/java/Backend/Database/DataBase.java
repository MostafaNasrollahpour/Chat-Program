package Backend.Database;


import java.sql.*;
import java.util.HashMap;
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

    public void signIn(String userName, String password){

        var result = checkExist(userName);
        var key = result.keySet().iterator().next();
        var detail = result.get(key);
        if (key){
            System.out.println(key);
        }else{
            System.out.println(detail);
        }
    }


    private HashMap<Boolean, String> checkExist(String userName){
        HashMap<Boolean, String> result = new HashMap<>();
        try {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT userName FROM users");

            while (resultSet.next()) {
                String name = resultSet.getString("userName");
                if(Objects.equals(name, userName)){
                    result.put(false, "User Name Already Exist");
                    return result;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            closeDataBase();
            result.put(false, "Unexpected");
            return result;
        }
        result.put(true, "OK");
        return result;
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