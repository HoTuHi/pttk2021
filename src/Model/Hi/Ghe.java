package Model.Hi;

import Model.Nam.MayBay;

import java.io.Serializable;

public class Ghe implements Serializable {
    private MayBay mayBay;
    private int masoghe;
    private String loaighe;

    public Ghe() {
    }

    public Ghe(MayBay mayBay, int masoghe, String loaighe) {
        this.mayBay = mayBay;
        this.masoghe = masoghe;
        this.loaighe = loaighe;
    }

    public MayBay getMayBay() {
        return mayBay;
    }

    public void setMayBay(MayBay mayBay) {
        this.mayBay = mayBay;
    }

    public int getMasoghe() {
        return masoghe;
    }

    public void setMasoghe(int masoghe) {
        this.masoghe = masoghe;
    }

    public String getLoaighe() {
        return loaighe;
    }

    public void setLoaighe(String loaighe) {
        this.loaighe = loaighe;
    }
    public Object[] toObject(){
        return new Object[]{ mayBay.getId(),masoghe,loaighe};
    }
}
