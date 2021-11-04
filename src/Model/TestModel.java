package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

    public void resultMap(ResultSet resultSet) throws SQLException {
        this.id = resultSet.getInt("id");
        this.title = resultSet.getString("title");
        this.value = resultSet.getInt("value");
    }
    public PreparedStatement ptmtUpdate(PreparedStatement ptmt, boolean flag) throws SQLException {
        ptmt.setString(1,this.getTitle());
        ptmt.setInt(2,this.getValue());
        if(flag){
            ptmt.setInt(3,this.getId());
        }
        return ptmt;
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
