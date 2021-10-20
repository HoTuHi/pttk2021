package Model;

import java.io.Serializable;

public class DiaChi implements Serializable {
    int id;
    String xa,huyen,tinh,quocgia;
    int dma=10001;
    public DiaChi(){
        this.id=dma++;
    }
    public DiaChi(int id,String xa,String huyen,String tinh,String quocgia){
        this.id=id;
        this.xa=xa;
        this.huyen=huyen;
        this.tinh=tinh;
        this.quocgia=quocgia;
    }
    
}