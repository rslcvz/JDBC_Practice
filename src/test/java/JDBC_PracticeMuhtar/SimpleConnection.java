package JDBC_PracticeMuhtar;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SimpleConnection {
    public static void main(String[] args) throws SQLException {
        String url="jdbc:oracle:thin:@3.83.88.105:1521:xe";
        String username ="hr";
        String password ="hr";

        Connection connection = DriverManager.getConnection(url, username, password);
        System.out.println("Connected");

        Statement  statement = connection.createStatement();

        ResultSet result = statement.executeQuery("select * from countries");

        while(result.next()){
            String countryName = result.getString("country_name");
            int region_id = result.getInt("region_id");
            if(countryName.equals("Germany")){
                System.out.println("countryName = " + countryName + "region_id" + region_id);
            }
//            System.out.println(countryName);
        }

//        System.out.println("result = " + result);


    }
}
