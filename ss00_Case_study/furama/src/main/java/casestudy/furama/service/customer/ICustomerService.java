package casestudy.furama.service.customer;

import casestudy.furama.model.Customer;
import casestudy.furama.model.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    Page<Customer> finAll(Pageable pageable);

    List<CustomerType> getAllCustomerType();
    List<Customer> findAll();

    void saveCustomer(Customer customer);

    void deleteCustomerById(Integer id);

    Optional<Customer> findById(Integer id);

    Page<Customer> findByCustomerNameContaining(String name, Pageable pageable);

    Page<Customer> findByCusType(Integer id, Pageable pageable);

    Page<Customer> findByNameAndType(String name, Integer id,Pageable pageable);
}
