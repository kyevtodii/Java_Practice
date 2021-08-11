class Operator extends Employee implements EmployeePosition {

    public Operator() {
        this.jobPosition = "Operator";
        employeeIncome = 0;
        fixSalary = (79000 + (Math.random() * (80000 - 79000)));
        monthSalary = fixSalary;
    }

    public double getMonthSalary() {
        return fixSalary;
    }

    public int compareTo(Employee emp) {
        return (int) (emp.monthSalary - this.monthSalary);
    }
}