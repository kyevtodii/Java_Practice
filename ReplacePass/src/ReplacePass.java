import java.io.IOException;

public class ReplacePass {
    public static void main(String[] args) throws IOException {

        String password = "Любая строка. Например <123>456 or that string <12345>6789 and 123<456>";
        String partOne = "<.*?>";
        String placeholder = "abc";
        String safe = password.replaceAll(partOne,placeholder);
        System.out.println("You're card number is: " + safe);
    }
}
