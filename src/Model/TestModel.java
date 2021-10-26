package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class TestModel {

    int id;
    String title;
    int value;
    public TestModel() {
    }

    public TestModel(int id, String title, int value) {
        this.id = id;
        this.title = title;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void prepare(ResultSet resultSet) throws SQLException {
        this.id = resultSet.getInt("id");
        this.title = resultSet.getString("title");
        this.value = resultSet.getInt("value");
    }

    @Override
    public String toString() {
        return "TestModel{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", value=" + value +
                '}';
    }
}
