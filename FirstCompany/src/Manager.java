class Manager extends Employee implements EmployeePosition {

    public Manager() {
        this.jobPosition = "Manager";
        employeeIncome = 115000 + (Math.random() * (140000 - 115000));
        fixSalary = (79000 + (Math.random() * (80000 - 79000)));
        monthSalary = getMonthSalary();
    }

    public double getMonthSalary() {
        return fixSalary + (0.05 * employeeIncome);
    }

    public int compareTo(Employee emp) {
        return (int) (emp.monthSalary - this.monthSalary);
    }
}