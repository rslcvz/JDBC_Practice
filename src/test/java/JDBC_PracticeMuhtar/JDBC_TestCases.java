package JDBC_PracticeMuhtar;


import org.junit.BeforeClass;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_TestCases {

    String url="jdbc:oracle:thin:@3.83.88.105:1521:xe";
    String username ="hr";
    String password ="hr";
    Connection connection = DriverManager.getConnection(url, username, password);
    Statement statement ;

    @BeforeClass
    public void setUp(){
        String url="jdbc:oracle:thin:@3.83.88.105:1521:xe";
        String username ="hr";
        String password ="hr";
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) { }
        Statement statement ;

    }

    public JDBC_TestCases() throws SQLException {
    }

    @Test(description = "Verify that Sayfos' salary is greater tham Messi's salary")
    public void test1(){



    }
}
