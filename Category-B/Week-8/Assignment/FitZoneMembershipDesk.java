interface MembershipPlan {
    double calculateFee();
}

class MonthlyPlan implements MembershipPlan {
    public double calculateFee() {
        return 1000;
    }
}

class QuarterlyPlan implements MembershipPlan {
    public double calculateFee() {
        return 2700;
    }
}

class AnnualPlan implements MembershipPlan {
    public double calculateFee() {
        return 9000;
    }
}

class Membership {

    enum Status {
        ACTIVE, FROZEN, EXPIRED
    }

    MembershipPlan plan;
    Status status = Status.ACTIVE;

    Membership(MembershipPlan plan) {
        this.plan = plan;
    }

    void freeze() {
        if (status == Status.ACTIVE) {
            status = Status.FROZEN;
            System.out.println("Membership frozen");
        }
    }

    void unfreeze() {
        if (status == Status.FROZEN) {
            status = Status.ACTIVE;
            System.out.println("Membership active");
        }
    }

    void checkIn(String name) {
        if (status == Status.ACTIVE) {
            System.out.println(name + " checked in");
        } else {
            System.out.println(
                name + " cannot check in: " + status
            );
        }
    }
}

public class FitZoneMembershipDesk {
    public static void main(String[] args) {

        Membership monthly =
            new Membership(new MonthlyPlan());

        Membership quarterly =
            new Membership(new QuarterlyPlan());

        Membership annual =
            new Membership(new AnnualPlan());

        System.out.println(
            "Monthly fee: ₹" +
            monthly.plan.calculateFee()
        );

        System.out.println(
            "Quarterly fee: ₹" +
            quarterly.plan.calculateFee()
        );

        System.out.println(
            "Annual fee: ₹" +
            annual.plan.calculateFee()
        );

        monthly.checkIn("Asha");
        monthly.freeze();
        monthly.checkIn("Asha");
        monthly.unfreeze();
        monthly.checkIn("Asha");
    }
}