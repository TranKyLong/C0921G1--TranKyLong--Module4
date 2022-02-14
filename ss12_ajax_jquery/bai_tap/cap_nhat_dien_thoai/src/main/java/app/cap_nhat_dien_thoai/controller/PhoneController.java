package app.cap_nhat_dien_thoai.controller;

import app.cap_nhat_dien_thoai.model.Phone;
import app.cap_nhat_dien_thoai.model.PhoneDto;
import app.cap_nhat_dien_thoai.service.IPhoneService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("phone/v1")
@RestController

public class PhoneController {
    @Autowired
    IPhoneService iPhoneService;

    @GetMapping
    public ResponseEntity<List<Phone>> getPhoneList() {
        List<Phone> phoneList = iPhoneService.findAll();
        if (!(phoneList.isEmpty())) {
            return new ResponseEntity<>(phoneList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Phone> deletePhone(@PathVariable int id) {
        if (iPhoneService.findById(id).isPresent()) {
            iPhoneService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("edit/{id}")
    public ResponseEntity<Phone> updateCustomer(@PathVariable int id,
                                                @RequestBody PhoneDto phoneDto) {
        if (iPhoneService.findById(id).isPresent()) {
            Phone phone = iPhoneService.findById(id).get();
            phone.setModel(phoneDto.getModel());
            phone.setPrice(phoneDto.getPrice());
            phone.setProducer(phoneDto.getProducer());
            iPhoneService.save(phone);
            return new ResponseEntity<>(phone, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity addCustomer(@RequestBody PhoneDto phoneDto) {
        Phone customer = new Phone();
        BeanUtils.copyProperties(phoneDto, customer);
        iPhoneService.save(customer);
        return new ResponseEntity(HttpStatus.OK);
    }



}
