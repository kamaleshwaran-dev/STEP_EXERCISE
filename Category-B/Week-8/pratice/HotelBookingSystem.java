abstract class Room {
    String number;
    boolean available = true;

    Room(String number) {
        this.number = number;
    }

    public abstract int getPrice();
}

class StandardRoom extends Room {
    StandardRoom(String number) {
        super(number);
    }

    public int getPrice() {
        return 2000;
    }
}

class DeluxeRoom extends Room {
    DeluxeRoom(String number) {
        super(number);
    }

    public int getPrice() {
        return 3500;
    }
}

class SuiteRoom extends Room {
    SuiteRoom(String number) {
        super(number);
    }

    public int getPrice() {
        return 5000;
    }
}

class Customer {
    String name;

    Customer(String name) {
        this.name = name;
    }
}

class Reservation {
    Customer customer;
    Room room;
    int days;

    Reservation(
        Customer customer,
        Room room,
        int days
    ) {
        this.customer = customer;
        this.room = room;
        this.days = days;
    }

    int total() {
        return room.getPrice() * days;
    }

    void cancel() {
        room.available = true;

        System.out.println(
            "Reservation cancelled for " +
            customer.name
        );
    }
}

public class HotelBookingSystem {

    static Reservation book(
        Customer customer,
        Room room,
        int days
    ) {

        if (!room.available) {
            System.out.println(
                "Room " +
                room.number +
                " unavailable"
            );
            return null;
        }

        room.available = false;

        Reservation r =
            new Reservation(
                customer,
                room,
                days
            );

        System.out.println(
            customer.name +
            " booked " +
            room.number +
            " for " +
            days +
            " days: ₹" +
            r.total()
        );

        return r;
    }

    public static void main(String[] args) {

        Customer asha =
            new Customer("Asha");

        Room room =
            new DeluxeRoom("D101");

        Reservation r =
            book(asha, room, 2);

        book(
            new Customer("Ravi"),
            room,
            1
        );

        r.cancel();
    }
}