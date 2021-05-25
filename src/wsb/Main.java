package wsb;

import wsb.database.ObjectToSQL;
import wsb.devices.Car;
import wsb.devices.DieselCar;
import wsb.devices.ElectricCar;

public class Main {
    public static void main(String[] args) {
        Car car = new ElectricCar("Tesla", "Model S", 2019);
        Car car1 = new DieselCar("Jeep", "wrangler", 1999, 3.2);
        ObjectToSQL objectToSql = new ObjectToSQL();
        System.out.println(objectToSql.insert(car));
        System.out.println(objectToSql.insert(car1));
    }
}


