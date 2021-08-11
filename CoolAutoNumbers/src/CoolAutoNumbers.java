import java.util.*;
import java.io.*;

public class CoolAutoNumbers {
    public static void main(String[] args) throws IOException {
        String[] letters = {"A", "B", "E", "K", "M", "H", "O", "P", "C", "T", "Y", "X"};
        ArrayList<String> str = new ArrayList<>();
        HashSet<String> strTwo = new HashSet<>();

        for (int reg = 0; reg <= 197; ++reg) {
            for (int num = 111; num <= 999; num += 111) {
                for (String first : letters) {
                    for (String second : letters) {
                        for (String third : letters) {
                            str.add(String.format("%s%d%s%02d", first, num, second + third, reg));
                        }
                    }
                }
            }
        }
        Collections.sort(str);
        strTwo.addAll(str);
        TreeSet<String> strThree = new TreeSet<>(str);

        Scanner s = new Scanner(System.in);
        for (;;) {
            System.out.println("=Write number=");
            String x = s.nextLine();

            long start = System.nanoTime();
            if (str.contains(x.toUpperCase())) {
                System.out.print("Find car number: " + x.toUpperCase());
            } else {
                System.out.print("Car number" + " " + x.toUpperCase() + " " + "not found");
            }
            long end = System.nanoTime() - start;
            System.out.println(" from ArraySearch in " + end + " ns");

            long start1 = System.nanoTime();
            int in = Collections.binarySearch(str, x.toUpperCase());
            if (in >= 0) {
                System.out.print("Find car number: " + x.toUpperCase());
            } else {
                System.out.print("Car number" + " " + x.toUpperCase() + " " + "not found");
            }
            long end1 = System.nanoTime() - start1;
            System.out.println(" from Binary search in " + end1 + " ns");

            long start2 = System.nanoTime();
            if (strTwo.contains(x.toUpperCase())) {
                System.out.print("Find car number: " + x.toUpperCase());
            } else {
                System.out.print("Car number" + " " + x.toUpperCase() + " " + "not found");
            } long end2 = System.nanoTime() - start2;
            System.out.println(" from HashSet search in " + end2 + " ns");

            long start3 = System.nanoTime();
            if (strThree.contains(x.toUpperCase())) {
                System.out.print("Find car number: " + x.toUpperCase());
            } else {
                System.out.print("Car number" + " " + x.toUpperCase() + " " + "not found");
            } long end3 = System.nanoTime() - start3;
            System.out.println(" from TreeSet search in " + end3 + " ns");
        }
    }
}
