import java.util.*;
import java.util.regex.*;

public class FirstTreeSet {
    public static void main(String[] args) {

        final String ADD = "ADD";
        final String LIST = "LIST";
        final String QUIT = "QUIT";
        final String REGEX = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";

        TreeSet<String> firstStr = new TreeSet<>();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println();
            System.out.println(":Please write you`re email:");
            System.out.println("1) ADD \n2) LIST \n3) QUIT - for EXIT ");
            String secondStr = sc.nextLine();
            if (secondStr.startsWith(ADD)) {
                String thirdStr = secondStr.substring(ADD.length());
                thirdStr = thirdStr.trim();
                Pattern pattern = Pattern.compile(REGEX);
                Matcher matcher = pattern.matcher(thirdStr);
                if (matcher.find()) {
                    firstStr.add(thirdStr);
                } else {
                    System.out.println("Invalid email! Try again!");
                }
            } else if (secondStr.startsWith(LIST)) {
                int i = 0;
                System.out.println("\nList of valid email:");
                for (String fourStr : firstStr) {
                    ++i;
                    System.out.println(i + " - " + fourStr);
                }
            } else if (secondStr.startsWith(QUIT)) {
                break;
            }
        }
    }
}
