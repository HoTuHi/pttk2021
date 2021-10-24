package Model;

import java.io.Serializable;
import java.sql.Timestamp;

public class NguoiDung  implements Serializable {
    private int id;
    private String tennguoidung,password;
    private boolean tinhTrang;
    private ThongTinNguoiDung thongTinNguoiDung;
    private Timestamp timestamp;
    private Quyen quyen;
    private static int ndma=1000000;

    public NguoiDung() {
        this.id=ndma++;
    }

    public NguoiDung(int id, String tennguoidung, String password, ThongTinNguoiDung thongTinNguoiDung, Timestamp timestamp, Quyen quyen, boolean tinhTrang) {
        this.id = id;
        this.tennguoidung = tennguoidung;
        this.password = password;
        this.thongTinNguoiDung = thongTinNguoiDung;
        this.timestamp = timestamp;
        this.quyen = quyen;
        this.tinhTrang = tinhTrang;
    }

    public static int getNdma() {
        return ndma;
    }

    public static void setNdma(int ndma) {
        NguoiDung.ndma = ndma;
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

    public boolean getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
}
