import java.io.IOException;
import java.util.Scanner;
public class StringToAnotherStrings {
    public static void main(String[] args) throws IOException {
        System.out.print("Please write you're surname, name and middle name: ");
        Scanner reader = new Scanner(System.in);
        String fullName = reader.nextLine();
        fullName = fullName.trim();
        String[] separateFullName = fullName.split("\\s*(\\s|,|!|\\.)\\s*");

        System.out.println("Surname: " + separateFullName[0]);
        System.out.println("Name: " + separateFullName[1]);
        System.out.println("Middle name: " + separateFullName[2]);
    }
}
