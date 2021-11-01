package DAO.Hi;

import Conn.Conn;
import DAO.DAO;
import Model.Hi.TuyenDuongBay;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TuyenDuongBayDAO implements DAO {
    Connection conn = null;
    PreparedStatement ptmt = null;
    ResultSet resultSet = null;
    String tblName = "TuyenDuongBay";
    List<TuyenDuongBay> TuyenDuongBays = null;


    String getAllQuery = "SELECT * from " + tblName + " ORDER BY id";
    String createQuery = "INSERT INTO " + tblName + "(heso,ghichu) " + "VALUES(?,?)";
    String updateQuery = "UPDATE TuyenDuongBay SET heso= ?,ghichu=? WHERE id=?";
    String readQuery = "SELECT * from "+tblName+" WHERE id=?";
    String deleteQuery = "DELETE FROM "+tblName+" WHERE id=?";

    private Connection getConnection() {
        Connection conn;
        conn = Conn.getInstance().getConnection();
        return conn;
    }

    @Override
    public Optional get(int id) {
        return TuyenDuongBays.stream().filter(u -> u.getId() == id).findFirst();
    }

    @Override
    public List gellAll() {
        TuyenDuongBays = new ArrayList<>();
        try {
            conn = getConnection();
            ptmt = conn.prepareStatement(getAllQuery);
            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                TuyenDuongBay t = new TuyenDuongBay();
                t.resultMap(resultSet);
                TuyenDuongBays.add(t);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return TuyenDuongBays;
    }

    @Override
    public void create(Object o) {
        TuyenDuongBay t = (TuyenDuongBay) o;
        conn = getConnection();
        try {
            ptmt = conn.prepareStatement(createQuery, ptmt.RETURN_GENERATED_KEYS);
            t.ptmtCreate(ptmt).executeUpdate();
            new LogMessage(true, tblName);
        } catch (SQLException e) {
            new LogMessage(false, tblName);
        }
    }

    @Override
    public Object read(int t) {
        TuyenDuongBay TuyenDuongBay = new TuyenDuongBay();
        try {

            conn = getConnection();
            ptmt = conn.prepareStatement(readQuery);
            ptmt.setInt(1, t);
            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                TuyenDuongBay.resultMap(resultSet);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return TuyenDuongBay;
    }

    @Override
    public void update(Object o) {
        TuyenDuongBay t = (TuyenDuongBay) o;
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
        TuyenDuongBay t = (TuyenDuongBay) o;
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
