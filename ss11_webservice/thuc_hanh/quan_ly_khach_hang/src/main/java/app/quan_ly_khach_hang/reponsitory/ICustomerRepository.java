package app.quan_ly_khach_hang.reponsitory;

import app.quan_ly_khach_hang.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findCustomerByFirstNameContaining(String name);
}
