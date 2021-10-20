package DAO;

import java.sql.*;

public class testConn {
    public static void main(String[] args) {
        String host ="localhost";
        String port ="5432";
        String dbName = "pttkQlmb";
        String user="postgres";
        String pass="Daucham@";
        String dburl = "jdbc:postgres://"+host+":"+port+"/"+dbName+"?loggerLevel=OFF";
        Connection conn = null;
        Statement stmt = null;
        PreparedStatement pstmt = null;
        ResultSet ret = null;
        try{
            conn = DriverManager.getConnection(dburl,user,pass);
            pstmt =conn.prepareStatement("select * from tblDiaChi;");
            stmt= conn.createStatement();
            ret = pstmt.executeQuery();
            while (ret.next()){
                System.out.println(ret.getString("xa"));
            }
            ret.close();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
