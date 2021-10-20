package Service;

import DAO.TestDAO;
import Model.TestModel;

import java.util.List;

public class TestService {
    public TestService() {
    }

    public List<TestModel> getTestModel(TestModel te, TestDAO testDao) {
        if (true) // check Somthing ?
        {
            // add them 1 te
            testDao.create(te);
            return testDao.gellAll();
        }
        else return null;
    }
}
