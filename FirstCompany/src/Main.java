import java.util.*;

public class Main {
    public static void main(String[] args) {

        Company globalCompany = new Company();
        List<Employee> listOfSalary;

        Company topManagerCompany = new Company();

        for (int i = 0; i < 180; i++) {
            Operator operator = new Operator();
            globalCompany.hire(operator);
        }
        for (int i = 0; i < 80; i++) {
            Manager manager = new Manager();
            globalCompany.hire(manager);
        }
        for (int i = 0; i < 10; i++) {
            TopManager topManager = new TopManager(globalCompany);
            topManagerCompany.hire(topManager);
        }
        globalCompany.hireAll(topManagerCompany.getAllEmployees());

        System.out.println("Количество сотрудников в компании - " + globalCompany.getAllEmployeesSize());
        System.out.println();

        System.out.println("Топ 10 высоких зарплат сотрудников:");
        listOfSalary = globalCompany.getTopSalaryStaff(10);
        for (int i = 0; i < listOfSalary.size(); ++i) {
            System.out.println(i + 1 + ". " + listOfSalary.get(i));
        }
        System.out.println();

        System.out.println("Топ 15 низких зарплат сотрудников:");
        listOfSalary = globalCompany.getLowestSalary(15);
        for (int i = 0; i < listOfSalary.size(); ++i) {
            System.out.println(i + 1 + ". " + listOfSalary.get(i));
        }
        System.out.println();

        for (int i = (globalCompany.getAllEmployeesSize() - 1); i >= 0; i-=2){
            globalCompany.fire(i);
        }

        System.out.println("Количество сотрудников в компании после сокращения " +
                "- " + globalCompany.getAllEmployeesSize());
        System.out.println();

        System.out.println("Топ 10 высоких зарплат сотрудников:");
        listOfSalary = globalCompany.getTopSalaryStaff(10);
        for (int i = 0; i < listOfSalary.size(); ++i) {
            System.out.println(i + 1 + ". " + listOfSalary.get(i));
        }
        System.out.println();

        System.out.println("Топ 15 низких зарплат сотрудников:");
        listOfSalary = globalCompany.getLowestSalary(15);
        for (int i = 0; i < listOfSalary.size(); ++i) {
            System.out.println(i + 1 + ". " + listOfSalary.get(i));
        }
    }
}

