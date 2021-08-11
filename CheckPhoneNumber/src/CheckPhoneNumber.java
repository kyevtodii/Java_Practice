import java.util.*;
import java.io.IOException;

public class CheckPhoneNumber {
    public static void main(String[] args) throws IOException {

        for(;;) {
            System.out.print("Please write you're phone number: ");
            String regex = "[^0-9]+";

            Scanner sc = new Scanner(System.in);
            String number = sc.nextLine();
            String clearNumber = number.replaceAll(regex, "");
            clearNumber.trim();
            char c = clearNumber.charAt(0);

            if (clearNumber.length() > 11 || clearNumber.length() < 10 || clearNumber.length() == 11 && c == '9') {
                System.out.println("Wrong number format:");
            } else if (clearNumber.length() == 11 && c == '8') {
                StringBuilder addNum = new StringBuilder(clearNumber);
                addNum.setCharAt(0, '7');
                clearNumber = String.valueOf(addNum);
                System.out.println("Phone number is: " + clearNumber);
            } else if (clearNumber.length() == 10) {
                StringBuilder addNum = new StringBuilder(clearNumber);
                addNum.insert(0, 7);
                clearNumber = String.valueOf(addNum);
                System.out.println("Phone number is: " + clearNumber);
            } else {
                System.out.println("Phone number is: " + clearNumber);
            }
        }
    }
}
