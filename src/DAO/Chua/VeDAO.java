package DAO.Chua;

import Conn.Conn;
import DAO.DAO;
import Model.Roi.ChuyenBay;
import Model.Roi.DiaChi;
import Model.Roi.ThongTinNguoiDung;
import Model.Chua.Ve;
import Model.Chua.HoaDon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VeDAO implements DAO {
    Connection conn = null;
    PreparedStatement ptmt = null;
    ResultSet resultSet = null;
    String tblName = "tblve";
    List<Ve> ves = new ArrayList<>();

    public VeDAO() {

    }

    private Connection getConnection() {
        Connection conn;
        conn = Conn.getInstance().getConnection();
        return conn;
    }

    @Override
    public List<Ve> gellAll() {
        try {
            String querryString = "SELECT * from " + tblName;
            conn = getConnection();
            ptmt = conn.prepareStatement(querryString);
            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                Ve v = new Ve(resultSet.getInt("id"), resultSet.getObject("tinh", DiaChi.class), resultSet.getObject("tinh", DiaChi.class), resultSet.getString("hoten"), resultSet.getTimestamp("thoigiankhoitao"), resultSet.getInt("sohieumaybay"), resultSet.getInt("hangve"), resultSet.getInt("masoghe"), resultSet.getObject("id", ThongTinNguoiDung.class), resultSet.getObject("id", ChuyenBay.class), resultSet.getObject("id", HoaDon.class));
                ves.add(v);
//                System.out.println(d.getId()+" | "+d.getXa()+" | "+d.getHuyen()+ " | "+d.getTinh()+" | "+d.getQuocgia());

            }
            return ves;

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
        return ves;
    }

    @Override
    public Optional get(int id) {
        return ves.stream().filter(u -> u.getId() == id).findFirst();
    }

    @Override
    public void create(Object o) {
        try {
            Ve v = (Ve) o;
            String stringQuerry = "INSERT INTO tblVe(diemdi,diemden,hoten,sohieumaybay,hangve,masoghe,tblthongtinnguoidungid,tblchuyenbayid,tblhoadonid,thoigian) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            conn = getConnection();

            ptmt = conn.prepareStatement(stringQuerry);
//            ptmt.setString(1, d.getId());
            ptmt.setString(1, v.getDiemDi().getTinh());
            ptmt.setString(2, v.getDiemDen().getTinh());
            ptmt.setString(3, v.getHoTen());
            ptmt.setInt(4, v.getSoHieuMayBay());
            ptmt.setInt(5, v.getSoHieuMayBay());
            ptmt.setInt(6, v.getMaSoGHe());
            ptmt.setInt(7, v.getThongTinNguoiDung().getId());
            ptmt.setInt(8, v.getChuyenBay().getId());
            ptmt.setString(9, v.getHoaDon().toString());
            ptmt.setTimestamp(10, v.getThoiGianKhoiTao());
            ptmt.executeUpdate();
            System.out.println("Ve Added Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Object read(int t) {
        try {
            String querryString = "SELECT * FROM tbldiachi WHERE id=?";
            conn = getConnection();
            ptmt = conn.prepareStatement(querryString);
            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                Ve v = new Ve(resultSet.getInt("id"), resultSet.getObject("tinh", DiaChi.class), resultSet.getObject("tinh", DiaChi.class), resultSet.getString("hoten"), resultSet.getTimestamp("thoigiankhoitao"), resultSet.getInt("sohieumaybay"), resultSet.getInt("hangve"), resultSet.getInt("masoghe"), resultSet.getObject("id", ThongTinNguoiDung.class), resultSet.getObject("id", ChuyenBay.class), resultSet.getObject("id", HoaDon.class));
                ves.add(v);
//                System.out.println(d.getId()+" | "+d.getXa()+" | "+d.getHuyen()+ " | "+d.getTinh()+" | "+d.getQuocgia());

            }
            return ves;

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
        return ves;
    }

    @Override
    public void update(Object o) {
        System.out.println("cho fe");
    }

    @Override
    public void delete(Object o) {
        try {
            Ve d = (Ve) o;
            String stringQuery = "DELETE FROM tblve WHERE id=?";
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
