package DAO.Hi;

import Conn.Conn;
import DAO.DAO;
import Model.Hi.HeSoNgay;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class HeSoNgayDAO implements DAO {
    Connection conn = null;
    PreparedStatement ptmt = null;
    ResultSet resultSet = null;
    String tblName = "hesongay";
    List<HeSoNgay> heSoNgays = null;


    String getAllQuery = "SELECT * from " + tblName + " ORDER BY id";
    String createQuery = "INSERT INTO " + tblName + "(heso,ghichu) " + "VALUES(?,?)";
    String updateQuery = "UPDATE hesongay SET heso= ?,ghichu=? WHERE id=?";
    String readQuery = "SELECT * from "+tblName+" WHERE id=?";
    String deleteQuery = "DELETE FROM "+tblName+" WHERE id=?";

    private Connection getConnection() {
        Connection conn;
        conn = Conn.getInstance().getConnection();
        return conn;
    }

    @Override
    public Optional get(int id) {
        return heSoNgays.stream().filter(u -> u.getId() == id).findFirst();
    }

    @Override
    public List gellAll() {
        heSoNgays = new ArrayList<>();
        try {
            conn = getConnection();
            ptmt = conn.prepareStatement(getAllQuery);
            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                HeSoNgay t = new HeSoNgay();
                t.resultMap(resultSet);
                heSoNgays.add(t);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return heSoNgays;
    }

    @Override
    public void create(Object o) {
        HeSoNgay t = (HeSoNgay) o;
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
        HeSoNgay heSoNgay = new HeSoNgay();
        try {

            conn = getConnection();
            ptmt = conn.prepareStatement(readQuery);
            ptmt.setInt(1, t);
            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                heSoNgay.resultMap(resultSet);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return heSoNgay;
    }

    @Override
    public void update(Object o) {
        HeSoNgay t = (HeSoNgay) o;
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
        HeSoNgay t = (HeSoNgay) o;
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
