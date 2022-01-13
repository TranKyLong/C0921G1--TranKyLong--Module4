package app.service;

import app.model.Employee;
import app.reponsitory.IEmployeeReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    IEmployeeReponsitory iEmployeeReponsitory;


    @Override
    public void getNewEmployee(Employee employee) {
        iEmployeeReponsitory.getNewEmployee(employee);
    }

    @Override
    public List<Employee> findAll() {
        return iEmployeeReponsitory.findAll();
    }


}

