package Model;

import java.io.Serializable;
import java.sql.Timestamp;

public class NguoiDung  implements Serializable {
    private int id;
    private String tennguoidung,password;
    private ThongTinNguoiDung thongTinNguoiDung;
    private Timestamp timestamp;
    private Quyen quyen;
    private TinhTrang tinhTrang;
    private int ndma=1000000;

    public NguoiDung() {
        this.id=ndma++;
    }

    public NguoiDung(int id, String tennguoidung, String password, ThongTinNguoiDung thongTinNguoiDung, Timestamp timestamp, Quyen quyen, TinhTrang tinhTrang) {
        this.id = id;
        this.tennguoidung = tennguoidung;
        this.password = password;
        this.thongTinNguoiDung = thongTinNguoiDung;
        this.timestamp = timestamp;
        this.quyen = quyen;
        this.tinhTrang = tinhTrang;
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

    public ThongTinNguoiDung getThongTinNguoiDung() {
        return thongTinNguoiDung;
    }

    public void setThongTinNguoiDung(ThongTinNguoiDung thongTinNguoiDung) {
        this.thongTinNguoiDung = thongTinNguoiDung;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Quyen getQuyen() {
        return quyen;
    }

    public void setQuyen(Quyen quyen) {
        this.quyen = quyen;
    }

    public TinhTrang getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(TinhTrang tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
}
