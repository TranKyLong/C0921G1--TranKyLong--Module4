package casestudy.furama.service.employee;

import casestudy.furama.model.Division;
import casestudy.furama.model.EducationDegree;
import casestudy.furama.model.Employee;
import casestudy.furama.model.Position;
import casestudy.furama.reponsitory.employee.IDivionRepository;
import casestudy.furama.reponsitory.employee.IEduRepository;
import casestudy.furama.reponsitory.employee.IEmployeeRepository;
import casestudy.furama.reponsitory.employee.IPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    IEmployeeRepository iEmployeeRepository;

    @Autowired
    IEduRepository iEduRepository;

    @Autowired
    IDivionRepository iDivionRepository;

    @Autowired
    IPositionRepository iPositionRepository;

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return iEmployeeRepository.findAll(pageable);
    }

    @Override
    public List<Division> findAllDivision() {
        return iDivionRepository.findAll();
    }

    @Override
    public List<EducationDegree> findAllEdu() {
        return iEduRepository.findAll();
    }

    @Override
    public List<Position> findAllPos() {
        return iPositionRepository.findAll();
    }

    @Override
    public List<Employee> findAllEmployee() {
        return iEmployeeRepository.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {
        iEmployeeRepository.save(employee);
    }

    @Override
    public void deleteEmployeeById(Integer id) {
        iEmployeeRepository.deleteById(id);
    }

    @Override
    public Optional<Employee> findById(Integer id) {
        return iEmployeeRepository.findById(id);
    }


    @Override
    public Page<Employee> findByName(String name, Pageable pageable) {
        return iEmployeeRepository.findByEmployeeNameContaining(name, pageable);
    }

    @Override
    public Page<Employee> findByDivision(Integer divisionId, Pageable pageable) {
        return iEmployeeRepository.findByDivId(divisionId, pageable);
    }
//
    @Override
    public Page<Employee> findByNameAndDivision(String name, Integer id, Pageable pageable) {
        return iEmployeeRepository.theoTenVaDiv(name,id,pageable);
    }
}
