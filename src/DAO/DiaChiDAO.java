package DAO;

import Connection.Conn;
import Model.DiaChi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DiaChiDAO implements DAO {
    Connection conn = null;
    PreparedStatement ptmt = null;
    ResultSet resultSet = null;
    String tblName = "tbldiachi";
    List<DiaChi> diaChis = new ArrayList<>();

    public DiaChiDAO() {

    }

    private Connection getConnection() {
        Connection conn;
        conn = Conn.getInstance().getConnection();
        return conn;
    }

    @Override
    public List<DiaChi> gellAll() {

        try {
            String querryString = "SELECT * from " + tblName;
            conn = getConnection();
            ptmt = conn.prepareStatement(querryString);
            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                DiaChi d = new DiaChi(resultSet.getInt("id"), resultSet.getString("xa"), resultSet.getString("huyen"), resultSet.getString("tinh"), resultSet.getString("quocgia"));
                diaChis.add(d);
//                System.out.println(d.getId()+" | "+d.getXa()+" | "+d.getHuyen()+ " | "+d.getTinh()+" | "+d.getQuocgia());

            }
            return diaChis;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if (resultSet != null)
                    resultSet.close();
                if (ptmt != null)
                    ptmt.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return diaChis;
    }

    @Override
    public Optional get(int id) {
        return diaChis.stream().filter(u -> u.getId() == id).findFirst();
    }

    @Override
    public void create(Object o) {
        try {
            DiaChi d = (DiaChi) o;
            String stringQuerry = "INSERT INTO tbldiachi(xa,huyen,tinh,quocgia) VALUES (?,?,?,?)";
            conn = getConnection();

            ptmt = conn.prepareStatement(stringQuerry);
//            ptmt.setString(1, d.getId());
            ptmt.setString(1, d.getXa());
            ptmt.setString(2, d.getHuyen());
            ptmt.setString(3, d.getTinh());
            ptmt.setString(4, d.getHuyen());
            ptmt.executeUpdate();
            System.out.println("DiaChi Added Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Object read(int o) {
        try {
            DiaChi d = null;
            String stringQuery = "SELECT * FROM tbldiachi WHERE id=?";
            conn = getConnection();
            ptmt = conn.prepareStatement(stringQuery);
            ptmt.setInt(1, 2);
            resultSet = ptmt.executeQuery();
            while (resultSet.next()){
                d = new DiaChi(resultSet.getInt("id"), resultSet.getString("xa"), resultSet.getString("huyen"), resultSet.getString("tinh"), resultSet.getString("quocgia"));
            }
             return d;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if (resultSet != null)
                    resultSet.close();
                if (ptmt != null)
                    ptmt.close();
                if (conn != null)
                    conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return null;

    }

    @Override
    public void update(Object o) {
//        DiaChi d = (DiaChi) o;
//        String stringQuery = "UPDATE tbldiachi SET xa=?,huyen=?,tinh=?,quocgia=? WHERE id=?";
//        conn = getConnection();
//        try {
//            ptmt = conn.prepareStatement(stringQuery);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        ptmt.setString(1, d.getXa());
//        ptmt.setString(2, d.getHuyen());
//        ptmt.setString(3, d.getTinh());
//        ptmt.setString(4, d.getQuocgia());
//        ptmt.setInt(5, d.getId());
//        ptmt.executeUpdate();
//        System.out.println("Successfully");
    }

    @Override
    public void delete(Object o) {
        try {
            DiaChi d = (DiaChi) o;
            String stringQuery = "DELETE FROM tbldiachi WHERE id=?";
            conn = getConnection();
            ptmt = conn.prepareStatement(stringQuery);
            ptmt.setInt(1, d.getId());
            ptmt.executeUpdate();
            System.out.println("Successfully");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
