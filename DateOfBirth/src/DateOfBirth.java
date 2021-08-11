import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateOfBirth {
    public static void main(String[] args) {

        int day = 9;
        int month = 10;
        int year = 1986;

        Date currentDate = new Date();
        Locale locale = new Locale("ru");
        DateFormat df = new SimpleDateFormat("- dd.MM.yyyy - E", locale);

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        Calendar calendarTwo = Calendar.getInstance();
        calendarTwo.setTime(currentDate);

        for (int i = 0; calendar.before(calendarTwo); ++i) {
            System.out.println(i + " " + df.format(calendar.getTime()));
            calendar.add(Calendar.YEAR, 1);
        }

    }
}
