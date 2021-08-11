import com.skillbox.airport.Airport;

public class TestAirport {
    public static void main(String[] args) {

        Airport airport = Airport.getInstance();

        Object[] array = airport.getAllAircrafts().toArray();

        int allAircraft = array.length;

        airport.getTerminals().forEach(System.out::println);
        System.out.println();

        airport.getAllAircrafts().forEach(System.out::println);
        System.out.println();

        System.out.println("Количество самолетов - " + allAircraft);

    }
}
