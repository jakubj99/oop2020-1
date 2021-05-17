package wsb;

import wsb.creatures.Animal;
import wsb.creatures.FarmAnimal;
import wsb.creatures.Human;
import wsb.creatures.Pet;
import wsb.creatures.enums.Gender;
import wsb.threads.Task9a;

import java.sql.SQLException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        new Thread(new Task9a()).start();
        new Thread(new Task9a()).start();
        new Thread(new Task9a()).start();
    }
}



