package wsb;

import wsb.threads.Subzero;
import wsb.threads.Scorpion;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        new Thread(new Scorpion()).start();
        new Thread(new Subzero()).start();
    }
}



