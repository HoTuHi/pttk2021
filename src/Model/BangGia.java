package Model;

import java.io.Serializable;

public class BangGia implements Serializable {
    private int id;
    private float phothongtietkiem;
    private float phothongtieuchuan;
    private float thuonggiatieuchuan;
    private float thuonggiacaocap;
    private static int bma=10000;

    public BangGia() {
        this.id=bma++;
    }

    public BangGia(int id, float phothongtietkiem, float phothongtieuchuan, float thuonggiatieuchuan, float thuonggiacaocap) {
        this.id = id;
        this.phothongtietkiem = phothongtietkiem;
        this.phothongtieuchuan = phothongtieuchuan;
        this.thuonggiatieuchuan = thuonggiatieuchuan;
        this.thuonggiacaocap = thuonggiacaocap;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPhothongtietkiem() {
        return phothongtietkiem;
    }

    public void setPhothongtietkiem(float phothongtietkiem) {
        this.phothongtietkiem = phothongtietkiem;
    }

    public float getPhothongtieuchuan() {
        return phothongtieuchuan;
    }

    public void setPhothongtieuchuan(float phothongtieuchuan) {
        this.phothongtieuchuan = phothongtieuchuan;
    }

    public float getThuonggiatieuchuan() {
        return thuonggiatieuchuan;
    }

    public void setThuonggiatieuchuan(float thuonggiatieuchuan) {
        this.thuonggiatieuchuan = thuonggiatieuchuan;
    }

    public float getThuonggiacaocap() {
        return thuonggiacaocap;
    }

    public void setThuonggiacaocap(float thuonggiacaocap) {
        this.thuonggiacaocap = thuonggiacaocap;
    }

    public static int getBma() {
        return bma;
    }

    public static void setBma(int bma) {
        BangGia.bma = bma;
    }
}
