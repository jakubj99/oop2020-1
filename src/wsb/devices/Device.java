package wsb.devices;

import wsb.database.MapToSQL;

public abstract class Device {
    @MapToSQL
        final public String producer;
    @MapToSQL
        final public String model;
    @MapToSQL
        public Double value;

    public Device(String producer, String model) {
        this.producer = producer;
        this.model = model;
    }

   public abstract void turnOn();

    public String getModel(){
        return this.model;
    }

    public String getProducer() {
        return producer;
    }
}
