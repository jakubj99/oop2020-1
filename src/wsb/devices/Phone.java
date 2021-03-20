package wsb.devices;

import wsb.App;
import wsb.creatures.Human;
import wsb.devices.enums.PhoneSystem;

import java.util.*;

public class Phone extends Device {

    enum OperatingSystem {
        IOS, ANDROID, WINDOWS_MOBILE
    }

    final Double screenSize;
    public List<App> applications;
    private final PhoneSystem phoneSystem;

    public static Phone createIPhone(String model, Double screenSize) {
        return new Phone("Apple", model, screenSize, PhoneSystem.IOS);
    }

    public static Phone createAndroidPhone(String producer, String model, Double screenSize) {
        return new Phone(producer, model, screenSize, PhoneSystem.ANDROID);
    }

    public static Phone createTrashPhone(String producer, String model, Double screenSize) {
        return new Phone(producer, model, screenSize, PhoneSystem.WINDOWS_MOBILE);
    }

    private Phone(String producer, String model, Double screenSize, PhoneSystem phoneSystem) {
        super(producer, model);
        this.screenSize = screenSize;
        this.phoneSystem = phoneSystem;
        applications = new LinkedList<>();
    }

    @Override
    public void turnOn() {
        String systemMessage;
        switch (phoneSystem) {
            case IOS:
                systemMessage = "Apple system message";
                break;
            case ANDROID:
                systemMessage = "Android system message";
                break;
            case WINDOWS_MOBILE:
                systemMessage = "WP system message";
                break;
            default:
                throw new RuntimeException("Phone not detected");
        }
        System.out.println(systemMessage);
    }


    public void sell() {
        System.out.println("already sold");
    }

    public void installAnApp(App app, Human owner) throws Exception {
        if (app.getPrice() > 0) {
            if (owner.cash < app.getPrice()) {
                throw new Exception("not enough money");
            }
            owner.cash -= app.getPrice();
        }
        applications.add(app);
        System.out.println("Application " + app.getName() + " installed");
    }

    public void installAnApp(String name) {
        installAnApp(name, 0.0);
    }


    public void installAnApp(String[] apps) {
        for (String app : apps) {
            installAnApp(app);
        }
    }

    public void installAnApp(String name, Double version) {
        System.out.println("The app " + name + " was installed in version " + version);
    }

    public boolean isInstalled(App app) {
        return applications.contains(app);
    }

    public boolean isInstalled(String appName) {
        for (App application : applications) {
            if (application.getName().equals(appName)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Phone:  " + producer + " " + model;
    }

}
