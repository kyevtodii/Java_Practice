import core.Line;
import core.Station;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {

    private static final String MOS_METRO = "https://ru.wikipedia.org/wiki/%D0%A1%D0%BF%D0%B8%D1%81%D0%BE%D0%BA_" +
            "%D1%81%D1%82%D0%B0%D0%BD%D1%86%D0%B8%D0%B9_" +
            "%D0%9C%D0%BE%D1%81%D0%BA%D0%BE%D0%B2%D1%81%D0%BA%D0%BE%D0%B3%D0%BE_" +
            "%D0%BC%D0%B5%D1%82%D1%80%D0%BE%D0%BF%D0%BE%D0%BB%D0%B8%D1%82%D0%B5%D0%BD%D0%B0";

    public static StationIndex mosMetroStations;
    private static StationsIndexes stationIndex;
    private static final List<List<SimpleConnection>> connectionList = new ArrayList<>();


    private static Elements getMetroRows() throws IOException {
        Document document = Jsoup.connect(MOS_METRO).maxBodySize(0).get();
        Elements elements = document.select("table[class=standard sortable]");
        return elements.select("tbody").select("tr");
    }

    public static void main(String[] args) throws IOException {

        parseStationAndLines(getMetroRows());
        parseConnections(getMetroRows());
        createMetroJson();
        deserializeJsonToStationIndex();
        resultOfHomework();
        mosMetroStations.createSimpleConnections();
    }

    private static void parseStationAndLines(Elements elements) {
        mosMetroStations = new StationIndex();
        elements.remove(0);
        try {
            for (Element row : elements) {
                Elements lineCell = row.select("td");
                if (lineCell.size() == 7 || lineCell.size() == 8) {

                    String lineNumber = lineCell.select("span.sortkey").first().text();
                    Element lineN = row.child(0).select("span[title]").last();

                    final String lineName = lineN.attr("title");
                    final String stationLineNumber = row.select("span.sortkey").first().text();
                    final String stationName = row.child(1).select("a").first().text();

                    Line parseLine = new Line(lineNumber, lineName);
                    Station parseStation = new Station(stationName, new Line(stationLineNumber, lineName));

                    mosMetroStations.addLine(parseLine);
                    mosMetroStations.addStation(parseStation);

                    if (lineCell.attr("data-sort-value").equals("8.9")) {

                        String lineNumber11 = lineCell.select("span.sortkey").get(1).text();
                        Element stationCell = row.child(1).select("span").first();
                        String stationNameLine11 = stationCell.text();
                        Station parseStation11 = new Station(stationNameLine11, mosMetroStations.getLine(lineNumber11));
                        mosMetroStations.addStation(parseStation11);
                    }
                }
            }
        } catch (Exception exception) {
            exception.getStackTrace();
        }
    }

    private static void parseConnections(Elements elements) {
        try {
            for (Element row : elements) {
                Elements cells = row.select("td");
                List<Station> tempConnection = new ArrayList<>();
                List<SimpleConnection> simpletempConnection = new ArrayList<>();
                if (cells.size() == 7 || cells.size() == 8) {
                    final String stationName = cells.get(1).select("a").first().text();
                    Elements connectElements = cells.get(3).select("span");
                    for (Element connectElement : connectElements) {
                        Element tempStationNameElement = connectElement.nextElementSibling();
                        if (tempStationNameElement == null) {
                            continue;
                        }
                        String tempConnectStationName = tempStationNameElement.attr("title");
                        if (tempConnectStationName == null) {
                            continue;
                        }
                        String connectStationName = getConnectionStationName(tempConnectStationName);
                        if (connectStationName.equals("")) {
                            continue;
                        }

                        if (simpletempConnection.contains(new SimpleConnection(mosMetroStations.getStation(stationName)))) {
                            simpletempConnection.add(new SimpleConnection(mosMetroStations.getStation(connectStationName)));
                            continue;
                        }
                        simpletempConnection.add(new SimpleConnection(mosMetroStations.getStation(stationName)));
                        simpletempConnection.add(new SimpleConnection(mosMetroStations.getStation(connectStationName)));
                        connectionList.add(simpletempConnection);
                    }
                    mosMetroStations.addConnection(tempConnection);
                }
            }
        } catch (
                Exception ex) {
            ex.getStackTrace();
        }
    }

    private static void createMetroJson() {
        try(PrintWriter printWriter = new PrintWriter("src/main/resources/map.json")) {
            printWriter.write(serializeStationsIndexes(mosMetroStations));
            printWriter.flush();
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        } catch (StackOverflowError error) {
            error.getStackTrace();
        }
    }

    private static void deserializeJsonToStationIndex() {
        StringBuilder json = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/map.json"))) {
            for (; ; ) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }
                json.append(line);
            }
        } catch (Exception ex) {
            ex.getStackTrace();
        }
        stationIndex = new Gson().fromJson(String.valueOf(json), StationsIndexes.class);
    }

    private static void resultOfHomework() {
        try {
            for (Line line : stationIndex.getLines()) {
                for (String stationNumber : stationIndex.getStations().keySet()) {
                    if (stationNumber.equals(line.getNumber())) {
                        System.out.println("Line :" +
                                line.getNumber() + " have " +
                                stationIndex.getStations().get(stationNumber).size() + " stations.");
                    }
                }
            }
        } catch (NullPointerException ex) {
            ex.getStackTrace();
        }
    }

    private static String getConnectionStationName(String tempConnectStationName) {
        for (Station metStation : mosMetroStations.getStations()) {
            Pattern stationPattern = Pattern.compile(metStation.getName());
            Matcher staMatcher = stationPattern.matcher(tempConnectStationName);
            if (staMatcher.find()) {
                return metStation.getName();
            }
        }
        return "";
    }

    private static String serializeStationsIndexes(StationIndex metro) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        List<Line> lines = new ArrayList<>(metro.getLines().values());
        HashMap<String, List<Station>> stations = new HashMap<>();
        for (Line line : metro.getLines().values()) {
            List<Station> stationList = new ArrayList<>();
            for (Station station : metro.getStations()) {
                String a = station.getLine().getNumber();
                String b = line.getNumber();
                if (a.equals(b)) {
                    stationList.add(station);
                    stations.put(station.getLine().getNumber(), stationList);
                }
            }
        }
        List<List<SimpleConnection>> connections = new ArrayList<>(connectionList);
        StationsIndexes jsonStationIndexes = new StationsIndexes(lines, stations, connections);
        return gson.toJson(jsonStationIndexes);
    }

    private static class StationsIndexes {
        List<Line> lines;
        HashMap<String, List<Station>> stations;
        List<List<SimpleConnection>> connections;

        public StationsIndexes(List<Line> lines, HashMap<String, List<Station>> stations, List<List<SimpleConnection>> connections) {
            this.lines = lines;
            this.stations = stations;
            this.connections = connections;
        }

        public List<Line> getLines() {
            return lines;
        }

        public HashMap<String, List<Station>> getStations() {
            return stations;
        }
    }

    public static class SimpleConnection {
        private final String line;
        private final String station;

        public SimpleConnection(Station station) {
            this.line = station.getLine().getNumber();
            this.station = station.getName();
        }

        public String getLine() {
            return line;
        }

        public String getStation() {
            return station;
        }
    }
}

