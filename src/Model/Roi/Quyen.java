package Model.Roi;

import Model.model;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Quyen implements Serializable, model {
    private int id;
    private String tenquyen;
    private int quyen; //0 is admin,1 is Manager,2 is staff,3 is client
    private String ghiChu;

    public Quyen() {
    }

    public Quyen(int id) {
        this.id = id;
    }

    public Quyen(int id, String tenquyen, int quyen, String ghiChu) {
        this.id = id;
        this.tenquyen = tenquyen;
        this.quyen = quyen;
        this.ghiChu = ghiChu;
    }

    @Override
    public void resultMap(ResultSet resultSet) throws SQLException {
        this.id = resultSet.getInt("id");
        this.tenquyen = resultSet.getString("tenquyen");
        this.quyen = resultSet.getInt("quyen");
        this.ghiChu = resultSet.getString("ghichu");
    }

    @Override
    public PreparedStatement ptmtUpdate(PreparedStatement ptmt) throws SQLException {
        ptmt.setString(1, this.getTenquyen());
        ptmt.setInt(2, this.getQuyen());
        ptmt.setString(3, this.getGhiChu());
        //WHERE
        ptmt.setInt(4, this.getId());
        return ptmt;
    }

    @Override
    public PreparedStatement ptmtCreate(PreparedStatement ptmt) throws SQLException {
        ptmt.setString(1, this.getTenquyen());
        ptmt.setInt(2, this.getQuyen());
        ptmt.setString(3, this.getGhiChu());

        return ptmt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenquyen() {
        return tenquyen;
    }

    public void setTenquyen(String tenquyen) {
        this.tenquyen = tenquyen;
    }

    public int getQuyen() {
        return quyen;
    }

    public void setQuyen(int quyen) {
        this.quyen = quyen;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}
