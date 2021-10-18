package Model;

import java.io.Serializable;

public class HeSoNgay  implements Serializable {
    private int id;
    private float heso;
    private String ghichu;
    private static int nma=1000;

    public HeSoNgay() {
        this.id=nma++;
    }

    public HeSoNgay(int id, float heso, String ghichu) {
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

    public static int getNma() {
        return nma;
    }

    public static void setNma(int nma) {
        HeSoNgay.nma = nma;
    }
}
