import java.util.Map;
import java.util.Random;
import java.util.HashMap;

public class Bank {

    private long bankFund;
    private final Random random = new Random();
    private final HashMap<String, Account> accounts;
    public Bank() {
        accounts = new HashMap<>();
    }

    public long getBankFund() {
        return bankFund;
    }
    public void setToBankFund(long amount) {
        this.bankFund += amount;
    }
    public void getFromBankFund(long amount) {
        this.bankFund -= amount;
    }

    public synchronized boolean isFraud() throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    public void transfer(String fromAccountNum, String toAccountNum, long amount) {

        long fromMoney = accounts.get(fromAccountNum).getBalance();
        if(fromMoney < amount) {
            System.out.println("Not enough money.");
        }

        String from = fromAccountNum;
        String to = toAccountNum;
        if(from.compareTo(to) < 0 ) {
            to = fromAccountNum;
            from = toAccountNum;
        }

        try {
            synchronized (accounts.get(from)) {
                synchronized (accounts.get(to)) {
                    if(amount > 50000 && isFraud()) {
                        accounts.get(fromAccountNum).setBlock();
                        accounts.get(toAccountNum).setBlock();
                        System.out.println("Bad transfer. All accounts are blocked.");
                    } else {
                        accounts.get(fromAccountNum).getMoney(amount);
                        accounts.get(toAccountNum).setMoney(amount);
                        System.out.println("From account " + fromAccountNum + " to account " + toAccountNum + " successful.");
                        System.out.println();
                    }
                }
            }
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

    public long getBalance(String accountNum) {
        Account account = accounts.get(accountNum);
        return account.getBalance();
    }

    public HashMap<String, Account> getAccounts() {
        return accounts;
    }

    public Account createAccount(long money) {
        Account account = new Account(getRandomNumber());
        account.setMoney(money);
        setToBankFund(money);
        return account;
    }
    
    public String getRandomNumber() {
        String[] letters;
        letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
                "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        return (int) (1 + Math.random() * 9)
                + letters[(int) (Math.random() * letters.length - 1)]
                + (int) (1000 + Math.random() * 9999)
                + letters[(int) (Math.random() * letters.length - 1)]
                + (int) (1000 + Math.random() * 9999);
    }

    public String getRandomNumber(String accNumber) {
        String numberNew = null;
        for (Map.Entry<String, Account> entry : accounts.entrySet()) {
            if (random.nextBoolean()) {
                numberNew = entry.getKey();
                if (numberNew.equals(accNumber)) {
                    numberNew = null;
                }
            }
        }
        return numberNew;
    }
}
