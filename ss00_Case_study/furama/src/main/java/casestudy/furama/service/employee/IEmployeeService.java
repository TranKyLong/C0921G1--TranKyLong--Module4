package casestudy.furama.service.employee;

import casestudy.furama.model.Division;
import casestudy.furama.model.EducationDegree;
import casestudy.furama.model.Employee;
import casestudy.furama.model.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {
    Page<Employee> findAll(Pageable pageable);
    Page<Employee> searchEmployee(String empName,
                                  String division,
                                  String edu,
                                  String pos,
                                  Pageable pageable);

    List<Division> findAllDivision();

    List<EducationDegree> findAllEdu();

    List<Position> findAllPos();
    List<Employee> findAllEmployee();

    void saveEmployee(Employee employee);

    void deleteEmployeeById(Integer id);

    Optional<Employee> findById(Integer id);

//    Page<Employee> findByName(String name, Pageable pageable);
//
//    Page<Employee> findByDivision(Integer divisionId, Pageable pageable);
//
//    Page<Employee> findByNameAndDivision(String name, Integer id, Pageable pageable);
}
