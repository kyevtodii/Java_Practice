import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class Loader {
    public static void main(String[] args) {
        String text = "     Вася заработал 13437 рублей, Петя - 6563 рубля, а Маша - 330000 рублей     ";
        String regex = "[-]*[0-9]+";
        int sum = 0;
        Pattern pat = Pattern.compile(regex);
        Matcher mat = pat.matcher(text.trim());
        while(mat.find()) {
            sum += Integer.parseInt(mat.group(0));
        }
        System.out.println("Sum = " + sum);
    }
}