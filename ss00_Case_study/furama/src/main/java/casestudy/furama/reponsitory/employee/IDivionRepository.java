package casestudy.furama.reponsitory.employee;

import casestudy.furama.model.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDivionRepository extends JpaRepository<Division,Integer> {
}
