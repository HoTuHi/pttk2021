package Model;

import java.io.Serializable;

public class HeSoGio  implements Serializable {
    private int id;
    private float heso;
    private String ghichu;
    private int hma=100;

    public HeSoGio() {
    }

    public HeSoGio(int id, float heso, String ghichu) {
        this.id = id;
        this.heso = heso;
        this.ghichu = ghichu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getHeso() {
        return heso;
    }

    public void setHeso(float heso) {
        this.heso = heso;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public int getHma() {
        return hma;
    }

    public void setHma(int hma) {
        this.hma = hma;
    }
}
