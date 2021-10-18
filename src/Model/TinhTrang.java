package Model;

import java.io.Serializable;

public class TinhTrang  implements Serializable {
    private int id;
    private boolean tinhtrang; //True is enable, false is disable;
    private int tma=100;

    public TinhTrang() {
        this.id=tma++;
    }

    public TinhTrang(int id, boolean tinhtrang) {
        this.id = id;
        this.tinhtrang = tinhtrang;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(boolean tinhtrang) {
        this.tinhtrang = tinhtrang;
    }

    public int getTma() {
        return tma;
    }

    public void setTma(int tma) {
        this.tma = tma;
    }
}
