package casestudy.furama.reponsitory.customer;

import casestudy.furama.model.Customer;
import casestudy.furama.model.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

    Page<Customer> findAll(Pageable page);

    Page<Customer> findByCustomerNameContaining(String cusName, Pageable page);

    @Query(value = " select * FROM customer WHERE customer.customer_type_customer_type_id = :id ",
            countQuery = "  select count(*) from customer  where customer.customer_type_customer_type_id = :id ",
            nativeQuery = true)
    Page<Customer> findByCusType(@Param("id") Integer id, Pageable pageable);

    @Query(value = " select * FROM customer WHERE customer_name like :cusName and customer_type_customer_type_id = :id ",
            countQuery = "  select count(*) from customer  where customer_name like :cusName and customer.customer_type_customer_type_id = :id ",
            nativeQuery = true)
    Page<Customer> findByNameAndType(@Param("cusName") String cusName, @Param("id") Integer id, Pageable pageable);
}
