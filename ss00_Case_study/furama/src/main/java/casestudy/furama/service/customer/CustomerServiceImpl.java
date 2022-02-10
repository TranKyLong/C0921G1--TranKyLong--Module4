package casestudy.furama.service.customer;

import casestudy.furama.model.Customer;
import casestudy.furama.model.CustomerType;
import casestudy.furama.reponsitory.customer.ICustomerRepository;
import casestudy.furama.reponsitory.customer.ICustomerTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    ICustomerRepository iCustomerRepository;

    @Autowired
    ICustomerTypeRepository iCustomerTypeRepository;

    @Override
    public Page<Customer> finAll(Pageable pageable) {
        return iCustomerRepository.findAll(pageable);
    }

    @Override
    public List<CustomerType> getAllCustomerType() {
        return iCustomerTypeRepository.findAll();
    }

    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public void saveCustomer(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public void deleteCustomerById(Integer id) {
        iCustomerRepository.deleteById(id);
    }

    @Override
    public Optional<Customer> findById(Integer id) {
        return iCustomerRepository.findById(id);
    }

    @Override
    public Page<Customer> findByCustomerNameContaining(String name, Pageable pageable) {
        return iCustomerRepository.findByCustomerNameContaining(name, pageable);
    }

    @Override
    public Page<Customer> findByCusType(Integer id, Pageable pageable) {
        return iCustomerRepository.findByCusType(id, pageable);
    }

    @Override
    public Page<Customer> findByNameAndType(String name, Integer id, Pageable pageable) {
        return iCustomerRepository.findByNameAndType(name, id, pageable);
    }


}
