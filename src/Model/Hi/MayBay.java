package Model.Hi;

import Model.model;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class MayBay  implements Serializable, model {
    private int id;
    private String loaimaybay,hang,sohieu,ghichu;
    private Timestamp timestamp;
    private static int mbma=10000;
    public MayBay() {
        this.id=mbma++;
    }

    public MayBay(int id) {
        this.id = id;
    }

    public MayBay(int id, String loaimaybay, String hang, String sohieu, String ghichu, Timestamp timestamp) {
        this.id = id;
        this.loaimaybay = loaimaybay;
        this.hang = hang;
        this.sohieu = sohieu;
        this.ghichu = ghichu;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoaimaybay() {
        return loaimaybay;
    }

    public void setLoaimaybay(String loaimaybay) {
        this.loaimaybay = loaimaybay;
    }

    public String getHang() {
        return hang;
    }

    public void setHang(String hang) {
        this.hang = hang;
    }

    public String getSohieu() {
        return sohieu;
    }

    public void setSohieu(String sohieu) {
        this.sohieu = sohieu;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public static int getMbma() {
        return mbma;
    }

    public static void setMbma(int mbma) {
        MayBay.mbma = mbma;
    }

    @Override
    public void resultMap(ResultSet resultSet) throws SQLException {
        this.id=resultSet.getInt("id");
        this.hang=resultSet.getString("hang");
        this.loaimaybay=resultSet.getString("loai");
        this.sohieu=resultSet.getString("sohieu");
        this.ghichu=resultSet.getString("ghichu");
    }

    @Override
    public PreparedStatement ptmtUpdate(PreparedStatement ptmt) throws SQLException{
        //SET
        ptmt.setString(1,this.getHang());
        ptmt.setString(2,this.getLoaimaybay());
        ptmt.setString(3,this.getSohieu());
        ptmt.setString(4,this.getGhichu());
        //WHERE
        ptmt.setInt(5,this.getId());
        return ptmt;
    }

    @Override
    public PreparedStatement ptmtCreate(PreparedStatement ptmt) throws SQLException{
        ptmt.setString(1,this.getHang());
        ptmt.setString(2,this.getLoaimaybay());
        ptmt.setString(3,this.getSohieu());
        ptmt.setString(4,this.getGhichu());
        return ptmt;
    }
}
