package Model.Roi;

import Model.model;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ghe implements Serializable, model {

    int id;
    String hang;
    String ghiChu;
    MayBay mayBay;

    public Ghe() {
    }

    public Ghe(int id) {
        this.id = id;
    }

    public Ghe(int id, String hang, String ghiChu, MayBay mayBay) {
        this.id = id;
        this.hang = hang;
        this.ghiChu = ghiChu;
        this.mayBay = mayBay;
    }


    @Override
    public void resultMap(ResultSet resultSet) throws SQLException {
        this.id = resultSet.getInt("id");
        this.hang = resultSet.getString("hang");
        this.ghiChu = resultSet.getString("ghichu");
        this.mayBay = new MayBay(resultSet.getInt("maybayid"));
    }

    @Override
    public PreparedStatement ptmtUpdate(PreparedStatement ptmt) throws SQLException {
        //SET
        ptmt.setString(1,this.getHang());
        ptmt.setString(2,this.getGhiChu());
        ptmt.setInt(3,this.getMayBay().getId());
        //Where
        ptmt.setInt(4,this.getId());

        return ptmt;
    }

    @Override
    public PreparedStatement ptmtCreate(PreparedStatement ptmt) throws SQLException {
        ptmt.setString(1,this.getHang());
        ptmt.setString(2,this.getGhiChu());
        ptmt.setInt(3,this.getMayBay().getId());
        return ptmt;
    }

    @Override
    public String toString() {
        return "Ghe{" +
                "id=" + id +
                ", hang='" + hang + '\'' +
                ", ghiChu='" + ghiChu + '\'' +
                ", mayBay=" + mayBay +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHang() {
        return hang;
    }

    public void setHang(String hang) {
        this.hang = hang;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public MayBay getMayBay() {
        return mayBay;
    }

    public void setMayBay(MayBay mayBay) {
        this.mayBay = mayBay;
    }
}
