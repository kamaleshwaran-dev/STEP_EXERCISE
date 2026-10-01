interface Printable {
    String printLabel();
}

class PackageBox implements Printable {
    private String trackingNumber;

    PackageBox(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String printLabel() {
        return "Package label: " + trackingNumber;
    }
}

class Invoice implements Printable {
    private String invoiceNumber;

    Invoice(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String printLabel() {
        return "Invoice label: " + invoiceNumber;
    }
}

public class WarehouseLabelPrinter {
    public static void printAll(Printable[] items) {
        for (Printable item : items) {
            System.out.println(item.printLabel());
        }
    }

    public static void main(String[] args) {
        Printable[] items = {
            new PackageBox("TRK-88"),
            new Invoice("INV-42")
        };

        printAll(items);
    }
}