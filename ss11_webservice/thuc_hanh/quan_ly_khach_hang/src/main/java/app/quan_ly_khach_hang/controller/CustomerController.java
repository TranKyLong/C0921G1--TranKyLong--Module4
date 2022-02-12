package app.quan_ly_khach_hang.controller;

import app.quan_ly_khach_hang.dto.CustomerDto;
import app.quan_ly_khach_hang.model.Customer;
import app.quan_ly_khach_hang.service.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer/v1")
public class CustomerController {

    @Autowired
    private ICustomerService iCustomerService;

    @GetMapping
    public ResponseEntity<List<Customer>> getCustomerList() {
        List<Customer> customers = iCustomerService.findAll();
        for (Customer c : customers) {
            System.out.println(c + " \n");
        }
        if (customers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity addCustomer(@RequestBody CustomerDto customerDto) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        iCustomerService.save(customer);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable long id,
                                                   @RequestBody CustomerDto customerDto) {

        if (iCustomerService.findById(id).isPresent()) {
            Customer customer = iCustomerService.findById(id).get();
            customer.setFirstName(customerDto.getFirstName());
            customer.setLastName(customerDto.getLastName());
            iCustomerService.save(customer);
            return new ResponseEntity<>(customer, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable long id) {

        if (iCustomerService.findById(id).isPresent()) {
            iCustomerService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("find")
    public ResponseEntity<List<Customer>> findByName(@RequestParam String name) {
        List<Customer> customerList = iCustomerService.findByName(name);
        if (customerList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }


}
