import core.Line;
import core.Station;

import java.util.*;
import java.util.stream.Collectors;

public class StationIndex {
    HashMap<String, Line> lines;
    List<Station> stations;
    TreeMap<Station, TreeSet<Station>> connections;
    protected List<List<Main.SimpleConnection>> simpleConnections;

    public StationIndex() {
        lines = new HashMap<>();
        stations = new ArrayList<>();
        connections = new TreeMap<>();
    }

    public void addStation(Station station) {
        stations.add(station);
    }

    public void addLine(Line line) {
        lines.put(line.getNumber(), line);
    }

    public void addConnection(List<Station> stations) {
        for(Station station : stations) {
            if(!connections.containsKey(station)) {
                connections.put(station, new TreeSet<>());
            }
            TreeSet<Station> connectedStations = connections.get(station);
            connectedStations.addAll(stations.stream()
                    .filter(s -> !s.equals(station)).collect(Collectors.toList()));
        }
    }

    public Line getLine(String number) {
        return lines.get(number);
    }

    public Station getStation(String name) {
        for(Station station : stations) {
            if(station.getName().equalsIgnoreCase(name)) {
                return station;
            }
        }
        return null;
    }

    public HashMap<String, Line> getLines() {
        return lines;
    }

    public List<Station> getStations() {
        return stations;
    }

    public void createSimpleConnections() {
        simpleConnections = new ArrayList<>();
        connections.values().forEach(set -> set.forEach(station -> {
                    List<Main.SimpleConnection> connectedStations = new ArrayList<>();
                    connectedStations.add(new Main.SimpleConnection(station));
                    connections.get(station).forEach(station1 -> connectedStations.add(new Main.SimpleConnection(station1)));
                    simpleConnections.add(connectedStations);
                }
        ));
    }
}

