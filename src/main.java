import Connection.Conn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class main {
    public static void main(String[] args) throws SQLException {
        // make a connection for all.
        Conn app = new Conn();
        Connection conn = app.connect();

        // example
        PreparedStatement pstmt = null;
        pstmt = conn.prepareStatement("select * from tblDiaChi;");
        ResultSet ret = null;
        ret = pstmt.executeQuery();
        while (ret.next()) {
            System.out.println(ret.getString("huyen"));
        }
        ret.close();
    }
}
