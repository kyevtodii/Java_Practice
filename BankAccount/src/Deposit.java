import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Deposit extends MainCard {

    private final Scanner SCANNER = new Scanner(System.in);
    private final int MONTH = 1;
    private final SimpleDateFormat S_FORMAT = new SimpleDateFormat("dd.MM.yyyy");
    protected Calendar calendar = Calendar.getInstance();
    protected Calendar calendarTwo = Calendar.getInstance();

    public Deposit(double money) {
        super(money);
    }
    public void deposit(double money) {
        balance += money;
        calendarTwo = Calendar.getInstance();
        calendarTwo.add(Calendar.MONTH,MONTH);
    }
    public void withdraw() {
        if (calendar.after(calendarTwo)) {
            System.out.println("Enter money");
            balance -= SCANNER.nextDouble();
        } else {
            System.out.println("====================================");
            System.out.println("Not today, sorry, wait to " + S_FORMAT.format(calendarTwo.getTime()));
            System.out.println("====================================");
        }
    }
}
