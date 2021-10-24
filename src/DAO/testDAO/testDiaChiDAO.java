package DAO.testDAO;

import DAO.DiaChiDAO;
import Model.DiaChi;

import java.sql.SQLException;

public class testDiaChiDAO {
    public static void main(String[] args) throws SQLException {
        DiaChiDAO diaChiDAO = new DiaChiDAO();
        // getAll- done
        for (DiaChi i : diaChiDAO.gellAll()) {
            System.out.println(i.toString());
        }
        //Create
        DiaChi d = new DiaChi(5, "12", "12", "12", "123");
        diaChiDAO.create(d);
        System.out.println(d.toString());
        // read by id - done
        DiaChi x = (DiaChi) diaChiDAO.read(2);
        System.out.println(x.toString());
        //delete
        diaChiDAO.delete(d);
        //update
        diaChiDAO.update(new DiaChi(57, "thinh son", "tien du", "bacNinh", "NgheAn"));
    }
}
