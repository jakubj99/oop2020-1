package wsb;

import wsb.devices.*;

public class Main {
    public static void main(String[] args) {

        Car ford = new DieselCar("VW", "Polo", 2019, 2.0);
        ford.startACar();
        ford.stopACar();
    }
}

