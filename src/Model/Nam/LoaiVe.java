package Model.Nam;

import java.io.Serializable;

public class LoaiVe  implements Serializable {
    private int id;
    private String ten;
    private static int lma=100;

    public LoaiVe() {
        this.id=lma++;
    }

    public LoaiVe(int id, String ten) {
        this.id = id;
        this.ten = ten;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public static int getLma() {
        return lma;
    }

    public static void setLma(int lma) {
        LoaiVe.lma = lma;
    }
    public Object[] toObjects(){
        return new Object[]{id,ten};
    }
}
