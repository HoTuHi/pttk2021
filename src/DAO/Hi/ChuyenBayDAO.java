package DAO.Hi;


import DAO.DAO;
import Model.Hi.ChuyenBay;
import Connection.Conn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ChuyenBayDAO implements DAO {
    Connection conn = null;
    PreparedStatement ptmt = null;
    ResultSet resultSet = null;
    String tblName = "tblchuyenbay";
    List<ChuyenBay> chuyenBays = new ArrayList<>();

    private Connection getConnection() {
        Connection conn;
        conn = Conn.getInstance().getConnection();
        return conn;
    }

    @Override
    public Optional get(int id) {
        return chuyenBays.stream().filter(u -> u.getId() == id).findFirst();
    }

    @Override
    public List<ChuyenBay> gellAll() {
        try {
            String querryString = "SELECT * from " + tblName;
            conn = getConnection();
            ptmt = conn.prepareStatement(querryString);
            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                ChuyenBay c = new ChuyenBay();
                //set code here
                chuyenBays.add(c);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return chuyenBays;
    }

    @Override
    public void create(Object o) {

    }

    @Override
    public Object read(int t) {
        return null;
    }

    @Override
    public void update(Object o) {

    }

    @Override
    public void delete(Object o) {

    }
}
