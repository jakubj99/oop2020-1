package wsb.creatures;

import wsb.creatures.enums.FoodType;
import wsb.creatures.interfaces.Edible;

public class FarmAnimal extends Animal implements Edible {

    public FarmAnimal(String species, double weight) {
        super(species, FoodType.ALL, weight);
    }

    @Override
    public void beEaten() throws Exception {
        this.kill();
        System.out.println("that was yuammy");
    }
}
