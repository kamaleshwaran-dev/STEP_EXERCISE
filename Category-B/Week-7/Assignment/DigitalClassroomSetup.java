abstract class ClassroomDevice {
    protected String id;

    ClassroomDevice(String id) {
        this.id = id;
    }

    public abstract String operate();
}

interface Chargeable {
    String charge();
    String charge(int minutes);
}

class Tablet extends ClassroomDevice implements Chargeable {

    Tablet(String id) {
        super(id);
    }

    public String operate() {
        return "Tablet " + id + " displaying lesson";
    }

    public String charge() {
        return id + " charging";
    }

    public String charge(int minutes) {
        return id + " charging for " + minutes + " minutes";
    }
}

public class DigitalClassroomSetup {
    public static void main(String[] args) {
        Tablet tablet = new Tablet("TAB-5");

        System.out.println(tablet.operate());
        System.out.println(tablet.charge());
        System.out.println(tablet.charge(30));
    }
}