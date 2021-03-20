package wsb;

import wsb.devices.Device;
import wsb.devices.DieselCar;
import wsb.devices.ElectricCar;
import wsb.devices.Phone;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

    Map<String, Double> countryAreaMap = Stream.of(
            new AbstractMap.SimpleEntry<>("Czech Republic", 75d),
            new AbstractMap.SimpleEntry<>("Germany", 100d),
            new AbstractMap.SimpleEntry<>("Norway", 40d),
            new AbstractMap.SimpleEntry<>("Sweden", 1d),
            new AbstractMap.SimpleEntry<>("Kaczoland", 10d))
            .collect(Collectors.toMap(
                    AbstractMap.SimpleEntry::getKey,
                    AbstractMap.SimpleEntry::getValue));

         System.out.println("Largest country - " + countryAreaMap.entrySet().stream()
                 .max(Map.Entry.comparingByValue())
            .map(Map.Entry::getKey)
                 .orElse(""));



         System.out.println("Smallest country - " + countryAreaMap.entrySet().stream()
                 .min(Map.Entry.comparingByValue())
            .map(Map.Entry::getKey)
                 .orElse(""));


        List<Device> devices = Arrays.asList(
                Phone.createIPhone("7", 4.7),
                Phone.createIPhone("12 pro", 6.1),
                Phone.createTrashPhone("Samsung", "S10", 6.9),
                Phone.createTrashPhone("Samsung", "S20", 7.2)
        );

        Map<String, List<Device>> producerDevicesMap = devices.stream().collect(
                Collectors.groupingBy(Device::getProducer, HashMap::new, Collectors.toCollection(ArrayList::new)));

        System.out.println("Devices produced by Apple :" + producerDevicesMap.get("Apple"));
        System.out.println("Devices produced by Samsung :" + producerDevicesMap.get("Samsung"));

    }
}

