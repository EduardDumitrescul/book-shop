package org.example.data;
import java.sql.*;

public class MySqlCon {
    public static void main(String[] args){
        Connection conn = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://0.0.0.0:3306/test","root","root");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from test");
            while(rs.next())
                System.out.println(rs.getInt(1));
            con.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
