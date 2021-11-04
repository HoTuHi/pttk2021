package Model.Hi;

import Model.model;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoaiVe  implements Serializable, model {
    private int id;
    private String loai;
    String ghichu;

    public LoaiVe() {
    }

    public LoaiVe(int id) {
        this.id = id;
    }

    public LoaiVe(int id, String loai, String ghichu) {
        this.id = id;
        this.loai = loai;
        this.ghichu = ghichu;
    }

    @Override
    public void resultMap(ResultSet resultSet) throws SQLException {
        this.id = resultSet.getInt("id");
        this.loai = resultSet.getString("loai");
        this.ghichu = resultSet.getString("ghichu");
    }

    @Override
    public PreparedStatement ptmtUpdate(PreparedStatement ptmt) throws SQLException {
        ptmt.setString(1,this.getLoai());
        ptmt.setString(2,this.getGhichu());
        //WHERE
        ptmt.setInt(3,this.getId());
        return ptmt;

    }

    @Override
    public PreparedStatement ptmtCreate(PreparedStatement ptmt) throws SQLException {
        ptmt.setString(1,this.getLoai());
        ptmt.setString(2,this.getGhichu());

        return ptmt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }
}
