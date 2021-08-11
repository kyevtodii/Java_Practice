import java.util.Scanner;

public class Main
{
    private static final String addCommand = "add Василий Петров " +
            "vasily.petrov@gmail.com +79215637722";
    private static final String commandExamples = "\t" + addCommand + "\n" +
            "\tlist\n\tcount\n\tremove Василий Петров\n\texit";
    private static final String commandError = "Wrong command! Available command examples: \n" +
            commandExamples;
    private static final String helpText = "Command examples:\n" + commandExamples;

    public static void main(String[] args)
    {
        System.err.println("Hello! \n please print HELP \n\t and press ENTER!");
        Scanner scanner = new Scanner(System.in);
        CustomerStorage executor = new CustomerStorage();
        for (;;) {
            String command = scanner.nextLine();
            String[] tokens = command.split("\\s+", 2);
            if (tokens[0].equalsIgnoreCase("add")) {
                try {
                    executor.addCustomer(tokens[1]);
                } catch (IndexOutOfBoundsException | IllegalArgumentException e) {
                    System.out.println(e.getMessage() + "\n" + helpText);
                }
            } else if (tokens[0].equalsIgnoreCase("list")) {
                executor.listCustomers();
            } else if (tokens[0].equalsIgnoreCase("remove")) {
                try {
                    executor.removeCustomer(tokens[1]);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println(e.getMessage());
                }
            } else if (tokens[0].equalsIgnoreCase("count")) {
                System.out.println("There are " + executor.getCount() + " customers");
            } else if (tokens[0].equalsIgnoreCase("help")) {
                System.out.println(helpText);
            } else if (tokens[0].equalsIgnoreCase("exit")) {
                break;
            } else {
                System.out.println(commandError);
            }
        }
    }
}
