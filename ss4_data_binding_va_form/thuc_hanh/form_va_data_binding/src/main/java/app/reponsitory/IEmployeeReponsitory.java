package app.reponsitory;

import app.model.Employee;

import java.util.List;

public interface IEmployeeReponsitory {
    void getNewEmployee(Employee employee);
    public List<Employee> findAll();
}
