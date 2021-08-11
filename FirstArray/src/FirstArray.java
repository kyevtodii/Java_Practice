import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;

public class FirstArray {
    public static void main(String[] args) {
        String[] text = {"Каждый","охотник","желает","знать", "где","сидит","фазан"};
        System.out.println(Arrays.asList(text));
//        List<String> reverseText = Arrays.asList(text);
//        Collections.reverse(reverseText);
//        System.out.println(Arrays.toString(text));
        for (int i = 0; i < text.length / 2; ++i) {
            String reverse = text[i];
            text[i] = text[text.length - i - 1];
            text[text.length - i - 1] = reverse;
        }
        System.out.println(Arrays.asList(text));
    }
}
