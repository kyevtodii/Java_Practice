import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;

import java.util.Calendar;
import java.util.Date;

public class AirportTest {
    public static void main(String[] args) {

        Airport airport = Airport.getInstance();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR, 2);
        Date first = new Date();
        Date second = calendar.getTime();


        airport.getTerminals().stream().flatMap(terminal -> terminal.getFlights().stream())
                .filter(flight -> flight.getDate().after(first))
                .filter(flight -> flight.getDate().before(second))
                .filter(flight -> flight.getType().equals(Flight.Type.DEPARTURE))
                .forEach(flight -> System.out.println(flight.toString() + " " + flight.getAircraft().getModel()));

//        for (Terminal terminal : airport.getTerminals()) {
//            for (Flight flight : terminal.getFlights()) {
//                if (flight.getDate().after(first)) {
//                    if (flight.getDate().before(second)) {
//                        if (flight.getType().equals(Flight.Type.DEPARTURE)) {
//                            System.out.println(flight.toString() + " " + flight.getAircraft().getModel());
//                        }
//                    }
//                }
//            }
//        }
    }
}