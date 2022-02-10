package casestudy.furama.reponsitory.employee;

import casestudy.furama.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPositionRepository extends JpaRepository<Position,Integer> {
}
