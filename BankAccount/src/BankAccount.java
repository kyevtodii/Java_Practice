import java.util.Scanner;
import java.text.DecimalFormat;

public class BankAccount {

    public static void main(String[] args) {

        MainCard bank = new MainCard(0.0);
        Deposit deposit = new Deposit(0.0);
        Percent percent = new Percent(0.0);

        DecimalFormat df = new DecimalFormat("#.##");
        for (;;) {
            Scanner sc = new Scanner(System.in);
            System.out.println("=======================");
            System.out.println("(1) Simple bank card");
            System.out.println("(2) Deposit bank card");
            System.out.println("(3) Percent bank card");
            System.out.println("(4) Balance all cards");
            System.out.println("=======================");
            int x = sc.nextInt();
            if (x == 1) {
                System.out.println("(1) ADD money \n(2) GET money \n(3) Transfer to Deposit card " +
                        "\n(4) Transfer to Percent card \n(5) SHOW balance");
                int y = sc.nextInt();
                if (y == 1) {
                    System.out.println("Enter money");
                    bank.deposit(sc.nextDouble());
                } else if (y == 2) {
                    System.out.println("Enter money");
                    bank.withdraw(sc.nextDouble());
                } else if (y == 3) {
                    System.out.println("Enter money");
                    bank.transfer(deposit, sc.nextDouble());
                } else if (y == 4) {
                    System.out.println("Enter money");
                    bank.transfer(percent, sc.nextDouble());
                } else if (y == 5) {
                    System.out.println(df.format(bank.getBalance()));
                }
            } else if (x == 2) {
                System.out.println("(1) ADD money \n(2) GET money \n(3) SHOW balance");
                int y = sc.nextInt();
                if (y == 1) {
                    System.out.println("Enter money");
                    deposit.deposit(sc.nextDouble());
                } else if (y == 2) {
                    deposit.withdraw();
                } else if (y == 3) {
                    System.out.println(df.format(deposit.getBalance()));
                }
            } else if (x == 3) {
                System.out.println("(1) ADD money \n(2) GET money \n(3) SHOW balance");
                int y = sc.nextInt();
                if (y == 1) {
                    System.out.println("Enter money");
                    percent.deposit(sc.nextDouble());
                } else if (y == 2) {
                    System.out.println("Enter money");
                    percent.withdraw(sc.nextDouble());
                } else if (y == 3) {
                    System.out.println(df.format(percent.getBalance()));
                }
            } else if (x == 4) {
                System.out.println(df.format(bank.getBalance()) +"\n" + df.format(deposit.getBalance()) +"\n"
                        + df.format(percent.getBalance()));
            } else {
                break;
            }
        }
    }
}
