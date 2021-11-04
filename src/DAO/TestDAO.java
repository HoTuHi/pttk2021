package DAO;

import Model.TestModel;
import Conn.Conn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// khoi tao 1 list gom 2 test.
public class TestDAO implements DAO<TestModel> {
    Connection conn = null;
    PreparedStatement ptmt = null;
    ResultSet resultSet = null;
    String tblName = "test";
    List<TestModel> testModels = null;


    private Connection getConnection() {
        Connection conn;
        conn = Conn.getInstance().getConnection();
        return conn;
    }

    @Override
    public List<TestModel> gellAll() {
        testModels = new ArrayList<>();
        try {
            String querryString = "SELECT * from test ORDER BY id";
            conn = getConnection();
            ptmt = conn.prepareStatement(querryString);
            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                TestModel t = new TestModel();
                t.resultMap(resultSet);
                testModels.add(t);
//                System.out.println(t.toString());
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return testModels;
    }

    @Override
    public Optional<TestModel> get(int id) {
        return testModels.stream().filter(u -> u.getId() == id).findFirst();
    }

    @Override
    public void create(TestModel te) {
        TestModel t = (TestModel) te;
        String stringQuery = "INSERT INTO test(title,value) VALUES(?,?)";
        conn = getConnection();
        try {
            ptmt = conn.prepareStatement(stringQuery, ptmt.RETURN_GENERATED_KEYS);
            t.ptmtUpdate(ptmt,false).executeUpdate();
            System.out.println("success");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Fa");
        }
    }

    @Override
    public TestModel read(int te) {
        TestModel testModel = new TestModel();
        try {
            String querryString = "SELECT * from test WHERE id=?";
            conn = getConnection();
            ptmt = conn.prepareStatement(querryString);
            ptmt.setInt(1,te);
            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                testModel.resultMap(resultSet);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return testModel;
    }

    @Override
    public void update(TestModel te) {
        TestModel t = (TestModel) te;
        String stringQuery = "UPDATE test SET title=?,value=? WHERE id=?";
        conn = getConnection();
        try {
            ptmt = conn.prepareStatement(stringQuery);
            ptmt = t.ptmtUpdate(ptmt,true);
            ptmt.executeUpdate();
            System.out.println("success");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("F in update");
        }
    }


    @Override
    public void delete(TestModel te) {
        try {
            String querryString = "DELETE FROM test WHERE id=?";
            conn = getConnection();
            ptmt = conn.prepareStatement(querryString);
            ptmt.setInt(1, te.getId());
            ptmt.executeUpdate();
            System.out.println("success!");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
