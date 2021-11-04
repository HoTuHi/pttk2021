package DAO.Chua;

import Conn.Conn;
import DAO.DAO;
import Model.Roi.DiaChi;
import Model.Roi.ThongTinNguoiDung;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ThongTinNguoiDungDAO implements DAO {
    Connection conn = null;
    PreparedStatement ptmt = null;
    ResultSet resultSet = null;
    String tblName = "tblthongtinnguoidung";
    List<ThongTinNguoiDung> thongTinNguoiDungs = new ArrayList<>();

    public ThongTinNguoiDungDAO() {
    }

    private Connection getConnection() {
        Connection conn;
        conn = Conn.getInstance().getConnection();
        return conn;
    }

    @Override
    public Optional get(int id) {
        return thongTinNguoiDungs.stream().filter(u -> u.getId() == id).findFirst();
    }

    @Override
    public List<ThongTinNguoiDung> gellAll() {
        try {
            String querryString = "SELECT * from " + tblName;
            conn = getConnection();
            ptmt = conn.prepareStatement(querryString);
            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                ThongTinNguoiDung t = new ThongTinNguoiDung();
                t.setId(resultSet.getInt("id"));
                t.setHo(resultSet.getString("ho"));
                t.setTen_dem(resultSet.getString("tendem"));
                t.setTen(resultSet.getString("ho"));
                t.setNgaysinh(resultSet.getTimestamp("ngaysinh"));
                t.setEmail(resultSet.getString("email"));
                t.setSdt(resultSet.getString("sdt"));
                t.setKhoitao(resultSet.getTimestamp("khoitao"));
                t.setDiaChi(new DiaChi(resultSet.getInt("tbldiachiid"), "", "", "", ""));
                thongTinNguoiDungs.add(t);
//                System.out.println(d.getId()+" | "+d.getXa()+" | "+d.getHuyen()+ " | "+d.getTinh()+" | "+d.getQuocgia());

            }

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
        return thongTinNguoiDungs;
    }

    @Override
    public void create(Object o) {
        try {
            ThongTinNguoiDung t = (ThongTinNguoiDung) o;
            String stringQuery = "INSERT INTO tblthongtinnguoidung" +
                    "(ho,ten_dem,ten,ngaysinh,email,sdt,khoitao,tbldiachiid)" +
                    "VALUES(?,?,?,?,?,?,?,?)";
            conn = getConnection();
            ptmt = conn.prepareStatement(stringQuery);
            ptmt.setString(1, t.getHo());
            ptmt.setString(2, t.getTen_dem());
            ptmt.setString(3, t.getTen());
            ptmt.setTimestamp(4, t.getNgaysinh());
            ptmt.setString(5, t.getEmail());
            ptmt.setString(6, t.getSdt());
            ptmt.setTimestamp(7, t.getKhoitao());
            ptmt.setInt(8, t.getDiaChi().getId());
            ptmt.executeUpdate();
            System.out.println("TTND added Successfully !!!");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Object read(int o) {
        ThongTinNguoiDung t = new ThongTinNguoiDung();
        String stringQuery = "SELECT * FROM tblthongtinnguoidung WHERE id=?";
        conn = getConnection();
        try {
            ptmt = conn.prepareStatement(stringQuery);
            ptmt.setInt(1, o);
            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                t.setId(resultSet.getInt("id"));
                t.setHo(resultSet.getString("ho"));
                t.setTen_dem(resultSet.getString("tendem"));
                t.setTen(resultSet.getString("ho"));
                t.setNgaysinh(resultSet.getTimestamp("ngaysinh"));
                t.setEmail(resultSet.getString("email"));
                t.setSdt(resultSet.getString("sdt"));
                t.setKhoitao(resultSet.getTimestamp("khoitao"));
                t.setDiaChi(new DiaChi(resultSet.getInt("tbldiachiid"), "", "", "", ""));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return t;
    }

    @Override
    public void update(Object o) {
        ThongTinNguoiDung t = new ThongTinNguoiDung();
        String stringQuery = "UPDATE tblthongtinnguoidung SET ho=?,tendem=?,ten=?,ngaysinh=?,email=?,sodienthoai=?,tbldiachiid=? WHERE id =?";
        conn = getConnection();
        try {
            ptmt = conn.prepareStatement(stringQuery);
            ptmt.setString(1, t.getHo());
            ptmt.setString(2, t.getTen_dem());
            ptmt.setString(3, t.getTen());
            ptmt.setTimestamp(4, t.getNgaysinh());
            ptmt.setString(5, t.getEmail());
            ptmt.setString(6, t.getSdt());
            ptmt.setInt(7, t.getDiaChi().getId());
            ptmt.setInt(8, t.getId());
            ptmt.executeUpdate();
            System.out.println("Successfully");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void delete(Object o) {
        ThongTinNguoiDung t = new ThongTinNguoiDung();
        String stringQuery = "DELETE tblthongtinnguoidung WHERE id =?";
        conn = getConnection();
        try {
            ptmt = conn.prepareStatement(stringQuery);
            ptmt.setInt(1, t.getId());
            ptmt.executeUpdate();
            System.out.println("Successfully");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
