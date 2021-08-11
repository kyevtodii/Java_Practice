import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    private static long folderSize;
    public static void main(String[] args) {
        System.out.println("Enter the folder whose you want to know:");
        Scanner sc = new Scanner(System.in);
        String inputPathToFolder = sc.nextLine();
        File myFile = new File(inputPathToFolder);
        if (myFile.exists()) {
            try {
                folderSize = Files.walk(Paths.get(inputPathToFolder))
                        .map(Path::toFile)
                        .map(File::length)
                        .mapToLong(Long::longValue)
                        .sum();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            System.out.println("Size of all files in a directory: " + byteSizeToHumanReadableFormat(folderSize));
        } else {
            System.out.println("Input error");
        }
    }
    private static String byteSizeToHumanReadableFormat(long folderSize) {
        int byteCount = 0;
        while (folderSize > 1024) {
            folderSize /= 1024;
            byteCount++;
        }
        String sizeUnit = "KMGTPE";
        char sizeValue = sizeUnit.charAt(byteCount);
        return folderSize + " " + sizeValue + "b.";
    }
}
