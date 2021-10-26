package DAO.testDAO;

import DAO.BanggiaDAO;
import Model.BangGia;
import Model.DiaChi;

public class testBanggiaDAO {
    public static void main(String[] args) {
        BanggiaDAO banggiaDAO= new BanggiaDAO();
        for (BangGia i: banggiaDAO.gellAll())
            System.out.println(i);
        //Create
        BangGia b = new BangGia(5, 12, 12, 12, 123);
        banggiaDAO.create(b);
        System.out.println(b.toString());
        // read by id - done
        BangGia bc = (BangGia) banggiaDAO.read(2);
        System.out.println(bc.toString());
        //delete
        banggiaDAO.delete(b);
    }
}
