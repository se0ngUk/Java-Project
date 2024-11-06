package connectDatabase;
import java.util.*;
import java.sql.*;
import AdminMenu.*;

public class MainConnect {
    public static void main(String [] args){
        String url = "jdbc:mysql://localhost:3306/practice";
        String user = "root";
        String password = "root";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            System.out.println("MySQL Successfully Connected!"); // 데이터베이스 연결
            //MainMenu.startMenu(conn);
            menu.login(conn);
        }
        catch(Exception e){
            System.out.println("error " + e);
        }
    }
}
