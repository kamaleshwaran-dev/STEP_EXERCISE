interface Seat {
    int getPrice();
}

class RegularSeat implements Seat {
    public int getPrice() {
        return 150;
    }
}

class PremiumSeat implements Seat {
    public int getPrice() {
        return 250;
    }
}

class ReclinerSeat implements Seat {
    public int getPrice() {
        return 400;
    }
}

class Customer {
    String name;

    Customer(String name) {
        this.name = name;
    }
}

class Show {
    java.util.Map<String, Seat> seats =
        new java.util.HashMap<>();

    java.util.Set<String> booked =
        new java.util.HashSet<>();

    void addSeat(String id, Seat seat) {
        seats.put(id, seat);
    }

    void book(Customer customer, String[] ids) {

        for (String id : ids) {
            if (booked.contains(id)) {
                System.out.println(
                    customer.name +
                    " blocked on " + id
                );
                return;
            }
        }

        int total = 0;

        for (String id : ids) {
            booked.add(id);
            total += seats.get(id).getPrice();
        }

        System.out.println(
            customer.name +
            " booked " +
            String.join(", ", ids) +
            " total ₹" + total
        );
    }

    void cancel(String[] ids) {
        for (String id : ids) {
            booked.remove(id);
        }

        System.out.println(
            "Cancelled: " +
            String.join(", ", ids)
        );
    }
}

public class CampusPremiereTicketCounter {
    public static void main(String[] args) {

        Customer asha = new Customer("Asha");
        Customer ravi = new Customer("Ravi");
        Customer neha = new Customer("Neha");

        Show show = new Show();

        show.addSeat("A1", new RegularSeat());
        show.addSeat("A2", new RegularSeat());
        show.addSeat("F5", new PremiumSeat());
        show.addSeat("R1", new ReclinerSeat());

        show.book(
            asha,
            new String[]{"A1", "A2", "F5"}
        );

        show.book(
            ravi,
            new String[]{"A2"}
        );

        show.book(
            ravi,
            new String[]{"R1"}
        );

        show.cancel(
            new String[]{"A1", "A2", "F5"}
        );

        show.book(
            neha,
            new String[]{"A2"}
        );
    }
}