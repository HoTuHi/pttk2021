package Model;

import java.io.Serializable;
import java.sql.Timestamp;

public class MayBay  implements Serializable {
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
}
