import java.util.concurrent.CopyOnWriteArraySet;

public class MapNodes {
    private final String URL;
    private volatile int depth;
    private volatile MapNodes parent;
    private volatile CopyOnWriteArraySet<MapNodes> subLinks;

    public MapNodes(String url) {
        this.URL = url;
        subLinks = new CopyOnWriteArraySet<>();
        depth = 0;
        parent = null;
    }

    public void addSubLinks(MapNodes subLink) {
        if (!subLinks.contains(subLink) && subLink.getUrl().startsWith(URL)) {
            this.subLinks.add(subLink);
            subLink.setParent(this);
        }
    }

    private void setParent(MapNodes mapNodes) {
        synchronized (this) {
            this.parent = mapNodes;
            this.depth = setDepth();
        }
    }

    public int getDepth() {
        return depth;
    }

    private int setDepth() {
        if (parent == null) {
            return 0;
        }
        return 1 + parent.getDepth();
    }

    public CopyOnWriteArraySet<MapNodes> getSubLinks() {
        return subLinks;
    }

    public String getUrl() {
        return URL;
    }
}