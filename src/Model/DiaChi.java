package Model;

import java.io.Serializable;

public class DiaChi implements Serializable {
    private int id;
    private String xa,huyen,tinh,quocgia;
    private int dma=100000;

    public DiaChi() {
        this.id=dma++;
    }

    public DiaChi(int id, String xa, String huyen, String tinh, String quocgia) {
        this.id = id;
        this.xa = xa;
        this.huyen = huyen;
        this.tinh = tinh;
        this.quocgia = quocgia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getXa() {
        return xa;
    }

    public void setXa(String xa) {
        this.xa = xa;
    }

    public String getHuyen() {
        return huyen;
    }

    public void setHuyen(String huyen) {
        this.huyen = huyen;
    }

    public String getTinh() {
        return tinh;
    }

    public void setTinh(String tinh) {
        this.tinh = tinh;
    }

    public String getQuocgia() {
        return quocgia;
    }

    public void setQuocgia(String quocgia) {
        this.quocgia = quocgia;
    }

    public int getDma() {
        return dma;
    }

    public void setDma(int dma) {
        this.dma = dma;
    }
}
