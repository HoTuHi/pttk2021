package DAO.Hi;

import DAO.DAO;
import Model.Hi.BangGia;
import Connection.Conn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BanggiaDAO implements DAO {
    Connection conn = null;
    PreparedStatement ptmt = null;
    ResultSet resultSet = null;
    String tblName = "tblbanggia";
    List<BangGia> bangGias = new ArrayList<>();

    public BanggiaDAO() {

    }

    private Connection getConnection() {
        Connection conn;
        conn = Conn.getInstance().getConnection();
        return conn;
    }
    @Override
    public List<BangGia> gellAll() {
        try {
            String querryString = "SELECT * from " + tblName;
            conn = getConnection();
            ptmt = conn.prepareStatement(querryString);
            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                BangGia b = new BangGia(resultSet.getInt("id"), resultSet.getFloat("phothongtietkiem"), resultSet.getFloat("phothongtieuchuan"), resultSet.getFloat("thuonggiatieuchuan"), resultSet.getFloat("thuonggiacaocap"));
                bangGias.add(b);

            }
            return bangGias;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if (resultSet != null)
                    resultSet.close();
                if (ptmt != null)
                    ptmt.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return bangGias;
    }

    @Override
    public Optional get(int id) {
        return bangGias.stream().filter(u -> u.getId() == id).findFirst();
    }

    @Override
    public void create(Object o) {
        try {
            BangGia b = (BangGia) o;
            String stringQuerry = "INSERT INTO tblbanggia(phothongtietkiem,phothongtieuchuan,thuonggiatieuchuan,thuonggiacaocap) VALUES (?,?,?,?)";
            conn = getConnection();

            ptmt = conn.prepareStatement(stringQuerry);
//            ptmt.setString(1, d.getId());
            ptmt.setFloat(1, b.getPhothongtietkiem());
            ptmt.setFloat(2, b.getPhothongtieuchuan());
            ptmt.setFloat(3, b.getThuonggiatieuchuan());
            ptmt.setFloat(4,b.getThuonggiacaocap());
            ptmt.executeUpdate();
            System.out.println("Banggia Added Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Object read(int o) {
        try {
            BangGia b = null;
            String stringQuery = "SELECT * FROM tblbanggia WHERE id=?";
            conn = getConnection();
            ptmt = conn.prepareStatement(stringQuery);
            ptmt.setInt(1, 2);
            resultSet = ptmt.executeQuery();
            while (resultSet.next()){
                b = new BangGia(resultSet.getInt("id"), resultSet.getFloat("phothongtietkiem"), resultSet.getFloat("phothongtieuchuan"), resultSet.getFloat("thuonggiatieuchuan"), resultSet.getFloat("thuonggiacaocap"));
            }
            return b;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if (resultSet != null)
                    resultSet.close();
                if (ptmt != null)
                    ptmt.close();
                if (conn != null)
                    conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return null;

    }

    @Override
    public void update(Object o) {
        System.out.println("cho fe");
    }
    @Override
    public void delete(Object o) {
        try {
            BangGia d = (BangGia) o;
            String stringQuery = "DELETE FROM tblbanggia WHERE id=?";
            conn = getConnection();
            ptmt = conn.prepareStatement(stringQuery);
            ptmt.setInt(1, d.getId());
            ptmt.executeUpdate();
            System.out.println("Successfully");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
