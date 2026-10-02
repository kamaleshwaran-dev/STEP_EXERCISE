interface PaymentMethod {
    boolean pay(double amount);
}

class CreditCard implements PaymentMethod {

    public boolean pay(double amount) {
        System.out.println(
            "Paid by Credit Card: ₹" + amount
        );
        return true;
    }
}

class PayPal implements PaymentMethod {

    public boolean pay(double amount) {
        System.out.println(
            "Paid by PayPal: ₹" + amount
        );
        return true;
    }
}

class BankTransfer implements PaymentMethod {

    public boolean pay(double amount) {
        System.out.println(
            "Paid by Bank Transfer: ₹" + amount
        );
        return true;
    }
}

class Product {
    String name;
    double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class Order {

    java.util.List<Product> products =
        new java.util.ArrayList<>();

    String status = "Pending";

    void addProduct(Product product) {
        products.add(product);
    }

    double total() {
        double total = 0;

        for (Product p : products) {
            total += p.price;
        }

        return total;
    }

    void makePayment(PaymentMethod method) {

        if (products.isEmpty()) {
            System.out.println(
                "Payment blocked: order has no items"
            );
            return;
        }

        if (method.pay(total())) {
            status = "Paid";
        }
    }
}

public class PaymentProcessingShoppingSystem {

    public static void main(String[] args) {

        Order order = new Order();

        order.makePayment(
            new CreditCard()
        );

        order.addProduct(
            new Product("Book", 500)
        );

        order.addProduct(
            new Product("Pen", 50)
        );

        order.makePayment(
            new CreditCard()
        );

        System.out.println(
            "Order status: " +
            order.status
        );
    }
}