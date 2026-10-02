class Student {
    String name;

    Student(String name) {
        this.name = name;
    }
}

interface WashType {
    String getName();
    int getCharge();
}

class QuickWash implements WashType {
    public String getName() {
        return "Quick";
    }

    public int getCharge() {
        return 20;
    }
}

class NormalWash implements WashType {
    public String getName() {
        return "Normal";
    }

    public int getCharge() {
        return 30;
    }
}

class HeavyWash implements WashType {
    public String getName() {
        return "Heavy";
    }

    public int getCharge() {
        return 45;
    }
}

class WashCycle {
    Student student;
    WashType type;

    WashCycle(Student student, WashType type) {
        this.student = student;
        this.type = type;
    }
}

class WashingMachine {
    String id;
    boolean busy;

    WashingMachine(String id) {
        this.id = id;
    }

    void start(WashCycle cycle) {
        if (busy) {
            System.out.println(
                cycle.student.name +
                " blocked on busy " + id
            );
            return;
        }

        busy = true;

        System.out.println(
            cycle.student.name + " " +
            cycle.type.getName() +
            " on " + id +
            " ₹" + cycle.type.getCharge()
        );
    }

    void complete() {
        busy = false;
        System.out.println(id + " completed/free");
    }
}

public class HostelLaundryQueue {
    public static void main(String[] args) {

        Student asha = new Student("Asha");
        Student ravi = new Student("Ravi");
        Student neha = new Student("Neha");

        WashingMachine m1 =
            new WashingMachine("M1");

        WashingMachine m2 =
            new WashingMachine("M2");

        m1.start(
            new WashCycle(asha, new QuickWash())
        );

        m1.start(
            new WashCycle(ravi, new HeavyWash())
        );

        m2.start(
            new WashCycle(ravi, new HeavyWash())
        );

        m1.complete();

        m1.start(
            new WashCycle(neha, new NormalWash())
        );
    }
}