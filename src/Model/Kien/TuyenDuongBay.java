package Model.Kien;

import Model.Hi.DiaChi;

import java.io.Serializable;

public class TuyenDuongBay implements Serializable {
    private int id;
    private DiaChi diemdi;
    private DiaChi diemden;
    private float thoigianbay;
    private static int tdbma=10000;

    public TuyenDuongBay() {
        this.id=tdbma++;
    }

    public TuyenDuongBay(int id, DiaChi diemdi, DiaChi diemden, float thoigianbay) {
        this.id = id;
        this.diemdi = diemdi;
        this.diemden = diemden;
        this.thoigianbay = thoigianbay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DiaChi getDiemdi() {
        return diemdi;
    }

    public void setDiemdi(DiaChi diemdi) {
        this.diemdi = diemdi;
    }

    public DiaChi getDiemden() {
        return diemden;
    }

    public void setDiemden(DiaChi diemden) {
        this.diemden = diemden;
    }

    public float getThoigianbay() {
        return thoigianbay;
    }

    public void setThoigianbay(float thoigianbay) {
        this.thoigianbay = thoigianbay;
    }

    public static int getTdbma() {
        return tdbma;
    }

    public static void setTdbma(int tdbma) {
        TuyenDuongBay.tdbma = tdbma;
    }
}
