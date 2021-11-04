package DAO.testDAO;

import DAO.Roi.TuyenDuongBayDAO;
import Model.Roi.TuyenDuongBay;

public class testTuyenDuongBayDAO {
    public static void main(String[] args) {
        TuyenDuongBayDAO tuyenDuongBayDAO = new TuyenDuongBayDAO();
        for (Object i : tuyenDuongBayDAO.gellAll()) {
            if(i instanceof TuyenDuongBay){
                System.out.println(i.toString());
            }
        }
        TuyenDuongBay tuyenDuongBay1 = (TuyenDuongBay) tuyenDuongBayDAO.read(2);
        System.out.println(tuyenDuongBay1.toString());
        tuyenDuongBay1.setId(12);
        tuyenDuongBay1.setPhoThongTietKiem(12);
        TuyenDuongBay tuyenDuongBay= null;
        tuyenDuongBay= tuyenDuongBay1;
        tuyenDuongBayDAO.create(tuyenDuongBay);
//        tuyenDuongBayDAO.delete(tuyenDuongBay);
    }
}
