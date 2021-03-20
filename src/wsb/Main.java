package wsb;

import wsb.devices.Car;
import wsb.devices.DieselCar;
import wsb.devices.ElectricCar;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {


    public static void main(String[] args) {
        Map<String, Car> modelCarMap = new HashMap<>(Stream.of(
                new DieselCar("Mercedes", "G350d", 2020, 3.0),
                new ElectricCar("Porsche", "Taycan", 2021),
                new ElectricCar("Tesla", "3", 2020)
        ).collect(Collectors.toMap(Car::getModel, car -> car)));

        modelCarMap.keySet().stream()
                .sorted(Comparator.comparing(key -> key))
                .forEach(key -> System.out.println(modelCarMap.get(key)));

    }
}
