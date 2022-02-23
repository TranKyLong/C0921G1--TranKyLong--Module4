package casestudy.furama.reponsitory.contract;

import casestudy.furama.model.Contract;
import casestudy.furama.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface IContractRepository extends JpaRepository<Contract, Integer> {

    @Query(value="SELECT * FROM contract where customer_id_customer_id like concat('%',:customerName,'%') \n" +
            "and employee_id_employee_id like concat('%',:empId,'%')  \n" +
            "and service_id_service_id like  concat('%',:serId,'%')" ,
            countQuery = "  select count(*) from contract  where customer_id_customer_id like concat('%',:customerName,'%') \n" +
                    " and employee_id_employee_id like concat('%',:empId,'%')  \n" +
                    " and service_id_service_id like  concat('%',:serId,'%')" ,
            nativeQuery=true)
    Page<Contract> searchContract(@Param("customerName") String customerName,
                                  @Param("empId") String empId,
                                  @Param("serId") String serId,
                                  Pageable pagle);

}
