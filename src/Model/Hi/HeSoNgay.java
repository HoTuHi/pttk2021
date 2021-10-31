package Model.Hi;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HeSoNgay  implements Serializable,model {
    private int id;
    private double heso;
    private String ghichu;

    public HeSoNgay() {
    }

    public HeSoNgay(int id) {
        this.id = id;
    }

    public HeSoNgay(int id, double heso, String ghichu) {
        this.id = id;
        this.heso = heso;
        this.ghichu = ghichu;
    }

    @Override
    public void resultMap(ResultSet resultSet) throws SQLException {
        this.id = resultSet.getInt("id");
        this.heso = resultSet.getInt("heso");
        this.ghichu = resultSet.getString("ghichu");
    }

    @Override
    public PreparedStatement ptmtUpdate(PreparedStatement ptmt) throws SQLException {
        //SET
        ptmt.setDouble(1,this.getHeso());
        ptmt.setString(2,this.getGhichu());
        //WHERE
        ptmt.setInt(3,this.getId());
        return ptmt;
    }

    @Override
    public PreparedStatement ptmtCreate(PreparedStatement ptmt) throws SQLException {
        ptmt.setDouble(1,this.getHeso());
        ptmt.setString(2,this.getGhichu());
        return ptmt;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getHeso() {
        return heso;
    }

    public void setHeso(float heso) {
        this.heso = heso;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }


}
