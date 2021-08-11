import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ArrayListMyNotes {
    public static void main(String[] args) {

        final String ADD = "ADD";
        final String LIST = "LIST";
        final String EDIT = "EDIT";
        final String DELETE = "DELETE";
        final String QUIT = "QUIT";
        final String REGEX = "^\\d+";

        Scanner scanner = new Scanner(System.in);
        ArrayList<String> myNotes = new ArrayList<>();

        while (true) {

            System.out.println("---------------------------------------------");
            System.out.println(":Please select an option from the list below:");
            System.out.println("---------------------------------------------");
            System.out.println("1) LIST \n2) ADD \n3) EDIT \n4) DELETE \n5) QUIT - for exit");
            String userString = scanner.nextLine();

            if (userString.startsWith(LIST)) {
                System.out.println(":xxxxxxxxxxxxxxxxxxxxxx:");
                for (int i = 0; i < myNotes.size(); ++i) {
                    System.out.println(i + " " + myNotes.get(i));
                }
                System.out.println(":xxxxxxxxxxxxxxxxxxxxxx:");
            } else if (userString.startsWith(ADD)) {
                String strOne = userString.substring(ADD.length());
                strOne = strOne.trim();
                Pattern pattern = Pattern.compile(REGEX);
                Matcher matcher = pattern.matcher(strOne);
                if (matcher.find()) {
                    int x = Integer.parseInt(matcher.group(0));
                    String strTwo = userString.substring(userString.indexOf(matcher.group()) + 1);
                    myNotes.add(x, strTwo);
                } else {
                    String y = userString.substring(ADD.length());
                    myNotes.add(y);
                }
            } else if (userString.startsWith(EDIT)) {
                String strThree = userString.substring(EDIT.length());
                strThree = strThree.trim();
                Pattern pattern = Pattern.compile(REGEX);
                Matcher matcher = pattern.matcher(strThree);
                if (matcher.find()) {
                    int y = Integer.parseInt(matcher.group(0));
                    String strFour = userString.substring(userString.indexOf(matcher.group(0)) + 1);
                    myNotes.set(y, strFour);
                }
            } else if (userString.startsWith(DELETE)) {
                String strFive = userString.substring(DELETE.length());
                strFive = strFive.trim();
                Pattern pattern = Pattern.compile(REGEX);
                Matcher matcher = pattern.matcher(strFive);
                if (matcher.find()) {
                    int z = Integer.parseInt(matcher.group(0));
                    myNotes.remove(z);
                }
            } else if (userString.startsWith(QUIT)) {
                break;
            }
        }
    }
}