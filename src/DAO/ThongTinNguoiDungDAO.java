package DAO;

import Connection.Conn;
import Model.DiaChi;
import Model.ThongTinNguoiDung;

import javax.sound.midi.Soundbank;
import java.sql.*;
import java.util.List;
import java.util.Optional;

public class ThongTinNguoiDungDAO implements DAO {
    Connection conn = null;
    PreparedStatement ptmt = null;
    ResultSet resultSet = null;
    String tblName = "tblthongtinnguoidung";

    public ThongTinNguoiDungDAO() {
    }

    private Connection getConnection() {
        Connection conn;
        conn = Conn.getInstance().getConnection();
        return conn;
    }

    // Khong can
    @Override
    public Optional get(int id) {
        return Optional.empty();
    }

    // Khong can
    @Override
    public List gellAll() {
        return null;
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
            ptmt.setDate(4, (Date) t.getNgaysinh());
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
            ptmt.setInt(1,o);
            resultSet = ptmt.executeQuery();
            while (resultSet.next()){
                t.setId(resultSet.getInt("id"));
                t.setHo(resultSet.getString("ho"));
                t.setTen_dem(resultSet.getString("ho"));
                t.setTen(resultSet.getString("ho"));
                t.setNgaysinh(resultSet.getDate("ngaysinh"));
                t.setEmail(resultSet.getString("email"));
                t.setSdt(resultSet.getString("sdt"));
                t.setKhoitao(resultSet.getTimestamp("khoitao"));
                t.setDiaChi(new DiaChi(resultSet.getInt("tbldiachiid"),"","","",""));
            }
            return  t;
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void update(Object o) {

    }

    @Override
    public void delete(Object o) {

    }
}
