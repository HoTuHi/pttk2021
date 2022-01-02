package DAO;

import Conn.Conn;
import Model.LoaiVe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LoaiVeDAO implements DAO {
    Connection conn = null;
    PreparedStatement ptmt = null;
    ResultSet resultSet = null;
    String tblName = "LoaiVe";
    List<LoaiVe> LoaiVes = null;

    String getAllQuery = "SELECT * from " + tblName + " ORDER BY id";
    String createQuery = "INSERT INTO " + tblName + "(loai,ghichu) " + "VALUES(?,?)";
    String updateQuery = "UPDATE LoaiVe SET loai=?,ghichu=? WHERE id=?";

    // Default
    String readQuery = "SELECT * from "+tblName+" WHERE id=?";
    String deleteQuery = "DELETE FROM "+tblName+" WHERE id=?";


    private Connection getConnection() {
        Connection conn;
        conn = Conn.getInstance().getConnection();
        return conn;
    }

    @Override
    public Optional get(int id) {
        return LoaiVes.stream().filter(u -> u.getId() == id).findFirst();
    }

    @Override
    public List gellAll() {
        LoaiVes = new ArrayList<>();
        try {
            conn = getConnection();
            ptmt = conn.prepareStatement(getAllQuery);
            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                LoaiVe t = new LoaiVe();
                t.resultMap(resultSet);
                LoaiVes.add(t);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return LoaiVes;
    }

    @Override
    public void create(Object o) {
        LoaiVe t = (LoaiVe) o;
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
        LoaiVe LoaiVe = new LoaiVe();
        try {

            conn = getConnection();
            ptmt = conn.prepareStatement(readQuery);
            ptmt.setInt(1, t);
            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                LoaiVe.resultMap(resultSet);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return LoaiVe;
    }

    @Override
    public void update(Object o) {
        LoaiVe t = (LoaiVe) o;
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
        LoaiVe t = (LoaiVe) o;
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
