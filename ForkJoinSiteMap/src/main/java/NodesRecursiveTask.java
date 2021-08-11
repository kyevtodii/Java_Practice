import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.RecursiveAction;
import static java.lang.Thread.sleep;

public class NodesRecursiveTask extends RecursiveAction {
    private final MapNodes URL;
    private final MapNodes ROOT_URL;
    private static final CopyOnWriteArraySet<String> ALL_LINKS = new CopyOnWriteArraySet<>();

    public NodesRecursiveTask(MapNodes url, MapNodes rootUrl) {
        this.URL = url;
        this.ROOT_URL = rootUrl;
    }

    @Override
    protected void compute() {
        Set<NodesRecursiveTask> taskList = new HashSet<>();
        try {
            sleep(150);
            Document doc = Jsoup.connect(URL.getUrl()).timeout(100000).get();
            Elements links = doc.select("a[href]");
            links.stream().map(link -> link.attr("abs:href")).filter(this::isCorrected).forEach(absUrl -> {
                URL.addSubLinks(new MapNodes(absUrl));
                ALL_LINKS.add(absUrl);
            });
        } catch (IOException | InterruptedException exception) {
            exception.printStackTrace();
        }

        for (MapNodes link : URL.getSubLinks()) {
            NodesRecursiveTask task = new NodesRecursiveTask(link, ROOT_URL);
            task.fork();
            taskList.add(task);
        }

        for (NodesRecursiveTask task : taskList) {
            task.join();
        }
    }

    private boolean isCorrected(String url) {
        return (!url.isEmpty() && url.startsWith(ROOT_URL.getUrl())
                && !ALL_LINKS.contains(url) && !url.contains("#")
                && !url.matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp|pdf))$)"));
    }
}