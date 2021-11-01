package DAO.Hi;

import DAO.DAO;
import Model.Hi.MayBay;
import Conn.Conn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MayBayDAO implements DAO {
    Connection conn = null;
    PreparedStatement ptmt = null;
    ResultSet resultSet = null;
    String tblName = "MayBay";
    List<MayBay> MayBays = null;


    String getAllQuery = "SELECT * from " + tblName + " ORDER BY id";
    String createQuery = "INSERT INTO " + tblName + "(heso,ghichu) " + "VALUES(?,?)";
    String updateQuery = "UPDATE MayBay SET heso= ?,ghichu=? WHERE id=?";
    String readQuery = "SELECT * from "+tblName+" WHERE id=?";
    String deleteQuery = "DELETE FROM "+tblName+" WHERE id=?";

    private Connection getConnection() {
        Connection conn;
        conn = Conn.getInstance().getConnection();
        return conn;
    }

    @Override
    public Optional get(int id) {
        return MayBays.stream().filter(u -> u.getId() == id).findFirst();
    }

    @Override
    public List gellAll() {
        MayBays = new ArrayList<>();
        try {
            conn = getConnection();
            ptmt = conn.prepareStatement(getAllQuery);
            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                MayBay t = new MayBay();
                t.resultMap(resultSet);
                MayBays.add(t);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return MayBays;
    }

    @Override
    public void create(Object o) {
        MayBay t = (MayBay) o;
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
        MayBay MayBay = new MayBay();
        try {

            conn = getConnection();
            ptmt = conn.prepareStatement(readQuery);
            ptmt.setInt(1, t);
            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                MayBay.resultMap(resultSet);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return MayBay;
    }

    @Override
    public void update(Object o) {
        MayBay t = (MayBay) o;
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
        MayBay t = (MayBay) o;
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
