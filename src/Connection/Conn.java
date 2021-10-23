package Connection;

import java.sql.*;

public class Conn {

    private final String url = "jdbc:postgresql://localhost/pttkQlmb";
    private final String user = "postgres";
    private final String password = "Daucham@";

    private static Conn conn = null;

    public Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }
    public static Conn getInstance(){
        if(conn == null){
            conn = new Conn();
        }
        return conn;
    }
}
