public class PayrollRegisterSystem {
    static class Payslip {
        String name;
        String type;
        long pay;

        Payslip(String name, String type, long pay) {
            this.name = name;
            this.type = type;
            this.pay = pay;
        }

        @Override
        public String toString() {
            return "Payslip[name=" + name
                + ", type=" + type
                + ", pay=" + pay + "]";
        }
    }

    public static void main(String[] args) {
        Payslip[] payslips = {
            new Payslip("Asha", "FullTime", 50000),
            new Payslip("Ravi", "PartTime", 80L * 300),
            new Payslip("Neha", "Intern", 15000)
        };

        long total = 0;
        Payslip topEarner = payslips[0];

        for (Payslip payslip : payslips) {
            System.out.println(payslip);
            total += payslip.pay;

            if (payslip.pay > topEarner.pay) {
                topEarner = payslip;
            }
        }

        System.out.println("Total " + total);
        System.out.println("top earner " + topEarner.name);
    }
}