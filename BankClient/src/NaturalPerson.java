public class NaturalPerson extends Client {

    public NaturalPerson(double money) {
        super(money);
    }
    public double getWithdrawalCommission(double money) {
        return 0;
    }
    public double getDepositCommission(double money) {
        return 0;
    }
    public void aboutClient() {
        System.out.printf("Natural Person Account\nTop-up: without interest\n" +
                "Withdrawal: without interest\nBalance: %s%n", df.format(balance));
    }
}
