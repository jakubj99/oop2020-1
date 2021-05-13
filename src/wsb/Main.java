package wsb;

import wsb.devices.*;

public class Main {
    public static void main(String[] args) {
        Car car = new DieselCar("VW", "Polo", 2019, 2.0);
        car.startACar();
        car.stopACar();
    }
}

