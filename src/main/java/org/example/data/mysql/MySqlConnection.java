package org.example.data.mysql;
import java.sql.*;

public class MySqlConnection {
    public static void main(String[] args){
        getConnection();
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection con=DriverManager.getConnection(
//                    "jdbc:mysql://0.0.0.0:3306/test","root","root");
//            Statement stmt=con.createStatement();
//            ResultSet rs=stmt.executeQuery("select * from test");
//            while(rs.next())
//                System.out.println(rs.getInt(1));
    }

    private static Connection connection = null;

    public static Connection getConnection() {
        if(connection == null) {
            try {
                connection = DriverManager.getConnection("jdbc:mysql://0.0.0.0:3306/bookshop","root","root");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
        return connection;
    }
}
