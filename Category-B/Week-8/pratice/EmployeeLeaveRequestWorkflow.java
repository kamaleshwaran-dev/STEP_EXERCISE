interface LeavePolicy {
    boolean canApprove(int days);
}

class RegularLeavePolicy implements LeavePolicy {

    public boolean canApprove(int days) {
        return days <= 10;
    }
}

class Employee {
    String name;
    LeavePolicy policy;

    Employee(
        String name,
        LeavePolicy policy
    ) {
        this.name = name;
        this.policy = policy;
    }
}

class LeaveRequest {

    enum Status {
        PENDING, APPROVED, REJECTED
    }

    Employee employee;
    int days;
    Status status = Status.PENDING;

    LeaveRequest(
        Employee employee,
        int days
    ) {
        this.employee = employee;
        this.days = days;
    }

    void approve() {

        if (status != Status.PENDING) {
            System.out.println(
                "Request cannot change from " +
                status
            );
            return;
        }

        if (employee.policy.canApprove(days)) {
            status = Status.APPROVED;

            System.out.println(
                employee.name +
                " leave approved"
            );
        } else {
            status = Status.REJECTED;

            System.out.println(
                employee.name +
                " leave rejected"
            );
        }
    }
}

public class EmployeeLeaveRequestWorkflow {

    public static void main(String[] args) {

        Employee asha =
            new Employee(
                "Asha",
                new RegularLeavePolicy()
            );

        LeaveRequest request =
            new LeaveRequest(asha, 5);

        request.approve();

        request.approve();
    }
}