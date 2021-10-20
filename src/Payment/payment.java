package Payment;
import java.util.Random;

// return random result
public class payment {
    public boolean itOk(int hoaDon) {
        Random rand = new Random();
        // a number between [0 - 149].
        int n = rand.nextInt(150);
        if (n % 3 == 0) {
            return false;
        }
        return true;
    }
}
