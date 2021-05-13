package wsb.devices;

import wsb.creatures.Human;
import wsb.Soldable;

public abstract class Car extends Device implements Soldable, Comparable<Car> {
    public final Integer yearOfProduction;
    public final Double sizeOfAnEngine;
    public String plates;
    private Engine engine;

    public Car(String producer, String model, Integer yearOfProduction, Double sizeOfAnEngine) {
        super(producer, model);
        this.yearOfProduction = yearOfProduction;
        this.sizeOfAnEngine = sizeOfAnEngine;
        this.engine = new Engine(150d, sizeOfAnEngine, 0d);
    }

    abstract public void refuel();

    @Override
    public void turnOn() {
        System.out.println("car is switched on");
        startACar();
    }

    public void stopACar() {
        engine.turnOff();
    }

    public void startACar() {
        engine.turnOn();
    }

    public String toString() {
        return this.producer + " " + this.model + " " + this.plates;
    }
    @Override
    public int compareTo(Car otherCar) {
        return this.yearOfProduction - otherCar.yearOfProduction;
    }
    @Override
    public void sell(Human buyer, Human seller, Double price) throws Exception {
        if(!seller.hasACar(this)){
            throw new Exception("seller don't have a car");
        }
        if(!buyer.hasAFreePlace()){
            throw new Exception("buyer dont have a car");
        }
        if(buyer.cash < price){
            throw new Exception("exception");
        }
        buyer.removeCar(this);
        seller.addCar(this);
        buyer.cash -= price;
        seller.cash += price;
        System.out.println("great success");
    }

    private static class Engine {

        private boolean isOn;
        private Double horsePower;
        private Double millage;
        private Double volume;

        public Engine(Double horsePower, Double millage, Double volume) {
            this.horsePower = horsePower;
            this.millage = millage;
            this.volume = volume;
        }

        public void turnOn() {
            isOn = true;
            System.out.println("engine starts");
        }

        public void turnOff() {
            isOn = false;
            System.out.println("engine stops");
        }
    }

}