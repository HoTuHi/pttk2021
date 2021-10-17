package Model;

import java.io.Serializable;

public class Quyen  implements Serializable {
    int id;
    int quyen;
    int qma=10000;
    public Quyen(){
        this.id=qma++;
    }
    public Quyen(int id,int quyen){
        this.id=id;
        this.quyen=quyen;
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
}
