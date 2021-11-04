package DAO.Roi;

import DAO.DAO;
import Model.Roi.DiaChi;
import Conn.Conn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DiaChiDAO implements DAO {
    Connection conn = null;
    PreparedStatement ptmt = null;
    ResultSet resultSet = null;
    String tblName = "diachi";
    List<DiaChi> diaChis = null;

    String getAllQuery = "SELECT * from " + tblName + " ORDER BY id";
    String createQuery = "INSERT INTO " + tblName + "(xa,huyen,tinh,quocgia) " + "VALUES(?,?,?,?)";
    String updateQuery = "UPDATE diachi SET xa=?,huyen=?, tinh=?, quocgia=? WHERE id=?";
    String readQuery = "SELECT * from "+tblName+" WHERE id=?";
    String deleteQuery = "DELETE FROM "+tblName+" WHERE id=?";


    private Connection getConnection() {
        Connection conn;
        conn = Conn.getInstance().getConnection();
        return conn;
    }

    @Override
    public Optional get(int id) {
        return diaChis.stream().filter(u -> u.getId() == id).findFirst();
    }

    @Override
    public List gellAll() {
        diaChis = new ArrayList<>();
        try {
            conn = getConnection();
            ptmt = conn.prepareStatement(getAllQuery);
            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                DiaChi t = new DiaChi();
                t.resultMap(resultSet);
                diaChis.add(t);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return diaChis;
    }

    @Override
    public void create(Object o) {
        DiaChi t = (DiaChi) o;
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
        DiaChi diaChi = new DiaChi();
        try {

            conn = getConnection();
            ptmt = conn.prepareStatement(readQuery);
            ptmt.setInt(1, t);
            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                diaChi.resultMap(resultSet);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return diaChi;
    }

    @Override
    public void update(Object o) {
        DiaChi t = (DiaChi) o;
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
        DiaChi t = (DiaChi) o;
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
