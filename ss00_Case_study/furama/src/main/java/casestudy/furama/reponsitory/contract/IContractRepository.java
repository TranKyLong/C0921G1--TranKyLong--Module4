package casestudy.furama.reponsitory.contract;

import casestudy.furama.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface IContractRepository extends JpaRepository<Contract, Integer> {
}
