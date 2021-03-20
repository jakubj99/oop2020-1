package wsb.creatures;

import wsb.creatures.enums.FoodType;

import java.sql.SQLException;

public class Pet extends Animal {
    public Pet(String species) throws SQLException {
        super(species, FoodType.ALL);
    }
}
