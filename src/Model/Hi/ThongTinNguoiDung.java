package Model.Hi;

import Model.Hi.DiaChi;
import Model.model;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class ThongTinNguoiDung implements Serializable, model {
    private int id;
    private String ho;
    String ten_dem;
    String ten;
    private Timestamp ngaysinh;
    private String email;
    String sdt;
    private Timestamp khoitao;
    private DiaChi diaChi;

    public ThongTinNguoiDung() {
    }

    public ThongTinNguoiDung(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "ThongTinNguoiDung{" +
                "id=" + id +
                ", ho='" + ho + '\'' +
                ", ten_dem='" + ten_dem + '\'' +
                ", ten='" + ten + '\'' +
                ", ngaysinh=" + ngaysinh +
                ", email='" + email + '\'' +
                ", sdt='" + sdt + '\'' +
                ", khoitao=" + khoitao +
                ", diaChi=" + diaChi +
                '}';
    }

    @Override
    public void resultMap(ResultSet resultSet) throws SQLException {
        this.id = resultSet.getInt("id");
        this.ho = resultSet.getString("ho");
        this.ten_dem = resultSet.getString("tendem");
        this.ten = resultSet.getString("ten");
        this.ngaysinh = resultSet.getTimestamp("ngaysinh");
        this.email = resultSet.getString("email");
        this.sdt = resultSet.getString("sdt");
        this.khoitao = resultSet.getTimestamp("khoitao");
        this.diaChi = new DiaChi(resultSet.getInt("diaChi"));
    }

    @Override
    public PreparedStatement ptmtUpdate(PreparedStatement ptmt) throws SQLException {
        //SET
        ptmt.setString(1,this.getHo());
        ptmt.setString(2,this.getTen_dem());
        ptmt.setString(3,this.getTen());
        ptmt.setTimestamp(4,this.getNgaysinh());
        ptmt.setString(5,this.getEmail());
        ptmt.setString(6,this.getSdt());
        ptmt.setTimestamp(7,this.getKhoitao());
        ptmt.setInt(8,this.getDiaChi().getId());
        // WHERE
        ptmt.setInt(9,this.getId());
        return ptmt;
    }

    @Override
    public PreparedStatement ptmtCreate(PreparedStatement ptmt) throws SQLException {
        ptmt.setString(1,this.getHo());
        ptmt.setString(2,this.getTen_dem());
        ptmt.setString(3,this.getTen());
        ptmt.setTimestamp(4,this.getNgaysinh());
        ptmt.setString(5,this.getEmail());
        ptmt.setString(6,this.getSdt());
        ptmt.setTimestamp(7,this.getKhoitao());
        ptmt.setInt(8,this.getDiaChi().getId());

        return ptmt;
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
}
