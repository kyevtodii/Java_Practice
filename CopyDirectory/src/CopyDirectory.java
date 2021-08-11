import java.io.*;
import java.util.Arrays;

public class CopyDirectory {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out, true);

        System.out.print("Write source directory: ");
        String inputSource = br.readLine();
        System.out.print("Write destination directory: ");
        String inputDestination = br.readLine();

        File sourceDirectory = new File(inputSource);
        File destinationDirectory = new File(inputDestination);

        copyDirectoryWithFolder(sourceDirectory, destinationDirectory);
        pw.println("\nSource directory: " + Arrays.toString(sourceDirectory.list()));
        pw.println("\nDestination directory: " + Arrays.toString(destinationDirectory.list()));
    }

    public static void copyDirectoryWithFolder (File sourceDirectory, File destinationDirectory) {
        if (sourceDirectory.isDirectory()) {
            if (!destinationDirectory.exists()) {
                destinationDirectory.mkdir();
            }

            String[] files = sourceDirectory.list();
            assert files != null;

            for (String file : files) {
                File sourceFile = new File(sourceDirectory, file);
                File destinationFile = new File(destinationDirectory, file);
                copyDirectoryWithFolder(sourceFile, destinationFile);
            }
        } else {
            try (FileInputStream inputStream = new FileInputStream(sourceDirectory);
            FileOutputStream outputStream = new FileOutputStream(destinationDirectory)) {

                byte[] byteBuffer = new byte[1024];
                int length;

                while ((length = inputStream.read(byteBuffer)) > 0) {
                    outputStream.write(byteBuffer, 0, length);
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
}

