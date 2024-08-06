package bank;
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

    public void deposit(double amount) throws Exception {

        if (amount <= 0) {
            throw new Exception("You can't deposit negative amount");
        }
        this.balance += amount;
    }
    public void withdraw(double amount) throws Exception {

        if (amount <= 0) {
            throw new Exception("You can't withdraw negative amount");
        }
        if (amount > this.balance) {
            throw new Exception("Insuffcient balance");
            //thow new는 return이 필요없고 show new가 출력되면 알아서 코드를 종료한다.
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
