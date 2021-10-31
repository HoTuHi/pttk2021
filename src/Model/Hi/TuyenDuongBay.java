package Model.Hi;

import Model.Hi.DiaChi;
import Model.Hi.model;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TuyenDuongBay implements Serializable, model {
    private int id;
    private DiaChi diemdi;
    private DiaChi diemden;
    private float thoiGianDiChuyen;
    double phoThongTietKiem;
    double phoThongTieuChuan;
    double thuongGiaTieuChuan;
    double thuongGiaCaoCap;

    public TuyenDuongBay() {
    }

    public TuyenDuongBay(int id) {
        this.id = id;
    }

    public TuyenDuongBay(int id, DiaChi diemdi, DiaChi diemden, float thoiGianDiChuyen, double phoThongTietKiem, double phoThongTieuChuan, double thuongGiaTieuChuan, double thuongGiaCaoCap) {
        this.id = id;
        this.diemdi = diemdi;
        this.diemden = diemden;
        this.thoiGianDiChuyen = thoiGianDiChuyen;
        this.phoThongTietKiem = phoThongTietKiem;
        this.phoThongTieuChuan = phoThongTieuChuan;
        this.thuongGiaTieuChuan = thuongGiaTieuChuan;
        this.thuongGiaCaoCap = thuongGiaCaoCap;
    }

    @Override
    public String toString() {
        return "TuyenDuongBay{" +
                "id=" + id +
                ", diemdi=" + diemdi +
                ", diemden=" + diemden +
                ", thoiGianDiChuyen=" + thoiGianDiChuyen +
                ", phoThongTietKiem=" + phoThongTietKiem +
                ", phoThongTieuChuan=" + phoThongTieuChuan +
                ", thuongGiaTieuChuan=" + thuongGiaTieuChuan +
                ", thuongGiaCaoCap=" + thuongGiaCaoCap +
                '}';
    }

    @Override
    public void resultMap(ResultSet resultSet) throws SQLException {
        this.id = resultSet.getInt("id");
        this.diemdi = new DiaChi(resultSet.getInt("diemdi"));
        this.diemden = new DiaChi(resultSet.getInt("diemden"));
        ;
        this.thoiGianDiChuyen = resultSet.getFloat("thoiGianDiChuyen");
        this.phoThongTietKiem = resultSet.getDouble("phoThongTietKiem");
        this.phoThongTieuChuan = resultSet.getDouble("phoThongTieuChuan");
        this.thuongGiaTieuChuan = resultSet.getDouble("thuongGiaTieuChuan");
        this.thuongGiaCaoCap = resultSet.getDouble("thuongGiaCaoCap");
    }

    @Override
    public PreparedStatement ptmtUpdate(PreparedStatement ptmt) throws SQLException {
        //SET
        ptmt.setInt(1, this.getDiemdi().getId());
        ptmt.setInt(2, this.getDiemden().getId());
        ptmt.setFloat(3, this.getThoiGianDiChuyen());
        ptmt.setDouble(4, this.getPhoThongTietKiem());
        ptmt.setDouble(5, this.getPhoThongTieuChuan());
        ptmt.setDouble(6, this.getThuongGiaTieuChuan());
        ptmt.setDouble(7, this.getThuongGiaCaoCap());
        //WHERE
        ptmt.setDouble(8, this.getId());
        return ptmt;
    }

    @Override
    public PreparedStatement ptmtCreate(PreparedStatement ptmt) throws SQLException {
        //CREATE
        ptmt.setInt(1, this.getDiemdi().getId());
        ptmt.setInt(2, this.getDiemden().getId());
        ptmt.setFloat(3, this.getThoiGianDiChuyen());
        ptmt.setDouble(4, this.getPhoThongTietKiem());
        ptmt.setDouble(5, this.getPhoThongTieuChuan());
        ptmt.setDouble(6, this.getThuongGiaTieuChuan());
        ptmt.setDouble(7, this.getThuongGiaCaoCap());
        return ptmt;
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

    public float getThoiGianDiChuyen() {
        return thoiGianDiChuyen;
    }

    public void setThoiGianDiChuyen(float thoiGianDiChuyen) {
        this.thoiGianDiChuyen = thoiGianDiChuyen;
    }

    public double getPhoThongTietKiem() {
        return phoThongTietKiem;
    }

    public void setPhoThongTietKiem(double phoThongTietKiem) {
        this.phoThongTietKiem = phoThongTietKiem;
    }

    public double getPhoThongTieuChuan() {
        return phoThongTieuChuan;
    }

    public void setPhoThongTieuChuan(double phoThongTieuChuan) {
        this.phoThongTieuChuan = phoThongTieuChuan;
    }

    public double getThuongGiaTieuChuan() {
        return thuongGiaTieuChuan;
    }

    public void setThuongGiaTieuChuan(double thuongGiaTieuChuan) {
        this.thuongGiaTieuChuan = thuongGiaTieuChuan;
    }

    public double getThuongGiaCaoCap() {
        return thuongGiaCaoCap;
    }

    public void setThuongGiaCaoCap(double thuongGiaCaoCap) {
        this.thuongGiaCaoCap = thuongGiaCaoCap;
    }
}
