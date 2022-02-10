package casestudy.furama.reponsitory.furama_service;

import casestudy.furama.model.RentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRentTypeRepository extends JpaRepository <RentType,Integer> {
}
