package casestudy.furama.reponsitory.employee;

import casestudy.furama.model.EducationDegree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEduRepository extends JpaRepository<EducationDegree,Integer> {
}
