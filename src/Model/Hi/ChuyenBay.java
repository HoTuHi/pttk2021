package Model.Hi;

import Model.Nam.LichBay;
import Model.Nam.MayBay;

import java.io.Serializable;
import java.sql.Timestamp;

public class ChuyenBay implements Serializable {
    private int id;
    private MayBay mayBay;
    private LichBay lichBay;
    private Timestamp timestamp;
    private boolean tinhtrang;
    private static int cma=10000;

    public ChuyenBay() {
        this.id=cma++;
    }

    public ChuyenBay(int id, MayBay mayBay, LichBay lichBay,boolean tinhtrang,Timestamp timestamp) {
        this.id = id;
        this.mayBay = mayBay;
        this.lichBay = lichBay;
        this.tinhtrang= tinhtrang;
        this.timestamp=timestamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MayBay getMayBay() {
        return mayBay;
    }

    public void setMayBay(MayBay mayBay) {
        this.mayBay = mayBay;
    }

    public LichBay getLichBay() {
        return lichBay;
    }

    public void setLichBay(LichBay lichBay) {
        this.lichBay = lichBay;
    }

    public boolean isTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(boolean tinhtrang) {
        this.tinhtrang = tinhtrang;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public static int getCma() {
        return cma;
    }

    public static void setCma(int cma) {
        ChuyenBay.cma = cma;
    }

    @Override
    public String toString() {
        return "ChuyenBay{" +
                "id=" + id +
                ", mayBay=" + mayBay +
                ", lichBay=" + lichBay +
                ", timestamp=" + timestamp +
                ", tinhtrang=" + tinhtrang +
                '}';
    }
}
