package DAO;

import Model.TestModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// khoi tao 1 list gom 2 test.
public class TestDAO implements DAO<TestModel> {
    List<TestModel> testModels = new ArrayList<>();

    public TestDAO() {
        testModels.add(new TestModel(1, "test 1"));
        testModels.add(new TestModel(2, "test 2"));
    }


    @Override
    public List<TestModel> gellAll() {
        return testModels;
    }

    @Override
    public Optional<TestModel> get(int id) {
        return testModels.stream().filter(u -> u.getId() == id).findFirst();
    }

    @Override
    public void create(TestModel te) {
        // INSERT INTO table_name (column1, column2, column3, ...)
        testModels.add(te);
    }

    @Override
    public void read(TestModel te) {

    }

    @Override
    public void update(TestModel te) {
    //    UPDATE testModel
    //  SET column1 = value1, column2 = value2, ...
    //  WHERE id = te.id;
        get(te.getId()).ifPresent(existTe -> {
            existTe.setTestString(te.getTestString());
        });
    }

    @Override
    public void delete(TestModel te) {
        get(te.getId()).ifPresent(existUser -> testModels.remove(existUser));
    }
}
