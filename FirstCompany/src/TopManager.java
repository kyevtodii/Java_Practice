class TopManager extends Employee implements EmployeePosition {

    Company company;
    private double income;

    public TopManager(Company company) {
        this.jobPosition = "TopManager";
        this.company = company;
        employeeIncome = 0;
        fixSalary = (79000 + (Math.random() * (80000 - 79000)));
        setIncome(company.getIncome());
        monthSalary = getMonthSalary();
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public double getMonthSalary() {
        if (income > 10000000)
            return 1.5 * fixSalary;
        return fixSalary;
    }

    public int compareTo(Employee emp) {
        return (int) (emp.monthSalary - this.monthSalary);
    }
}
