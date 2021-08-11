import java.util.Scanner;

public class BankClient {
    public static void main(String[] args) {

        NaturalPerson natural = new NaturalPerson(0.0);
        LegalPerson legal = new LegalPerson(0.0);
        IndividualEntrepreneur individual = new IndividualEntrepreneur(0.0);

        for (;;) {
            Scanner sc = new Scanner(System.in);
            System.out.println("===========================");
            System.out.println("(1) Natural Person");
            System.out.println("(2) Legal Person");
            System.out.println("(3) Individual Entrepreneur");
            System.out.println("===========================");
            int x = sc.nextInt();
            if (x == 1) {
                System.out.println("=======================");
                natural.aboutClient();
                System.out.println("=======================");
                System.out.println("(1) ADD money \n(2) GET money \n(3) SHOW balance");
                int y = sc.nextInt();
                if (y == 1) {
                    System.out.println("Enter money");
                    natural.deposit(sc.nextDouble());
                } else if (y == 2) {
                    System.out.println("Enter money");
                    natural.withdraw(sc.nextDouble());
                } else if (y == 3) {
                    System.out.println("Natural Person balance: " + natural.getBalance());
                } else {
                    break;
                }
            } else if (x == 2) {
                System.out.println("=======================");
                legal.aboutClient();
                System.out.println("=======================");
                System.out.println("(1) ADD money \n(2) GET money \n(3) SHOW balance \n(4) Show Withdrawal commission");
                int y = sc.nextInt();
                if (y == 1) {
                    System.out.println("Enter money");
                    legal.deposit(sc.nextDouble());
                } else if (y == 2) {
                    System.out.println("Enter money");
                    legal.withdraw(sc.nextDouble());
                } else if (y == 3) {
                    System.out.println("Legal Person balance: " + legal.getBalance());
                } else if (y == 4) {
                    System.out.println("Enter money");
                    double money = sc.nextDouble();
                    System.out.println("Withdrawal commission is: " + legal.getWithdrawalCommission(money));
                    System.out.println("Sum with commission is: " + (money + legal.getWithdrawalCommission(money)));
                } else {
                    break;
                }
            } else if (x == 3) {
                System.out.println("=======================");
                individual.aboutClient();
                System.out.println("=======================");
                System.out.println("(1) ADD money \n(2) GET money \n(3) SHOW balance \n(4) Show Deposit commission");
                int y = sc.nextInt();
                if (y == 1) {
                    System.out.println("Enter money");
                    individual.deposit(sc.nextDouble());
                } else if (y == 2) {
                    System.out.println("Enter money");
                    individual.withdraw(sc.nextDouble());
                } else if (y == 3) {
                    System.out.println("Individual Entrepreneur balance: " + individual.getBalance());
                } else if (y == 4) {
                    System.out.println("Enter money");
                    double money = sc.nextDouble();
                    System.out.println("Deposit commission is: " + individual.getDepositCommission(money));
                    System.out.println("Sum with commission is: " + (money + individual.getDepositCommission(money)));
                } else {
                    break;
                }
            } else {
                break;
            }
        }
    }
}
