public class Client implements Runnable {

    private final Bank bank;
    private final Account account;
    private final String accountNumber;

    public Client(Bank bank, long amount) {
        this.bank = bank;
        this.account = bank.createAccount(amount);
        this.accountNumber = account.getAccNumber();
        this.bank.getAccounts().put(account.getAccNumber(), account);
    }

    @Override
    public void run() {
        while (!account.isBlocked()) {
            try {
                long money = (long) (Math.random() * (54321));
                if(account.getBalance() > money) {
                    String number = bank.getRandomNumber(accountNumber);
                    if(number == null || account.getBalance() < 0) {
                        account.setBlock();
                    }  else {
                        bank.transfer(accountNumber, number, money);
                        bank.getBalance(account.getAccNumber());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
