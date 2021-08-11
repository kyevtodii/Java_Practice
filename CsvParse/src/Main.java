import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private final static String MOVEMENT_LIST = "data/movementList.csv";
    private final static int COLUMNS = 11;
    private final static int INCOME = 9;
    private final static int EXPENSE = 10;
    private final static int INCOME_EXPENSE = 6;

    public static void main(String[] args) {

        double revenueAmount = 0;
        double expenseAmount = 0;
        final String emptyQuotation = "";
        final String dotRegEx = ".";
        final String commaRegEx = ",";
        final String csvRegEx = "\"";
        final String columnRegEx = " \\(.*?\\)";
        final String spaceRegEx = "\\s{3,}";
        List<String> allLines;
        List<MovementPojo> listLines = new ArrayList<>();

        try {
            allLines = Files.readAllLines(Path.of(MOVEMENT_LIST));
            allLines.remove(0);
            for (String allLine : allLines) {
                String[] fragments = allLine
                        .replaceAll(csvRegEx, emptyQuotation)
                        .replaceAll(columnRegEx, emptyQuotation)
                        .replaceAll(spaceRegEx, commaRegEx)
                        .split(commaRegEx, COLUMNS);

                double income = Double.parseDouble(fragments[INCOME]);
                double expense = Double.parseDouble(fragments[EXPENSE].replaceAll(commaRegEx, dotRegEx));
                revenueAmount += income;
                expenseAmount += expense;
                listLines.add(new MovementPojo(fragments[INCOME_EXPENSE], income, expense));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        System.out.println("Total revenue: " + revenueAmount + " RUR");
        System.out.println("Total expensive: " + expenseAmount + " RUR");

        System.out.println("\nExpenses of organizations:");
        listLines.stream()
                .filter(line -> line.expense > 0)
                .collect(Collectors.groupingBy(MovementPojo::getAgent, Collectors.summingDouble(MovementPojo::getExpense)))
                .forEach((a, expense) -> System.out.println(a + " : " + expense + " RUR"));
    }
}

