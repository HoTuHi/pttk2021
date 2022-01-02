import java.io.File;
import java.sql.SQLException;

public class main {
    public static void main(String[] args) throws SQLException {
        File file = null;
        boolean isCreat = false;
        try{

            file = new File("C:\\Users\\Admin\\IdeaProjects\\pttk2021\\src\\View\\login.jsp");
            isCreat = file.createNewFile();
            if (isCreat)
                System.out.print("Da tao file thanh cong!");
            else
                System.out.print("Tao file that bai");
            //file.delete();
        }
        catch (Exception e){
            System.out.print(e);
        }
    }
}
