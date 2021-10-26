package DAO;

import Model.TestModel;
import Connection.Conn;

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
    List<TestModel> testModels = new ArrayList<>();


    private Connection getConnection() {
        Connection conn;
        conn = Conn.getInstance().getConnection();
        return conn;
    }

    @Override
    public List<TestModel> gellAll() {
        try {
            String querryString = "SELECT * from test";
            conn = getConnection();
            ptmt = conn.prepareStatement(querryString);
            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                TestModel t = new TestModel();
                t.prepare(resultSet);
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
            ptmt = conn.prepareStatement(stringQuery);
            ptmt.setString(1,t.getTitle());
            ptmt.setInt(2,t.getValue());
            ptmt.executeUpdate();
            System.out.println("success");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Fa");
        }
    }

    @Override
    public TestModel read(int te) {
        return null;
    }

    @Override
    public void update(TestModel te) {
    }

    @Override
    public void delete(TestModel te) {
        get(te.getId()).ifPresent(existUser -> testModels.remove(existUser));
    }
}
