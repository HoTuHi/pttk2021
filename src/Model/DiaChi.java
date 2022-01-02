package Model;

import Model.model;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DiaChi implements Serializable, model {
    private  int id;
    private String xa,huyen,tinh,quocgia;
    public DiaChi(int id,String xa,String huyen,String tinh,String quocgia){
        this.id=id;
        this.xa=xa;
        this.huyen=huyen;
        this.tinh=tinh;
        this.quocgia=quocgia;
    }

    public DiaChi() {
    }

    public DiaChi(int id) {
        this.id = id;
    }

    @Override
    public void resultMap(ResultSet resultSet) throws SQLException {
        this.id=resultSet.getInt("id");
        this.xa=resultSet.getString("xa");
        this.huyen=resultSet.getString("huyen");
        this.tinh=resultSet.getString("tinh");
        this.quocgia=resultSet.getString("quocgia");
    }

    @Override
    public PreparedStatement ptmtUpdate(PreparedStatement ptmt) throws SQLException {
        //SET
        ptmt.setString(1,this.getXa());
        ptmt.setString(2,this.getHuyen());
        ptmt.setString(3,this.getTinh());
        ptmt.setString(4,this.getQuocgia());
        //WHERE
        ptmt.setInt(5,this.getId());
        return ptmt;
    }

    @Override
    public PreparedStatement ptmtCreate(PreparedStatement ptmt) throws SQLException {
        // create
        ptmt.setString(1,this.getXa());
        ptmt.setString(2,this.getHuyen());
        ptmt.setString(3,this.getTinh());
        ptmt.setString(4,this.getQuocgia());
        return ptmt;
    }

    public int getId() {
        return id;
    }

    public String getXa() {
        return xa;
    }

    public String getHuyen() {
        return huyen;
    }

    public String getTinh() {
        return tinh;
    }

    public String getQuocgia() {
        return quocgia;
    }
    public String toString(){
        return  this.getId()+" | "+this.getXa()+" | "+this.getHuyen()+ " | "+this.getTinh()+" | "+this.getQuocgia();
    }

}
