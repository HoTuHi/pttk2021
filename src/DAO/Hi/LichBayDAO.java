package DAO.Hi;

import Conn.Conn;
import DAO.DAO;
import Model.Hi.LichBay;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LichBayDAO implements DAO {
    Connection conn = null;
    PreparedStatement ptmt = null;
    ResultSet resultSet = null;
    String tblName = "lichbay";
    List<LichBay> lichBays = null;

    String getAllQuery = "SELECT * from " + tblName + " ORDER BY id";
    String createQuery = "INSERT INTO " + tblName + "(tuyenduongbayid,thoigiankhoihanh,hesogio,hesongay,khoitao) " + "VALUES(?,?,?,?,?)";
    String updateQuery = "UPDATE " + tblName + "SET tuyenduongbayid=?,thoigiankhoihanh=?, hesogio=?, hesongay=?,khoitao=? WHERE id=?";
    String readQuery = "SELECT * from "+tblName+" WHERE id=?";
    String deleteQuery = "DELETE FROM "+tblName+" WHERE id=?";

    private Connection getConnection() {
        Connection conn;
        conn = Conn.getInstance().getConnection();
        return conn;
    }

    @Override
    public Optional get(int id) {
        return lichBays.stream().filter(u -> u.getId() == id).findFirst();
    }

    @Override
    public List gellAll() {
        lichBays = new ArrayList<>();
        try {
            conn = getConnection();
            ptmt = conn.prepareStatement(getAllQuery);
            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                LichBay t = new LichBay();
                t.resultMap(resultSet);
                lichBays.add(t);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return lichBays;
    }

    @Override
    public void create(Object o) {
        LichBay t = (LichBay) o;
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
        LichBay lichBay = new LichBay();
        try {

            conn = getConnection();
            ptmt = conn.prepareStatement(readQuery);
            ptmt.setInt(1, t);
            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                lichBay.resultMap(resultSet);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return lichBay;
    }

    @Override
    public void update(Object o) {
        LichBay t = (LichBay) o;
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
        LichBay t = (LichBay) o;
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
