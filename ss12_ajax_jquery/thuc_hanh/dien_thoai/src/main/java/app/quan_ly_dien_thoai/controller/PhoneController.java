package app.quan_ly_dien_thoai.controller;

import app.quan_ly_dien_thoai.model.Phones;
import app.quan_ly_dien_thoai.service.IPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;


@RestController
@RequestMapping("/")
public class PhoneController {

    @Autowired
    IPhoneService iPhoneService;

    @PostMapping
    public ResponseEntity<Phones> createSmartphone(@RequestBody Phones smartphone) {
        iPhoneService.save(smartphone);
        return new ResponseEntity<>(smartphone, HttpStatus.CREATED);
    }
    @GetMapping({"", "phonelist"})
    public ModelAndView showPhoneList() {
        return new ModelAndView("phonelist", "smartphones", iPhoneService.findAll());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Phones> deleteSmartphone(@PathVariable Integer id) {
        Optional<Phones> smartphoneOptional = iPhoneService.findById(id);
        if (!smartphoneOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iPhoneService.delete(id);
        return new ResponseEntity<>(smartphoneOptional.get(), HttpStatus.NO_CONTENT);
    }
}
