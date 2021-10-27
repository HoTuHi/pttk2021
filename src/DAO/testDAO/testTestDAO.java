package DAO.testDAO;

import DAO.TestDAO;
import Model.TestModel;

public class testTestDAO {
    public static void main(String[] args) {
        TestDAO testDAO = new TestDAO();
        TestModel te = new TestModel(12,"sad",123);
        for (TestModel t: testDAO.gellAll()){
            System.out.println(t.toString());
        }
        testDAO.create(te);
        for (TestModel t: testDAO.gellAll()){
            System.out.println(t.toString());
        }
        te = new TestModel(2,"update hihi",123);
        testDAO.update(te);
        for (TestModel t: testDAO.gellAll()){
            System.out.println(t.toString());
        }
    }

}
