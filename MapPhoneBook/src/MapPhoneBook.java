import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MapPhoneBook {
    public static void main(String[] args) throws IOException {

        final String LIST = "LIST";
        final String QUIT = "QUIT";
        final String REGEX = "^\\d+$";
        final String STREGEX = "\\D+";

        TreeMap<String, String> phoneBook = new TreeMap<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("#######################");
            System.out.println("\t\tWELCOME\n#######################");
            System.out.println("LIST - to show all \nQUIT - to exit");
            System.out.println("\tWrite you date");
            String userIn = sc.nextLine();
            int i = 0;

            if (phoneBook.containsValue(userIn)) {
                for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
                    if (entry.getValue().equals(userIn)) {
                        ++i;
                        System.out.println(i +") " +entry.getKey() + " - " + entry.getValue());
                    }
                } continue;
            } else if (userIn.equals(LIST)) {
                for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
                    ++i;
                    System.out.println(i + ") " + entry.getKey() + " - " + entry.getValue());
                } continue;
            } else if (userIn.equals(QUIT)) break;
            if (phoneBook.containsKey(userIn)) {
                String keyValue = phoneBook.get(userIn);
                ++i;
                System.out.println(i +") " + userIn + " - " + keyValue);
                continue;
            }
            if (userIn.matches(REGEX)) {
                String number = userIn.trim();
                char c = number.charAt(0);

                if (number.length() > 11 || number.length() < 10 || number.length() == 11 && c == '9') {
                    System.out.println("Wrong number format:");
                } else {
                    System.out.println("Write name");
                    String name = sc.nextLine();
                    phoneBook.put(name, number);
                }
            } else if (userIn.matches(STREGEX)) {
                System.out.println("Write phone number");
                String number = sc.nextLine();
                phoneBook.put(userIn, number);
            }  else {
                String number = sc.nextLine();
                phoneBook.put(userIn, number);
            }
        }
    }
}
