public class IndividualEntrepreneur extends Client {

    public IndividualEntrepreneur(double money) {
        super(money);
    }
    public double getWithdrawalCommission(double money) {
        return 0;
    }
    public double getDepositCommission(double money) {
        if (money < PEAK) {
            money = money * ONE_PERCENT / 100;
        } else if (money >= PEAK) {
            money = money * HALF_PERCENT / 100;
        }
        return money;
    }
    public void aboutClient() {
        System.out.printf("Individual Entrepreneur Account\nIf the replenishment amount is less than 1000 rub.\n\tTop-up : with 1 %% fee\n" +
                "If the replenishment amount is greater or equal than 1000 rub.\n\tTop-up : with 0.5 %% fee\n" +
                "Balance: %s%n", df.format(balance));
    }
}
