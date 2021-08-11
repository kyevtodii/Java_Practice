import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Company {
    private final ArrayList<Employee> listOfEmployee= new ArrayList<>();

    List<Employee> getTopSalaryStaff(int count) {
        if (count > 0 && count <= listOfEmployee.size()) {
            ArrayList<Employee> topList = listOfEmployee;
            Collections.sort(topList);
            ArrayList<Employee> finalTopList = new ArrayList<>();
            for (int i = 0; i < count; ++i)
                finalTopList.add(topList.get(i));
            return finalTopList;
        }
        return null;
    }

    List<Employee> getLowestSalary(int count) {
        if (count > 0 && count < listOfEmployee.size()) {
            ArrayList<Employee> lowestList = listOfEmployee;
            lowestList.sort(Collections.reverseOrder());
            ArrayList<Employee> finalLowestList = new ArrayList<>();
            for (int i = 0; i < count; ++i)
                finalLowestList.add(lowestList.get(i));
            return finalLowestList;
        }
        return null;
    }

    void hire(Employee employee) {
        listOfEmployee.add(employee);
    }

    void hireAll(List<Employee> employees) {
        listOfEmployee.addAll(employees);
    }

    void fire(int emp){
        for (int i = 0; i < listOfEmployee.size(); ++i) {
            if (i == emp)
                listOfEmployee.remove(i);
        }
    }

    int getAllEmployeesSize() {
        return listOfEmployee.size();
    }

    List <Employee> getAllEmployees() {
        return listOfEmployee;
    }

    public double getIncome() {
        int income = 0;
        for (Employee man : listOfEmployee)
            income += man.getIncome();
        return income;
    }
}


