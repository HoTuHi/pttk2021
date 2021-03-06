package DAO;

import Model.HeSoGio;
import Conn.Conn;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
public class HeSoGioDAO implements DAO {

    Connection conn = null;
    PreparedStatement ptmt = null;
    ResultSet resultSet = null;
    String tblName = "hesogio";
    List<HeSoGio> heSoGios = null;


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
        return heSoGios.stream().filter(u -> u.getId() == id).findFirst();
    }

    @Override
    public List gellAll() {
        heSoGios = new ArrayList<>();
        try {
            conn = getConnection();
            ptmt = conn.prepareStatement(getAllQuery);
            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                HeSoGio t = new HeSoGio();
                t.resultMap(resultSet);
                heSoGios.add(t);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return heSoGios;
    }

    @Override
    public void create(Object o) {
        HeSoGio t = (HeSoGio) o;
        conn = getConnection();
        try {
            ptmt = conn.prepareStatement(createQuery, ptmt.RETURN_GENERATED_KEYS);
            t.ptmtCreate(ptmt).executeUpdate();
            new LogMessage(true, tblName);
        } catch (SQLException e) {

        }
    }

    @Override
    public Object read(int t) {
        HeSoGio heSoNgay = new HeSoGio();
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
        HeSoGio t = (HeSoGio) o;
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
        HeSoGio t = (HeSoGio) o;
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
