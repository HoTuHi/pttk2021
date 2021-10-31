package Model.Hi;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface model {
    public void resultMap(ResultSet resultSet) throws SQLException;
    public PreparedStatement ptmtUpdate(PreparedStatement ptmt) throws SQLException;
    public PreparedStatement ptmtCreate(PreparedStatement ptmt) throws SQLException;
}
