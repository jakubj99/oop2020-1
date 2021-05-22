package wsb;

import wsb.database.ObjectToSQL;
import wsb.devices.Car;
import wsb.devices.ElectricCar;

public class Main {
    public static void main(String[] args) {
        Car car = new ElectricCar("Tesla", "Model S", 2019);
        ObjectToSQL objectToSql = new ObjectToSQL();
        System.out.println(objectToSql.insert(car));
    }
}


