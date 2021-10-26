package Model.Nam;

import Model.Hi.BangGia;
import Model.Hi.HeSoGio;
import Model.Hi.HeSoNgay;
import Model.Kien.TuyenDuongBay;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class LichBay  implements Serializable {
    private int id;
    private float phothongtietkiem;
    private float phothongtieuchuan;
    private float thuonggiatieuchuan;
    private float thuonggiacaocap;
    private TuyenDuongBay tuyenDuongBay;
    private Date thoigiankhoihanh;
    private HeSoNgay heSoNgay;
    private HeSoGio heSoGio;
    private Timestamp khoitao;
    private BangGia bangGia;
    private static int lma=1000000;

    public LichBay() {
        this.id=lma++;
    }

    public LichBay(int id, float phothongtietkiem, float phothongtieuchuan, float thuonggiatieuchuan, float thuonggiacaocap, TuyenDuongBay tuyenDuongBay, Date thoigiankhoihanh, HeSoNgay heSoNgay, HeSoGio heSoGio, Timestamp khoitao, BangGia bangGia) {
        this.id = id;
        this.phothongtietkiem = phothongtietkiem;
        this.phothongtieuchuan = phothongtieuchuan;
        this.thuonggiatieuchuan = thuonggiatieuchuan;
        this.thuonggiacaocap = thuonggiacaocap;
        this.tuyenDuongBay = tuyenDuongBay;
        this.thoigiankhoihanh = thoigiankhoihanh;
        this.heSoNgay = heSoNgay;
        this.heSoGio = heSoGio;
        this.khoitao = khoitao;
        this.bangGia = bangGia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPhothongtietkiem() {
        return phothongtietkiem;
    }

    public void setPhothongtietkiem(float phothongtietkiem) {
        this.phothongtietkiem = phothongtietkiem;
    }

    public float getPhothongtieuchuan() {
        return phothongtieuchuan;
    }

    public void setPhothongtieuchuan(float phothongtieuchuan) {
        this.phothongtieuchuan = phothongtieuchuan;
    }

    public float getThuonggiatieuchuan() {
        return thuonggiatieuchuan;
    }

    public void setThuonggiatieuchuan(float thuonggiatieuchuan) {
        this.thuonggiatieuchuan = thuonggiatieuchuan;
    }

    public float getThuonggiacaocap() {
        return thuonggiacaocap;
    }

    public void setThuonggiacaocap(float thuonggiacaocap) {
        this.thuonggiacaocap = thuonggiacaocap;
    }

    public TuyenDuongBay getTuyenDuongBay() {
        return tuyenDuongBay;
    }

    public void setTuyenDuongBay(TuyenDuongBay tuyenDuongBay) {
        this.tuyenDuongBay = tuyenDuongBay;
    }

    public Date getThoigiankhoihanh() {
        return thoigiankhoihanh;
    }

    public void setThoigiankhoihanh(Date thoigiankhoihanh) {
        this.thoigiankhoihanh = thoigiankhoihanh;
    }

    public HeSoNgay getHeSoNgay() {
        return heSoNgay;
    }

    public void setHeSoNgay(HeSoNgay heSoNgay) {
        this.heSoNgay = heSoNgay;
    }

    public HeSoGio getHeSoGio() {
        return heSoGio;
    }

    public void setHeSoGio(HeSoGio heSoGio) {
        this.heSoGio = heSoGio;
    }

    public Timestamp getKhoitao() {
        return khoitao;
    }

    public void setKhoitao(Timestamp khoitao) {
        this.khoitao = khoitao;
    }

    public BangGia getBangGia() {
        return bangGia;
    }

    public void setBangGia(BangGia bangGia) {
        this.bangGia = bangGia;
    }

    public static int getLma() {
        return lma;
    }

    public static void setLma(int lma) {
        LichBay.lma = lma;
    }
}
