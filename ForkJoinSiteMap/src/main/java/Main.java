import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;
import java.util.concurrent.ForkJoinPool;

public class Main {
    private static final String SITE_URL = "https://common-lisp.net/";
    private static final String SITE_MAP_FILE = "src/main/resources/sitemap.txt";

    public static void main(String[] args) {
        MapNodes rootUrl = new MapNodes(SITE_URL);
        new ForkJoinPool().invoke(new NodesRecursiveTask(rootUrl,rootUrl));
        siteMapUrlWriter(rootUrl,SITE_MAP_FILE);
    }

    public static void siteMapUrlWriter(MapNodes node,String siteMapFile) {
        int depth = node.getDepth();
        String tabs = String.join("", Collections.nCopies(depth, "\t"));
        appendStringInFile(siteMapFile, tabs + node.getUrl() + "\n");
        node.getSubLinks().forEach(link -> siteMapUrlWriter(link, siteMapFile));
    }

    private static void appendStringInFile(String fileName, String data) {
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(new File(fileName), true);
            outputStream.write(data.getBytes(), 0, data.length());
        } catch (IOException exception) {
            exception.printStackTrace();
        } finally {
            try {
                assert outputStream != null;
                outputStream.close();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }
}