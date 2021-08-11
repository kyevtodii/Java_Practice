import java.text.DecimalFormat;

public abstract class Client {

    protected double balance;
    protected final int ONE_PERCENT = 1;
    protected final int PEAK = 1000;
    protected final double HALF_PERCENT = 0.5;

    protected DecimalFormat df = new DecimalFormat("#.##");

    public Client(double money) {
        this.balance = money;
    }
    public void deposit(double money) {
        balance += (money - getDepositCommission(money));
    }
    public void withdraw(double money) {
        balance -= (money + getWithdrawalCommission(money));
    }
    protected abstract double getDepositCommission(double money);

    protected abstract double getWithdrawalCommission(double money);

    protected abstract void aboutClient();

    protected double getBalance() {
        return Double.parseDouble(df.format(balance));
    }
}
