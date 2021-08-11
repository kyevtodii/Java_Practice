public class MainCard {

    protected double balance;

    public MainCard(double money) {
        this.balance = money;
    }
    public void deposit(double money) {
        balance += money;
    }
    public void withdraw(double money) {
        balance -= money;
    }
    protected double getBalance() {
        return balance;
    }
    protected void transfer(MainCard bank, double money) {
        if (money <= this.balance) {
            withdraw(money);
            bank.deposit(money);
        } else {
            System.out.println("Sorry, not enough balance!");
        }
    }
}
