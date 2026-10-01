abstract class Toy {
    private static int counter = 1000;
    private final String toyId;

    Toy() {
        toyId = "TOY-" + (++counter);
    }

    public final String getToyId() {
        return toyId;
    }

    public abstract String makeSound();
}

class ToyCar extends Toy {
    private String name;

    ToyCar(String name) {
        this.name = name;
    }

    public String makeSound() {
        return name + ": Vroom vroom!";
    }
}

class ToyRobot extends Toy {
    private String name;

    ToyRobot(String name) {
        this.name = name;
    }

    public String makeSound() {
        return name + ": Beep boop!";
    }
}

public class TalkingToyBox {
    public static void main(String[] args) {
        ToyCar car = new ToyCar("Speedster");
        ToyRobot robot = new ToyRobot("Bolt");

        System.out.println(car.makeSound());
        System.out.println("ID: " + car.getToyId());

        System.out.println(robot.makeSound());
        System.out.println("ID: " + robot.getToyId());
    }
}