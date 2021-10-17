package Model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Ve implements Serializable {
    int id;
    DiaChi diemDi;
    DiaChi diemDen;
    String hoTen;
    Timestamp thoiGianKhoiTao;
    int soHieuMayBay;
    int hangVe;
    int maSoGHe;
    ThongTinNguoiDung thongTinNguoiDung;
    ChuyenBay ChuyenBay;
    HoaDon hoaDon;

    public Ve(int id, DiaChi diemDi, DiaChi diemDen, String hoTen, Timestamp thoiGianKhoiTao, int soHieuMayBay, int hangVe, int maSoGHe, ThongTinNguoiDung thongTinNguoiDung, Model.ChuyenBay chuyenBay, HoaDon hoaDon) {
        this.id = id;
        this.diemDi = diemDi;
        this.diemDen = diemDen;
        this.hoTen = hoTen;
        this.thoiGianKhoiTao = thoiGianKhoiTao;
        this.soHieuMayBay = soHieuMayBay;
        this.hangVe = hangVe;
        this.maSoGHe = maSoGHe;
        this.thongTinNguoiDung = thongTinNguoiDung;
        ChuyenBay = chuyenBay;
        this.hoaDon = hoaDon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DiaChi getDiemDi() {
        return diemDi;
    }

    public void setDiemDi(DiaChi diemDi) {
        this.diemDi = diemDi;
    }

    public DiaChi getDiemDen() {
        return diemDen;
    }

    public void setDiemDen(DiaChi diemDen) {
        this.diemDen = diemDen;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Timestamp getThoiGianKhoiTao() {
        return thoiGianKhoiTao;
    }

    public void setThoiGianKhoiTao(Timestamp thoiGianKhoiTao) {
        this.thoiGianKhoiTao = thoiGianKhoiTao;
    }

    public int getSoHieuMayBay() {
        return soHieuMayBay;
    }

    public void setSoHieuMayBay(int soHieuMayBay) {
        this.soHieuMayBay = soHieuMayBay;
    }

    public int getHangVe() {
        return hangVe;
    }

    public void setHangVe(int hangVe) {
        this.hangVe = hangVe;
    }

    public int getMaSoGHe() {
        return maSoGHe;
    }

    public void setMaSoGHe(int maSoGHe) {
        this.maSoGHe = maSoGHe;
    }

    public ThongTinNguoiDung getThongTinNguoiDung() {
        return thongTinNguoiDung;
    }

    public void setThongTinNguoiDung(ThongTinNguoiDung thongTinNguoiDung) {
        this.thongTinNguoiDung = thongTinNguoiDung;
    }

    public Model.ChuyenBay getChuyenBay() {
        return ChuyenBay;
    }

    public void setChuyenBay(Model.ChuyenBay chuyenBay) {
        ChuyenBay = chuyenBay;
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }
}