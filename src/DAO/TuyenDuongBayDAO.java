package DAO;

import Model.DiaChi;
import Model.TuyenDuongBay;
import Connection.Conn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TuyenDuongBayDAO implements DAO{
    Connection conn=null;
    PreparedStatement ptmt = null;
    ResultSet resultSet = null;
    String tblName = "tbltuyenduongbay";
    List<TuyenDuongBay> tuyenDuongBays = new ArrayList<>();

    public TuyenDuongBayDAO() {

    }

    private Connection getConnection() {
        Connection conn;
        conn = Conn.getInstance().getConnection();
        return conn;
    }
    @Override
    public List<TuyenDuongBay> gellAll() {
        try {
            String querryString = "SELECT * from " + tblName;
            conn = getConnection();
            ptmt = conn.prepareStatement(querryString);
            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                TuyenDuongBay d = new TuyenDuongBay(resultSet.getInt("id"), resultSet.getObject("tinh",DiaChi.class), resultSet.getObject("tinh",DiaChi.class), resultSet.getFloat("thoigianbay"));
                tuyenDuongBays.add(d);
//                System.out.println(d.getId()+" | "+d.getXa()+" | "+d.getHuyen()+ " | "+d.getTinh()+" | "+d.getQuocgia());

            }
            return tuyenDuongBays;

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
        return tuyenDuongBays;
    }

    @Override
    public Optional get(int id) {
        return tuyenDuongBays.stream().filter(u -> u.getId() == id).findFirst();
    }

    @Override
    public void create(Object o) {
        try {
            TuyenDuongBay t = (TuyenDuongBay) o;
            String stringQuerry = "INSERT INTO tbltuyenduongbay(diemdi,diemden,thoigianbay,tbldiemdi,tbldiemden) VALUES (?,?,?,?,?)";
            conn = getConnection();

            ptmt = conn.prepareStatement(stringQuerry);
//            ptmt.setString(1, d.getId());
            ptmt.setString(1, t.getDiemdi().getTinh());
            ptmt.setString(2, t.getDiemden().getTinh());
            ptmt.setFloat(3, t.getThoigianbay());
            ptmt.setInt(4,t.getDiemdi().getId());
            ptmt.setInt(5,t.getDiemden().getId());
            ptmt.executeUpdate();
            System.out.println("TuyenDuongBay Added Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object read(int t) {
        try {
            String querryString = "SELECT * FROM tbltuyenduongbay WHERE id=?";
            conn = getConnection();
            ptmt = conn.prepareStatement(querryString);
            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                TuyenDuongBay d = new TuyenDuongBay(resultSet.getInt("id"), resultSet.getObject("tinh",DiaChi.class), resultSet.getObject("tinh",DiaChi.class), resultSet.getFloat("thoigianbay"));
                tuyenDuongBays.add(d);
//                System.out.println(d.getId()+" | "+d.getXa()+" | "+d.getHuyen()+ " | "+d.getTinh()+" | "+d.getQuocgia());

            }
            return tuyenDuongBays;

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
        return tuyenDuongBays;
    }

    @Override
    public void update(Object o) {
        System.out.println("cho fe");
    }

    @Override
    public void delete(Object o) {
        try {
            TuyenDuongBay d = (TuyenDuongBay) o;
            String stringQuery = "DELETE FROM tbltuyenduongbay WHERE id=?";
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
