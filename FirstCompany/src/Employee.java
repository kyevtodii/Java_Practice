abstract class Employee implements Comparable<Employee> {

    protected double fixSalary;
    protected String jobPosition;
    protected double employeeIncome;
    protected double monthSalary;

    public double getIncome() {
        return employeeIncome;
    }

    public String toString() {
        return jobPosition + " - " + (int) monthSalary + " rub.";
    }
}