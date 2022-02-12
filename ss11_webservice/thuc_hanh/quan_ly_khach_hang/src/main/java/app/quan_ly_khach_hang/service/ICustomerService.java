package app.quan_ly_khach_hang.service;

import app.quan_ly_khach_hang.model.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    List<Customer> findAll();

    void delete(Long id);

    void save(Customer customer);

    Optional<Customer> findById(Long id);

    List<Customer>findByName(String name);
}
