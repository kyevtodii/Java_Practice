import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static final int newWidth = 300;

    public static void main(String[] args) {

        String srcFolder = "/home/ky/Pictures";
        String dstFolder = "/home/ky/dst";
        int processors = Runtime.getRuntime().availableProcessors();
        File srcDirectory = new File(srcFolder);

        long startTimeMillis = System.currentTimeMillis();

        File[] files = srcDirectory.listFiles();
        assert files != null;
        List<File[]> filesList = getListFiles(files, processors);
        for (File[] filesPart : filesList) {
            new Thread(new ImageResizer(filesPart, newWidth, dstFolder, startTimeMillis)).start();
        }
    }

    public static List<File[]> getListFiles(File[] files, int processors) {
        List<File[]> filesList = new ArrayList<>();
        int size = files.length / processors;
        for(int i = 0; i < processors; ++i) {
            if(i == processors - 1) {
                int sizeLast = size + (files.length - (size * processors));
                File[] files1 = new File[sizeLast];
                System.arraycopy(files, size * i, files1, 0, sizeLast);
                filesList.add(files1);
            }
            File[] files1 = new File[size];
            System.arraycopy(files, size * i, files1, 0, size);
            filesList.add(files1);
        }
        return filesList;
    }
}
