package wsb.creatures;

import wsb.creatures.enums.FoodType;
import wsb.creatures.interfaces.Feedable;

import java.io.File;
import java.sql.SQLException;

public class Animal implements Feedable, Comparable<Animal> {

    private static Double NEW_DOG_WEIGHT = 4.0;
    private static Double NEW_LION_WEIGHT = 39.2;
    private static Double NEW_OTHER_ANIMAL_WEIGHT = 5.3;
    private static Double DEFAULT_FEED_WEIGHT = 1.0;

    final String species;
    private Double weight;
    public String name;
    private final FoodType foodType;
    File pic;

    public Animal(String species, FoodType foodType, double weight) {
        System.out.println("we created new Animal");
        this.species = species;
        this.foodType = foodType;
        this.weight = weight;
        try {
            this.save();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void feed() {
        feed(DEFAULT_FEED_WEIGHT);
    }

    public void feed(Double foodWeight) {
        if (weight == 0) {
            System.out.println("too late, " + name + " is dead");
        } else {
            weight += foodWeight;
            System.out.println(name + " says thx for food");
        }
    }

    public void takeForAWalk() {
        if (weight == 0.0) {
            System.out.println("you can't walk the street with dead animal you freak");
        } else if (weight > 3.0) {
            --weight;
            System.out.println(name + " says thx for a walk");
        } else if (weight > 1.0) {
            --weight;
            System.out.println(name + " says thx for a walk but I'm hungry");
        } else {
            weight = 0.0;
            System.out.println(name + " died");
        }
    }

//    Double getWeight() {
//        return weight;
//    }
    public Double getWeight() { return weight; }

    protected void kill() {
        System.out.println("byeeeeeeeeeeeeee");
        this.weight = 0.0;
    }

    public String toString() {
        return "Hi I'm an Animal " + this.species + " " + this.name;
    }

    @Override
    public int compareTo(Animal o) {
        return this.species.compareTo(o.species);
    }

    public void save() throws SQLException {
        String sql = "insert into animal values ('" + this.species + "','" + this.name + "'," + this.weight + ");";
        System.out.println(sql);
//        Connector.executeSQL(sql);
    }

    private void eat(Double foodWeight) {
        switch (foodType) {
            case MEAT:
                digest(foodWeight, .7);
                break;
            case CROPS:
                digest(foodWeight, .3d);
                break;
            case ALL:
                digest(foodWeight, .5d);
                break;
            default:
                digest(-foodWeight, .5d);
                break;
        }
    }

    private void digest(Double foodWeight, Double multiplier) {
        weight += foodWeight * multiplier;
    }

}
