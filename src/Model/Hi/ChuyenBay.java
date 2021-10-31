package Model.Hi;

import DAO.Hi.LichBayDAO;
import Model.Nam.LichBay;
import Model.Nam.MayBay;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class ChuyenBay implements Serializable,model {
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

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public LichBay getLichbay() {return lichbay;}
    public void setLichbay(LichBay lichbay) {this.lichbay = lichbay;}
    public MayBay getMayBay() {return mayBay;}
    public void setMayBay(MayBay mayBay) {this.mayBay = mayBay;}
    public boolean isTinhTrang() {return tinhTrang;}public void setTinhTrang(boolean tinhTrang) {this.tinhTrang = tinhTrang;}public double getPhoThongTietKiem() {return phoThongTietKiem;}
    public void setPhoThongTietKiem(double phoThongTietKiem) {this.phoThongTietKiem = phoThongTietKiem;}public double getPhoThongTieuChuan() {return phoThongTieuChuan;}
    public void setPhoThongTieuChuan(double phoThongTieuChuan) {this.phoThongTieuChuan = phoThongTieuChuan;}
    public double getThuongGiaTieuChuan() {return thuongGiaTieuChuan;}
    public void setThuongGiaTieuChuan(double thuongGiaTieuChuan) {this.thuongGiaTieuChuan = thuongGiaTieuChuan;}
    public double getThuongGiaCaoCap() {return thuongGiaCaoCap;}public void setThuongGiaCaoCap(double thuongGiaCaoCap) {this.thuongGiaCaoCap = thuongGiaCaoCap;}

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
        this.id = resultSet.getInt("banggia.id");
        lichbay.resultMap(resultSet);
        this.lichbay = lichbay;
        mayBay.resultMap(resultSet);
        this.mayBay = mayBay;
        this.tinhTrang = tinhTrang;
        this.phoThongTietKiem = phoThongTietKiem;
        this.phoThongTieuChuan = phoThongTieuChuan;
        this.thuongGiaTieuChuan = thuongGiaTieuChuan;
        this.thuongGiaCaoCap = thuongGiaCaoCap;
    }
    @Override
    public PreparedStatement ptmtUpdate(PreparedStatement ptmt){
        return ptmt;
    }
    @Override
    public PreparedStatement Get(PreparedStatement ptmt){
        return  ptmt;
    }
}
