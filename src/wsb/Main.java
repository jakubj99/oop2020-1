package wsb;

import java.util.AbstractMap;
import java.util.Map;
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

    }
}

