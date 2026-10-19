import java.util.HashMap;
import java.util.Map;

public class CampusVehiclePassSystem {
    interface Chargeable {
    }

    static class Vehicle {
        String pass;
        String owner;
        String type;
        int fee;

        Vehicle(String pass, String owner, String type, int fee) {
            this.pass = pass;
            this.owner = owner;
            this.type = type;
            this.fee = fee;
        }
    }

    static class Bike extends Vehicle {
        Bike(String pass, String owner) {
            super(pass, owner, "Bike", 300);
        }
    }

    static class Car extends Vehicle {
        Car(String pass, String owner) {
            super(pass, owner, "Car", 1000);
        }
    }

    static class ECar extends Vehicle implements Chargeable {
        ECar(String pass, String owner) {
            super(pass, owner, "ECar", 1000);
        }
    }

    static class EBike extends Vehicle implements Chargeable {
        EBike(String pass, String owner) {
            super(pass, owner, "EBike", 300);
        }
    }

    static void charge(Map<String, Vehicle> vehicles, String pass) {
        Vehicle vehicle = vehicles.get(pass);

        if (vehicle == null) {
            System.out.println("Account not found");
        } else if (vehicle instanceof Chargeable) {
            System.out.println(pass + " charging bay allotted");
        } else {
            System.out.println(pass + " rejected: charging unsupported");
        }
    }

    public static void main(String[] args) {
        Map<String, Vehicle> vehicles = new HashMap<>();

        Vehicle bike = new Bike("KA01", "Asha");
        Vehicle eCar = new ECar("KA02", "Ravi");

        vehicles.put(bike.pass, bike);
        vehicles.put(eCar.pass, eCar);

        System.out.println(
            bike.pass + " (" + bike.type + ") pass fee " + bike.fee
        );
        System.out.println(
            eCar.pass + " (" + eCar.type + ") pass fee " + eCar.fee
        );

        charge(vehicles, "KA02");
        charge(vehicles, "KA01");
    }
}