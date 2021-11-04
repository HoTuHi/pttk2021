package Model.Roi;

import Model.model;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ChuyenBay implements Serializable, model {
    int id;
    LichBay lichbay;
    MayBay mayBay;
    boolean tinhTrang;
    double phoThongTietKiem;
    double phoThongTieuChuan;
    double thuongGiaTieuChuan;
    double thuongGiaCaoCap;

    public ChuyenBay() {
    }

    public ChuyenBay(int id, LichBay lichbay, MayBay mayBay, boolean tinhTrang, double phoThongTietKiem, double phoThongTieuChuan, double thuongGiaTieuChuan, double thuongGiaCaoCap) {
        this.id = id;
        this.lichbay = lichbay;
        this.mayBay = mayBay;
        this.tinhTrang = tinhTrang;
        this.phoThongTietKiem = phoThongTietKiem;
        this.phoThongTieuChuan = phoThongTieuChuan;
        this.thuongGiaTieuChuan = thuongGiaTieuChuan;
        this.thuongGiaCaoCap = thuongGiaCaoCap;
    }


    @Override
    public String toString() {
        return "ChuyenBay{" +
                "id=" + id +
                ", lichbay=" + lichbay +
                ", mayBay=" + mayBay +
                ", tinhTrang=" + tinhTrang +
                ", phoThongTietKiem=" + phoThongTietKiem +
                ", phoThongTieuChuan=" + phoThongTieuChuan +
                ", thuongGiaTieuChuan=" + thuongGiaTieuChuan +
                ", thuongGiaCaoCap=" + thuongGiaCaoCap +
                '}';
    }

    @Override
    public void resultMap(ResultSet resultSet) throws SQLException {
        this.id = resultSet.getInt("id");
        this.lichbay = new LichBay(resultSet.getInt("lichbayid"));
        this.mayBay = new MayBay(resultSet.getInt("maybayid"));
        this.tinhTrang = resultSet.getBoolean("tinhtrang");
        this.phoThongTietKiem = resultSet.getDouble("phoThongTietKiem");
        this.phoThongTieuChuan = resultSet.getDouble("phoThongTieuChuan");
        this.thuongGiaTieuChuan = resultSet.getDouble("thuongGiaTieuChuan");
        this.thuongGiaCaoCap = resultSet.getDouble("thuongGiaCaoCap");
    }

    @Override
    public PreparedStatement ptmtUpdate(PreparedStatement ptmt) throws SQLException {
        // SET
        ptmt.setInt(1, this.getLichbay().getId());
        ptmt.setInt(2, this.getMayBay().getId());
        ptmt.setBoolean(3,this.isTinhTrang());
        ptmt.setDouble(4,this.getPhoThongTietKiem());
        ptmt.setDouble(5,this.getPhoThongTieuChuan());
        ptmt.setDouble(6,this.getThuongGiaTieuChuan());
        ptmt.setDouble(7,this.getThuongGiaCaoCap());
        // WHERE
        ptmt.setInt(8,this.id);
        return ptmt;
    }

    @Override
    public PreparedStatement ptmtCreate(PreparedStatement ptmt) throws SQLException {
        // Create
        ptmt.setInt(1, this.getLichbay().getId());
        ptmt.setInt(2, this.getMayBay().getId());
        ptmt.setBoolean(3,this.isTinhTrang());
        ptmt.setDouble(4,this.getPhoThongTietKiem());
        ptmt.setDouble(5,this.getPhoThongTieuChuan());
        ptmt.setDouble(6,this.getThuongGiaTieuChuan());
        ptmt.setDouble(7,this.getThuongGiaCaoCap());
        return ptmt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LichBay getLichbay() {
        return lichbay;
    }

    public void setLichbay(LichBay lichbay) {
        this.lichbay = lichbay;
    }

    public MayBay getMayBay() {
        return mayBay;
    }

    public void setMayBay(MayBay mayBay) {
        this.mayBay = mayBay;
    }

    public boolean isTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
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
