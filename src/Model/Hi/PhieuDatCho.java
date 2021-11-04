package Model.Hi;

import Model.Hi.Ghe;
import Model.Hi.MayBay;
import Model.Nam.Ve;
import Model.model;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class PhieuDatCho  implements Serializable, model {
    int id;
    Ve ve;
    MayBay mayBay;
    Ghe ghe;
    Timestamp khoiTao;

    public PhieuDatCho() {
    }

    public PhieuDatCho(int id) {
        this.id = id;
    }

    public PhieuDatCho(int id, Ve ve, MayBay mayBay, Ghe ghe, Timestamp khoiTao) {
        this.id = id;
        this.ve = ve;
        this.mayBay = mayBay;
        this.ghe = ghe;
        this.khoiTao = khoiTao;
    }

    @Override
    public void resultMap(ResultSet resultSet) throws SQLException {
        this.id = resultSet.getInt("id");
        this.ve = new Ve(resultSet.getInt("ve"));
        this.mayBay = new MayBay(resultSet.getInt("mayBay"));
        this.ghe = new Ghe(resultSet.getInt("ghe"));
        this.khoiTao = resultSet.getTimestamp("khoiTao");
    }

    @Override
    public PreparedStatement ptmtUpdate(PreparedStatement ptmt) throws SQLException {
        ptmt.setInt(1,this.getVe().getId());
        ptmt.setInt(2,this.getMayBay().getId());
        ptmt.setInt(3,this.getGhe().getId());
        ptmt.setTimestamp(4,this.getKhoiTao());
        //WHERE
        ptmt.setInt(5,this.getId());
        return ptmt;
    }

    @Override
    public PreparedStatement ptmtCreate(PreparedStatement ptmt) throws SQLException {
        ptmt.setInt(1,this.getVe().getId());
        ptmt.setInt(2,this.getMayBay().getId());
        ptmt.setInt(3,this.getGhe().getId());
        ptmt.setTimestamp(4,this.getKhoiTao());
        return ptmt;
    }

    @Override
    public String toString() {
        return "PhieuDatCho{" +
                "id=" + id +
                ", ve=" + ve +
                ", mayBay=" + mayBay +
                ", ghe=" + ghe +
                ", khoiTao=" + khoiTao +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Ve getVe() {
        return ve;
    }

    public void setVe(Ve ve) {
        this.ve = ve;
    }

    public MayBay getMayBay() {
        return mayBay;
    }

    public void setMayBay(MayBay mayBay) {
        this.mayBay = mayBay;
    }

    public Ghe getGhe() {
        return ghe;
    }

    public void setGhe(Ghe ghe) {
        this.ghe = ghe;
    }

    public Timestamp getKhoiTao() {
        return khoiTao;
    }

    public void setKhoiTao(Timestamp khoiTao) {
        this.khoiTao = khoiTao;
    }
}
