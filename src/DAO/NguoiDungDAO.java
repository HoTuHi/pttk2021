package DAO;

import Conn.Conn;
import Model.NguoiDung;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class NguoiDungDAO implements DAO {
    Connection conn = null;
    PreparedStatement ptmt = null;
    ResultSet resultSet = null;
    String tblName = "NguoiDung";
    List<NguoiDung> NguoiDungs = null;


    String createQuery = "INSERT INTO " + tblName + "(tennguoidung,password,tinhtrang,thongtinnguoidungid,quyenid) " + "VALUES(?,?,?,?,?)";
    String updateQuery = "UPDATE NguoiDung SET tennguoidung=?,password=?,tinhtrang=?,thongtinnguoidungid=?,quyenid=? WHERE id=?";

    // Default
    String getAllQuery = "SELECT * from " + tblName + " ORDER BY id";
    String readQuery = "SELECT * from "+tblName+" WHERE id=?";
    String deleteQuery = "DELETE FROM "+tblName+" WHERE id=?";


    private Connection getConnection() {
        Connection conn;
        conn = Conn.getInstance().getConnection();
        return conn;
    }

    @Override
    public Optional get(int id) {
        return NguoiDungs.stream().filter(u -> u.getId() == id).findFirst();
    }

    @Override
    public List gellAll() {
        NguoiDungs = new ArrayList<>();
        try {
            conn = getConnection();
            ptmt = conn.prepareStatement(getAllQuery);
            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                NguoiDung t = new NguoiDung();
                t.resultMap(resultSet);
                NguoiDungs.add(t);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return NguoiDungs;
    }

    @Override
    public void create(Object o) {
        NguoiDung t = (NguoiDung) o;
        conn = getConnection();
        try {
            ptmt = conn.prepareStatement(createQuery, ptmt.RETURN_GENERATED_KEYS);
            t.ptmtCreate(ptmt).executeUpdate();
            System.out.println("sc");
        } catch (SQLException e) {
            System.out.println("f");
        }
    }

    @Override
    public Object read(int t) {
        NguoiDung NguoiDung = new NguoiDung();
        try {

            conn = getConnection();
            ptmt = conn.prepareStatement(readQuery);
            ptmt.setInt(1, t);
            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                NguoiDung.resultMap(resultSet);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return NguoiDung;
    }

    @Override
    public void update(Object o) {
        NguoiDung t = (NguoiDung) o;
        conn = getConnection();
        try {
            ptmt = conn.prepareStatement(updateQuery);
            ptmt = t.ptmtUpdate(ptmt);
            ptmt.executeUpdate();
            System.out.println("success");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("F in update");
        }
    }

    @Override
    public void delete(Object o) {
        NguoiDung t = (NguoiDung) o;
        try {
            conn = getConnection();
            ptmt = conn.prepareStatement(deleteQuery);
            ptmt.setInt(1, t.getId());
            ptmt.executeUpdate();
            System.out.println("success!");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
