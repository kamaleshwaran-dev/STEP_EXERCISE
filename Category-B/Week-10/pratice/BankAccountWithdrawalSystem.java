import java.util.HashMap;
import java.util.Map;

public class BankAccountWithdrawalSystem {
    static class Account {
        String id;
        String type;
        int balance;

        Account(String id, String type, int balance) {
            this.id = id;
            this.type = type;
            this.balance = balance;
        }

        void withdraw(int amount) {
            if (type.equals("Savings") && balance - amount < 1000) {
                System.out.println(
                    id + " rejected: minimum balance 1000"
                );
            } else if (type.equals("Current")
                    && balance - amount < -5000) {
                System.out.println(
                    id + " rejected: overdraft limit 5000"
                );
            } else {
                balance -= amount;
                System.out.println(id + " balance " + balance);
            }
        }
    }

    public static void main(String[] args) {
        Map<String, Account> accounts = new HashMap<>();

        accounts.put("S1", new Account("S1", "Savings", 5000));
        accounts.get("S1").withdraw(4500);

        accounts.put("C1", new Account("C1", "Current", 2000));
        accounts.get("C1").withdraw(6000);

        accounts.get("S1").withdraw(3000);
        accounts.get("C1").withdraw(2000);
    }
}