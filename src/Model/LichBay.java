package Model;

import java.io.Serializable;
import java.sql.*;

public class LichBay  implements Serializable, model {
    int id;
    TuyenDuongBay tuyenDuongBay;
    Timestamp thoiGianKhoiHanh;
    HeSoGio heSoGio;
    HeSoNgay heSoNgay;
    Timestamp khoitao;
    public LichBay() {
    }

    public LichBay(int id) {
        this.id = id;
    }

    public LichBay(int id, TuyenDuongBay tuyenDuongBay, Timestamp thoiGianKhoiHanh, HeSoGio heSoGio, HeSoNgay heSoNgay, Timestamp khoitao) {
        this.id = id;
        this.tuyenDuongBay = tuyenDuongBay;
        this.thoiGianKhoiHanh = thoiGianKhoiHanh;
        this.heSoGio = heSoGio;
        this.heSoNgay = heSoNgay;
        this.khoitao = khoitao;
    }

    @Override
    public String toString() {
        return "LichBay{" +
                "id=" + id +
                ", tuyenDuongBay=" + tuyenDuongBay +
                ", thoiGianKhoiHanh=" + thoiGianKhoiHanh +
                ", heSoGio=" + heSoGio +
                ", heSoNgay=" + heSoNgay +
                ", khoitao=" + khoitao +
                '}';
    }

    @Override
    public void resultMap(ResultSet resultSet) throws SQLException {
        this.id = resultSet.getInt("id");
        this.tuyenDuongBay = new TuyenDuongBay(resultSet.getInt("tuyenDuongBay"));
        this.thoiGianKhoiHanh = resultSet.getTimestamp("thoiGianKhoiHanh");
        this.heSoGio = new HeSoGio(resultSet.getInt("heSoGio"));
        this.heSoNgay = new HeSoNgay(resultSet.getInt("heSoNgay"));
        this.khoitao = resultSet.getTimestamp("khoitao");
    }

    @Override
    public PreparedStatement ptmtUpdate(PreparedStatement ptmt) throws  SQLException{
        //SET
        ptmt.setInt(1,this.getTuyenDuongBay().getId());
        ptmt.setTimestamp(2,this.getThoiGianKhoiHanh());
        ptmt.setInt(3,this.getHeSoGio().getId());
        ptmt.setInt(3,this.getHeSoNgay().getId());
        ptmt.setTimestamp(4,this.getKhoitao());
        // WHERE
        ptmt.setInt(5,this.getId());
        return ptmt;
    }

    @Override
    public PreparedStatement ptmtCreate(PreparedStatement ptmt) throws  SQLException{
        ptmt.setInt(1,this.getTuyenDuongBay().getId());
        ptmt.setTimestamp(2,this.getThoiGianKhoiHanh());
        ptmt.setInt(3,this.getHeSoGio().getId());
        ptmt.setInt(3,this.getHeSoNgay().getId());
        ptmt.setTimestamp(4,this.getKhoitao());

        return ptmt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TuyenDuongBay getTuyenDuongBay() {
        return tuyenDuongBay;
    }

    public void setTuyenDuongBay(TuyenDuongBay tuyenDuongBay) {
        this.tuyenDuongBay = tuyenDuongBay;
    }

    public Timestamp getThoiGianKhoiHanh() {
        return thoiGianKhoiHanh;
    }

    public void setThoiGianKhoiHanh(Timestamp thoiGianKhoiHanh) {
        this.thoiGianKhoiHanh = thoiGianKhoiHanh;
    }

    public HeSoGio getHeSoGio() {
        return heSoGio;
    }

    public void setHeSoGio(HeSoGio heSoGio) {
        this.heSoGio = heSoGio;
    }

    public HeSoNgay getHeSoNgay() {
        return heSoNgay;
    }

    public void setHeSoNgay(HeSoNgay heSoNgay) {
        this.heSoNgay = heSoNgay;
    }

    public Timestamp getKhoitao() {
        return khoitao;
    }

    public void setKhoitao(Timestamp khoitao) {
        this.khoitao = khoitao;
    }

}
