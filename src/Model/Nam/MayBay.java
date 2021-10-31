package Model.Nam;

import Model.Hi.model;

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

    }

    @Override
    public PreparedStatement ptmtUpdate(PreparedStatement ptmt) {
        return null;
    }

    @Override
    public PreparedStatement Get(PreparedStatement ptmt) {
        return null;
    }
}
