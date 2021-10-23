package Connection;

import java.sql.*;

public class Conn {

    private final String url = "jdbc:postgresql://localhost/pttkQlmb";
    private final String user = "postgres";
    private final String password = "Daucham@";

    /**
     * Connect to the PostgreSQL database
     *
     * @return a Connection object
     */
    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }

}
