import core.Line;
import core.Station;
import junit.framework.TestCase;
import java.util.List;
import java.util.ArrayList;

public class RouteCalculatorTest extends TestCase {

    StationIndex stationIndex;
    RouteCalculator routeCalculator;

    Line line1;
    Line line2;
    Line line3;

    ArrayList<Station> route1;
    ArrayList<Station> route2;
    ArrayList<Station> route3;
    ArrayList<Station> route4;
    ArrayList<Station> route5;

    Station lineOne_Station1;
    Station lineOne_Station2;
    Station lineOne_Station3;
    Station lineOne_Station4;
    Station lineTwo_Station1;
    Station lineTwo_Station2;
    Station lineThree_Station1;
    Station lineThree_Station2;

    ArrayList<Station> connectedFirst;
    ArrayList<Station> connectedSecond;

    protected void setUp() {
        stationIndex = new StationIndex();
        routeCalculator = new RouteCalculator(stationIndex);

        line1 = new Line(1, "Дерибасовская");
        line2 = new Line(2, "Пушкинская");
        line3 = new Line(3, "Ришельевская");

        lineOne_Station1 = new Station("Бочарова", line1);
        lineOne_Station2 = new Station("Заболотного", line1);
        lineOne_Station3 = new Station("Филатова", line1);
        lineOne_Station4 = new Station("Паустовского", line1);

        lineTwo_Station1 = new Station("Екатериниская", line2);
        lineTwo_Station2 = new Station("Высоцкого", line2);

        lineThree_Station1 = new Station("Краснова", line3);
        lineThree_Station2 = new Station("Луцкая", line3);

        line1.addStation(lineOne_Station1);
        line1.addStation(lineOne_Station2);
        line1.addStation(lineOne_Station3);
        line1.addStation(lineOne_Station4);
        line2.addStation(lineTwo_Station1);
        line2.addStation(lineTwo_Station2);
        line3.addStation(lineThree_Station1);
        line3.addStation(lineThree_Station2);

        stationIndex.addStation(lineOne_Station1);
        stationIndex.addStation(lineOne_Station2);
        stationIndex.addStation(lineOne_Station3);
        stationIndex.addStation(lineOne_Station4);
        stationIndex.addStation(lineTwo_Station1);
        stationIndex.addStation(lineTwo_Station2);
        stationIndex.addStation(lineThree_Station1);
        stationIndex.addStation(lineThree_Station2);

        connectedFirst = new ArrayList<>();
        connectedFirst.add(lineOne_Station2);
        connectedFirst.add(lineTwo_Station1);
        stationIndex.addConnection(connectedFirst);

        connectedSecond = new ArrayList<>();
        connectedSecond.add(lineOne_Station4);
        connectedSecond.add(lineThree_Station1);
        stationIndex.addConnection(connectedSecond);

        route1 = new ArrayList<>();
        route1.add(lineOne_Station1);
        route1.add(lineOne_Station2);
        route1.add(lineOne_Station3);
        route1.add(lineOne_Station4);

        route2 = new ArrayList<>();
        route2.add(lineOne_Station1);
        route2.add(lineOne_Station2);
        route2.add(lineTwo_Station1);
        route2.add(lineTwo_Station2);

        route3 = new ArrayList<>();
        route3.add(lineTwo_Station1);
        route3.add(lineOne_Station2);
        route3.add(lineOne_Station3);
        route3.add(lineOne_Station4);
        route3.add(lineThree_Station1);
        route3.add(lineThree_Station2);

        route4 = new ArrayList<>();
        route4.add(lineOne_Station3);
        route4.add(lineOne_Station3);

        route5 = new ArrayList<>();
        route5.add(lineTwo_Station1);
        route5.add(lineOne_Station2);
    }
    
    public void test_duration_from_one_station_to_it() {
        double actual = RouteCalculator.calculateDuration(route4);
        double expected = 0;
        assertEquals(expected, actual);
    }

    public void test_branch_change_duration() {
        double actual = RouteCalculator.calculateDuration(route5);
        double expected = 3.5;
        assertEquals(expected, actual);
    }

    public void test_trip_duration_on_one_line() {
        double actual = RouteCalculator.calculateDuration(route1);
        double expected = 7.5;
        assertEquals(expected, actual);
    }

    public void test_opposite_stations_on_single_line() {
        List<Station> actual = routeCalculator.getShortestRoute(lineOne_Station1, lineOne_Station4);
        List<Station> expected = route1;
        assertEquals(expected, actual);
    }

    public void test_opposite_stations_with_two_transfer() {
        List<Station> actual = routeCalculator.getShortestRoute(lineTwo_Station1, lineThree_Station2);
        List<Station> expected = route3;
        assertEquals(expected, actual);
    }

    public void test_opposite_stations_with_one_transfers() {
        List<Station> actual = routeCalculator.getShortestRoute(lineTwo_Station1, lineOne_Station2);
        List<Station> expected = route5;
        assertEquals(expected, actual);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
