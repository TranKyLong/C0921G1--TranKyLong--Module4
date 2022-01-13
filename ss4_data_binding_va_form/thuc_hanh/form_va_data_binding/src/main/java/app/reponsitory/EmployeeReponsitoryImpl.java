package app.reponsitory;

import app.model.Employee;
import app.service.EmployeeServiceImpl;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeReponsitoryImpl implements IEmployeeReponsitory {

    private static final List<Employee> employeeList;

    static {
        employeeList = new ArrayList<>();
        employeeList.add(new Employee(1, "John", "03221"));
        employeeList.add(new Employee(2, "Astates", "42000"));
        employeeList.add(new Employee(3, "Harry Bolter", "23456"));
        employeeList.add(new Employee(4, "Tony", "123546"));
        employeeList.add(new Employee(5, "Shaun", "789787"));
    }

    @Override
    public void getNewEmployee(Employee employee) {
        employeeList.add(employee);
    }

    @Override
    public List<Employee> findAll() {
        return employeeList;
    }
}
