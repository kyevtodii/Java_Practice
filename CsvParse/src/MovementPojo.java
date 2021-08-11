
public class MovementPojo {
    String agent;
    double income;
    double expense;

    public MovementPojo (String agent, double income, double expense) {
        this.agent = agent;
        this.income = income;
        this.expense = expense;
    }

    public String getAgent() {
        return agent;
    }

    public double getIncome() {
        return income;
    }

    public double getExpense() {
        return expense;
    }
}