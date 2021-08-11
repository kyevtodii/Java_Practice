import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.URL;

public class Main {

    private static final String LENTA_RU = "https://lenta.ru/";
    private static final String IMAGES_FOLDER = "images/";

    public static void main(String[] args) {
        try {
            Document document = Jsoup.connect(LENTA_RU).get();
            Elements images = document.select("img.g-picture");

            for (Element imageElement : images) {
                String imageURL = imageElement.absUrl("src");
                downloadImage(imageURL);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }

    }
    private static void downloadImage (String imageURL) throws  IOException {

        String imageName = imageURL.substring(imageURL.lastIndexOf("/"));
        System.out.println("Saving: " + imageName + ", from: " + imageURL);

        URL url = new URL(imageURL);

        try (InputStream in = url.openStream();
             OutputStream out = new BufferedOutputStream(new FileOutputStream(IMAGES_FOLDER + imageName))) {
            for (int b; (b = in.read()) != -1; ) {
                    out.write(b);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



