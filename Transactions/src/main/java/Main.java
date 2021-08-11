import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;


public class Main {

    static Client client;
    static final int MY_PROCESSORS = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) {

        Bank bank = new Bank();
        List<Thread> threads = new ArrayList<>();

        for(int i = 0; i < MY_PROCESSORS; ++i) {
            client = new Client(bank, 1000000);
            Thread thread = new Thread(client);
            threads.add(thread);
        }

        System.out.println("\nAll threads are created.");
        System.out.println("Money in bank after start: " + bank.getBankFund() + "\n");

        for(Thread thread : threads) {
            try {
                thread.start();
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("\nAll threads is end.\n");

        HashMap<String, Account> accounts = bank.getAccounts();
        for(Map.Entry<String, Account> entry : accounts.entrySet()) {
            String accNumber = entry.getValue().getAccNumber();
            System.out.println("Money in account: " + accNumber + " - " + bank.getBalance(accNumber));
        }
        System.out.println("\nMoney in bank after all transaction: " + bank.getBankFund());
    }
}
