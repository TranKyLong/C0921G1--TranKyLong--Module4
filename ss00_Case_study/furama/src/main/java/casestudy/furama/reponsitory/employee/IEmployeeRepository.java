package casestudy.furama.reponsitory.employee;

import casestudy.furama.model.Division;
import casestudy.furama.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

    Page<Employee> findAll(Pageable page);

    Page<Employee> findByEmployeeNameContaining(String name, Pageable page);

    @Query(value = " select * FROM employee where employee.division_id_division_id = :id ",
            countQuery = "select count(*) from employee  where employee.division_id_division_id = :id ",
            nativeQuery = true
    )
    Page<Employee> findByDivId(@Param("id") Integer id, Pageable pageable);


    @Query(value = " select * FROM employee where employee_name like :empName and employee.division_id_division_id = :id ",
            nativeQuery = true
    )
    Page<Employee> theoTenVaDiv(@Param("empName") String empName,
                                @Param("id") Integer id, Pageable pageable);

}
