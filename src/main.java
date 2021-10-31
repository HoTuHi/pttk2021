import Model.Hi.DiaChi;

import java.sql.SQLException;

public class main {
    public static void main(String[] args) throws SQLException {
        // make a connection for all.

        // example
        DiaChiDAO diaChiDAO = new DiaChiDAO();
//        for (DiaChi i : diaChiDAO.gellAll()) {
//            System.out.println(i.getId() + i.getXa());
//        }
//        DiaChi d = new DiaChi(5, "12", "12", "12", "123");
//        diaChiDAO.create(d);
//        for (DiaChi i : diaChiDAO.gellAll()) {
//            System.out.println(i.getId() + i.getXa());
//        }
        DiaChi x = (DiaChi) diaChiDAO.read(2);
        System.out.println(x.getXa()+x.getHuyen());

    }
}
