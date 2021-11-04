package Model.Hi;

import Model.Hi.Quyen;
import Model.Hi.ThongTinNguoiDung;
import Model.model;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class NguoiDung implements Serializable, model {
    private int id;
    private String tennguoidung;
    String password;
    private boolean tinhTrang;
    private ThongTinNguoiDung thongTinNguoiDung;
    private Quyen quyen;

    public NguoiDung() {
    }

    public NguoiDung(int id) {
        this.id = id;
    }

    public NguoiDung(int id, String tennguoidung, String password, boolean tinhTrang, ThongTinNguoiDung thongTinNguoiDung, Quyen quyen) {
        this.id = id;
        this.tennguoidung = tennguoidung;
        this.password = password;
        this.tinhTrang = tinhTrang;
        this.thongTinNguoiDung = thongTinNguoiDung;
        this.quyen = quyen;
    }

    @Override
    public void resultMap(ResultSet resultSet) throws SQLException {
        this.id = resultSet.getInt("id");
        this.tennguoidung = resultSet.getString("tennguoidung");
        this.password = resultSet.getString("password");
        this.tinhTrang = resultSet.getBoolean("tinhTrang");
        this.thongTinNguoiDung = new ThongTinNguoiDung(resultSet.getInt("thongTinNguoiDung"));
        this.quyen = new Quyen(resultSet.getInt("quyen"));
    }

    @Override
    public PreparedStatement ptmtUpdate(PreparedStatement ptmt) throws SQLException {
        ptmt.setString(1,this.getTennguoidung());
        ptmt.setString(2,this.getPassword());
        ptmt.setInt(3,this.getThongTinNguoiDung().getId());
        ptmt.setInt(4,this.getQuyen().getId());
        //WHERE
        ptmt.setInt(5,this.getId());
        return ptmt;
    }

    @Override
    public PreparedStatement ptmtCreate(PreparedStatement ptmt) throws SQLException {
        ptmt.setString(1,this.getTennguoidung());
        ptmt.setString(2,this.getPassword());
        ptmt.setInt(3,this.getThongTinNguoiDung().getId());
        ptmt.setInt(4,this.getQuyen().getId());

        return ptmt;
    }

    @Override
    public String toString() {
        return "NguoiDung{" +
                "id=" + id +
                ", tennguoidung='" + tennguoidung + '\'' +
                ", password='" + password + '\'' +
                ", tinhTrang=" + tinhTrang +
                ", thongTinNguoiDung=" + thongTinNguoiDung +
                ", quyen=" + quyen +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTennguoidung() {
        return tennguoidung;
    }

    public void setTennguoidung(String tennguoidung) {
        this.tennguoidung = tennguoidung;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public ThongTinNguoiDung getThongTinNguoiDung() {
        return thongTinNguoiDung;
    }

    public void setThongTinNguoiDung(ThongTinNguoiDung thongTinNguoiDung) {
        this.thongTinNguoiDung = thongTinNguoiDung;
    }

    public Quyen getQuyen() {
        return quyen;
    }

    public void setQuyen(Quyen quyen) {
        this.quyen = quyen;
    }
}
