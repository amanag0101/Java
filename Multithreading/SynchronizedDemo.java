class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public synchronized void setBalnace(double amount) {
        this.balance += amount;
    }

    public synchronized double getBalance() {
        return this.balance;
    }
}

class Teller implements Runnable {
    private BankAccount bankAccount;
    private double d;

    public Teller(BankAccount bankAccount, double d) {
        this.bankAccount = bankAccount;
        this.d = d;
    }

    @Override
    public void run() {
        bankAccount.setBalnace(d);
    }
}

public class SynchronizedDemo {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(1000);

        Thread t1 = new Thread(new Teller(bankAccount, 2000));
        Thread t2 = new Thread(new Teller(bankAccount, 3000));

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(bankAccount.getBalance());
    }
}
