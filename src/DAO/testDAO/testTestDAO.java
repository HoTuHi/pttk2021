package DAO.testDAO;

import DAO.TestDAO;
import Model.TestModel;

public class testTestDAO {
    public static void main(String[] args) {
        TestDAO testDAO = new TestDAO();
        for (TestModel t: testDAO.gellAll()){
            System.out.println(t.toString());
        }
    }

}
