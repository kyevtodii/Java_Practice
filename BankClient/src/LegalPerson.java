public class LegalPerson extends Client {

    public LegalPerson(double money) {
        super(money);
    }
    public double getWithdrawalCommission(double money) {
        money = money * ONE_PERCENT / 100;
        return money;
    }
    public double getDepositCommission(double money) {
        return 0;
    }
    public void aboutClient() {
        System.out.printf("Legal Person Account\nTop-up: without interest\n" +
                "Withdrawal: from 1%% commission account\nBalance: %s%n", df.format(balance));
    }
}
