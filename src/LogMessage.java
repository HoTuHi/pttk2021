public class LogMessage {
    public LogMessage(boolean b, String tblName) {
        if (b==true){
            System.out.println("success at "+tblName);
        }
        else {
            System.out.println("failed at "+tblName);
        }
    }

}
