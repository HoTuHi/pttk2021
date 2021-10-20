package Controller;

import DAO.TestDAO;
import Model.TestModel;
import Service.TestService;

public class TestController {
    private static TestDAO testDAO;
    private static TestService testService;

    public static void main(String[] args) {
        testDAO = new TestDAO();
        testService = new TestService();
        TestModel t = new TestModel(3, "test 3");
        System.out.println("truoc :");
        testDAO.gellAll().forEach(test -> System.out.println(test.getId() + "," + test.getTestString()));
        if (testService.getTestModel(t, testDAO) != null){
            System.out.println("sau:");
            testDAO.gellAll().forEach(test -> System.out.println(test.getId() + "," + test.getTestString()));
        }
        else {
            System.out.println("Failed !!!");
        }
    }
}
