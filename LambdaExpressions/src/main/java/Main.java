import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.nio.file.Files;
import java.nio.file.Paths;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
import java.util.*;
//import java.util.stream.Stream;

public class Main {
    private static final String staffFileJson = "data/staff.json";
//    private static final String staffFileTxt = "data/staff.txt";
//    private static final String dateFormat = "dd.MM.yyyy";

    public static void main(String[] args) {

//        ArrayList<Employee> staff = loadStaffFromFile();
        try {
            String data = getDataFromFile();
            JSONParser parser = new JSONParser();
            JSONArray array = (JSONArray) parser.parse(data);
            for(Object item : array) {
                JSONObject jsonObject = (JSONObject) item;
                System.out.println(jsonObject.get("name") + " - " + jsonObject.get("salary"));
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

//        Calendar after = Calendar.getInstance();
//        Calendar before = Calendar.getInstance();
//        after.set(2016,Calendar.DECEMBER, 31);
//        before.set(2018, Calendar.JANUARY, 0);
//
//        staff.stream().filter(e ->
//            e.getWorkStart().after(after.getTime()) && e.getWorkStart().before(before.getTime()))
//                .max(Comparator.comparing(Employee::getSalary)).ifPresent(System.out::println);

//        staff.sort((employee, anotherEmployee) -> {
//            if (employee.getSalary().compareTo(anotherEmployee.getSalary()) == 0) {
//                return employee.getName().compareTo(anotherEmployee.getName());
//            } else {
//                return employee.getSalary().compareTo(anotherEmployee.getSalary());
//            }
//        });
//        staff.forEach(System.out::println);
    }


//    private static ArrayList<Employee> loadStaffFromFile() {
//        ArrayList<Employee> staff = new ArrayList<>();
//        try {
//            List<String> lines = Files.readAllLines(Paths.get(staffFile));
//            for(String line : lines) {
//                String[] fragments = line.split("\t");
//                if(fragments.length != 3) {
//                    System.out.println("Wrong line: " + line);
//                    continue;
//                }
//                staff.add(new Employee(
//                        fragments[0],
//                        Integer.parseInt(fragments[1]),
//                        (new SimpleDateFormat(dateFormat)).parse(fragments[2])
//                ));
//            }
//        }
//        catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return staff;
//    }
    private static String getDataFromFile() {
        StringBuilder builder = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(Paths.get(Main.staffFileJson));
            for(String line : lines) {
                builder.append(line);
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return builder.toString();
    }
}