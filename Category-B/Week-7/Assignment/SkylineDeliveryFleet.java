abstract class Drone {
    protected String id;

    Drone(String id) {
        this.id = id;
    }

    public String fly() {
        return id + " flying";
    }
}

interface Trackable {
    String getLocation();
}

class DeliveryDrone extends Drone implements Trackable {
    private String location;

    DeliveryDrone(String id, String location) {
        super(id);
        this.location = location;
    }

    public String getLocation() {
        return location;
    }
}

class ScoutDrone extends Drone {
    ScoutDrone(String id) {
        super(id);
    }
}

class GroundRobot implements Trackable {
    private String location;

    GroundRobot(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }
}

public class SkylineDeliveryFleet {

    public static String getLocationIfTrackable(Object obj) {
        if (obj instanceof Trackable) {
            Trackable t = (Trackable) obj;
            return t.getLocation();
        }

        return "Tracking not available";
    }

    public static void main(String[] args) {
        DeliveryDrone d =
            new DeliveryDrone("D-1", "Gate A");

        ScoutDrone s =
            new ScoutDrone("S-1");

        GroundRobot r =
            new GroundRobot("Warehouse B");

        System.out.println(getLocationIfTrackable(d));
        System.out.println(getLocationIfTrackable(s));
        System.out.println(getLocationIfTrackable(r));
    }
}