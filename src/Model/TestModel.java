package Model;

import java.sql.Timestamp;

public class TestModel {
    int id;
    String testString;
    Timestamp starTime;

    public TestModel(int id, String testString) {
        this.id = id;
        this.testString = testString;
        this.starTime = new Timestamp(System.currentTimeMillis());
    }

    public int getId() {
        return id;
    }

    public String getTestString() {
        return testString;
    }

    public Timestamp getStarTime() {
        return starTime;
    }

    public void setTestString(String testString) {
        this.testString = testString;
    }

}
