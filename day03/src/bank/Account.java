package bank;
import java.util.Date;
import java.util.Random;

public class Account {
    private String accNumber;
    private double balance;

    public String getAccNumber() {
        return accNumber;
    }

    public double getBalance() {
        return balance;
    }

    public Account(double money) {
        Random rand = new Random();
        int num = rand.nextInt(100) * 1000/ 100;

    }

    public Account(String accNumber, double balance) {
        this.accNumber = accNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {

        if (amount <= 0) {
            System.out.println("You don't have enough money to deposit");
            return;
        }
        this.balance += amount;
    }
    public void withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("You don't have enough money to withdraw");
            return;
        }
        if (amount > this.balance) {
            System.out.println("You can't withdraw more than balance");
            return;
        }
        this.balance -= amount;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accNumber='" + accNumber + '\'' +
                ", balance=" + balance +
                '}';
    }
}
