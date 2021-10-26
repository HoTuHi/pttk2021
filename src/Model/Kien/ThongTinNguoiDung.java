package Model.Kien;

import Model.Hi.DiaChi;

import java.io.Serializable;
import java.sql.Timestamp;

public class ThongTinNguoiDung implements Serializable {
    private int id;
    private String ho, ten_dem, ten;
    private Timestamp ngaysinh;
    private String email, sdt;
    private Timestamp khoitao;
    private DiaChi diaChi;
    private static int ttndma = 100000;

    public ThongTinNguoiDung() {
        this.id = ttndma++;
    }

    public ThongTinNguoiDung(int id, String ho, String ten_dem, String ten, Timestamp ngaysinh, String email, String sdt, Timestamp khoitao, DiaChi diaChi) {
        this.id = id;
        this.ho = ho;
        this.ten_dem = ten_dem;
        this.ten = ten;
        this.ngaysinh = ngaysinh;
        this.email = email;
        this.sdt = sdt;
        this.khoitao = khoitao;
        this.diaChi = diaChi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen_dem() {
        return ten_dem;
    }

    public void setTen_dem(String ten_dem) {
        this.ten_dem = ten_dem;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Timestamp getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Timestamp ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public Timestamp getKhoitao() {
        return khoitao;
    }

    public void setKhoitao(Timestamp khoitao) {
        this.khoitao = khoitao;
    }

    public DiaChi getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(DiaChi diaChi) {
        this.diaChi = diaChi;
    }

    public static int getTtndma() {
        return ttndma;
    }

    public static void setTtndma(int ttndma) {
        ThongTinNguoiDung.ttndma = ttndma;
    }

    public String toString() {
        return this.ho + " | " + this.ten;
    }
}
