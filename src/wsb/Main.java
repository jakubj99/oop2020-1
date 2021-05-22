package wsb;

import wsb.threads.Finisher;
import wsb.threads.Task9a;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        new Thread(new Task9a(() -> System.out.println("Scorpion"))).start();
        new Thread(new Task9a(() -> System.out.println("Sub Zero"))).start();
    }
}



