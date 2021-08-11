public class Percent extends MainCard {

    private final int PERCENT = 1;

    public Percent(double money) {
        super(money);
    }
    public void deposit(double money) {
        money -= (PERCENT / money) * 100;
        balance += money;
    }
    public void withdraw(double money) {
        balance -= money;
        balance -= (PERCENT / money) * 100;
    }
}
