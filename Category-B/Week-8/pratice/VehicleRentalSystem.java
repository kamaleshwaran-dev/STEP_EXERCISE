abstract class Vehicle {
    String id;
    boolean available = true;

    Vehicle(String id) {
        this.id = id;
    }

    public abstract int getPrice();
}

class Sedan extends Vehicle {
    Sedan(String id) {
        super(id);
    }

    public int getPrice() {
        return 1500;
    }
}

class SUV extends Vehicle {
    SUV(String id) {
        super(id);
    }

    public int getPrice() {
        return 2500;
    }
}

class Truck extends Vehicle {
    Truck(String id) {
        super(id);
    }

    public int getPrice() {
        return 3500;
    }
}

class Customer {
    String name;

    Customer(String name) {
        this.name = name;
    }
}

class Rental {
    Vehicle vehicle;
    Customer customer;
    int days;

    Rental(
        Vehicle vehicle,
        Customer customer,
        int days
    ) {
        this.vehicle = vehicle;
        this.customer = customer;
        this.days = days;
    }

    int total() {
        return vehicle.getPrice() * days;
    }
}

public class VehicleRentalSystem {

    static Rental rent(
        Vehicle vehicle,
        Customer customer,
        int days
    ) {

        if (!vehicle.available) {
            System.out.println(
                vehicle.id + " is unavailable"
            );
            return null;
        }

        vehicle.available = false;

        Rental rental =
            new Rental(vehicle, customer, days);

        System.out.println(
            customer.name +
            " rented " + vehicle.id +
            " for " + days +
            " days: ₹" + rental.total()
        );

        return rental;
    }

    static void returnVehicle(Rental rental) {
        rental.vehicle.available = true;

        System.out.println(
            rental.vehicle.id +
            " returned and available"
        );
    }

    public static void main(String[] args) {

        Vehicle car = new Sedan("S1");

        Customer asha =
            new Customer("Asha");

        Rental rental =
            rent(car, asha, 2);

        rent(
            car,
            new Customer("Ravi"),
            1
        );

        returnVehicle(rental);
    }
}