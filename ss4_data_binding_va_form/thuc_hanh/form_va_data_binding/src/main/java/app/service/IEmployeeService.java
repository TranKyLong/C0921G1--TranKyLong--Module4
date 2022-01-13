package app.service;

import app.model.Employee;

import java.util.List;

public interface IEmployeeService {
    void getNewEmployee(Employee employee);
    public List<Employee> findAll();
}
