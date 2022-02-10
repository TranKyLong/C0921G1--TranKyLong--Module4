package casestudy.furama.reponsitory.contract;

import casestudy.furama.model.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IContractDetail extends JpaRepository<ContractDetail, Integer> {

    Page<ContractDetail> findAll(Pageable page);

    @Query(value = " SELECT * FROM contract_detail cd  " +
            " LEFT join contract c on cd.contract_id_contract_id = c.contract_id " +
            " LEFT JOIN customer cus on c.customer_id_customer_id = cus.customer_id " +
            " WHERE cus.customer_name like :customerName ",
            countQuery = "  SELECT count(*) FROM contract_detail cd " +
                    " LEFT join contract c on cd.contract_id_contract_id = c.contract_id " +
                    " LEFT JOIN customer cus on c.customer_id_customer_id = cus.customer_id " +
                    " WHERE cus.customer_name like :customerName ",
            nativeQuery = true)
    Page<ContractDetail> findByCustomerName(@Param("customerName") String cusName, Pageable page);

    @Query(value = " SELECT * FROM contract_detail cd " +
            " LEFT join contract c on cd.contract_id_contract_id = c.contract_id" +
            " LEFT JOIN furama_service fs on c.service_id_service_id = fs.service_id" +
            " WHERE fs.service_name like :serName ",
            countQuery = "  SELECT count(*)  FROM contract_detail cd  " +
                    " LEFT join contract c on cd.contract_id_contract_id = c.contract_id " +
                    " EFT JOIN furama_service fs on c.service_id_service_id = fs.service_id " +
                    " WHERE fs.service_name like :serName ",
            nativeQuery = true)
    Page<ContractDetail> findByServiceName(@Param("serName") String serName, Pageable page);

    @Query(value = " SELECT * FROM contract_detail cd " +
            " LEFT join contract c on cd.contract_id_contract_id = c.contract_id " +
            " LEFT JOIN furama_service fs on c.service_id_service_id = fs.service_id " +
            " LEFT JOIN customer cus on c.customer_id_customer_id = cus.customer_id " +
            " WHERE cus.customer_name like :cusName and  fs.service_name like :serName ",
            countQuery = "  SELECT count(*)  FROM contract_detail cd  " +
                    "  LEFT join contract c on cd.contract_id_contract_id = c.contract_id " +
                    "  LEFT JOIN furama_service fs on c.service_id_service_id = fs.service_id  " +
                    "   LEFT JOIN customer cus on c.customer_id_customer_id = cus.customer_id  " +
                    "   WHERE cus.customer_name like :cusName and  fs.service_name like :serName ",
            nativeQuery = true)
    Page<ContractDetail> findByCustomerNameAndService(@Param("cusName") String cusName, @Param("serName")String serName, Pageable page);
}
