package DAO.testDAO;

import DAO.Hi.TuyenDuongBayDAO;
import Model.Hi.DiaChi;
import Model.Hi.TuyenDuongBay;

public class testTuyenDuongBayDAO {
    public static void main(String[] args) {
        TuyenDuongBayDAO tuyenDuongBayDAO = new TuyenDuongBayDAO();
        for (Object i : tuyenDuongBayDAO.gellAll()) {
            if(i instanceof TuyenDuongBay){
                System.out.println(i.toString());
            }
        }
        TuyenDuongBay tuyenDuongBay= new TuyenDuongBay();
        tuyenDuongBayDAO.create(tuyenDuongBay);
        TuyenDuongBay tuyenDuongBay1 = (TuyenDuongBay) tuyenDuongBayDAO.read(2);
        System.out.println(tuyenDuongBay1.toString());
//        tuyenDuongBayDAO.delete(tuyenDuongBay);
    }
}
