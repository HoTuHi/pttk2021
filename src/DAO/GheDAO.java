package DAO;

import Conn.Conn;
import Model.Ghe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GheDAO implements DAO {
    Connection conn = null;
    PreparedStatement ptmt = null;
    ResultSet resultSet = null;
    String tblName = "ghe";
    List<Ghe> Ghes = null;

    String getAllQuery = "SELECT * from " + tblName + " ORDER BY id";
    String createQuery = "INSERT INTO " + tblName + "(hang,ghichu,maybay) " + "VALUES(?,?,?)";
    String updateQuery = "UPDATE ghe SET hang=?,ghichu=?, maybay=? WHERE id=?";
   // NoChange
    String readQuery = "SELECT * from "+tblName+" WHERE id=?";
    String deleteQuery = "DELETE FROM "+tblName+" WHERE id=?";

    private Connection getConnection() {
        Connection conn;
        conn = Conn.getInstance().getConnection();
        return conn;
    }
    @Override
    public Optional get(int id) {
        return Ghes.stream().filter(u -> u.getId() == id).findFirst();
    }

    @Override
    public List gellAll() {
        Ghes = new ArrayList<>();
        try {
            conn = getConnection();
            ptmt = conn.prepareStatement(getAllQuery);
            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                Ghe t = new Ghe();
                t.resultMap(resultSet);
                Ghes.add(t);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return Ghes;
    }

    @Override
    public void create(Object o) {
        Ghe t = (Ghe) o;
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
        Ghe Ghe = new Ghe();
        try {

            conn = getConnection();
            ptmt = conn.prepareStatement(readQuery);
            ptmt.setInt(1, t);
            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                Ghe.resultMap(resultSet);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return Ghe;
    }

    @Override
    public void update(Object o) {
        Ghe t = (Ghe) o;
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
        Ghe t = (Ghe) o;
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
