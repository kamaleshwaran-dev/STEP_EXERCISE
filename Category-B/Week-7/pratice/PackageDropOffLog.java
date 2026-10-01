abstract class DeliveryNote {
    protected String trackingNumber;

    DeliveryNote(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public abstract String confirmDelivery();

    public String confirmDelivery(String signature) {
        return confirmDelivery()
                + " | Signed by: " + signature;
    }
}

class ParcelNote extends DeliveryNote {
    ParcelNote(String trackingNumber) {
        super(trackingNumber);
    }

    public String confirmDelivery() {
        return "Parcel " + trackingNumber + " delivered";
    }
}

class LetterNote extends DeliveryNote {
    LetterNote(String trackingNumber) {
        super(trackingNumber);
    }

    public String confirmDelivery() {
        return "Letter " + trackingNumber + " delivered";
    }
}

public class PackageDropOffLog {

    public static void logAll(DeliveryNote[] notes) {
        for (DeliveryNote note : notes) {
            System.out.println(note.confirmDelivery());
        }
    }

    public static void main(String[] args) {
        ParcelNote parcel = new ParcelNote("TRK-1");
        LetterNote letter = new LetterNote("TRK-2");

        System.out.println(parcel.confirmDelivery());
        System.out.println(parcel.confirmDelivery("Asha"));

        logAll(new DeliveryNote[]{parcel, letter});
    }
}