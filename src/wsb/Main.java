package wsb;

import wsb.creatures.Animal;
import wsb.creatures.FarmAnimal;
import wsb.creatures.Human;
import wsb.creatures.Pet;
import wsb.creatures.enums.Gender;

import java.sql.SQLException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        List<Animal> animals = Arrays.asList(
                new Human(13, 20, Gender.MAN, 55),
                new Pet("York", 0.9),
                new FarmAnimal("George", 120),
                new Human(69, 0, Gender.WOMAN, 46),
                new FarmAnimal("Peppa", 200)
        );
        animals.sort(new Comparator<Animal>() {
            @Override
            public int compare(Animal o1, Animal o2) {
                return Double.compare(o1.getWeight(), o2.getWeight());
            }
        });
        System.out.println(animals);
    }
}



