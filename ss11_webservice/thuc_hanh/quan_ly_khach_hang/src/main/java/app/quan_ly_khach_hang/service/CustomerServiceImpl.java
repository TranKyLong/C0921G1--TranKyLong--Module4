package app.quan_ly_khach_hang.service;

import app.quan_ly_khach_hang.model.Customer;
import app.quan_ly_khach_hang.reponsitory.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    ICustomerRepository iCustomerRepository;

    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        iCustomerRepository.deleteById(id);
    }

    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return iCustomerRepository.findById(id);
    }

    @Override
    public List<Customer> findByName(String name) {
        return iCustomerRepository.findCustomerByFirstNameContaining(name);
    }
}
