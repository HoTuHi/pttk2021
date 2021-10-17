package Model;

import java.io.Serializable;

public class TinhTrang  implements Serializable {
    int id;
    boolean tinhtrang;
    int tma=1000;
    public TinhTrang(){
        this.id=tma++;
    }
    public TinhTrang(int id,boolean tinhtrang){
        this.id=id;
        this.boolean=boolean;
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
}
