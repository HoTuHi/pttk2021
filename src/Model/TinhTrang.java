package Model;

import java.io.Serializable;

public class TinhTrang  implements Serializable {
    int id;
    boolean tinhTrang; // true is enable, false is disabled
    int tma=10001;
    public TinhTrang(){
        this.id=tma++;
    }
    public TinhTrang(int id, boolean tinhTrang) {
        this.id = id;
        this.tinhTrang = tinhTrang;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
}
