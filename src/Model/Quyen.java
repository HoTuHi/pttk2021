package Model;

import java.io.Serializable;

public class Quyen  implements Serializable {
    private int id;
    private int quyen; //0 is admin,1 is Manager,2 is staff,3 is client
    private int qma=100;

    public Quyen() {
        this.id=qma++;
    }

    public Quyen(int id, int quyen) {
        this.id = id;
        this.quyen = quyen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuyen() {
        return quyen;
    }

    public void setQuyen(int quyen) {
        this.quyen = quyen;
    }

    public int getQma() {
        return qma;
    }

    public void setQma(int qma) {
        this.qma = qma;
    }
}
