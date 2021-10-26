package DAO;

import Model.DiaChi;
import Model.Quyen;
import Connection.Conn;
import Model.TuyenDuongBay;
import Model.Ve;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class QuyenDAO implements DAO{

    Connection conn=null;
    PreparedStatement ptmt = null;
    ResultSet resultSet = null;
    String tblName = "tblquyen";
    List<Quyen> quyens = new ArrayList<>();

    public QuyenDAO() {

    }

    private Connection getConnection() {
        Connection conn;
        conn = Conn.getInstance().getConnection();
        return conn;
    }
    @Override
    public List<Quyen> gellAll() {
        try {
        String querryString = "SELECT * from " + tblName;
        conn = getConnection();
        ptmt = conn.prepareStatement(querryString);
        resultSet = ptmt.executeQuery();
        while (resultSet.next()) {
            Quyen q = new Quyen(resultSet.getInt("id"), resultSet.getInt("quyen"));
            quyens.add(q);
//                System.out.println(d.getId()+" | "+d.getXa()+" | "+d.getHuyen()+ " | "+d.getTinh()+" | "+d.getQuocgia());

        }
        return quyens;

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
        return quyens;
    }

    @Override
    public Optional get(int id) {
        return quyens.stream().filter(u->u.getId()==id).findFirst();
    }

    @Override
    public void create(Object o) {
        try {
            Quyen q = (Quyen) o;
            String stringQuerry = "INSERT INTO tblquyen(quyen) VALUES (?)";
            conn = getConnection();
            ptmt = conn.prepareStatement(stringQuerry);
//            ptmt.setString(1, d.getId());
            ptmt.setInt(1, q.getQuyen());
            ptmt.executeUpdate();
            System.out.println("TuyenDuongBay Added Successfully");
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    @Override
    public Object read(int t) {
        try {
            String querryString = "SELECT * from tblquyen WHERE id=?";
            conn = getConnection();
            ptmt = conn.prepareStatement(querryString);
            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                Quyen q = new Quyen(resultSet.getInt("id"), resultSet.getInt("quyen"));
                quyens.add(q);
//                System.out.println(d.getId()+" | "+d.getXa()+" | "+d.getHuyen()+ " | "+d.getTinh()+" | "+d.getQuocgia());

            }
            return quyens;

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
        return quyens;
    }

    @Override
    public void update(Object o) {
        System.out.println("cho Fe");
    }

    @Override
    public void delete(Object o) {
        try {
            Quyen d = (Quyen) o;
            String stringQuery = "DELETE FROM tblquyen WHERE id=?";
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
